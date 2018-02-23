package me.xlui.data_structure.tree;

import java.util.Arrays;
import java.util.List;

/*
 * 完全二叉树的数组实现
 *
 * 有 n 个结点的完全二叉树：
 * 			 A
 * 		 B      O
 * 	   C   S  M   Q
 *    W K
 *
 * 其数组形式：
 *
 * 结点： A B O C S M Q W K
 * 序号： 1 2 3 4 5 6 7 8 9
 *
 * 有如下规律：
 * 1、非根结点（序号 i > 1）的 父结点 的序号是 [i/2](向下取整)
 * 2、结点（i）的左孩子的序号是 2i。如果 2i > n，则没有左孩子
 * 3、结点（i）的右孩子的序号是 2i+1。如果 2i+1 > n，则没有右孩子
 */
@SuppressWarnings("unchecked")
public class CompleteBinaryTree<E> implements Tree<E> {
	private static final int DEFAULT_CAPACITY = 20;
	private List<E> data;

	public CompleteBinaryTree(E ...e) {
		data = Arrays.asList(e);
	}

	@Override
	public void preOrderTraversal() {

	}

	@Override
	public void inOrderTraversal() {

	}

	@Override
	public void postOrderTraversal() {

	}

	@Override
	public void levelOrderTraversal() {
		for (Object datum : data) {
			System.out.print(datum + " ");
		}
	}
}
