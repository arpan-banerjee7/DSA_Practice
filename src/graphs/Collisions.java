package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://www.hackerrank.com/contests/test-your-skills-in-graph/challenges/akbars-kingdom/problem
// https://atcoder.jp/contests/abc209/submissions/24899655
// https://atcoder.jp/contests/abc209/tasks/abc209_d

public class Collisions {

	private static int[] findShortestPath(int s, List<Integer>[] adj, int n) {
		int dist[] = new int[n];
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[s] = 0;

		// get the vertex with minimum distance so far, out of all the unvisited
		// vertices
		// array contains=[vertex,distance]
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);

		while (!queue.isEmpty()) {
			int parent = queue.poll();

			for (int child : adj[parent]) {
				if (dist[parent] + 1 < dist[child]) {
					dist[child] = dist[parent] + 1;
					queue.add(child);
				}
			}
		}
		return dist;
	}

	public static List<String> collision(List<List<Integer>> edges, List<List<Integer>> query, int n, int Q) {
		// Write your code here

		// build adjacency list
		List<Integer>[] adj = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < edges.size(); i++) {
			adj[edges.get(i).get(0) - 1].add(edges.get(i).get(1) - 1);
			adj[edges.get(i).get(1) - 1].add(edges.get(i).get(0) - 1);
		}

		// find shortest path from Akbar's town to all other town
		int[] shortestPaths = findShortestPath(0, adj, n);

		List<String> res = new ArrayList<>();
		for (List<Integer> q : query) {
			if ((shortestPaths[q.get(0) - 1] + shortestPaths[q.get(1) - 1]) % 2 == 0) {
				res.add("town");
			} else {
				res.add("road");
			}
		}
		return res;
	}

	public static void main(String[] args) {
		List<List<Integer>> query = new ArrayList<>();
		List<List<Integer>> edges = new ArrayList<>();

		List<Integer> e1 = Arrays.asList(2, 3);
		List<Integer> e2 = Arrays.asList(5, 6);
		List<Integer> e3 = Arrays.asList(4, 8);
		List<Integer> e4 = Arrays.asList(8, 9);
		List<Integer> e5 = Arrays.asList(4, 5);
		List<Integer> e6 = Arrays.asList(3, 4);
		List<Integer> e7 = Arrays.asList(1, 7);
		List<Integer> e8 = Arrays.asList(3, 7);
		edges.add(e1);
		edges.add(e2);
		edges.add(e3);
		edges.add(e4);
		edges.add(e5);
		edges.add(e6);
		edges.add(e7);
		edges.add(e8);

		List<Integer> q1 = Arrays.asList(7, 9);
		List<Integer> q2 = Arrays.asList(2, 5);
		List<Integer> q3 = Arrays.asList(2, 6);
		List<Integer> q4 = Arrays.asList(4, 6);
		List<Integer> q5 = Arrays.asList(2, 4);
		List<Integer> q6 = Arrays.asList(5, 8);
		List<Integer> q7 = Arrays.asList(3, 8);
		List<Integer> q8 = Arrays.asList(2, 9);
		List<Integer> q9 = Arrays.asList(1, 8);
		query.add(q1);
		query.add(q2);
		query.add(q3);
		query.add(q4);
		query.add(q5);
		query.add(q6);
		query.add(q7);
		query.add(q8);
		query.add(q9);

		int N = 9;
		int Q = query.size();

		List<String> res = collision(edges, query, N, Q);
		res.forEach(e -> System.out.print(e + " "));
		// town road town town town town town town town

	}

	/*
	 * Single-source shortest path
	 * 
	 * normal algo does not use priority queue- we can find shortets path in a
	 * grapgh with unit weights. BFS kind of traversal, with a smiple check, its BFS
	 * so it ensures that each node we visit, we visit through the shortest path
	 * https://stackoverflow.com/questions/14784753/shortest-path-dfs-bfs-or-both#:~
	 * :text=I%20know%20it%20late%20for%20the%20party%20here%20but.%20There%20are%
	 * 20several%20differences%20between%20DFS%20and%20BFS%20(short
	 * 
	 * Dijkstra-- used to find the shortest path in undirected graph with arbitary
	 * weights. If we do not use Priority queue here, then in case of arbitary
	 * weights with the simple algo, we might have to revisit a node, since normal
	 * BFS won t guarente the shortest path.
	 * 
	 * The priority queue selects the next vertex so as to (eventually) ensure
	 * shortest paths in a weighted graph. If you use a FIFO queue instead, you will
	 * not be able to account for arbitrary edge weights. This will essentially be
	 * breadth-first search which only guarantees finding shortest paths in
	 * unweighted graphs. The use of a priority queue comes at the cost of greater
	 * runtime - usually by a log factor.
	 */
}
