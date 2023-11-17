public class TreeNode<Item extends Comparable<Item>> {
    public Item item;
    public TreeNode<Item> left;
    public TreeNode<Item> right;
    public TreeNode<Item> parent;

    public TreeNode(Item item, TreeNode<Item> left, TreeNode<Item> right) {
        this.item = item;
        this.left = left;
        this.right = right;
        this.parent = null;
    }

    public TreeNode(Item item, TreeNode<Item> left, TreeNode<Item> right, TreeNode<Item> parent) {
        this.item = item;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public TreeNode(Item item) {
        this.item = item;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

}