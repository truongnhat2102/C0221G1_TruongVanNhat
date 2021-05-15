package bai12_java_collection_framework.exercise.postorder;

public class TestPostorder {
    public static void main(String[] args) {
        //create a BST
        Postorder<String> tree = new Postorder<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        //traverse tree
        System.out.println("Inorder (sorted): ");
        tree.postorder();
        System.out.println("The number of nodes is: " + tree.getSize());
    }
}
