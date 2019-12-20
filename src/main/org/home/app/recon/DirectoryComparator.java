package org.home.app.recon;

import java.util.*;

public class DirectoryComparator {

    private String lDir;
    private String rDir;

    public DirectoryComparator(String lDir, String rDir) {
        this.lDir = lDir;
        this.rDir = rDir;
    }

    public List<String> compareDirectory(){
        FileLister fileLister = new FileLister();
        Map<String,String> lDirMap = fileLister.createFileMap(lDir,"jpg");
        Map<String,String> rDirMap = fileLister.createFileMap(rDir,"jpg");
        Set<Map.Entry<String,String>> lEntrySet = lDirMap.entrySet();
        Iterator<Map.Entry<String, String>> lEntrySetIterator = lEntrySet.iterator();
        List<String> duplicateEntries = new ArrayList<String>();
        while(lEntrySetIterator.hasNext()){
            Map.Entry<String,String> entry = lEntrySetIterator.next();
            if(rDirMap.containsKey(entry.getKey())){
                duplicateEntries.add(rDirMap.get(entry.getKey()));
                rDirMap.remove(entry.getKey());
            }
        }

        return duplicateEntries;
    }
}
