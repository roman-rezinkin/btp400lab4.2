package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

public class MyTypeQArrayStack<Q> {
    private Q[] element;
    int count;

    MyTypeQArrayStack(String s) throws Exception{
        URL url = getClass().getResource(s);
        File file = new File(url.getPath());
        FileReader fr = new FileReader(file);
        BufferedReader bis = new BufferedReader(fr);
        count = 0;
        while ((bis.readLine()) != null) {
            count++;
        }
        element = (Q[])new Object[count];
        bis.close();
        fr.close();
        fr = new FileReader(file);
        bis = new BufferedReader(fr);
        for (int j = 0; j < element.length; j++) {
            element[j] = (Q) bis.readLine();
        }
        for (int i = 0; i < element.length; i++) {
            System.out.println(element[i]);
        }
    }
    public Q top() {
        return element[element.length - 1];
    }

    public Q pop() {
        Q[] temp = (Q[])new Object[count - 1];
        Q temp2 = element[element.length - 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = element[i];
        }
        count -= 1;
        element = (Q[])new Object[count];
        for (int i = 0; i < temp.length; i++) {
            element[i] = temp[i];
        }
        return temp2;
    }

    public void push(Q toPush) {
        Q[] temp = (Q[])new Object[count + 1];
        for (int i = 0; i < element.length; i++) {
            temp[i] = element[i];
        }
        temp[count + 1] = toPush;
        element = (Q[])new Object[count];
        for (int i = 0; i < temp.length; i++) {
            element[i] = temp[i];
        }
    }

    public boolean isEmpty() {
        return element.length == 0 || element[0] == null;
    }

    public static void main(String[] args) throws Exception{
        MyTypeQArrayStack mals = new MyTypeQArrayStack("input.txt");
    }
}