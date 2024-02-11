import java.util.*;
public class PartitionList {
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
    public static void main(String[] args) {
        int val = Integer.parseInt(args[0]);
        List l1 = new List();
        while(scn.hasNext()) {
            l1.add(scn.nextInt());
        }
        l1.printAll();
        // while()
        Node partionedList = partition(l1.head, val);

        Node iterator = partionedList;
        while(iterator != null) {
            System.out.print(iterator.data + " ");
            iterator = iterator.next;
        }

        System.out.println();


    }
}