
/**
 * Created by Andrew on 7/11/16.
 */
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


import java.util.TreeSet;

public class BSTView extends Pane {
    private BinaryTree tree = new BinaryTree();
    private double radius = 15; // Tree node radius
    private double vGap = 50; // Gap between two levels in a tree

    BSTView(BinaryTree tree) {
        this.tree = tree;
        setStatus("Tree is empty");
    }

    public void setStatus(String msg) {
        getChildren().add(new Text(20, 20, msg));
    }

    public void displayTree() {
        this.getChildren().clear(); // Clear the pane
        if (tree.root != null) {
            // Display tree recursively
            displayTree(tree.root, getWidth() / 2, vGap,
                    getWidth() / 4);
        }
    }
    public void displayTreeColors(TreeSet<Integer> treeSet){
        this.getChildren().clear(); // Clear the pane
        if (tree.root != null) {
            // Display tree recursively
            displayTreeColors(tree.root, getWidth() / 2, vGap,
                    getWidth() / 4, treeSet);
        }
    }
    /** Display a subtree rooted at position (x, y) */
    private void displayTree(TreeNode root,
                             double x, double y, double hGap) {
        if (root.getLeft() != null) {
            // Draw a line to the left node
            getChildren().add(new Line(x - hGap, y + vGap, x, y));
            // Draw the left subtree recursively
            displayTree(root.getLeft(), x - hGap, y + vGap, hGap / 2);
        }

        if (root.getRight() != null) {
            // Draw a line to the right node
            getChildren().add(new Line(x + hGap, y + vGap, x, y));
            // Draw the right subtree recursively
            displayTree(root.getRight(), x + hGap, y + vGap, hGap / 2);
        }

        // Display a node
        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle,
                new Text(x - 4, y + 4, root.getValue() + ""));
    }
    /** Display a subtree rooted at position (x, y) */
    private void displayTreeColors(TreeNode root,
                                   double x, double y, double hGap, TreeSet<Integer> treeSet) {
        if (root.getLeft()!= null) {
            // Draw a line to the left node
            getChildren().add(new Line(x - hGap, y + vGap, x, y));
            // Draw the left subtree recursively
            displayTreeColors(root.getLeft(), x - hGap, y + vGap, hGap / 2,treeSet);
        }

        if (root.getRight()!= null) {
            // Draw a line to the right node
            getChildren().add(new Line(x + hGap, y + vGap, x, y));
            // Draw the right subtree recursively
            displayTreeColors(root.getRight(), x + hGap, y + vGap, hGap / 2,treeSet);
        }

        // Display a node
        Circle circle = new Circle(x, y, radius);
        if (treeSet.contains(root.getValue())){
            circle.setFill(Color.ORANGE);
        }else {
            circle.setFill(Color.WHITE);
        }
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle,
                new Text(x - 4, y + 4, root.getValue() + ""));
    }
}