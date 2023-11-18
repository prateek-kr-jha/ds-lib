import java.util.Scanner;

public class Client {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        Queue<Integer> list = new Queue<Integer>();
        while(scn.hasNext()) {
            String command = scn.next();
            if(command.compareTo("+") == 0) {
                list.enqueue(scn.nextInt());
                // System.out.println(scn.nextInt());
            } else if(command.compareTo("=") == 0) {
                System.out.println(list.size() + " size");
            } else if(command.compareTo("RH") == 0) {
                System.out.println(list.dequeue() + " removed head");
            } 
        }

        // for(Integer x : list) {
        //     System.out.print(x + " ");
        // }
        // list.printAll();
        System.out.println();
    }
}
