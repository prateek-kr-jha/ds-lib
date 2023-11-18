import java.util.Scanner;

public class Client {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        while(scn.hasNext()) {
            String command = scn.next();
            if(command.compareTo("+") == 0) {
                list.add(scn.nextInt());
                // System.out.println(scn.nextInt());
            } else if(command.compareTo("=") == 0) {
                System.out.println(list.size() + " size");
            } else if(command.compareTo("H") == 0) {
                System.out.println(list.head() + " head");
            } else if(command.compareTo("T") == 0) {
                System.out.println(list.tail() + " tail");
            } else if(command.compareTo("RH") == 0) {
                System.out.println(list.removeHead() + " removed head");
            } else if(command.compareTo("RT") == 0) {
                System.out.println(list.removeTail() + " removed tail");
            }
            else if(command.compareTo("-") == 0) {
                System.out.println(list.remove(scn.nextInt()) + " removed");
            }
            else if(command.compareTo("+H") == 0) {
                list.addHead(scn.nextInt());
            }
        }

        for(Integer x : list) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
