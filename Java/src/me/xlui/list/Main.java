package me.xlui.list;

import me.xlui.list.impl.CircularList;

public class Main {
	public static void main(String[] args) throws Exception {
		CircularList list = new CircularList();

		list.insert(1);
		list.insert(4);
		list.insert(9);
		list.insert(-10);

		System.out.println(list.hasCircle());

		list.access();
	}
}
