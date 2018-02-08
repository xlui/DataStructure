package me.xlui.tree.impl;

public class AVLTree {
	private Node root;

	public void insert(int element) {
		this.root = this.insert(this.root, element);
	}

	public void remove(int element) throws Exception {
		this.root = this.remove(this.root, element);
	}

	public void inOrderTraversal() {
		this.inOrderTraversal(this.root);
	}

	public void preOrderTraversal() {
		this.preOrderTraversal(this.root);
	}

	// *********************
	//    private methods
	// *********************
	private Node insert(Node node, int element) {
		if (node == null) {
			node = new Node();
			node.data = element;
		} else {
			if (element < node.data) {
				node.left = insert(node.left, element);
				// 插入节点后，AVL 树失去平衡
				if (height(node.left) - height(node.right) == 2) {
					if (element < node.left.data) {
						// 说明插入的位置是左儿子的左子节点，需要进行 LL 旋转
						node = this.leftLeftRotation(node);
					} else {
						// 说明插入的位置是右儿子的右子节点，需要进行 LR 旋转
						node = this.leftRightRotation(node);
					}
				}
			} else if (element > node.data) {
				node.right = insert(node.right, element);
				if (height(node.right) - height(node.left) == 2) {
					if (element > node.right.data) {
						// 说明插入位置是右儿子的右子节点，需要进行 RR 旋转
						node = rightRightRotation(node);
					} else {
						// 说明插入位置是右儿子的左子节点，需要进行 RL 旋转
						node = rightLeftRotation(node);
					}
				}
			}
			// 忽略相同结点
		}
		// 重新计算 height
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		return node;
	}

	private Node remove(Node node, int element) throws Exception {
		if (node == null) {
			return null;
		}
		if (element < node.data) {
			node.left = this.remove(node.left, element);
			// 删除左子树结点，可能导致 AVL 失衡。需要根据情况进行右旋
			if (height(node.right) - height(node.left) == 2) {
				if (height(node.right.left) > height(node.right.right)) {
					// 这一层判断是为了选择要进行的旋转。如果 右子树的左子树的高度 高于 右子树的右子树的高度，则进行 RL 旋转
					node = rightLeftRotation(node);
				} else {
					node = rightRightRotation(node);
				}
			}
		} else if (element > node.data) {
			node.right = this.remove(node.right, element);
			// 删除右子树结点，可能导致 AVL 失衡。需要根据情况进行左旋
			if (height(node.left) - height(node.right) == 2) {
				if (height(node.left.left) > height(node.left.right)) {
					// 这一层判断是为了选择要进行的旋转。如果 左子树的左子树的高度 高于 左子树的右子树的高度，则进行 LL 旋转
					node = leftLeftRotation(node);
				} else {
					node = leftRightRotation(node);
				}
			}
		} else {
			// 删除结点
			if (node.left != null && node.right != null) {
				if (height(node.left) > height(node.right)) {
					node.data = findMax(node.left);
					node.left = remove(node.left, node.data);
				} else {
					node.data = findMin(node.right);
					node.right = remove(node.right, node.data);
				}
			} else {
				node = (node.left != null) ? node.left : node.right;
			}
		}
		return node;
	}

	// 获取二叉树的高度。
	// 将空结点的高度定义为 0，非空节点的高度等于它的最大层次（根的层次为 1）
	private int height(Node node) {
		if (node != null)
			return node.height;
		return 0;
	}

	// LL 旋转。T 结点的左子树的左子树插入结点导致平衡因子改变。
	private Node leftLeftRotation(Node node) {
		// 定义临时结点，指向 node 的左孩子，旋转后替代 node 的位置
		Node tmp = node.left;
		// 将 node（失衡结点）的左孩子指向 tmp 的右孩子上
		node.left = tmp.right;
		// 将 tmp 的右孩子指向 node
		tmp.right = node;
		// 以上，旋转完成

		// 重新计算高度
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		tmp.height = Math.max(height(tmp.left), node.height) + 1;
		return tmp;
	}

	// RR 旋转。T 结点的右子树的右子树插入结点导致平衡因子改变。
	private Node rightRightRotation(Node node) {
		Node tmp = node.right;
		node.right = tmp.left;
		tmp.left = node;

		node.height = Math.max(height(node.left), height(node.right)) + 1;
		tmp.height = Math.max(height(tmp.left), node.height);

		return tmp;
	}

	// LR 旋转，首先进行 RR 旋转使其变为 LL 失衡状态，然后进行 LL 旋转
	private Node leftRightRotation(Node node) {
		node.left = rightRightRotation(node.left);
		return leftLeftRotation(node);
	}

	// RL 旋转，首先进行 LL 旋转使其变为 RR 失衡状态，然后进行 RR 旋转
	private Node rightLeftRotation(Node node) {
		node.right = leftLeftRotation(node.right);
		return rightRightRotation(node);
	}

	private int findMin(Node node) throws Exception {
		if (node != null) {
			while (node.left != null)
				node = node.left;
			return node.data;
		} else {
			throw new Exception("AVL Tree is empty!");
		}
	}

	private int findMax(Node node) throws Exception {
		if (node != null) {
			while (node.right != null)
				node = node.right;
			return node.data;
		} else {
			throw new Exception("AVL Tree is empty!");
		}
	}

	private void preOrderTraversal(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	private void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.data + " ");
			inOrderTraversal(node.right);
		}
	}

	private static class Node {
		int data;
		// 结点中增加 height 字段表明高度
		// 约定叶子结点的高度为 0，空结点的高度为 -1，
		// 非空非叶子结点的高度由子树的高度计算获得
		int height;
		Node left;
		Node right;

		public Node() {
			data = 0;
			left = null;
			right = null;
		}
	}
}
