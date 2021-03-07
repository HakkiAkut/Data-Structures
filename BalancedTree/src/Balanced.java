import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Hakkı Can Akut
 */
public class Balanced {
    public static void main(String[] args) {
        File output =new File("output.txt");
        Scanner input = null;
        try {
            input = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        String s1 = input.nextLine();
        String s2 = s1.replace("-", "-1");
        int array[] = new int[s2.split(" ").length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(s2.split(" ")[i]);
        }
        Tree tree = new Tree(array[0]);
        for (int i = 1; i < array.length; i++) {
            tree.insert(array[i]);
        }
        System.out.println(tree.isBalanced(tree.root));
        writeResultToFile(output.getAbsolutePath(), tree.isBalanced(tree.root));

    }

    /**
     * method for writing result to file
     * @param filename
     * @param str
     */
    public static void writeResultToFile(String filename, Boolean str) {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(str.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}

class Node {
    int data;
    Node parent, left, right;

    public Node(int data) {
        this.data = data;
        parent = null;
        left = null;
        right = null;
    }

}

class Tree {
    Node root;

    public Tree(int data) {
        this.root = new Node(data);
    }

    void insert(int data) {
        insert(this.root, data);
    }

    /**
     * insert method of Tree
     * @param root
     * @param data
     */
    void insert(Node root, int data) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.peek();
            queue.remove();
            if (temp.left == null) {
                temp.left = new Node(data);
                break;
            } else {
                queue.add(temp.left);
            }
            if (temp.right == null) {
                temp.right = new Node(data);
                break;
            } else {
                queue.add(temp.right);
            }
        }
    }

    /**
     * finds height of specified node
     * if node is null or node's value is -1 it will return 0, -1 is null pointer
     * else, we check left child's node height and right child's height
     * and compare this two variable, greater + 1 is this nodes height
     * @param node
     * @return height of node
     */
    int findHeight(Node node) {
        if (node == null || node.data == -1){
            return 0;
        }
        else {
            int leftHeight = findHeight(node.left);
            int rightHeight = findHeight(node.right);
            if (leftHeight > rightHeight) {
                return (leftHeight + 1);
            } else {
                return (rightHeight + 1);
            }
        }
    }

    /**
     * We check height of left child and height of right child,
     * if difference is more than one than this tree is not balanced
     * if it's not then we check(call method for this node) left node and right node respectively.
     * @param node
     * @return true if balanced false if it's not
     */
    boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);
        if (leftHeight - rightHeight == 0 || leftHeight - rightHeight == 1 || leftHeight - rightHeight == -1) {
            boolean leftCheck = isBalanced(node.left);
            if (!leftCheck) {
                return false;
            }
            boolean rightCheck = isBalanced(node.right);
            if (!rightCheck) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}

