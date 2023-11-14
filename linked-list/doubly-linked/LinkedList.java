import java.util.Iterator;

public class LinkedList<Items extends Comparable<Items>> implements Iterable<Items> {
    public class Node<Items extends Comparable<Items>> {
        public Items item;
        public Node<Items> next;
        public Node<Items> previous;
        public Node(Items item) {
            this.item = item;
            this.next = null;
            this.previous = null;
        }
    }

    private Node<Items> head;
    private Node<Items> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public Items head() {
        return this.head != null ? head.item : null;
    }

    public Items tail() {
        return this.tail != null ? tail.item : null;
    }

    public void add(Items item){
        Node<Items> new_node = new Node<Items>(item);

        if(size == 0) {
            head = new_node;
            tail = head;
        } else {
            tail.next = new_node;
            new_node.previous = tail;
            tail = tail.next;
        }

        size++;
    }

    public Iterator<Items> iterator() {
        // TODO Auto-generated method stub
        return new LinkedListIterator();
    }
    
    public class LinkedListIterator implements Iterator<Items> {
        Node<Items> iterator = head;

        public boolean hasNext() {
            return iterator != null;
        }

        public Items next() {
            Items item = iterator.item;
            iterator = iterator.next;
            return item;
        }
    }
    

}
