package data_structure.graph;

import java.util.Scanner;

/**
 * 邻接表无向图
 */
public class ListUnDirectedGraph extends BaseListGraph {

	/**
	 * 从用户输入初始化
	 */
	public ListUnDirectedGraph() {
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
	public ListUnDirectedGraph(String[] vertices, int[][] edges) {
		super(vertices.length, edges.length);

		for (int i = 0; i < this.vertexCount; i++) {
			this.vertices[i] = new VertexNode(vertices[i]);
		}
		for (int i = 0; i < this.vertexCount; i++) {
			for (int j = 0; j < this.vertexCount; j++) {
				if (edges[i][j] > 0) {
					if (this.vertices[i].firstNode == null) {
						this.vertices[i].firstNode = new Node(vertices[i]);
					} else {
						Node node = this.vertices[i].firstNode;
						while (node.next != null) {
							node = node.next;
						}
						node.next = new Node(vertices[i]);
					}
				}
			}
		}
		System.out.println("初始化完成！");
	}
}
