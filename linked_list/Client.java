import java.util.*;
public class Client {
    public static Scanner scn = new Scanner(System.in);

    public static Node partition(Node head, int partioningValue) {
        Node greaterHead = new Node(0);
        Node greater = greaterHead;
        Node lesserHead = new Node(0);
        Node lesser = lesserHead;
        while(head != null) {
            if(head.data < partioningValue) {
                lesser.next = head;
                lesser = lesser.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        greater.next = null;
        lesser.next = greaterHead.next;

        return lesserHead.next;
    }

    public static Node oddEven(Node head) {
        Node oddHead = new Node(0);
        Node odd = oddHead;
        Node evenHead = new Node(0);
        Node even = evenHead;

        while(head != null) {
            if(head.data % 2 == 0) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
        }

        odd.next = null;
        even.next = oddHead.next;

        return evenHead.next;
    }
    public static void main(String[] args) {
        // int val = Integer.parseInt(args[0]);
        List l1 = new List();
        while(scn.hasNext()) {
            l1.add(scn.nextInt());
        }
        l1.printAll();
        // while()
        // Node partionedList = partition(l1.head, val);
        Node partionedList = oddEven(l1.head);

        Node iterator = partionedList;
        while(iterator != null) {
            System.out.print(iterator.data + " ");
            iterator = iterator.next;
        }

        System.out.println();


    }
}