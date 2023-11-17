import java.util.Scanner;

public class Client {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        while(scn.hasNext()) {
            String x = scn.next();
            if(x.compareTo("+") == 0) {
                System.out.println(scn.nextInt());
            }
        }
    }
}