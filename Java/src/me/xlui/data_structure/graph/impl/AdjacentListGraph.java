package me.xlui.data_structure.graph.impl;

import java.util.Scanner;

/**
 * 邻接表实现的图
 * 将每个顶点对应的表用链表链接起来
 */
public class AdjacentListGraph {
	private static final int DEFAULT_VERTEX_COUNT = 100;
	private enum GraphType {DG, UG, DN, UN};
	private Graph graph = new Graph();

	public AdjacentListGraph() {
		Scanner scanner = new Scanner(System.in);
		graph.graphType = GraphType.DG; // 有向图
		System.out.println("请输入顶点数和边数（输入格式：顶点数 边数）：");
		graph.vertexCount = scanner.nextInt();
		graph.edgeCount = scanner.nextInt();

		System.out.println("请输入顶点信息（输入格式：顶点号）：");
		for (int i = 0; i < graph.vertexCount; i++) {
			graph.adjacentList[i].vertex = scanner.next();
		}

		int i, j;
		System.out.println("请输入边的信息（输入格式：i j）：");
		for (int k = 0; k < graph.edgeCount; k++) {
			i = scanner.nextInt();
			j = scanner.nextInt();
			Node node = new Node(j);    // 创建新的结点
			node.next = graph.adjacentList[i].firstNode;
			// 将新边表节点插入到顶点的头部
			graph.adjacentList[i].firstNode = node;
			// 如果是无向图，还需要生成一个结点用来保存边 (j, i)
		}
	}

	private static class Node { // 边表结点
		int region; // 邻接点域
		Node next;  // 指向下一个邻接点的指针域

		public Node() {
		}

		public Node(int region) {
			this.region = region;
			this.next = null;
		}
	}

	private static class VertexNode {   // 顶点表结点
		String vertex;  // 顶点域
		Node firstNode = null; // 边表头指针
	}

	private static class Graph {
		VertexNode adjacentList[] = new VertexNode[DEFAULT_VERTEX_COUNT];
		int vertexCount, edgeCount;
		GraphType graphType;
	}
}
