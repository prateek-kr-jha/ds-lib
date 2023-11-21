import java.util.Scanner;

public class Client {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        while(scn.hasNext()) {
            String x = scn.next();
            if(x.compareTo("+") == 0) {
                // System.out.println();
                bst.add(scn.nextInt());
            } else if(x.compareTo("+RC") == 0){
                bst.addRecursive(scn.nextInt());
            } else if(x.compareTo("R") == 0){
                System.out.println(bst.root() + " root");
            } else if(x.compareTo("=") == 0){
                System.out.println(bst.size() + " size");
            } else if(x.compareTo("IO") == 0){
                bst.inOrder();
                System.out.println("in order");
            }else if(x.compareTo("MIN") == 0){
                System.out.println(bst.min() + " min");
            } else if(x.compareTo("PO") == 0){
                bst.postOrder();
                System.out.println("Post order");
            } else if(x.compareTo("PRO") == 0){
                bst.preOrder();
                System.out.println("pre order");
            } else if(x.compareTo("LO") == 0){
                bst.levelOrder();
            } else if(x.compareTo("MAX") == 0){
                System.out.println(bst.max() + " max");
            } else if(x.compareTo("MAXNR") == 0){
                System.out.println(bst.maxNR() + " max nr");
            } else if(x.compareTo("=R") == 0){
                System.out.println(bst.sizeR() + " size recursive");
            } else if(x.compareTo("LOR") == 0){
                bst.levelOrderR();
            }
            // else if(x.compareTo("") == 0){
                
            // }
            // else if(x.compareTo("") == 0){
                
            // }
            // else if(x.compareTo("") == 0){
                
            // }
        }
    }
}