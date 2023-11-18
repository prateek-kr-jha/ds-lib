import java.util.Iterator;
//linear search
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
    private void addToEmpetyList(Node<Items> node) {
        head = node;
        tail = head;
    }
    public void add(Items item){
        Node<Items> new_node = new Node<Items>(item);

        if(size == 0) {
            addToEmpetyList(new_node);
        } else {
            tail.next = new_node;
            new_node.previous = tail;
            tail = tail.next;
        }
        
        new_node = null;
        size++;
    }

    public void addHead(Items item) {
        Node<Items> new_node = new Node<Items>(item);
        if(size == 0) {
            addToEmpetyList(new_node);
        } else {
            new_node.next = head;
            head.previous = new_node;
            head = new_node;
        }
        new_node = null;
        size++;
    }

    public Items removeHead() {
        if(size == 0) {
            throw new IllegalAccessError("Empty List");
        }
        Items item = head.item;
        head = head.next;
        size--;
        if(size != 0) {
            head.previous = null;
        } else {
            tail = null;
        }
        return item;
    }

    public Items removeTail() {
        if(size == 0) {
            throw new IllegalAccessError("Empty List");
        }
        Items item = tail.item;
        tail = tail.previous;
        size--;
        if(size != 0) {
            tail.next = null;
        } else {
            head = null;
        }
        return item;
    }

    public Items remove(Items item) {
        Node<Items> p1 = head;
        Node<Items> p2 = head;
        Items removed_item = null;
        while(p1 != null) {
            if(p1.item.compareTo(item) == 0) {
                if(p1 == head) {
                    head = p1.next;
                }
                removed_item = p1.item;
                p2.next = p1.next;
                if(p1.next != null) {
                    p1.next.previous = p2;
                }
                p1 = null;
                size--;
                if(size == 0) {
                    head = null;
                    tail = null;
                }
                break;
            } else {
                p2 = p1;
                p1 = p1.next;
            }
        }

        return removed_item;
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
