package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

/**
 * Different implementation of the MyArrayListStack data type with a member variable of type Q[] instead of an ArrayList<Q>.
 * This implementation differs from the MyObjectArrayStack implementation in that it requires the Object type to make a new array of
 * unknown length at compile time and then a cast to type to Q[] to get the final stack member variable, unlike the myObjectArrayStack
 * implementation which does not require this cast.
 * @param <Q> User defined data type to be stored in an instance of this class
 * @author Roman Rezinkin
 */
public class MyTypeQArrayStack<Q> {
    private Q[] element;
    int count;

    /**
     * Overload constructor which reads a file line by line into an array member variable.
     * @param s The filename to find and read from
     * @throws Exception
     */
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

    /**
     * Member method that gets the item at the top of the stack without removing it
     * @return The object held at the last index of the stack
     */
    public Q top() {
        return element[element.length - 1];
    }

    /**
     * Member method that gets the item at the top of the stack and removes it from the stack
     * @return The object held at the last index of the stack
     */
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

    /**
     * Method that adds the given item to the top of the stack
     * @param toPush The item to be pushed
     */
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

    /**
     * Method that returns true if the current stack is empty
     * @return True if stackArrayList member variable is empty
     */
    public boolean isEmpty() {
        return element.length == 0 || element[0] == null;
    }

    /**
     * Program entry point used for testing the MyTypeQArrayStack data type
     * @param args Command line arguments
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        MyTypeQArrayStack mals = new MyTypeQArrayStack("input.txt");
    }
}