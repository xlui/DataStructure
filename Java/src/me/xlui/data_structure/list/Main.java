package me.xlui.data_structure.list;

import me.xlui.data_structure.list.impl.CircularList;

public class Main {
	public static void main(String[] args) {
		CircularList<Integer> list = new CircularList<>();

		list.add(1);
		list.add(4);
		list.add(9);
		list.add(-10);

		System.out.println(list.hasCircle());

		list.access();
	}
}
