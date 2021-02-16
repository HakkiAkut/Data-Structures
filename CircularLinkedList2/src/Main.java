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
        cll.add(15);
        cll.add(62);
        cll.add(25);



        cll.print();
        CircularLinkedList cll2 = cll.split(); // splitting 2nd half of cll to cll2
        cll.print();
        cll2.print();
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

    // splits 2nd half of Circular linked list to another list and returns this list
    public CircularLinkedList split() {
        CircularLinkedList result = new CircularLinkedList();
        Node temp = head;
        int i = 2;
        // finding middle of the Circular Linked List as named temp
        // temp would be tail of the first half, temp.next would be head of second half
        do {
            temp = temp.next;
            i += 2;
        } while (i < length);

        result.head = temp.next;
        result.tail = tail;
        tail = temp;
        result.tail.next = result.head;
        tail.next=head;

        return result;
    }

}
