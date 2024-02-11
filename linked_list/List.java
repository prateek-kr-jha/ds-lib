public class List {
    public Node head;
    public Node tail;
    private int size = 0;

    public List() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public List(int item) {
        this.head = new Node(item);
        this.tail = head;
        size++;
    }


    private void addWhenSizeZero(Node node) {
        this.head = node;
        this.tail = head;
        node = null;
    }
    public void add(int item) {
        Node new_node = new Node(item);
        if(size == 0) {
            addWhenSizeZero(new_node);
        } else {
            this.tail.next = new_node;
            this.tail = tail.next;
        }
        size++;
    }

    public int size() {
        return size;
    }
        
    public void printAll() {
    	Node iterator = head;
    	
    	while(iterator != null) {
    		System.out.print(iterator.data + " ");
            iterator = iterator.next;
    	}
    	
    	System.out.println();
    }

}