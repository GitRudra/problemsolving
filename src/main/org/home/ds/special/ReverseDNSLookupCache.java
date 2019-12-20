package org.home.ds.special;

public class ReverseDNSLookupCache {

    private final Integer ALPHABET_SIZE = 11;
    DNSLookupCache cache;

    public ReverseDNSLookupCache() {
        this.cache = new DNSLookupCache();
    }


    public void doCache(String url, String dns) throws Exception {
        validateDns(dns);
        cache.add(dns,url);
    }

    public  String  resolveDns(String dns) throws Exception {
        validateDns(dns);
        return cache.findUrl(dns);
    }

    /**
     * The validator method to validate dns.
     * @param dns
     * @return
     * @throws Exception
     */
    private boolean validateDns(String dns) throws Exception {
        boolean isValid = false;
        if(dns == null || dns.length()==0){
            throw new Exception("DNS ["+dns+"] is empty");
        }
        String regexMatcher = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}";
        if(dns.matches(regexMatcher)){
            isValid =  true;
        }else{
            throw new Exception("DNS ["+dns+"] is not valid");
        }

        return isValid;
    }

    /**
     * The class represent one Trie LevelOrderTreeNode. The node contains the character associated with that node &
     * the children. Also the URL if  the node represent end character of the dns
     */
    class TNode{
        private TNode[] children;
        private char digit;
        private String url;

        public TNode() {
            children = new TNode[ALPHABET_SIZE];
            url = "";
        }

        public TNode[] getChildren() {
            return children;
        }

        public char getDigit() {
            return digit;
        }

        public void setDigit(char digit) {
            this.digit = digit;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    /**
     * The inner class actually represent the DNS cache.
     * DNS cache is implemented using trie structure. For DNS the underlying
     * set of character count in 11 (0-9 & .).
     */
    class DNSLookupCache{
        TNode root;

        /**
         * Constructor
         */
        public DNSLookupCache() {
            root = new TNode();
        }

        /**
         * Add a mapping in DNS cache. The method take a DNS string and URL and store the mapping
         * in the cache.
         * @param dns
         * @param url
         */
        public void add(String dns,String url){
            //Iterator works as root node at each level .
            //For each level if the character is already present into the node that node will
            //be assigned to iterator. Otherwise a new node will be created for the character
            //It will be stored into the respective position of children array & assigned to
            //iterator.
            TNode iterator = root;
            for(int i=0;i<dns.length();i++){
                //If the character is '.' then it will be stored in 10th position (starting index 0)
                //Here ALPHABET_SIZE is 11.
                if(dns.charAt(i) == '.'){
                    //If '.' has not occurred for the node, a new node will be created for '.'
                    if(iterator.getChildren()[ALPHABET_SIZE-1] == null){
                        TNode temp = new TNode();
                        temp.setDigit(dns.charAt(i));
                        iterator.getChildren()[ALPHABET_SIZE-1] = temp;
                        iterator = temp;
                    }else{
                        iterator = iterator.getChildren()[ALPHABET_SIZE-1];
                    }
                }else{
                    if(iterator.getChildren()[dns.charAt(i)-'0'] == null){
                        TNode temp = new TNode();
                        temp.setDigit(dns.charAt(i));
                        iterator.getChildren()[dns.charAt(i)-'0'] = temp;
                        iterator = temp;
                    }else{
                        iterator = iterator.getChildren()[dns.charAt(i)-'0'];
                    }
                }
            }
            iterator.setUrl(url);
        }

        /**
         * When finding the DNS in the cache if any character of the DNS string is not found
         * in the cache then it will throw exception.
         * @param dns
         * @return
         * @throws Exception
         */
        public  String findUrl(String dns) throws Exception {
            TNode iterator = root;
            for(int i=0;i<dns.length();i++){
                if(dns.charAt(i) == '.'){
                    if(iterator.getChildren()[ALPHABET_SIZE-1] == null){
                        throw new Exception("DNS not found !!!");
                    }else{
                        iterator = iterator.getChildren()[ALPHABET_SIZE-1];
                    }
                }else{
                    if(iterator.getChildren()[dns.charAt(i)-'0'] == null){
                        throw new Exception("DNS not found !!!");
                    }else{
                        iterator = iterator.getChildren()[dns.charAt(i)-'0'];
                    }
                }
            }
            return iterator.getUrl();
        }
    }
}
