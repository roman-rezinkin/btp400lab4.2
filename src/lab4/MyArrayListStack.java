package lab4;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class MyArrayListStack<Q> {
    private ArrayList<Q> stackArrayList= new ArrayList<Q>();

    MyArrayListStack(String fileString) throws Exception{
        URL url = getClass().getResource(fileString);
        File file = new File(url.getPath());
        FileReader fr = new FileReader(file);
        BufferedReader bis = new BufferedReader(fr);

        String st;
        while ((st = bis.readLine()) != null) {
            push((Q) st);
        }
    }

    public Q top() {
        return stackArrayList.get(stackArrayList.size() - 1);
    }
    public Q pop() {
        Q temp;
        temp = stackArrayList.get(stackArrayList.size() - 1);
        stackArrayList.remove(stackArrayList.size() - 1);
        return temp;
    }
    public void push(Q toPush) {
        stackArrayList.add(toPush);
    }
    public boolean isEmpty() {
        return stackArrayList.size() == 0;
    }
    public static void main(String[] args) throws Exception{
        MyArrayListStack mals = new MyArrayListStack("input.txt");
    }
}
