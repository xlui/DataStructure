package data_structure.heap;

public class Main {
	public static void main(String[] args) {
//		testMaxHeap();
//		testMinHeap();
//		testLeftistHeap();
		testSkewHeap();
	}

	private static void testSkewHeap() {
		SkewHeap<Integer> heap = new SkewHeap<>();
		heap.add(10);
		heap.add(40);
		heap.add(24);
		heap.add(30);
		heap.add(36);
		heap.add(20);
		heap.add(12);
		heap.add(16);

		heap.preOrderTraversal();
		heap.inOrderTraversal();
		heap.postOrderTraversal();
	}

	private static void testLeftistHeap() {
		LeftistHeap<Integer> heap = new LeftistHeap<>();
		heap.add(10);
		heap.add(40);
		heap.add(24);
		heap.add(30);
		heap.add(36);
		heap.add(20);
		heap.add(12);
		heap.add(16);

		heap.preOrderTraversal();
		heap.inOrderTraversal();
		heap.postOrderTraversal();
	}

	private static void testMinHeap() {
		MinHeap<Integer> heap = new MinHeap<>();
		heap.add(1);
		heap.add(4);
		heap.add(3);
		heap.add(6);
		heap.add(9);
		heap.add(7);
		heap.add(2);
		heap.add(5);
		heap.add(8);

		while (!heap.isEmpty()) {
			System.out.print(heap.poll() + " ");
		}
		System.out.println();
	}

	private static void testMaxHeap() {
		MaxHeap<Integer> heap = new MaxHeap<>();
		heap.add(1);
		heap.add(4);
		heap.add(3);
		heap.add(6);
		heap.add(9);
		heap.add(7);
		heap.add(2);
		heap.add(5);
		heap.add(8);

		while (!heap.isEmpty()) {
			System.out.print(heap.poll() + " ");
		}
		System.out.println();
	}
}
