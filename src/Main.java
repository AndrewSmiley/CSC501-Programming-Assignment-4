import java.io.*;
import java.util.ArrayList;

/**
 * Created by Andrew on 3/29/17.
 */
public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        int size = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        //attempt to open the file
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("prog4in1.txt")));
            //reference for our line
            String line;

            //the line count
            int lineCount = 0;
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
//                tree.root = tree.insert(tree.root, Integer.parseInt(line));
//                numbers[lineCount - 1] = Integer.parseInt(line);

            }

            br.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        //add the numbers from the array into the binary tree
        for (Integer i : numbers) {
            tree.root = tree.insert(tree.root, i);
        }

        //output size and height
        System.out.println("Size: " + tree.getSize() + "\t\tHeight: " + tree.getHeight());
        //first the preorder
        ArrayList<Integer> preorder = new ArrayList<>();
        tree.preorder(tree.root, preorder);
        StringBuilder preordersb = new StringBuilder();
        preordersb.append("Preorder: ");
        for (Integer i : preorder) {
            preordersb.append(i + " ");
        }

        System.out.println(preordersb.toString());

        ArrayList<Integer> inorder = new ArrayList<>();
        tree.inorder(tree.root, inorder);
        StringBuilder inordersb = new StringBuilder();
        inordersb.append("Inorder: ");
        for (Integer i : inorder) {
            inordersb.append(i + " ");
        }

        System.out.println(inordersb.toString());
        //Now the postorder styff
        ArrayList<Integer> postorder = new ArrayList<>();
        tree.postorder(tree.root, postorder);
        StringBuilder postordersb = new StringBuilder();
        postordersb.append("Postorder: ");
        for (Integer i : postorder) {
            postordersb.append(i + " ");
        }

        System.out.println(postordersb.toString());
        /**deleteRecursive every third element of the array from the tree. After each deleteRecursive, output the current
         *size and height of the tree
         * */
        for (int i = 0; i < numbers.size(); i = i + 4) {
            tree.deleteRecursive(numbers.get(i), tree.root);
            System.out.println("Deleting: " + numbers.get(i) + "\t\tSize: " + tree.getSize() + "\t\tHeight: " + tree.getHeight());

        }

        /**
         * Next, search for every fifth element of the array. Some of these won’t
         be found. The result of a search should merely output if the value was found or not
         */
        for (int i = 0; i < numbers.size(); i = i + 5) {
            TreeNode result = tree.search(numbers.get(i), tree.root);
            System.out.println(numbers.get(i)+ ((result==null)? " Not Found" :" Found"));
        }

        //first the preorder
        ArrayList<Integer> preorder1 = new ArrayList<>();
        tree.preorder(tree.root, preorder1);
        StringBuilder preordersb1 = new StringBuilder();
        preordersb1.append("Preorder: ");
        for (Integer i : preorder1) {
            preordersb1.append(i + " ");
        }

        System.out.println(preordersb1.toString());

        ArrayList<Integer> inorder1= new ArrayList<>();
        tree.inorder(tree.root, inorder1);
        StringBuilder inordersb1= new StringBuilder();
        inordersb1.append("Inorder: ");
        for (Integer i : inorder1) {
            inordersb1.append(i + " ");
        }

        System.out.println(inordersb1.toString());
        //Now the postorder styff
        ArrayList<Integer> postorder1 = new ArrayList<>();
        tree.postorder(tree.root, postorder1);
        StringBuilder postordersb1 = new StringBuilder();
        postordersb1.append("Postorder: ");
        for (Integer i : postorder1) {
            postordersb1.append(i + " ");
        }
        System.out.println(postordersb1);

    }


}
