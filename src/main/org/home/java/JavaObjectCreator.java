package org.home.java;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class JavaObjectCreator {

    public static void main(String[] args) throws Exception{
        JavaObjectCreator objectCreator = new JavaObjectCreator();
        objectCreator.createObjects();
    }

    public void createObjects() throws ClassNotFoundException, IllegalAccessException, InstantiationException,
             CloneNotSupportedException, NoSuchMethodException, InvocationTargetException, IOException {
        System.out.println("Creating using new keyword !!!");
        MyObject objNew = new MyObject();
        System.out.println("Using class.forname");
        Class objForNameClz = Class.forName("org.home.java.MyObject");
        MyObject objForName = (MyObject)objForNameClz.newInstance();

        System.out.println("Using clone :");
        MyObject objCloned = (MyObject) objNew.clone();
        System.out.println("Using Constructor.newInstance");
        createUsingConstructorReflection();
        System.out.println("Using deserialization");
        createObjectUsingSerialization(objNew);

    }

    private void createObjectUsingSerialization(MyObject obj) throws IOException, ClassNotFoundException {
        //MyObject obj = new MyObject();
        FileOutputStream f = new FileOutputStream("file.txt");
        ObjectOutputStream oos = new ObjectOutputStream(f);
        oos.writeObject(obj);
        oos.close();
        f.close();

        FileInputStream fin = new FileInputStream("file.txt");
        ObjectInputStream ois = new ObjectInputStream(fin);
        MyObject obj1 = (MyObject)ois.readObject();
        ois.close();
        fin.close();
    }

    private void createUsingConstructorReflection() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<MyObject> constructor = MyObject.class.getDeclaredConstructor();
        MyObject object = constructor.newInstance();
    }
}
