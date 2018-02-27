package me.xlui.data_structure.graph;

import java.util.ArrayList;
import java.util.List;

public class BaseListGraph {
	private static final int DEFAULT_VERTEX_COUNT = 100;
	VertexNode vertices[];
	int vertexCount, edgeCount;

	BaseListGraph() {
		vertices = new VertexNode[DEFAULT_VERTEX_COUNT];
	}

	BaseListGraph(int vertexCount, int edgeCount) {
		super();
		this.vertexCount = vertexCount;
		this.edgeCount = edgeCount;
		this.vertices = new VertexNode[vertexCount];
	}

	void setVertices(int size) {
		this.vertices = new VertexNode[size];
	}

	public void DFS() {
		boolean[] visited = new boolean[vertices.length];

		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}

		System.out.println("Depth First Search: ");
		// 外层循环的目的是同时遍历非连通图的情况
		for (int i = 0; i < vertices.length; i++) {
			if (!visited[i]) {
				this.depthFirstSearch(i, visited);
			}
		}
	}

	private void depthFirstSearch(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(this.vertices[v].vertex + " ");

		for (Integer integer : this.adjacent(vertices[v])) {
			if (!visited[integer]) {
				this.depthFirstSearch(integer, visited);
			}
		}
	}

	// 函数的目的是找出 vertexNode 的邻接点在 vertices 数组中对应的下标
	private List<Integer> adjacent(VertexNode vertexNode) {
		List<Integer> list = new ArrayList<>();
		if (vertexNode == null) {
			return list;
		}
		Node node = vertexNode.firstNode;
		while (node != null) {
			list.add(valueOf(node.vertex));
			node = node.next;
		}
		return list;
	}

	int valueOf(String v) {
		for (int i = 0; i < vertices.length; i++) {
			if (v.equals(vertices[i].vertex)) {
				return i;
			}
		}
		return -1;
	}

	public static final class Node { // 头节点之后的链表
		String vertex;  // 邻接点域
		Node next;      // 指向下一个邻接点的指针域

		public Node() {
		}

		public Node(String vertex) {
			this.vertex = vertex;
			this.next = null;
		}
	}

	public static final class VertexNode {   // 顶点表结点
		String vertex;          // 顶点域
		Node firstNode = null;  // 边表头指针

		public VertexNode(String vertex) {
			this.vertex = vertex;
		}
	}
}
