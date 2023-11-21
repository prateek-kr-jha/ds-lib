import java.util.LinkedList;
import java.util.Queue;

public class BST<Item extends Comparable<Item>> {
    private TreeNode<Item> root;
    private int size;

    public BST() {
        this.size = 0;
        this.root = null;
    }

    public int size() {
        return size;
    }

    public Item root() {
        return root.item;
    }

    public void add(Item item) {
        TreeNode<Item> new_node = new TreeNode<Item>(item);

        if(size == 0) {
            root = new_node;
        } else {
            TreeNode<Item> iterator = root;
            while(iterator != null) {
                int comp = iterator.item.compareTo(item);
                if(comp > 0) {
                    if(iterator.left != null) {
                        iterator = iterator.left;
                    } else {
                        iterator.left = new_node;
                        iterator = null;
                        break;
                    }
                } else if(comp < 0) {
                    if(iterator.right != null) {
                        iterator = iterator.right;
                    } else {
                        iterator.right = new_node;
                        iterator = null;
                        break;
                    }
                } else {
                    System.out.println("equals");
                    return;
                }
            }

        }
        size++;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode<Item> node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.item + " ");
        inOrder(node.right);
    }

    public void addRecursive(Item item){
        addRecursive(item, root);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode<Item> node) {
        if(node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.item + " ");
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode<Item> node) {
        if(node == null) {
            return;
        }

        System.out.print(node.item + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    
    public void levelOrder() {
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        while(queue.size() != 0) {
            TreeNode<Item> current_node = queue.poll();
            System.out.print(current_node.item + " ");

            if(current_node.left != null) {
                queue.add(current_node.left);
            }

            if(current_node.right != null) {
                queue.add(current_node.right);
            }
        }

        System.out.println();
    }

    private void addRecursive(Item item, TreeNode<Item> node) {
        int comp = node.item.compareTo(item);
        if(comp > 0) {
            if(node.left != null) {
                addRecursive(item, node.left);
            } else {
                node.left = new TreeNode<Item>(item);
                size++;

            }
        } else if(comp < 0) {
            if(node.left != null) {
                addRecursive(item, node.right);
            } else {
                node.right = new TreeNode<Item>(item);
                size++;
            }
        } else {
            System.out.println("equal");
            return;
        }
    }

    public Item min() {
        return min(root, root.item);
    }

    private Item min(TreeNode<Item> node, Item item) {
        if(node == null) {
            return item;
        }

        if(node.item.compareTo(item) < 0) {
            item = node.item;
        }
        item = min(node.left, item);
        
        return item;
    }
    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        bst.add(50);
        bst.add(25);
        bst.add(12);
        bst.add(37);
        bst.add(75);
        bst.addRecursive(34);
        bst.addRecursive(84);
        bst.addRecursive(8);
        bst.addRecursive(10);
        System.out.println(bst.root());
        System.out.println(bst.size());
        bst.inOrder();
        System.out.println();
        System.out.println(bst.min());
        bst.postOrder();
        System.out.println();
        bst.preOrder();
        System.out.println();
        bst.levelOrder();

    }

}
