import java.util.Iterator;

public class LinkedList<Item extends Comparable<Item>> implements Iterable<Item>{
    private int size;
    private Node<Item> head;
    private Node<Item> tail;
    public LinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public LinkedList(Item item) {
        this.head = new Node<Item>(item);
        this.tail = head;
        size++;
    }

    public int size() {
        return size;
    }

    public Item head() {
        if(size == 0) {
            throw new IllegalAccessError("No element in the list");
        }
        return head.item;
    }

    public Item tail() {
        if(size == 0) {
            throw new IllegalAccessError("No element in the list");
        }
        return tail.item;
    }
    
    private void addWhenSizeZero(Node<Item> node) {
        this.head = node;
        this.tail = head;
        node = null;
    }
    public void add(Item item) {
        Node<Item> new_node = new Node<Item>(item);
        if(size == 0) {
            addWhenSizeZero(new_node);
        } else {
            this.tail.next = new_node;
            this.tail = tail.next;
        }
        size++;
    }

    public void addHead(Item item) {
        Node<Item> new_node = new Node<Item>(item);
        if(size == 0) {
            addWhenSizeZero(new_node);
        } else {
            new_node.next = head;
            head = new_node;
        }
        size++;
    }

    public Item remove(Item removable) {
        if(size == 0) {
            return null;
        }
        Item returnItem = null;
        Node<Item> i1 = head;
        Node<Item> i2 = null;
        while(i1 != null) {
            if(i1.item.compareTo(removable) == 0) {
                if(i1 == head) {
                    return removeHead();
                }
                returnItem = i1.item;
                i2.next =i1.next;
                i1 = null;
                
                size--;
            } else {
                i2 = i1;
                i1 = i1.next;
            }
        }

        return returnItem;
    }
    public Item removeHead() {
        if(size == 0) {
            return null;
        }

        Item item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new ListIterator();
        
    }

    public class ListIterator implements Iterator<Item> {
        Node<Item> iterator = head;

        public boolean hasNext() {
            return iterator != null;
        }

        public Item next() {
            Item item = iterator.item;
            iterator = iterator.next;
            return item;
        }
    }
}
