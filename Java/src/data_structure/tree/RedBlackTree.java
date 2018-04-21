package data_structure.tree;

/**
 * 红黑树
 * <p>
 * 着色性质：
 * <p>
 * 1、每个结点或者是红色，或者是黑色
 * 2、根是黑色的
 * 3、如果一个结点是红色的，那么它的子结点必须是黑色的
 * 4、从一个结点到一个 null 指针的每一条路径必须包含相同数目的黑色结点
 * <p>
 * 同时为了分析简单，我们默认所有的空结点（NULL）为黑色。
 */
@SuppressWarnings("unchecked")
public class RedBlackTree<E extends Comparable> implements Tree<E> {
	private static final boolean RED = true;
	private static final boolean BLACK = true;
	private Node root;


	@Override
	public void preOrderTraversal() {
		this.preOrderTraversal(this.root);
		System.out.println();
	}

	@Override
	public void inOrderTraversal() {
		this.inOrderTraversal(this.root);
		System.out.println();
	}

	@Override
	public void postOrderTraversal() {
		this.postOrderTraversal(this.root);
		System.out.println();
	}


	// ***********************
	//  start private methods
	// ***********************

	/**
	 * 红黑树的插入
	 * <p>
	 * 首先，将红黑树当作一颗二叉搜索树进行插入，然后将结点着色为红色，最后通过旋转和重新着色等一系列操作来修正树，使其重新成为一颗红黑树
	 * <p>
	 * 第一步：将红黑树作为一颗二叉搜索树，将结点插入
	 * 第二步：将插入的结点着色为红色（避免违背性质4）
	 * 第三步：通过一系列旋转或着色操作，使之重新成为一颗红黑树
	 * <p>
	 * 对于红黑树的四条着色性质：
	 * <p>
	 * 1、每个结点或者是红色，或者是黑色
	 * 2、根是黑色的
	 * 3、如果一个结点是红色的，那么它的子结点必须是黑色的
	 * 4、从一个结点到一个 null 指针的每一条路径必须包含相同数目的黑色结点
	 * <p>
	 * 插入一个新结点显然有可能违背性质 3，我们需要通过一系列操作来让它重新满足
	 */
	private void insert(Node node, E key) {
		if (node == null) {
			this.root = new Node(key);
		} else {
			int cmp;
			while (true) {
				cmp = key.compareTo(node.key);
				if (cmp < 0) {
					if (node.left == null) {
						node.left = new Node(key);
						break;
					} else {
						node = node.left;
					}
				} else if (cmp > 0) {
					if (node.right == null) {
						node.right = new Node(key);
						break;
					} else {
						node = node.right;
					}
				} else {
					break;
				}
			}
		}
		this.insertFix(node);
	}

	/**
	 * 正常插入后，我们通过 fix 函数来修正红黑树
	 *
	 * 插入存在三种情况：
	 *
	 * 1、被插入结点是根结点
	 * 处理：直接把此结点涂成黑色
	 *
	 * 2、被插入结点的父结点是黑色
	 * 处理：什么也不做，结点插入后，仍然是红黑树
	 *
	 * 3、被插入结点的父结点是红色
	 * 处理：这种情况下，被插入结点一定存在非空祖父结点；进一步讲，被插入结点也一定存在叔叔结点（空结点视为黑色）。
	 * 根据叔叔结点的情况，将这种情况进一步分为三种子情况：
	 *
	 * 1）父结点为红色，叔叔结点也为红色：
	 * 处理：父结点设为黑色，叔叔结点设为黑色，祖父结点设为红色，将祖父结点设为当前结点。
	 * 即，之后继续对当前结点进行操作
	 * 2）父结点红色，叔叔结点黑色，且当前结点是父结点的左儿子：
	 * 处理：父结点设为黑色，祖父结点设为红色，以祖父结点为支点右旋
	 * 3）父结点红色，叔叔结点黑色，且当前结点为父结点的右儿子：
	 * 处理：以父结点为新的当前结点，以新的当前结点为支点左旋。其实是转换成第二种情况进行处理
	 */
	private void insertFix(Node node) {

	}

	private Node leftRotation(Node node) {
		Node tmp = node.right;
		node.right = tmp.left;
		tmp.left = node;
		return tmp;
	}

	private Node rightRotation(Node node) {
		Node tmp = node.left;
		node.left = tmp.right;
		tmp.right = node;
		return tmp;
	}

	private void preOrderTraversal(Node node) {
		if (node != null) {
			System.out.print(node.key + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	private void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.key + " ");
			inOrderTraversal(node.right);
		}
	}

	private void postOrderTraversal(Node node) {
		if (node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.key + " ");
		}
	}

	private boolean isRed(Node node) {
		// node == null, BLACK
		// node != null, judge
		return node != null && node.color;
	}

	private static final class Node<E> {
		boolean color;  // 颜色
		E key;
		Node left, right;

		public Node(E key) {
			this.key = key;
			this.color = RED;
			this.left = null;
			this.right = null;
		}

		public Node(boolean color, E key, Node left, Node right) {
			this.color = color;
			this.key = key;
			this.left = left;
			this.right = right;
		}
	}
}
