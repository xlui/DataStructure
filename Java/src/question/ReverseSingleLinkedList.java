package question;

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
		if (head == null || head.next == null) {
			return head;
		}

		Node node = head.next;
		// 将 head 结点断开
		head.next = null;
		// 对剩下的结点递归调用反转
		Node reverse = reverseByRecursion(node);
		// 将 head 结点接到转置后链表的末尾
		node.next = head;
		// 返回转置后的链表
		return reverse;
	}

}
