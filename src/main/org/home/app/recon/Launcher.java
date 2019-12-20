package org.home.app.recon;

import java.util.List;

public class Launcher {
    public static void main(String[] args) {
        String lDir = "F:\\Memories";
        String rDir = "H:\\Memories";
        DirectoryComparator comparator = new DirectoryComparator(lDir,rDir);
        List<String> duplicates = comparator.compareDirectory();
       /* duplicates.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });*/
        duplicates.sort((s1, s2) -> s1.compareTo(s2));

        System.out.println("Duplicate found : "+ duplicates.size());
        duplicates.forEach(e -> {
            System.out.println("del \"" + e + "\"");
        //new File(e).delete();
        });
    }
}
