public class FixedSizeArrayStack {
    private int[] stack;
    private int size;
    private int currentIndex;

    public FixedSizeArrayStack(int size) {
        this.stack = new int[size];
        this.size = 0;
        this.currentIndex = 0;
    }
    public FixedSizeArrayStack() {
        this(10);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == stack.length;
    }

    public void push(int data) {
        if(isFull()) {
            System.out.println("Stack already full");
            return;
        }
        stack[size++] = data;
    }
    public int pop() {
        if(isEmpty()) {
            System.out.println("stack is empty");
            throw new IllegalAccessError();
        }

        int element = stack[--size];
        // stack[size] = null;
        return element;
    }

    public int top() {
        if(isEmpty()) {
            throw new IllegalAccessError("empty stack");
        }

        return stack[size - 1];
    }

}