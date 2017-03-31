/**
 * Created by Andrew on 3/31/17.
 */
public class TreeNode {

    /**
     * The left node of the current node
     */
    private TreeNode left;

    /**
     * The right node the current node
     */
    private TreeNode right;

    /**
     * The value contained in this node
     */
    private Integer value;

    /**
     * Default, empty constructor
     */
    public TreeNode() {
    }

    /**
     * This constructor allows us to instanciate a node and pass in a value contained in this node
     * @param value the value we want to pass into this node
     */
    public TreeNode(Integer value) {
        this.value = value;

    }

    /**
     * Get the left child node of the current node
     * @return the left child node of the current node
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * Set the left child node of the current node
     * @param left the new node to add
     */
    public void setLeft(TreeNode left) {
        //just some debugging if we are adding the values incorrectly
        if(left.getValue() >= this.getValue())
            System.out.println("WARNING: You are adding a value incorrectly (left) to node "+this.getValue());
        this.left = left;
    }

    /**
     * Get the right node of the current node
     * @return the right node of the current node
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     * Set the right node of the current node
     * @param right the new node to add to the current node at the right child position
     */
    public void setRight(TreeNode right) {
        //just some debugging if we are adding the values incorrectly
        if(right.getValue() < this.getValue())
            System.out.println("WARNING: You are adding a value incorrectly (right) to node "+this.getValue());

        this.right = right;
    }

    /**
     * Get the value stored in the current node
     * @return the value stored in the current node
     */
    public Integer getValue() {
        return value;
    }

    /**
     * set the value of the current node
     * @param value the new value of the node
     */
    public void setValue(Integer value) {
        this.value = value;
    }
}
