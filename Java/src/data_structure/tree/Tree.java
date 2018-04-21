package data_structure.tree;

public interface Tree<E> {
	void preOrderTraversal();

	void inOrderTraversal();

	void postOrderTraversal();

	default void levelOrderTraversal() {}
}
