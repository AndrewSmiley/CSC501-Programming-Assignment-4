
import java.util.ArrayList;

/**
 * Created by Andrew on 3/29/17.
 */

/**
 * This class represents a binary tree. standard methods are  insert, serach, delete, etc. Some functions, such as insert and delete,
 * include helper functions, named by the function name plus 'recursive'. Essentially, binary tree is a tree in which each node
 * only has 2 children, hte left being < the value at the node and the right value being  >= the value at the node
 */
public class BinaryTree {


    //todo  Get height: compute and return the height of the tree

    protected TreeNode root;
    private int size;

    /**
     * This is our empty constructor which allows us to
     * create an empty binary tree
     */
    public BinaryTree() {
        size = 0;
    }

    /**
     * This is our insertion starter function. This method calls insertrecursive, which is our actual tree traversal
     *
     * @param value
     */
    public void insert(int value) {
        this.root = insertRecursive(this.root, value); //do the insertion and update the tree
        size++; //increment the size
    }

    /**
     * This is our recursive insertion function. This will be called by our actual insertRecursive() function. Traverse the tree
     * and try to determine where to place the value
     *
     * @param tree  the starting tree or subtree
     * @param value the value to insertRecursive
     * @return the updated tree
     */
    public TreeNode insertRecursive(TreeNode tree, int value) {

        //if we are working with a null tree, go ahead and drop the new value at the top
        if (tree == null) {
            return new TreeNode(value);
        }
        //otherwise, logically determine whether we should inch down to the left or the right
        else if (value < tree.getValue()) {
            //set the left subtree to the final result. essentially, this recursion will ultimately return the whole
            //binary tree
            tree.setLeft(insertRecursive(tree.getLeft(), value));

            return tree;
        } else {
            //set the right subtree and recurse to the final result. essentially, this recursion will ultimately return the whole
            //binary tree
            tree.setRight(insertRecursive(tree.getRight(), value));

            return tree;
        }
    }


    /**
     * This is our delete starter method, this method will call the deleteRecursive method, we use this as a starter method
     * and pass in the root of our binary tree and our value to insert
     *
     * @param value the value we want to delete
     */
    public void delete(int value) {
        //update the binary tree as a whole
        this.root = this.deleteRecursive(value, this.root); //the value to delete into the binary tree
        size--;//decrease the size

    }

    /**
     * This is our  actual delete function. Recursively walk down the tree to find the value to delete and remove it
     *
     * @param value the value we wish to deleteRecursive
     * @param node  the starting node
     * @return the tree node we have deleted
     */
    public TreeNode deleteRecursive(int value, TreeNode node) {
        //if we get down here, the value is not in the tree, return null and print a message
        if (node == null) {
            System.out.println("BinaryTree does not contain " + value);
            return null;
        }
        //otherwise, if the tree contains the node
        else if (node.getValue() == value) {
            //if the left child of the node to deleteRecursive is null, them return the right
            //because we are moving the right up to the deleted node's position
            if (node.getLeft() == null) {
                return node.getRight();
            }
            //if the right child of the node to deleteRecursive is null, them return the right
            //because we are moving the left up to the deleted node's position
            else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                //if nether children are null, we need to adjust accordingly
                //start by getting the right child of the node to deleteRecursive
                TreeNode temp = node.getRight();
                //then iterate through its lefts because they will always be less than the value at node.getRight().getValue()
                while (temp.getLeft() != null) {
                    temp = temp.getLeft();
                }
                //finally, update the node we 'deleted' by setting the value of the leftmost right child
                node.setValue(temp.getValue());
                //then deleteRecursive the leftmost child of node.getRight()
                node.setRight(deleteRecursive(temp.getValue(), node.getRight()));

                return node;
            }
        } else {
            //if we make it down here, then here's the thing, we need to continue recursing
            //Just do a logical check to determine where to inch down to the left or the right depending upon how we want to
            if (value < node.getValue()) {
                node.setLeft(deleteRecursive(value, node.getLeft()));
                return node;
            } else {
                node.setRight(deleteRecursive(value, node.getRight()));
                return node;
            }
        }


    }
    /**
     * This is our recursive height traversal function, this one will traverse the nodes recursively and
     * return the farthest depth we've reached
     *
     * @param node  the root of the tree (or subtree) we are starting with
     * @return int the depth of the tree (or subtree)
     */
    int height(TreeNode node)
    {
        //base case
        if (node == null)
            return 0;
        else
        {
            //get the depth of the left and right subtrees
            //tired using max(), but some strange values came up
            int leftDepth = height(node.getLeft());
            int rightDepth = height(node.getRight());

            //basically determine which is deeper, the left or right subtrees
            //increment and return
            if (leftDepth > rightDepth)
                return leftDepth + 1;
            else
                return rightDepth + 1;
        }
    }

    /**
     * This is our recursive inorder traversal.
     * basically recurse left, visit the starting node, then recurse right, should get our values in order
     *
     * @param node  the starting node
     * @param items the
     */
    public void inorder(TreeNode node, ArrayList<Integer> items) {
        //if the node is not null, we can recurse
        if (node != null) {
            //do the recursive left
            inorder(node.getLeft(), items);
            //addd the items we have visted
            items.add(node.getValue());

            //recurse right
            inorder(node.getRight(), items);
        }
    }

    /**
     * This is our recursive preorder method. This method will visit the starting node first, (i.e. add it to the items visited)
     * then recursively visit left, followed by recursively visit right
     *
     * @param node  the starting node
     * @param items the 'nodes' we have visited
     */
    public void preorder(TreeNode node, ArrayList<Integer> items) {
        //if the node is not null, we can recurse
        if (node != null) {
            //add the node we are currently on as visited
            items.add(node.getValue());
            //recurse to the left
            preorder(node.getLeft(), items);
            //recurse to the right
            preorder(node.getRight(), items);
        }
    }

    /**
     * Thisis our recursive postorder method. This method will recurse ot the left first, then recurse to the right,
     * finally visiting the node itself
     *
     * @param node  the starting node
     * @param items the 'nodes' we have visited
     */
    public void postorder(TreeNode node, ArrayList<Integer> items) {
        //if the node is not null, we can recurse
        if (node != null) {
            //first hit all hte lefts
            postorder(node.getLeft(), items);
            //then hit all the rights,
            postorder(node.getRight(), items);
            //finally, visit the node
            items.add(node.getValue());

        }
    }


    /**
     * This is our recursive search function, this functino will traverse the nodes to find the value we are looking for,
     * returning nill otherwise
     *
     * @param value the value we are searching for
     * @param node  the starting node
     * @return
     */
    public TreeNode search(int value, TreeNode node) {
        //if the node we are currently on is not null, check to see if the value exists further down
        if (node != null) {
            //if we've found the value, go ahead and return it
            if (value == node.getValue()) {
                return node;
            } else if (value < node.getValue()) { //otherwise check if hte vlaue falls less than the node we are on
                //if it does, we know that we should search to the left
                return search(value, node.getLeft());
            } else {
                //otherwise, we should look the right
                return search(value, node.getRight());
            }
        }
        //if we get down here, we know that the node does not exist.
        return null;

    }


    /**
     * This method allows us to get the size (number of elements) of the binary tree
     *
     * @return the size of the binary tree
     */
    public int getSize() {
        return size;
    }


}
