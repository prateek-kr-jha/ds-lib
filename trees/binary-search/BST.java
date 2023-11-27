import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.w3c.dom.traversal.TreeWalker;

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

    // public void deleteTree() {
    //     deleteTree(root);
    // }

    // private void deleteTree(TreeNode<Item> node) {
    //     if(node == null) {
    //         return;
    //     }

    //     deleteTree(node.left);
    //     deleteTree(node.right);
    //     node = null;
    //     size--;
    // }

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

    private TreeNode<Item> searchNode(Item item, TreeNode<Item> node) {
        if(node == null) {
            return null;
        }
        int compare = node.item.compareTo(item);
        if(compare == 0) {
            return node;
        } else if(compare == -1) {
            return searchNode(item, node.right);
        } else {
            return searchNode(item, node.left);
        }
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
            // size--;
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
        // System.out.println(node.item + " recursion stack");
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
            System.out.println("node " + node.item + " " + left_count + " " + right_count);
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

    public static void main(String[] args) {
        
    }
    
}
