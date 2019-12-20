package org.home.leetcode;

public class AddBinaryNumbers {
    public static String addBinary(String a, String b) {
        String result = "";
        String carryBit = "0";
        if( isEmpty(a) && isEmpty(b)){
            return "";
        }else if(isEmpty(a) || "0".equals(a)){
            return b;
        }else if(isEmpty(b) || "0".equals(b)){
            return a;
        }else{
            int len1 = a.length()-1;
            int len2 = b.length()-1;
            int maxLen = Math.max(len1,len2);

            for(int i=0;i<=maxLen;i++){
                if(len1-i >=0 && len2-i>= 0){
                    if(isOne(a.charAt(len1-i)) && isOne(b.charAt(len2-i))){
                        if("1".equals(carryBit)){
                            result  = "1" + result;
                        }else if("0".equals(carryBit)){
                            result = "0" + result;
							carryBit = "1";
                        }

                    }else if((isOne(a.charAt(len1-i)) && isZero(b.charAt(len2-i))) ||
					          isZero(a.charAt(len1-i)) && isOne(b.charAt(len2-i))){
						if("1".equals(carryBit)){
                            result  = "0" + result;
							carryBit = "1";
                        }else if("0".equals(carryBit)){
                            result  = "1" + result;
							carryBit = "0";
                        }
					}else{
                        result  = "0" + result;
						carryBit = "0";	
					}
                }else if(len1-i <0 && len2-i>= 0){
                    //if(isOne(b.charAt()))
                }
            }
            if("1".equals(carryBit)){
                result  = "1" + result;
            }
        }

        return result;
    }

    public String addBinaryString(String a, String b){

        /*int iA = Integer.parseInt(a,2);
        int iB = Integer.parseInt(b,2);*/
        return Integer.toBinaryString(Integer.parseInt(a,2) + Integer.parseInt(b,2));
    }

    private static boolean isOne(Character ch){
        return '1' == ch;
    }
	private static boolean isZero(Character ch){
        return '0' == ch;
    }

    private static boolean isEmpty(String a){
        return a==null || a.length() ==0 ;
    }
}
