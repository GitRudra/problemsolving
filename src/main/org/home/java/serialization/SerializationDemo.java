package org.home.java.serialization;

import org.home.design.cricinfo.entity.Person;

import java.io.*;

public class SerializationDemo {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setAge(34);
        emp.setName("name1");
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream("serialize.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(emp);

            fis = new FileInputStream("serialize.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Employee p2 = (Employee)ois.readObject();
            System.out.println(p2.getAge() == emp.getAge());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null){
                try {
                    fos.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
