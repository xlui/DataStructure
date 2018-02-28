package me.xlui.data_structure.graph;

import java.util.Scanner;

/**
 * 邻接矩阵无向图
 */
public class MatrixUnDirectedGraph extends BaseMatrixGraph {
	private static final int INF = Integer.MAX_VALUE;

	/**
	 * 通过用户输入初始化
	 */
	public MatrixUnDirectedGraph() {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入顶点数：");
		this.vertexCount = in.nextInt();
		System.out.println("请输入边数：");
		this.edgeCount = in.nextInt();

		if (this.vertexCount < 1 || this.edgeCount < 1 || this.edgeCount > (this.vertexCount * (this.vertexCount - 1))) {
			System.out.println("Invalid input!");
			return;
		}

		System.out.println("输入顶点信息：");
		for (int i = 0; i < this.vertexCount; i++) {
			System.out.print("下标 " + i + " 对应顶点：");
			this.vertices[i] = in.next();
		}

		// 初始化边的权值
		for (int i = 0; i < vertexCount; i++) {
			for (int j = 0; j < vertexCount; j++) {
				if (i == j) {
					edges[i][j] = 0;
				} else {
					edges[i][j] = INF;
				}
			}
		}

		int i, j, w;
		System.out.println("请输入每条边对应的两个顶点的序号以及边的权值，输入格式为 i j w");
		for (int k = 0; k < this.edgeCount; k++) {
			i = in.nextInt();
			j = in.nextInt();
			w = in.nextInt();
			this.edges[i][j] = w;
			this.edges[j][i] = w;   // 无向图是对称的
			System.out.println("成功设置顶点 " + i + " 和 " + j + " 之间的边");
		}
	}

	/**
	 * 从已有数据初始化
	 */
	public MatrixUnDirectedGraph(String[] vertices, int[][] edges) {
		super(vertices.length, edges.length);

		System.arraycopy(vertices, 0, this.vertices, 0, vertices.length);
		for (int i = 0; i < this.vertexCount; i++) {
			for (int j = 0; j < this.vertexCount; j++) {
				this.edges[i][j] = edges[i][j];
				this.edges[j][i] = edges[j][i];
			}
		}

		this.edgeCount = 0;
		for (int i = 0; i < this.vertexCount; i++) {
			for (int j = 0; j < this.vertexCount; j++) {
				if (this.edges[i][j] > 0) {
					++this.edgeCount;
				}
			}
		}
	}

	/*
	 * Dijkstra 最短路径算法
	 *
	 * 操作步骤：
	 *
	 * 1. 初始时，S 只包含 s，U 包含除 s 之外的其他定点，且 U 中顶点的距离为 “起点 s 到该顶点的距离”（例如：U 中顶点 v 的距离为 (s, v) 的长度。如果 s 和 v 不相邻，则 v 的距离为 ∞）。
	 * 2. 从 U 中选出“距离最短的顶点 k”，并将顶点 k 加入 S 中，同时从 U 中移除 k。
	 * 3. 更新 U 中各个顶点到起点 s 的距离。之所以更新，是因为上一步中确定了 k 是最短距离，从而可以利用 k 来更新其他顶点的距离。
	 * 4. 重复步骤 2 和 3，直到遍历完所有顶点。
	 */
	public void Dijkstra(int v) {
		boolean[] flag = new boolean[this.vertexCount]; // flag[i] = true 表示顶点 v 到顶点 i 的最短路径已经成功找到
		int[] distance = new int[this.vertexCount];     // 长度数组，distance[i] 是顶点 v 到顶点 i 的最短路径长度
		int k = 0;  // k 位置顶点是已获得的最短路径

		for (int i = 0; i < this.vertexCount; i++) {
			flag[i] = false;            // 顶点 i 的最短路径还没找到
			distance[i] = edges[v][i];  // 顶点 i 的最短路径为顶点 v 到顶点 i 的权，权值的默认值为 Integer.MAX_VALUE
		}

		// 对顶点 v 进行初始化
		flag[v] = true;
		distance[v] = 0;
		System.out.println("Dijkstra: ");
		System.out.println(vertices[v] + " 到 " + vertices[v] + " 的最短路径是：" + distance[v]);

		// 进行 vertexCount - 1 次循环
		for (int i = 1; i < this.vertexCount; i++) {
			int min = INF;
			// 获取未找到最短路径顶点中最小值及其索引
			for (int j = 0; j < this.vertexCount; j++) {
				if (!flag[j] && distance[j] < min) {
					min = distance[j];
					k = j;
				}
			}

			// 标记顶点 k 为已经获得的最短路径
			flag[k] = true;
			System.out.println(vertices[v] + " 到 " + vertices[k] + " 的最短路径是：" + distance[k]);

			// 修正未获得最短路径的顶点集合中的路径长度
			for (int j = 0; j < this.vertexCount; j++) {
				// tmp 此处的判断是：如果从顶点 k 到顶点 j 有边，那么暂存 min+边的权值
				int tmp = (edges[k][j] == INF ? INF : (min + edges[k][j]));
				if (!flag[j] && tmp < distance[j]) {
					// 如果 tmp 比 distance[j] 大，说明 j 到 v 之间有较短路径
					// 如果 tmp 比 distance[j] 小，说明需要更新 distance[j]
					distance[j] = tmp;
				}
			}
		}
	}
}
