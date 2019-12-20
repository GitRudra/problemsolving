package org.home.app.recon;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FileListerTest {

    @Test
    public void listFiles() {
        String filepath = "D:\\myDrive\\Memories\\Hyderabad Chapter";
        String ext = "jpg";
        FileLister lister = new FileLister();
        List files = lister.listFiles(filepath,ext);
        files.forEach(e-> System.out.println(e));
    }
}