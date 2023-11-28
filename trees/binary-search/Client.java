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
            } else if(x.compareTo("H") == 0){
                System.out.println(bst.height() + " height");
            } else if(x.compareTo("S") == 0){
                int to_search = scn.nextInt();
                System.out.println("found " + to_search + " " + bst.search(to_search));
            } else if(x.compareTo("SNR") == 0){
                int to_search = scn.nextInt();
                System.out.println("found " + to_search + " " + bst.searchNR(to_search));
            } else if(x.compareTo("DT") == 0){
                bst.deleteTree();
            }
            else if(x.compareTo("DL") == 0){
                System.out.println(bst.deepestNode() + " deepest node");
            } else if(x.compareTo("RA") == 0){
                System.out.println(bst.rank(scn.nextInt()) + " rank");
            } else if(x.compareTo("-MIN") == 0){
                bst.deleteMin();
            } else if(x.compareTo("-MAX") == 0){
                bst.deleteMax();
            } else if(x.compareTo("-") == 0){
                bst.delete(scn.nextInt());
            } else if(x.compareTo("L") == 0){
                System.out.println(bst.leaves() + " leaves");
            } else if(x.compareTo("LNR") == 0){
                System.out.println(bst.leavesNR() + " leaves");
            } else if(x.compareTo("FN") == 0){
                System.out.println(bst.fullNode() + " full node");
            } else if(x.compareTo("HN") == 0){
                System.out.println(bst.halfNode() + " half node");
            } else if(x.compareTo("HNNR") == 0){
                System.out.println(bst.halfNode() + " half node non recursive");
            } else if(x.compareTo("FNNR") == 0){
                System.out.println(bst.fullNodeNR() + " full node non recursive");
            } else if(x.compareTo("D") == 0){
                System.out.println(bst.diameter() + " diameter");
            } 
            // else if(x.compareTo("") == 0){
                
            // }
        }
    }
}