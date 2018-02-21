package me.xlui.data_structure.graph.impl;

import java.util.Scanner;

/**
 * 邻接矩阵实现的图（即，边表）
 * 用二维矩阵表示，两个顶点有连线则 Graph.edges[i][j] 大于 0
 */
public class AdjacentMatrixGraph {
	private static final int DEFAULT_VERTEX_COUNT = 100;
	private enum GraphType {DG, UG, DN, UN};
	// Directed Graph           有向图
	// Undirected Graph         无向图
	// Directed Network Graph   有向网图
	// Undirected Network Graph 无向网图
	private Graph graph = new Graph();

	public AdjacentMatrixGraph() {
		Scanner scanner = new Scanner(System.in);
		graph.graphType = GraphType.UN; // 无向网图

		System.out.println("请输入顶点数和边数：");
		graph.vertexCount = scanner.nextInt();
		graph.edgeCount = scanner.nextInt();

		// 建立顶点表
		System.out.println("输入顶点信息：");
		for (int i = 0; i < graph.vertexCount; i++) {
			graph.vertices[i] = scanner.next();
		}

		// 初始化邻接矩阵
		for (int i = 0; i < graph.vertexCount; i++) {
			for (int j = 0; j < graph.vertexCount; j++) {
				graph.edges[i][j] = Integer.MAX_VALUE;
			}
		}

		int i, j, w;
		System.out.println("请输入每条边对应的两个顶点的序号，以及权值，输入格式为 i j w");
		for (int k = 0; k < graph.edgeCount; k++) {
			i = scanner.nextInt();
			j = scanner.nextInt();
			w = scanner.nextInt();
			graph.edges[i][j] = w;
			graph.edges[j][i] = w;  // 无向图是对称的
		}
	}

	private void depthFirstSearch(String vertex) {
	/*  深度优先遍历
		visited[vertex] = true;
		for (v 的每个邻接点 w) {
			if (!visited[w]) {
				depthFirstSearch(w);
			}
		}
	*/
	}

	private void breadthFirstSearch(String vertex) {
	/*  广度优先遍历
		visited[vertex] = true;
		queue.add[vertex];
		while (!queue.isEmpty()) {
			vertex = queue.poll();
			for (vertex 的每个邻接点 w) {
				if (!visited[w]) {
					visited[w] = true;
					queue.add(w);
				}
			}
		}
	 */
	}

	private void listComponents() {
	/*  遍历不连通图
		for(each v in Graph) {
			if (!visited(v)) {
				DFS(V);
			}
		}
	 */
	}

	private static class Graph {
		String vertices[] = new String[DEFAULT_VERTEX_COUNT];
		int edges[][] = new int[DEFAULT_VERTEX_COUNT][DEFAULT_VERTEX_COUNT];
		int vertexCount, edgeCount;
		GraphType graphType;
	}
}
