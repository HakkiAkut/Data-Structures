/**
 * @author Hakkı Can Akut
 * */
public class Main {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.add(21);
        cll.add(2);
        cll.add(6);
        cll.add(17);
        cll.add(12);

        CircularLinkedList cll2 = new CircularLinkedList();

        cll2.add(17);
        cll2.add(12);
        cll2.add(21);
        cll2.add(2);
        cll2.add(6);

        cll.print();
        cll2.print();
        System.out.println(cll.checkSequences(cll2));
    }
}

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class CircularLinkedList {

    public Node head = null;
    public Node tail = null;
    public static int length = 0;

    // adds new node to end of circular linked list
    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            node.next = head;

        } else {
            tail.next = node;
            tail = node;
            tail.next = head;
        }
        length++;
    }

    // prints list
    public void print() {
        Node temp = head;
        if (head == null) {
            System.out.println("empty list");
        } else {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
            System.out.println();
        }
    }


    // checks that is two circular linked list has same sequence or not
    public boolean checkSequences(CircularLinkedList cll2) {
        Node list1Item = head;
        Node list2Item = cll2.head;
        boolean result = false;
        // if lengths not equal result return as false
        if (length == cll2.length) {
            int i = 0;
            while (i <= length && !result) {
                result = check(list1Item, list2Item);
                // if result still false changes the starting point of second list.
                if (!result) {
                    i++;
                    list2Item = list2Item.next;
                }
            }
        }
        return result;
    }

    //checks two list from start point list1Item and list2Item
    boolean check(Node list1Item, Node list2Item) {
        int j = 0;
        while (j < length && list1Item.data == list2Item.data) {
            list1Item = list1Item.next;
            list2Item = list2Item.next;
            j++;
        }
        // if j doesn't equals length this means while loop break because of lists data not equal
        return j == length ? true : false;
    }
}
