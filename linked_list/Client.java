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

    public static Node reverseList(Node head) {
        Node current = head;
        Node prev = null;
        Node next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public static boolean palindrome(Node head) {
        Node center = head;
        Node tail = head;
        while (tail.next != null && tail.next.next != null) {
            tail = tail.next.next;
            center = center.next;
        }

        Node reversedHalf = reverseList(center.next);
        center.next = null;
        Node firstHalf = head;
        while(firstHalf != null && reversedHalf != null) {
            if(firstHalf.data != reversedHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            reversedHalf = reversedHalf.next;
        }
        return true;
    }

    public static Node exchangeAdjacent(Node head) {
        if(head == null) {
            System.out.println("empty list");
            return null;
        }
        Node curr = head;

        while(curr != null && curr.next != null) {
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;
            curr = curr.next.next;
        }

        return head;
    }

    // TODO reverse k nodes recursive and swap adjacent book method
    public static Node reverseKNode(Node head, int k) {
        if(head == null || k == 1) {
            return head;
        }

        Node current = head;
        Node prev = null;
        Node next = null;
        int count = k;
        int length = 0;
        while(current != null && length != k) {
            length++;
            current = current.next;
        }

        if(length != k) {
            return head;
        }
        current = head;
        while(current != null && count > 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count--;
        }

        if(next != null) {
            head.next = reverseKNode(next, k);
        }

        return prev;
    }
    public static void main(String[] args) {
        int val = Integer.parseInt(args[0]);
        List l1 = new List();
        while(scn.hasNext()) {
            l1.add(scn.nextInt());
        }

        // printList(l1.head);
        l1.printAll();
        // l1.tail.next = l1.head;
        // while()
        Node partionedList = reverseKNode(l1.head, val);
        // Node partionedList = palindrome(l1.head);
        Node iterator = partionedList;

        while(iterator != null) {
            System.out.print(iterator.data + " ");
            iterator = iterator.next;
        }
        System.out.println();
        // System.out.println(palindrome(l1.head));


    }
}