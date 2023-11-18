import java.util.Scanner;

public class ClientNew {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<Integer>();
        while(scn.hasNext()) {
            String command = scn.next();
            if(command.compareTo("+") == 0) {
                array.put(scn.nextInt());
            } else if(command.compareTo("~") == 0) {
                array.replace(scn.nextInt(), scn.nextInt());
            } else if(command.compareTo("=") == 0) {
                System.out.println(array.size());
            } else if(command.compareTo("-") == 0) {
                System.out.println(array.get(scn.nextInt()));
            }
        }

        for(int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
