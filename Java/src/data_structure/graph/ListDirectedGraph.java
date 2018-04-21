package data_structure.graph;

import java.util.*;

public class ListDirectedGraph extends BaseListGraph {
	/**
	 * 从用户输入初始化
	 */
	public ListDirectedGraph() {
		Scanner in = new Scanner(System.in);
		System.out.println("输入顶点数：");
		this.vertexCount = in.nextInt();
		System.out.println("请输入边数：");
		this.edgeCount = in.nextInt();
		setVertices(this.vertexCount);

		if (this.vertexCount < 1 || this.edgeCount < 1 || this.edgeCount > (this.vertexCount * (this.vertexCount - 1))) {
			System.out.println("Invalid input!");
			return;
		}

		System.out.println("输入顶点信息：");
		for (int i = 0; i < this.vertexCount; i++) {
			System.out.print("下标 " + i + " 对应顶点：");
			this.vertices[i].vertex = in.next();
		}

		int index;
		Node node;
		for (int i = 0; i < this.vertexCount; i++) {
			System.out.println("输入与顶点 " + this.vertices[i] + " 直接相连的顶点对应的下标：");
			index = in.nextInt();
			if (this.vertices[i].firstNode == null) {
				this.vertices[i].firstNode = new Node(this.vertices[index].vertex);
			} else {
				node = this.vertices[i].firstNode;
				while (node.next != null) {
					node = node.next;
				}
				node.next = new Node(this.vertices[index].vertex);
			}
		}

		System.out.println("初始化完成！");
	}

	/**
	 * 从已有数据初始化
	 */
	public ListDirectedGraph(String[] vertices, int[][] edges) {
		super(vertices.length, edges.length);

		for (int i = 0; i < this.vertexCount; i++) {
			this.vertices[i] = new VertexNode(vertices[i]);
		}
		for (int i = 0; i < this.vertexCount; i++) {
			for (int j = 0; j < this.vertexCount; j++) {
				if (edges[i][j] > 0) {
					if (this.vertices[i].firstNode == null) {
						this.vertices[i].firstNode = new Node(vertices[j]);
					} else {
						Node node = this.vertices[i].firstNode;
						while (node.next != null) {
							node = node.next;
						}
						node.next = new Node(vertices[j]);
					}
				}
			}
		}
		System.out.println("初始化完成！");
	}

	// 拓扑排序
	public void topologicalSort() {
		Map<String, Integer> inDegree = new HashMap<>();    // 入度
		Queue<Integer> queue = new ArrayDeque<>();          // 保存入度为 0 的顶点
		List<Integer> result = new ArrayList<>();           // 结果序列

		// 计算每个顶点的入度
		for (int i = 0; i < vertexCount; i++) {
			Node node = vertices[i].firstNode;
			while (node != null) {
				// 初次初始化，使用 getOrDefault 来避免 NullPointerException
				inDegree.put(node.vertex, inDegree.getOrDefault(node.vertex, 0) + 1);
				node = node.next;
			}
		}

		// 入度为 0 的顶点入队列
		for (int i = 0; i < vertexCount; i++) {
			// 因为可能存在入度为 0 的顶点，所以这里也是用 getOrDefault 在未设置值的时候返回默认值
			if (inDegree.getOrDefault(vertices[i].vertex, 0) == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int v = queue.poll();   // 弹出入度为 0 的顶点
			result.add(v);          // 加入结果序列
			Node node = vertices[v].firstNode;  // 获得其邻接序列

			while (node != null) {
				// 更新 v 邻接序列的入度
				// v 的邻接序列的入度一定非 0，所以不需要设置 map 默认值
				inDegree.put(node.vertex, inDegree.get(node.vertex) - 1);

				if (inDegree.get(node.vertex) == 0) {
					queue.add(valueOf(node.vertex));
				}

				node = node.next;
			}
		}

		if (result.size() != vertexCount) {
			System.out.println("Graph has a cycle!");
			return;
		}

		System.out.println("Topological Sort:");
		for (Integer integer : result) {
			System.out.print(vertices[integer].vertex + " ");
		}
		System.out.println();
	}
}
