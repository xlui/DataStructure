package me.xlui.data_structure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Base Matrix Graph —— 实现了 DFS、BFS、Adjacent、valueOf(静态) 方法，作为基类供子类继承
 */
public class BaseMatrixGraph {
	private static final int DEFAULT_VERTEX_COUNT = 100;

	String vertices[];
	int edges[][];
	int vertexCount, edgeCount;

	BaseMatrixGraph() {
		vertices = new String[DEFAULT_VERTEX_COUNT];
		edges = new int[DEFAULT_VERTEX_COUNT][DEFAULT_VERTEX_COUNT];
	}

	BaseMatrixGraph(int vc, int ec) {
		vertices = new String[vc];
		edges = new int[vc][vc];
		vertexCount = vc;
		edgeCount = ec;
	}

	/*
	 * 深度优先遍历 —— Depth First Search
	 *
	 * 和树的先序遍历类似。
	 *
	 * 它的思想：假设初始状态所有顶点均未被访问，则从某个顶点 v 出发，首先访问该顶点，然后依次从它的各个邻接点出发进行深度优先搜索，
	 * 直至途中所有和 v 有路径连通的顶点都被访问到。若此时还有其他顶点没有被访问到，则另选一个未被访问的顶点作为起始点，重复上述过程，
	 * 直至图中所有的顶点都被访问到。
	 *
	 * 显示，深度优先遍历是一个递归的过程。
	 */
	public void DFS() {
		boolean[] visited = new boolean[this.vertexCount];

		for (int i = 0; i < this.vertexCount; i++) {
			visited[i] = false;
		}

		System.out.println("Depth First Search: ");
		// 外层循环的目的是同时遍历非连通图的情况
		for (int i = 0; i < this.vertices.length; i++) {
			if (!visited[i]) {
				this.depthFirstSearch(i, visited);
			}
		}
		System.out.println();
	}

	private void depthFirstSearch(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(this.vertices[v] + " ");
		for (Integer integer : this.adjacent(v)) {
			if (!visited[integer]) {
				this.depthFirstSearch(integer, visited);
			}
		}
	}

	/*
	 * 广度优先遍历 —— Breadth First Search
	 *
	 * 外层 for 循环的作用是完全访问这种图（不连通图）：A-B   C-D
	 * 内层使用队列，队列中的元素始终是访问过的，每次我们从队列中取出元素，访问其邻接点，然后再把邻接点放入队列。循环直到队列为空。
	 */
	public void BFS() {
		boolean[] visited = new boolean[this.vertexCount];
		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 0; i < this.vertexCount; i++) {
			visited[i] = false;
		}

		System.out.println("Breadth First Search: ");
		for (int i = 0; i < this.vertices.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				System.out.print(this.vertices[i] + " ");
				queue.add(i);
			}

			while (!queue.isEmpty()) {
				int v = queue.poll();
				for (Integer integer : this.adjacent(v)) {
					if (!visited[integer]) {
						visited[integer] = true;
						System.out.print(this.vertices[integer] + " ");
						queue.add(integer);
					}
				}
			}
		}
	}


	// 顶点 v 的邻接点
	private List<Integer> adjacent(int v) {
		List<Integer> list = new ArrayList<>();
		if (v < 0 || v > this.vertices.length - 1) {
			// v 的索引不合法
			return list;
		}

		for (int i = 0; i < this.vertexCount; i++) {
			if (this.edges[v][i] > 0) {
				// 说明 v 到 i 有一条边
				list.add(i);
			}
		}

		return list;
	}

	public static int valueOf(String[] vertices, String string) {
		for (int i = 0; i < vertices.length; i++) {
			if (string.equals(vertices[i])) {
				return i;
			}
		}
		return -1;
	}
}
