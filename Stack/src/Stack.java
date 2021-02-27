import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Hakkı Can Akut
 */
public class Stack {
    int[] stack; // stack data
    int size; // size of stack, size-1 is last index
    int capacity; // max size of stack

    /**
     * Constructor to initialize stack
     * @param capacity is max size of our stack
     */

    Stack(int capacity) {
        stack = new int[capacity];
        // initialize every number to -1
        for(int i=0;i<capacity;i++){
            stack[i]=-1;
        }
        size = 0;
        this.capacity= capacity;
    }

    /**
     * pushes an element to stack
     * @param element that would push
     */

    public void push(int element) {
        if(size+1 <=capacity){
            stack[size]= element;
            size++;
        }
    }

    /**
     * pops last element from stack
     * @return popped element
     */
    public int pop() {
        if (isEmpty()) {
            return -1;
        } else {
            int temp = stack[size - 1];
            stack[size - 1]=-1;
            size--;
            return temp;
        }
    }

    /**
     * peeks last element
     * @return last element
     */
    public int peek() {
        if (!isEmpty()) {
            return stack[size - 1];
        } else {
            return -1;
        }
    }

    /**
     * @return current size of stack
     */
    public int size() {
        return size;
    }

    /**
     *
     * @return false if size not equals 0 otherwise returns true
     */
    public Boolean isEmpty() {
        return size == 0;
    }

}

class Main {
    public static void main(String[] args) {
        resetResultFile();
        Var var = new Var();
        stackMethod(var.parsedString);
    }

    /**
     * stack method
     * we create new stack with given array
     * first loop is for checking every element for array,
     * we are pushing array elements from last to i (first loops counter) because we don't need before of ith element,
     * since we are checking elements after i. Then we decide our pivot.
     * Since we lastly add ith element of array to our stack it's our current pivot.
     * After that we initialize greaterAfterPivot and smallerAfterGreater as -1.
     * And start checking, what is first greater number after pivot. And first smaller element after greater one.
     * and lastly clear stack and do printing operation.
     * @param array
     */
    public static void stackMethod(int[] array) {
        Stack stack = new Stack(array.length);
        for(int i=0; i<array.length;i++){
            for (int j=array.length; j>i;j--) {
                stack.push(array[j-1]);
            }
            int pivot=stack.pop();
            int greaterAfterPivot= -1;
            int smallerAfterGreater= -1;
            while (!stack.isEmpty()){
                int temp = stack.pop();
                if(greaterAfterPivot == -1){
                    if(temp>pivot){
                        greaterAfterPivot =temp;
                    }
                }
                if(greaterAfterPivot != -1 && smallerAfterGreater == -1){
                    if(temp<greaterAfterPivot){
                        smallerAfterGreater=temp;
                        break;
                    }
                }
            }
            // resetting stack  if it's not empty.
            while (!stack.isEmpty()){
                stack.pop();
            }
            if(greaterAfterPivot!=-1&&smallerAfterGreater!=-1){
                System.out.print((greaterAfterPivot-smallerAfterGreater)+", ");
                printToResultFile((greaterAfterPivot-smallerAfterGreater)+", ");
            } else {
                System.out.print("-1, ");
                printToResultFile("-1, ");
            }
        }
    }

    /**
     * writes string to result file
     * */
    public static void printToResultFile(String str){
        try {
            FileWriter fileWriter = new FileWriter("./stackOutput.txt",true);
            fileWriter.write(str);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
    /**
     * reset files, when program starts so only recent process data will be there
     */
    public static void resetResultFile() {
        try {
            FileWriter fileWriter = new FileWriter("./stackOutput.txt");
            fileWriter.write("");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}

class Var {
    public int[] parsedString;
    /**
     * constructor method
     */

    public Var() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./stackInput.txt"))) {
            String string = bufferedReader.readLine();
            parsedString = new int[string.split(", ").length];
            for (int i = 0; i < parsedString.length; i++) {
                parsedString[i] = Integer.parseInt(string.split(", ")[i]);
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}