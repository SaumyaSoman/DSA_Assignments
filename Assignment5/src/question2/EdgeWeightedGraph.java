package question2;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * Credits-: Sedgewick
 * http://algs4.cs.princeton.edu/home/
 *
 */
public class EdgeWeightedGraph {

	private final int V;
	private int E;
	private ArrayList<Edge>[] adj;

	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (ArrayList<Edge>[]) new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Edge>();
		}
	}

	public int V() {
		return V;
	}
	
	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}

	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	public Iterable<Edge> edges() {
		ArrayList<Edge> list = new ArrayList<Edge>();
		for (int v = 0; v < V; v++) {
			int selfLoops = 0;
			for (Edge e : adj(v)) {
				if (e.other(v) > v) {
					list.add(e);
				}
				// only add one copy of each self loop (self loops will be consecutive)
				else if (e.other(v) == v) {
					if (selfLoops % 2 == 0) list.add(e);
					selfLoops++;
				}
			}
		}
		return list;
	}

}
