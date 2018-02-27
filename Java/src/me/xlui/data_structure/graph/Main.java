package me.xlui.data_structure.graph;

public class Main {
	/*
	 * 默认的无向图       默认的有向图
	 *
	 *  A-F-G-E         B->A->G
	 *  |＼              |    ︿
	 *  C--D            ﹀     |
	 *  |               D->F<-C
	 *  B               |
	 *                  ﹀
	 *                  E
	 */
	private static final int count = 7;
	private static String[] UDVertices = new String[count];
	private static int[][] UDEdges = new int[count][count];
	private static String[] DVertices = new String[count];
	private static int[][] DEdges = new int[count][count];

	static {
		UDVertices[0] = "A";
		UDVertices[1] = "F";
		UDVertices[2] = "G";
		UDVertices[3] = "E";
		UDVertices[4] = "C";
		UDVertices[5] = "D";
		UDVertices[6] = "B";
		UDEdges[0][1] = 1;    // A->F
		UDEdges[0][4] = 1;    // A->C
		UDEdges[0][5] = 1;    // A->D
		UDEdges[6][4] = 1;    // B->C
		UDEdges[4][0] = 1;    // C->A
		UDEdges[4][5] = 1;    // C->D
		UDEdges[4][6] = 1;    // C->B
		UDEdges[5][0] = 1;    // D->A
		UDEdges[5][4] = 1;    // D->C
		UDEdges[3][2] = 1;    // E->G
		UDEdges[1][0] = 1;    // F->A
		UDEdges[1][2] = 1;    // F->G
		UDEdges[2][1] = 1;    // G->F
		UDEdges[2][3] = 1;    // G->E
	}

	static {
		DVertices[0] = "A";
		DVertices[1] = "B";
		DVertices[2] = "C";
		DVertices[3] = "D";
		DVertices[4] = "E";
		DVertices[5] = "F";
		DVertices[6] = "G";
		DEdges[0][6] = 1;   // A->G
		DEdges[1][0] = 1;   // B->A
		DEdges[1][3] = 1;   // B->D
		DEdges[2][5] = 1;   // C->F
		DEdges[2][6] = 1;   // C->G
		DEdges[3][4] = 1;   // D->E
		DEdges[3][5] = 1;   // D->F
	}

	public static void main(String[] args) {
		ListDirectedGraph graph = new ListDirectedGraph(DVertices, DEdges);
//		graph.DFS();
		// A G B D E F C
		graph.topologicalSort();
	}

	private static void testListUnDirectedGraph() {
		ListUnDirectedGraph graph = new ListUnDirectedGraph(UDVertices, UDEdges);
		graph.DFS();
	}

	private static void testMatrixUnDirectedGraph() {
		MatrixUnDirectedGraph graph = new MatrixUnDirectedGraph(UDVertices, UDEdges);
		graph.DFS();
		graph.BFS();
	}
}
