package me.xlui.data_structure.graph;

import java.util.Arrays;

public class Main {
	/*
	 * 默认的无向图       默认的有向图      Dijkstra 图
	 *                                   B -- C
	 *  A-F-G-E         B->A->G         /    /|\
	 *  |＼              |    ︿        A - F  | D
	 *  C--D            ﹀     |        \ /  \ |
	 *  |               D->F<-C         G --- E
	 *  B               |
	 *                  ﹀
	 *                  E
	 */
	private static final int count = 7;
	private static String[] UDVertices = new String[count];
	private static int[][] UDEdges = new int[count][count];
	private static String[] DVertices = new String[count];
	private static int[][] DEdges = new int[count][count];
	private static String[] dijkstraVertices = new String[count];
	private static int[][] dijkstraEdges = new int[count][count];

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

	static {
		dijkstraVertices[0] = "A";
		dijkstraVertices[1] = "B";
		dijkstraVertices[2] = "C";
		dijkstraVertices[3] = "D";
		dijkstraVertices[4] = "E";
		dijkstraVertices[5] = "F";
		dijkstraVertices[6] = "G";
		for (int i = 0; i < count; i++) {
			Arrays.fill(dijkstraEdges[i], Integer.MAX_VALUE);
		}
		dijkstraEdges[0][1] = 12;   // A-B, 12
		dijkstraEdges[0][5] = 16;   // A-F, 16
		dijkstraEdges[0][6] = 14;   // A-G, 14
		dijkstraEdges[1][0] = 12;   // B-A, 12
		dijkstraEdges[1][2] = 10;   // B-C, 10
		dijkstraEdges[1][5] = 7;    // B-F, 7
		dijkstraEdges[2][1] = 10;   // C-B, 10
		dijkstraEdges[2][3] = 3;    // C-D, 3
		dijkstraEdges[2][4] = 5;    // C-E, 5
		dijkstraEdges[2][5] = 6;    // C-F, 6
		dijkstraEdges[3][2] = 3;    // D-C, 3
		dijkstraEdges[3][4] = 4;    // D-E, 4
		dijkstraEdges[4][2] = 5;    // E-C, 5
		dijkstraEdges[4][3] = 4;    // E-D, 4
		dijkstraEdges[4][5] = 2;    // E-F, 2
		dijkstraEdges[4][6] = 8;    // E-G, 8
		dijkstraEdges[5][0] = 16;   // F-A, 16
		dijkstraEdges[5][1] = 7;    // F-B, 7
		dijkstraEdges[5][2] = 6;    // F-C, 6
		dijkstraEdges[5][4] = 2;    // F-E, 2
		dijkstraEdges[5][6] = 9;    // F-G, 9
		dijkstraEdges[6][0] = 14;   // G-A, 14
		dijkstraEdges[6][4] = 8;    // G-E, 8
		dijkstraEdges[6][5] = 9;    // G-F, 9
	}

	public static void main(String[] args) {
		testDijkstra();
	}

	private static void testDijkstra() {
		MatrixUnDirectedGraph graph = new MatrixUnDirectedGraph(dijkstraVertices, dijkstraEdges);
		graph.BFS();
		graph.DFS();
		graph.Dijkstra(gValueOf("D"));
	}

	private static void testTopologicalSort() {
		ListDirectedGraph graph = new ListDirectedGraph(DVertices, DEdges);
		graph.DFS();
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

	private static int gValueOf(String s) {
		for (int i = 0; i < dijkstraVertices.length; i++) {
			if (s.equals(dijkstraVertices[i])) {
				return i;
			}
		}
		return -1;
	}
}
