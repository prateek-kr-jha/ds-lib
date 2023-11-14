import java.util.Iterator;

public class DynamicArray<Item> implements Iterable<Item> {
    private int size;
    private Item[] array;

    public DynamicArray() {
        this.size = 0;
        this.array = (Item[]) new Object[2];
    }

    public int size() {
        return size;
    }

    private void resize() {
        Item[] new_array = (Item[]) new Object[array.length * 2];
        for(int i = 0; i < array.length; i++) {
            new_array[i] = array[i];
        }

        array = new_array;
        new_array = null;
    }

    public Item get(int index) {
        if(index < -1 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }

        return array[index];
    }

    public void put(Item value) {
        array[size++] = value;

        if(size == array.length) {
            resize();
        }
    }

    public void replace(int index, Item value) {
        if(index < -1 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }

        array[index] = value;
    }

    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new dynamicArrayIterator();
    }

    public class dynamicArrayIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext() {
            return i < size;
        }
        public Item next() {
            Item value = array[i++];
            return value;
        }
    }
}
