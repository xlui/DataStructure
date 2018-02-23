package me.xlui.data_structure.queue;

public class Main {
	public static void main(String[] args) throws Exception {
		testArrayQueue();
//		testLinkedQueue();
	}

	private static void testArrayQueue() throws Exception {
		ArrayQueue<Integer> queue = new ArrayQueue<>();

		queue.add(8);
		queue.add(2);
		queue.add(-1);

		System.out.println("Peek: " + queue.peek());
		System.out.println("Size: " + queue.size());

		while (!queue.isEmpty()) {
			System.out.println("Poll: " + queue.poll());
		}
	}

	private static void testLinkedQueue() throws Exception {
		LinkedQueue<Integer> queue = new LinkedQueue<>();

		queue.add(9);
		queue.add(3);
		queue.add(-7);

		System.out.println("Peek: " + queue.peek());
		System.out.println("Size: " + queue.size());

		while (!queue.isEmpty()) {
			System.out.println("Poll: " + queue.poll());
		}
	}
}
