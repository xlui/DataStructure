package me.xlui.list;

public class Main {
	public static void main(String[] args) {
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

		doubleLinkedList.add(1);
		doubleLinkedList.add(2);
		doubleLinkedList.add(-8);
		doubleLinkedList.add(9);
		doubleLinkedList.add(13);

		doubleLinkedList.access();
		doubleLinkedList.remove(15);
		doubleLinkedList.access();
	}
}
