public class Queue<Item extends Comparable<Item>> {
    LinkedList<Item> queue;

    public Queue() {
        queue = new LinkedList<Item>();
    }

    public int size() {
        return queue.size();
    }

    public void enqueue(Item item) {
        queue.add(item);
    }

    public Item dequeue() {
        return queue.removeHead();
    }

    // public Iterator<Item> iterator() {
    //     return new queue.ListIterator();
    // }

    public void printAll() {
        queue.printAll();
    }
}
