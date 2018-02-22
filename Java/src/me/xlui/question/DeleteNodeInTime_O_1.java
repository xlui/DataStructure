package me.xlui.question;

/**
 * 给定链表的头指针和一个结点指针，在 O（1）的时间删除该结点
 * 思路：使用下一个结点的数据覆盖要删除的结点，然后删除下一个结点
 */
public class DeleteNodeInTime_O_1 {
	public void deleteNode(Node node) {
		assert node != null;
		assert node.next != null; // 不能是尾结点

		Node nextNode = node.next;
		node.data = nextNode.data;
		node.next = nextNode.next;
	}
}
