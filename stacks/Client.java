import java.util.Scanner;

public class Client {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        FixedSizeArrayStack stack1 = new FixedSizeArrayStack();
        // System.out.println(stack1.isEmpty());
        // System.out.println(stack1.isFull());
        // System.out.println(stack1.isEmpty());
        // stack1.push(1);
        // System.out.println(stack1.size());
        // System.out.println(stack1.top());
        // System.out.println(stack1.pop() + " pop");
        // stack1.push(24);
        // stack1.push(241);
        // stack1.push(124);
        // stack1.push(234);
        // System.out.println(stack1.isEmpty() + " is empty");
        // System.out.println(stack1.isFull() + " is full");
        // // System.out.println(stack1.isEmpty() + " is ");
        // System.out.println(stack1.size() + " size");
        // System.out.println(stack1.top() + " top");
        // System.out.println(stack1.pop() + " pop");
        // // stack1.push(32);
        // System.out.println(stack1.top() + " top");
        // System.out.println(stack1.pop() + " pop");

        while(scn.hasNext()) {
            // scn.next().equals("+");
            if(scn.next().equals("+")) {
                stack1.push(scn.nextInt());
                System.out.println("push");
            } else if(scn.next().equals("-")) {
                System.out.println(stack1.pop() + " pop");
            } else if(scn.next().equals("*")) {
                System.out.println(stack1.isEmpty() + " is empty");
            } else if(scn.next().equals("#")) {
                System.out.println(stack1.top() + " top");
            } else if(scn.next().equals("=")) {
                System.out.println(stack1.size() + " size");
            } 
        }

    }
}
