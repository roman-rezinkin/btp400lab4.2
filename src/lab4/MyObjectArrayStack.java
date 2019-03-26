package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

public class MyObjectArrayStack {
    private int count;
    private Object[] elements;

    MyObjectArrayStack(String s) throws Exception {
        URL url = getClass().getResource(s);
        File file = new File(url.getPath());
        FileReader fr = new FileReader(file);
        BufferedReader bis = new BufferedReader(fr);
        count = 0;
        while ((bis.readLine()) != null) {
            count++;
        }
        elements = new Object[count];
        bis.close();
        fr.close();
        fr = new FileReader(file);
        bis = new BufferedReader(fr);
        String st;
        for (int j = 0; j < elements.length; j++) {
            elements[j] = bis.readLine();
        }
//        while ((st = bis.readLine()) != null) {
//            push(st);
//        }
        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
        }
    }

    public Object top() {
        return elements[elements.length - 1];
    }

    public Object pop() {
        Object[] temp = new Object[count - 1];
        Object temp2 = elements[elements.length - 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = elements[i];
        }
        count -= 1;
        elements = new Object[count];
        for (int i = 0; i < temp.length; i++) {
            elements[i] = temp[i];
        }
        return temp2;
    }

    public void push(Object toPush) {
        Object[] temp = new Object[count + 1];
        for (int i = 0; i < elements.length; i++) {
            temp[i] = elements[i];
        }
        temp[count + 1] = toPush;
        elements = new Object[count];
        for (int i = 0; i < temp.length; i++) {
            elements[i] = temp[i];
        }
    }

    public boolean isEmpty() {
        return elements.length == 0 || elements == null;
    }

    public static void main(String[] args) throws Exception {
        MyObjectArrayStack mals = new MyObjectArrayStack("input.txt");
    }
}
