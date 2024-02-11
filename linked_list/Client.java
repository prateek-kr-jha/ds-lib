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

    public static void printList(Node head) {
        Node iterator = head;
        while(iterator != null && iterator.next != head && iterator.next.next != head) {
            System.out.print(iterator.data + " ");
            iterator = iterator.next;
        }
        if(iterator.next != head) {
            System.out.print(iterator.next.data);
        }
        System.out.println();
    }
    public static Node findCenterNode(Node headNode) {
        if(headNode == null) {
            return headNode;
        }
        Node tail = headNode;
        Node center = headNode;
        while(tail.next != headNode && tail.next.next != headNode) {
            tail = tail.next.next;
            center = center.next;
        }
        if(tail.next != headNode) {
            tail = tail.next;
        }

        System.out.println(tail.data +" + " + center.data);
        tail.next = center.next;
        Node cl2 = center.next;
        Node cl1 = headNode;
        center.next = headNode;
        printList(cl1);
        printList(cl2);
        return tail;

    }
    public static void main(String[] args) {
        // int val = Integer.parseInt(args[0]);
        List l1 = new List();
        while(scn.hasNext()) {
            l1.add(scn.nextInt());
        }

        // printList(l1.head);
        l1.printAll();
        l1.tail.next = l1.head;
        // while()
        Node partionedList = findCenterNode(l1.head);
        // Node partionedList = oddEven(l1.head);

        // Node iterator = partionedList;
        // while(iterator != null) {
        //     System.out.print(iterator.data + " ");
        //     iterator = iterator.next;
        // }

        System.out.println(partionedList.data);


    }
}