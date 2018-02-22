package me.xlui.question;

public class ReverseSingleLinkedList {
	public Node reverseByLoop(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node ret = null, next = null;
		while (head != null) {
			next = head.next;    // 保存下一个结点的位置
			head.next = ret;    // 现在的结点接到新链表的头部
			ret = head;            // 重置新链表的头部指针
			head = next;        // head 往后移动
		}

		return ret;
	}

	public Node reverseByRecursion(Node head) {
		if (head == null || head.next == null)
			return head;

		Node node = reverseByRecursion(head.next);

		head.next.next = head;
		head.next = null;

		return node;
	}
}
