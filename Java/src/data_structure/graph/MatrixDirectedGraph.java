package data_structure.graph;

import java.util.Scanner;

public class MatrixDirectedGraph extends BaseMatrixGraph {
	/**
	 * 通过用户输入初始化
	 */
	public MatrixDirectedGraph() {
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

		int i, j;
		System.out.println("请输入每条边对应的两个顶点的序号，输入格式为 i j");
		for (int k = 0; k < this.edgeCount; k++) {
			i = in.nextInt();
			j = in.nextInt();
			this.edges[i][j] = 1;
			System.out.println("成功设置顶点 " + i + " 和 " + j + " 之间的边");
		}
	}

	/**
	 * 从已有数据初始化
	 */
	public MatrixDirectedGraph(String[] vertices, int[][] edges) {
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

}