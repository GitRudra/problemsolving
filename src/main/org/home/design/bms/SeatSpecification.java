package org.home.design.bms;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

public class SeatSpecification implements Serializable,Cloneable {
    private HashMap<String,String> specification;

    public SeatSpecification(){
        specification = new HashMap<>();
    }

    public void addSpecification(String specKey, String specValue){
        specification.put(specKey,specValue);
    }

    public boolean matchSpecification(SeatSpecification targetSpec){
        Iterator<String> it = targetSpec.specification.keySet().iterator();
        String key;
        while(it.hasNext()){
            key = it.next();
            if(this.specification.containsKey(key)){
                if(!this.specification.get(key).equals(targetSpec.specification.get(key))){
                    return false;
                }
            }else{
                return false;
            }
        }

        return true;
    }

    public String getSpecificationForKey(String key){
        return specification.get(key);
    }

}
