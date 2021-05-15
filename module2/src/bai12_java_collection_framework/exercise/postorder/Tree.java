package bai12_java_collection_framework.exercise.postorder;

public interface Tree<E> {
    /**
     * Insert element e into the binary search tree.
     * Return true if the element is inserted successfully.
     */
    public boolean insert(E e);
    /**
     * Inorder traversal from the root
     */
    public void postorder();
    /**
     * Get the number of nodes in the tree
     */
    public void preorder();
    /**
     * Get the number of nodes in the tree
     */
    public int getSize();
}
