import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    	Queue<TreeNode<Item>> queue = new LinkedList<TreeNode<Item>>();

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

        System.out.println("level order");
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
        TreeNode<Item> node = min(root);
        return node == null ? null : node.item;
    }

    private TreeNode<Item> min(TreeNode<Item> node) {
        if(node.left == null) {
            return node;
        }
        
        return min(node.left);
    }

    public Item max() {
        return max(root);
    }

    private Item max(TreeNode<Item> node) {
        if(node.right == null) {
            return node.item;
        }
        
        return max(node.right);
    }

    public Item maxNR() {
        TreeNode<Item> current_node = root;
        Item max = root.item;
        while(current_node != null) {
            if(current_node.right != null) {
                current_node = current_node.right;
            } else {
                max = current_node.item;
                break;
            }
        }
        return max;
    }

    public int sizeR() {
        return sizeR(root);
    }  

    private int sizeR(TreeNode<Item> node) {
        if(node == null) {
            return 0;
        }

        return sizeR(node.left) + sizeR(node.right) + 1;
    }

    public void levelOrderR() {
        Queue<TreeNode<Item>> queue = new LinkedList<TreeNode<Item>>();
        Stack<TreeNode<Item>> stack = new Stack<TreeNode<Item>>();
        queue.add(root);

        while(queue.size() != 0) {
            TreeNode<Item> current_node = queue.poll();

            if(current_node.left != null) {
                queue.add(current_node.left);
            }

            if(current_node.right != null) {
                queue.add(current_node.right);
            }
            stack.push(current_node);
        }

        while(!stack.isEmpty()) {
            System.out.print((stack.pop().item) + " ");
        }
        System.out.println("level order reversed");
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode<Item> node) {
        if(node == null) {
            return -1;
        }
        int height_left = height(node.left);
        int height_right = height(node.right);
        if(height_left > height_right) {
            return height_left + 1;
        } 
        return height_right + 1;
    }

    public boolean search(Item item) {
        return search(item, root);
    }

    private boolean search(Item item, TreeNode<Item> node) {
        boolean found = false;
        if(node == null) {
            return found;
        }
        int compare = node.item.compareTo(item);
        if(compare == 0) {
            return true;
        } else if(compare == -1) {
            return found || search(item, node.right);
        } else {
            return found || search(item, node.left);
        }
    }

    public boolean searchNR(Item item) {
        TreeNode<Item> node = root;
        boolean found = false;
        while(node != null) {
            int cmp = node.item.compareTo(item);
            if(cmp == 0) {
                found = true;
                node = null;
                break;
            } else if(cmp == -1) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        return found;
    }

    public void deleteTree() {
        root = null;
    }

    public Item deepestNode() {
        Queue<TreeNode<Item>> queue = new LinkedList<TreeNode<Item>>();
        queue.add(root);
        TreeNode<Item> tmp = null;
        while(queue.size() != 0) {
            tmp = queue.poll();

            if(tmp.right != null) {
                queue.add(tmp.right);
            }

            if(tmp.left != null) {
                queue.add(tmp.left);
            }
        }

        return tmp.item;
    }

    public int rank(Item item) {
        return rank(item, root);
    }

    private int rank(Item item, TreeNode<Item> node) {
        if(node == null) {
            return 0;
        }
        int cmp = node.item.compareTo(item);
        
        if(cmp == 0) {
            return sizeR(node.left);
        } else if(cmp < 0) {
            return sizeR(node.left) + 1 + rank(item, node.right);
        } else {
            return rank(item, node.left);
        }
    }

    public void deleteMin() {
        if(size == 0) {
            System.out.println("Nothing to delete");
            return;
        }
        root = deleteMin(root);
        size = sizeR(root);
    }

    private TreeNode<Item> deleteMin(TreeNode<Item> node) {
        if(node.left == null) {
            // size--;
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }
    
    public void deleteMax() {
        if(size == 0) {
            System.out.println("Nothing to delete");
            return;
        }
        root = deleteMax(root);
        size = sizeR(root);
    }

    private TreeNode<Item> deleteMax(TreeNode<Item> node) {
        if(node.right == null) {
            return node.left;
        }
        node.right = deleteMax(node.right);
        return node;
    }

    public void delete(Item item) {
        root = delete(item, root);
        size = sizeR(root);
    }

    private TreeNode<Item> delete(Item item, TreeNode<Item> node) {
        if(node == null) {
            return null;
        }
        int cmp = node.item.compareTo(item);

        if(cmp < 0) {
            return delete(item, node.right);
        } else if(cmp > 0) {
            return delete(item, node.right);
        } else {
            if(node.right == null) {
                return node.left;
            }
            if(node.left == null) {
                return node.right;
            }

            TreeNode<Item> temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        return node;
    }

    public int leaves() {
        return leaves(root);
    }

    private int leaves(TreeNode<Item> node) {
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            return 1;
        }
        int left_leaves = leaves(node.left);
        int right_leaves = leaves(node.right);
        return left_leaves + right_leaves;

    }

    public int leavesNR() {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode<Item>> queue = new LinkedList<TreeNode<Item>>();
        queue.add(root);
        int leaves = 0;
        while(!queue.isEmpty()) {
            TreeNode<Item> temp_node = queue.poll();
            if(temp_node.left == null && temp_node.right == null) {
                leaves++;
            }

            if(temp_node.left != null) {
                queue.add(temp_node.left);
            }

            if(temp_node.right != null) {
                queue.add(temp_node.right);
            }
        }

        return leaves;
    }

    public int fullNode() {
        return fullNode(root, 0);
    }

    private int fullNode(TreeNode<Item> node, int full_node) {
        if(node == null) {
            return 0;
        }

        int left_count = fullNode(node.left, full_node);
        int right_count = fullNode(node.right, full_node);
        if(node.right != null && node.left != null) {
            full_node = left_count + right_count + 1;
        } else {
            full_node = left_count + right_count;
        }

        return full_node;
    }

    public int halfNode() {
        return halfNode(root);
    }

    private int halfNode(TreeNode<Item> node) {
        if(node == null) {
            return 0;
        }

        int left_count = halfNode(node.left);
        int right_count = halfNode(node.right);
        if((node.left == null && node.right != null) || (node.right == null && node.left != null)) {
            return left_count + right_count + 1;
        } else {
            return left_count + right_count;
        }
    }

    public int halfNodeNR() {
        Queue<TreeNode<Item>> queue = new LinkedList<TreeNode<Item>>();
        int half_nodes = 0;
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode<Item> temp = queue.poll();

            if((temp.right != null && temp.left == null) || (temp.right == null && temp.left != null)) {
                half_nodes++;
            }

            if(temp.left != null) {
                queue.add(temp.left);
            }

            if(temp.right != null) {
                queue.add(temp.right);
            }
        }

        return half_nodes;
    }

    public int fullNodeNR() {
        Queue<TreeNode<Item>> queue = new LinkedList<TreeNode<Item>>();
        int full_node = 0;
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode<Item> temp = queue.poll();
            
            if(temp.right != null && temp.left != null) {
                full_node++;
            }

            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
        }

        return full_node;
    }

    public boolean compareStructure(TreeNode<Item> node1, TreeNode<Item> node2) {
        if(node1 == null && node2 == null) {
            return true;
        }

        if(node1 == null || node2 == null) {
            return false;
        }
        boolean left_compare = compareStructure(node1.left, node2.left);
        boolean right_compare = compareStructure(node1.right, node2.right);
        return left_compare && right_compare;
    }

    public int diameter() {
        return diameter(root);
    }

    private int max(int a, int b, int c) {
        if((a >= b && b >= c) || (a >= c && c >= b)) {
            return a;
        }
        if((b >= a && a >= c) || (b >= c && c >= a)) {
            return b;
        }
        return c;
    }

    private int diameter(TreeNode<Item> node) {
        if(node == null) {
            return 0;
        }
        int left_height = height(node.left);
        int right_height = height(node.right);
        int left_dia = diameter(node.left);
        int right_dia = diameter(node.right);

        return max(right_dia, left_dia, left_height + right_height + 3);
    }

    public int width() {
        int max = 0;
        int height = height();

        for(int i = 0; i <= height; i++) {
            int tmp = width(root, i);

            if(tmp > max) {
                max = tmp;
            }
        }

        return max;
    }

    private int width(TreeNode<Item> node, int k) {
        if(node == null) {
            return 0;
        }

        if(k == 0) {
            return 1;
        } else {
            return width(node.left, k - 1) + width(node.right, k - 1);
        }
    }

    public int maxSum() {
        int max = Integer.MIN_VALUE;
        int height = height();

        for(int i = 0; i <= height; i++) {
            int tmp = (Integer) maxSum(root, i);

            if(max < tmp) {
                max = tmp;
            }
        }

        return max;
    }

    private Item maxSum(TreeNode<Item> node, int k) {
        if(node == null) {
            return  (Item) Integer.valueOf(0);
        }

        if(k == 0) {
            return node.item;
        } else {
            Item left = maxSum(node.left, k - 1);
            Item right = maxSum(node.right, k - 1);
            return (Item) (Integer)((Integer) left + (Integer) right); 
        }
    }

    public void rootToLeaf(){
        Item[] path =(Item[]) new Comparable[256];
        rootToLeaf(root, path, 0);
    }

    private void rootToLeaf(TreeNode<Item> node, Item[] path, int pathLen) {
        if(node == null) {
            return;
        }

        path[pathLen++] = node.item;
        if(node.right == null && node.left == null) {
            printPath(path, pathLen);
        } else {
            rootToLeaf(node.left, path, pathLen);
            rootToLeaf(node.right, path, pathLen);
        }
    }

    private void printPath(Item[] path, int pathLen) {
        for(int i = 0; i < pathLen; i++) {
            System.out.print(path[i] + " ");
        }

        System.out.println();
    }

    public boolean hasPathSum(int sum) {
        return hasPathSum(root, sum);
    }

    private boolean hasPathSum(TreeNode<Item> node, int sum) {
        if(node == null) {
            return false;
        }
        Integer num = (Integer) node.item;
        if(num == sum) {
            return true;
        }
        if(sum < num) {
            return false;
        }

        sum -= num;
        if(sum <= num) {
            return hasPathSum(node.left, sum);
        } else {
            return hasPathSum(node.right, sum);
        }
    }

    public int sumOfAllNodes() {
        return sumOfAllNodes(root);
    }

    private int sumOfAllNodes(TreeNode<Item> node) {
        if(node == null) {
            return 0;
        }

        return (Integer) node.item + sumOfAllNodes(node.left) + sumOfAllNodes(node.right);
    }
    public void mirror() {
        mirror(root);
    }
    private void mirror(TreeNode<Item> node) {
        if(node == null) {
            return;
        }
        mirror(node.left);
        mirror(node.right);

        TreeNode<Item> tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }

    public boolean isMirror(TreeNode<Item> node1, TreeNode<Item> node2) {
        if(node1 == null && node2 == null) {
            return true;
        }
        if(node1 == null || node2 == null) {
            return false;
        }

        if(node1.item.compareTo(node2.item) != 0) {
            return false;
        } 
        boolean left = isMirror(node1.left, node2.right);
        boolean right = isMirror(node1.right, node2.left);
        return (left && right);
    }
    //---------------------------------------------------------------------------------------//
    public static void main(String[] args) {
        BST<Integer> bst1 = new BST<Integer>();
        BST<Integer> bst2 = new BST<Integer>();

        for(int i = 100; i > 0; i-=20) {
            bst1.add(i);
            bst2.add(i);
        }
        // bst1.add(200);
        bst2.add(200);
        bst1.inOrder();
        System.out.println("in order");
        bst2.inOrder();
        System.out.println("in order");
        bst1.mirror();
        System.out.println(bst1.isMirror(bst1.root, bst2.root));;

    }
    
}
