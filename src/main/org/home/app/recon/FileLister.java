package org.home.app.recon;

import java.io.File;
import java.util.*;

public class FileLister {

    public List<String> listFiles(String path, String extension){
        File f = new File(path);

        List<String> fileNameList = new ArrayList<>();
        if(f.isDirectory()){
            File[] files = f.listFiles();
            if(files != null && files.length!=0){
                for(File fi : files ){
                    if(fi.isDirectory()){
                        fileNameList.addAll(listFiles(fi.getPath(),extension));
                    }else{
                        //(fi.getName().indexOf(extension)>0){
                            fileNameList.add(fi.getPath());
                       // }

                    }
                }
            }
        }
        return  fileNameList;
    }

    public Map<String, String> createMap(List<String> fileNameList){
        Map<String, String> fileListMap = new HashMap<>();
        fileNameList.stream().forEach(e->{
            fileListMap.put(new File(e).getName(),e);
        });

        return fileListMap;
    }


    public Map<String, String> createFileMap(String directory, String extension){
        return createMap(listFiles(directory,extension));
    }
}
