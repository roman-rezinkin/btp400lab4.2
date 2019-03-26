package lab4;

import java.io.File;
import java.io.FilePermission;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListStackTest {

//    @org.junit.jupiter.api.Test
//    void top() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void pop() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void push() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void isEmpty() {
//    }
    @org.junit.jupiter.api.Test
    void test() throws Exception{
        MyArrayListStack temp = new MyArrayListStack("input.txt");
        URL url = getClass().getResource("input.txt");
        File file = new File(url.getPath());

        try {
            if (file.exists()) {
                System.out.println(file.canRead());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        while (!temp.isEmpty()) {
            System.out.println(temp.pop());
        }
    }
}