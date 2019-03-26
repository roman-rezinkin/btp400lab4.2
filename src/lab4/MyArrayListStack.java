package lab4;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

/**
 * Class which represents an array list with rules enforced to make it behave like a stack
 * i.e last in, last out functionality.
 * @param <Q> User defined data type
 * @author Roman Rezinkin, Daniel Khan Hafner
 */
public class MyArrayListStack<Q> {
    private ArrayList<Q> stackArrayList= new ArrayList<Q>();

    /**
     * Overload constructor which populates each index of the stack with a line from the file
     * @param fileString The file to extract data from
     * @throws Exception
     */
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

    /**
     * Member method that gets the item at the top of the stack without removing it
     * @return The object held at the last index of the stack
     */
    public Q top() {
        return stackArrayList.get(stackArrayList.size() - 1);
    }

    /**
     * Member method that gets the item at the top of the stack and removes it from the stack
     * @return The object held at the last index of the stack
     */
    public Q pop() {
        Q temp;
        temp = stackArrayList.get(stackArrayList.size() - 1);
        stackArrayList.remove(stackArrayList.size() - 1);
        return temp;
    }

    /**
     * Method that adds the given item to the top of the stack
     * @param toPush The item to be pushed
     */
    public void push(Q toPush) {
        stackArrayList.add(toPush);
    }

    /**
     * Method that returns true if the current stack is empty
     * @return True if stackArrayList member variable is empty
     */
    public boolean isEmpty() {
        return stackArrayList.size() == 0;
    }

    /**
     * Program entry point used for testing the MyArrayListStack data type
     * @param args Command line arguments
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        MyArrayListStack mals = new MyArrayListStack("input.txt");
    }
}
