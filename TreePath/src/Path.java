import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Hakkı Can Akut
 */
public class Path {
    public static void main(String[] args) {
        File output = new File("output.txt");
        int value= Integer.parseInt("22");
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
        boolean bool = tree.path(tree.root, 1,"", 0, value, output.getAbsolutePath());
        if (!bool) {
            System.out.println("false");
            writeResultToFile(output.getAbsolutePath(), "false");
        }
    }

    /**
     * method for writing result to file
     * @param filename
     * @param str
     */
    public static void writeResultToFile(String filename, String str) {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(str);
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
     * if node is null we return false
     * adds this node's data to count
     * if count is greater than value means path is wrong, will return false
     * else if count equals value it will return true
     * else last possibility is count is lesser than value so it will continue searching(calls pth method again)
     * first left then right
     * @param node
     * @param path which is we go for sum
     * @param count which is sum
     * @param value we want to get
     * @param filename which we print the output
     * @return true if there is a path for expected value else will return false
     */
    boolean path(Node node,int index ,String path, int count, int value, String filename) {
        if (node == null) {
            return false;
        }
        count += node.data;
        path += " " +"T["+(index-1)+"] "+ node.data;
        if (count > value) {
            return false;
        } else if (count == value) {
            System.out.println("true: " + path);
            Path.writeResultToFile(filename, "true: " + path);
            return true;
        } else {
            boolean leftPath = path(node.left,(index*2) ,path, count, value, filename);
            boolean rightPath = path(node.right,(index*2)+1 ,path, count, value, filename);
            if (leftPath || rightPath) {
                return true;
            }
        }
        return false;
    }

}
