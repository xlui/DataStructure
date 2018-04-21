package data_structure.tree;

/**
 * Unchecked Splay Tree
 * 每次插入删除都进行旋转。对于插入，将新增的结点旋转为根。对于删除，如果被删除结点右左儿子，将其作为新的根；如果没有，将右儿子作为新的根。
 * 旋转使用了新的算法，见函数。
 */
@SuppressWarnings("unchecked")
public class SplayTree<E extends Comparable> implements Tree<E> {
	private Node root;

	public SplayTree() {
		this.root = null;
	}

	public void insert(E key) {
		// 先将结点正常插入伸展树
		this.root = this.insert(this.root, key);
		// 将插入的结点旋转为树的根
		this.root = this.splay(this.root, key);
	}

	/**
	 * 首先将要删除的结点旋转为根结点。
	 * 如果结点存在左儿子，右旋将左儿子旋转为新的根，删除右儿子
	 * 如果结点没有左儿子，右旋将右儿子旋转为新的根，删除右儿子
	 */
	public void remove(E key) {
		if (this.root == null) {
			return;
		}
		this.root = this.splay(this.root, key);

		if (key.compareTo(this.root.key) == 0) {
			if (this.root.left == null) {
				this.root = this.root.right;
			} else {
				Node node = this.root.right;
				this.root = this.splay(this.root.left, key);
				this.root.right = node;
			}
		}
	}

	@Override
	public void preOrderTraversal() {
		this.preOrderTraversal(this.root);
	}

	@Override
	public void inOrderTraversal() {
		this.inOrderTraversal(this.root);
	}

	@Override
	public void postOrderTraversal() {
		this.postOrderTraversal(this.root);
	}

	// ********************
	//    private method
	// ********************
	private Node insert(Node node, E key) {
		if (node == null) {
			node = new Node(key);
		} else if (key.compareTo(node.key) < 0) {
			node.left = insert(node.left, key);
		} else if (key.compareTo(node.key) > 0) {
			node.right = insert(node.right, key);
		} else {
			System.out.println("不允许插入相同结点！");
		}
		return node;
	}

	/**
	 * 算法思想参考了《数据结构与算法分析 —— C语言描述》中伸展树自底向上展开
	 * 以下注释中，
	 * <strong>根结点</strong>指的是调用 splay 时传入的 node 结点
	 * <strong>目标结点</strong>是程序中调用 splay 函数的语句返回的结点
	 */
	private Node splay(Node node, E key) {
		if (node == null) {
			// 如果结点为空，返回 null
			return null;
		}

		if (key.compareTo(node.key) < 0) {
			// 处理左侧，key < root.key
			if (node.left == null) {
				// 如果根结点没有左儿子，说明不存在值为 key 的结点，将根结点返回作为新的根。
				return node;
			}
			if (key.compareTo(node.left.key) < 0) {
				// 如果 key 小于根结点的左儿子，则对根结点的左儿子的左儿子进行 splay 调用
				node.left.left = splay(node.left.left, key);
				// 调用结束后对根结点进行一次右旋，根结点指向其原左儿子，目标结点（（原根结点的左儿子的左儿子）旋转到根结点的左儿子
				//  A       B
				// B   =>  C A
				//C     目标结点是 C
				node = rightRotation(node);
			} else if (key.compareTo(node.left.key) > 0) {
				// 如果 key 大于根结点的左儿子，则对根结点的左儿子的右儿子进行 splay 调用
				node.left.right = splay(node.left.right, key);
				if (node.left.right != null)
					// 如果调用结束目标结点（根结点的左儿子的右儿子）非空，则在左儿子处进行一次左旋，将目标结点旋转到根结点的左儿子
					node.left = leftRotation(node.left);
				//  A       A
				// B   =>  C    C 是目标结点
				//  C     B
			}

			// 最后如果根结点左儿子为空，则不存在 key 结点，返回当前根结点
			if (node.left == null) {
				return node;
			} else {
				// 如果左儿子非空，则说明 key 结点存在，并且就在根结点的左儿子，进行一次右旋将其旋转为新的根结点
				return rightRotation(node);
			}
		} else if (key.compareTo(node.key) > 0) {
			// 处理右侧，key > root.key
			if (node.right == null) {
				// 如果根结点没有右儿子，说明不存在值为 key 的结点，将当前结点返回作为根。
				return node;
			}
			if (key.compareTo(node.right.key) < 0) {
				// 如果 key 小于根结点的右儿子，则对根结点的右儿子的左儿子进行 splay 调用
				node.right.left = splay(node.right.left, key);
				if (node.right.left != null)
					// 如果调用结束并且目标结点（根结点的右儿子的左儿子）非空，则对根结点的右儿子进行一次右旋，将目标结点旋转为根结点的右儿子
					node.right = rightRotation(node.right);
				// A        A
				//  B  =>    C      C是目标结点
				// C          B
			} else if (key.compareTo(node.right.key) > 0) {
				// 如果 key 大于根结点的右儿子，则对根结点的右儿子的右儿子进行 splay 调用
				node.right.right = splay(node.right.right, key);
				// 调用结束后对根结点进行一次左旋，根结点指向其右儿子，现在根结点的右儿子是目标结点（原根结点的右儿子的右儿子）
				node = leftRotation(node);
				// A        B
				//  B  =>  A C
				//   C    C是目标结点
			}

			// 最后如果根结点右儿子为空，则不存在 key 结点，返回当前根结点
			if (node.right == null) {
				return node;
			} else {
				// 如果右儿子非空，则说明 key 结点存在，并且就在根结点的右儿子，进行一次左旋将其旋转为新的根结点
				return leftRotation(node);
			}
		} else {
			// 如果找到，直接返回
			return node;
		}
	}

	private Node rightRotation(Node node) {
		Node tmp = node.left;
		node.left = tmp.right;
		tmp.right = node;
		return tmp;
	}

	private Node leftRotation(Node node) {
		Node tmp = node.right;
		node.right = tmp.left;
		tmp.left = node;
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

	private static final class Node<E> {
		E key;
		Node left;
		Node right;

		public Node(E key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}
}
