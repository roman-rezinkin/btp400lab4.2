package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

/**
 * Different implementation of the MyArrayListStack data type with a member variable of type Object[] instead of an ArrayList<Q>.
 * This implementation differs from the MyTypeQArrayStack implementation in that it does not need a type cast when defining a new
 * member array length.
 * @author Roman Rezinkin, Daniel Khan Hafner
 */
public class MyObjectArrayStack {
    private int count;
    private Object[] elements;

    /**
     * Overload constructor which sets the elements member stack length to the amount of lines in the file provided and
     * reads each line of the file into an index of the member stack.
     * @param s The filename to find and read from
     * @throws Exception
     */
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

    /**
     * Member method that gets the item at the top of the stack without removing it
     * @return The object held at the last index of the stack
     */
    public Object top() {
        return elements[elements.length - 1];
    }

    /**
     * Member method that gets the item at the top of the stack and removes it from the stack
     * @return The object held at the last index of the stack
     */
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

    /**
     * Method that adds the given item to the top of the stack
     * @param toPush The item to be pushed
     */
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

    /**
     * Method that returns true if the current stack is empty
     * @return True if stackArrayList member variable is empty
     */
    public boolean isEmpty() {
        return elements.length == 0 || elements == null;
    }

    /**
     * Program entry point used for testing the MyObjectArrayStack data type
     * @param args Command line arguments
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        MyObjectArrayStack mals = new MyObjectArrayStack("input.txt");
    }
}
