package org.home.ds.tree;

public class RootToLeafPath {
    public static boolean check(TreeNodeInt root, int[] arr){
        int x = 0;
        TreeNodeInt temp = root;
        boolean foundPath = true;
        while((x<arr.length-1) && temp != null){
            if(arr[x] == temp.key){
                if(temp.left != null  && /*(x+1 < arr.length) &&*/ temp.left.key == arr[x+1]){
                    temp = temp.left;
                    x++;
                }else if(temp.right != null  && /*(x+1 < arr.length) &&*/ temp.right.key == arr[x+1]){
                    temp = temp.right;
                    x++;
                }else{
                    foundPath = false;
                    break;
                }
            }
        }
        /*if(foundPath){
            if((temp.left != null  && temp.left.key == arr[x]) ||
                    (temp.right != null  && temp.right.key == arr[x])){

            }
        }*/
        return foundPath;
    }
}
