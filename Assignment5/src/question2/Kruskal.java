package question2;

import java.util.ArrayList;

/**
 * 
 * Credits-: Sedgewick
 * http://algs4.cs.princeton.edu/home/
 *
 */
public class Kruskal {
	
    private double weight; 
    private ArrayList<Edge> mst =new ArrayList<Edge>();

    public Kruskal(EdgeWeightedGraph G) {
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e : G.edges()) {
            pq.insert(e);
        }

        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)) { 
                uf.union(v, w);
                mst.add(e);
                weight += e.weight();
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return weight;
    }
}
