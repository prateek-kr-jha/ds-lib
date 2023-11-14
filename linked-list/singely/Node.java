public class Node<Item extends Comparable<Item>> {
    public Item item;
    public Node<Item> next;

    public Node(Item item, Node<Item> next) {
        this.item = item;
        this.next = next;
    }
    public Node(Item item) {
        this.item = item;
        this.next = null;
    }
}