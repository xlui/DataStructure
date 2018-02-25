package me.xlui.data_structure.heap;

public class Main {
	public static void main(String[] args) {
//		testMaxHeap();
		testMinHeap();
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
