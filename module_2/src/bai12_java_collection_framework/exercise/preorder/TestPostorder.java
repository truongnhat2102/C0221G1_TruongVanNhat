package bai12_java_collection_framework.exercise.preorder;

class TestPreorder {
    public static void main(String[] args) {
        //create a BST
        Preorder<String> tree = new Preorder<>();
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
