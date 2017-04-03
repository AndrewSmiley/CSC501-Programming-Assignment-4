import java.util.ArrayList;

/**
 * Created by Andrew on 3/31/17.
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
     * @param value
     */
    public void insert(int value){
        this.root = insertRecursive(this.root, value); //do the insertion and update the tree
        size++;
    }

    /**
     * This is our recursive insertion function. This will be called by our actual insertRecursive() function. Traverse the tree
     * and try to determine where to place the value
     * @param tree the starting tree or subtree
     * @param value the value to insertRecursive
     * @return the updated tree
     */
    public TreeNode insertRecursive(TreeNode tree, int value) {

        //if we are working with a null tree, go ahead and drop the new value at the top
        if(tree == null) {
            return new TreeNode(value);
        }
        //otherwise, logically determine whether we should inch down to the left or the right
        else if(value<tree.getValue( )) {
            //set the left subtree to the final result. essentially, this recursion will ultimately return the whole
            //binary tree
            tree.setLeft(insertRecursive(tree.getLeft(), value));

            return tree;
        }
            else {
            //set the right subtree and recurse to the final result. essentially, this recursion will ultimately return the whole
            //binary tree
                tree.setRight(insertRecursive(tree.getRight(), value));

                return tree;
        }
    }


    /**
     * This is our delete starter method, this method will call the deleteRecursive method, we use this as a starter method
     * and pass in the root of our binary tree and our value to insert
     * @param value the value we want to delete
     */
    public void delete(int value){
        //update the binary tree as a whole
        this.root = this.deleteRecursive(value, this.root); //the value to delete into the binary tree
        size--;//decrease the size

    }
    /**
     * This is our  actual delete function
     * @param value the value we wish to deleteRecursive
     * @param node the starting node
     * @return the tree node we have deleted
     */
    public TreeNode deleteRecursive(int value, TreeNode node) {
        //if we get down here, the value is not in the tree, return null and print a message
        if(node==null) {
            System.out.println("BinaryTree does not contain "+value);
            return null;
        }
        //otherwise, if the tree contains the node
        else if(node.getValue()==value) {
            //if the left child of the node to deleteRecursive is null, them return the right
            //because we are moving the right up to the deleted node's position
            if(node.getLeft()==null) {
                return node.getRight();
            }
            //if the right child of the node to deleteRecursive is null, them return the right
            //because we are moving the left up to the deleted node's position
            else if(node.getRight()==null){
                return node.getLeft();
            }
            else {
                //if nether children are null, we need to adjust accordingly
                //start by getting the right child of the node to deleteRecursive
                TreeNode temp = node.getRight();
                //then iterate through its lefts because they will always be less than the value at node.getRight().getValue()
                while(temp.getLeft()!=null) {
                    temp=temp.getLeft();
                }
                //finally, update the node we 'deleted' by setting the value of the leftmost right child
                node.setValue(temp.getValue());
                //then deleteRecursive the leftmost child of node.getRight()
                node.setRight(deleteRecursive(temp.getValue(), node.getRight()));

                return node;
            }
        }
        else {
            //if we make it down here, then here's the thing, we need to continue recursing
            //Just do a logical check to determine where to inch down to the left or the right depending upon how we want to
            if(value<node.getValue()) {
                node.setLeft(deleteRecursive(value, node.getLeft()));
                return node;
            }
            else {
                node.setRight(deleteRecursive(value, node.getRight()));
                return node;
            }
        }


    }



    public int getHeight(){
        Integer lheight = 0; //default to -1
        lheight = height(root, lheight); //make the recursize call
        return lheight;
    }

    protected int height(TreeNode root, Integer l ){
        if(root == null) return l;
//        System.out.println("Recursing: "+l.toString());
        return Math.max(height(root.getLeft(),l++),height(root.getRight(),l++));
    }

    public void inorder(TreeNode r, ArrayList<Integer> items) {
        if(r!=null) {
            inorder(r.getLeft(), items);
            items.add(r.getValue());

            inorder(r.getRight(), items);
        }
    }

    public void preorder(TreeNode r, ArrayList<Integer> items) {
        if(r!=null) {
            items.add(r.getValue());
            preorder(r.getLeft(), items);
            preorder(r.getRight(), items);
        }
    }
    public void postorder(TreeNode r, ArrayList<Integer> items) {
        if(r!=null) {


            postorder(r.getLeft(), items);
            postorder(r.getRight(), items);
            items.add(r.getValue());

        }
    }



    public TreeNode search(int x, TreeNode t)  {
        if(t!=null) {
            if(x == t.getValue())  return t;
            else if(x < t.getValue()) return search(x, t.getLeft( ));
            else return search(x, t.getRight( ));
        }
        else return null; // not found
    }




    /**
     * This method allows us to get the size (number of elements) of the binary tree
     * @return the size of the binary tree
     */
    public int getSize() {
        return size;
    }


}
