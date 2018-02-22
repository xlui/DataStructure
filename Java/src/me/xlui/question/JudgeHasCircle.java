package me.xlui.question;

/**
 * 判断链表中是否有环，使用快慢指针的方法
 * 如果遇到 null，说明没有
 * 如果快指针遇到慢指针或者快指针跑到慢指针后面说明有环
 */
public class JudgeHasCircle {
	public boolean hasCircle(Node head) {
		Node fast = head;
		Node slow = head;

		while (true) {
			if (fast == null || fast.next == null) {
				// 如果链表中有空，即到尽头
				return false;
			} else {
				fast = fast.next.next;
				slow = slow.next;
			}

			if (fast == slow || fast.next == slow) {
				// 如果快慢指针相遇或者快指针跑到慢指针后边，说明有环
				return true;
			}
		}
	}

}
