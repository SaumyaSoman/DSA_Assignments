package question2;

/**
 * 
 * Credits-: Sedgewick
 * http://algs4.cs.princeton.edu/home/
 *
 */
import java.util.ArrayList;
import java.util.Queue;

public class Prim {
    private double weight;       
    private ArrayList<Edge> mst;    
    private boolean[] marked;    
    private MinPQ<Edge> pq;    

    public Prim(EdgeWeightedGraph G) {
        mst = new ArrayList<Edge>();
        pq = new MinPQ<Edge>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)     
        	if (!marked[v]) prim(G, v);     
    }

    private void prim(EdgeWeightedGraph G, int s) {
        scan(G, s);
        while (!pq.isEmpty()) {                       
            Edge e = pq.delMin();                    
            int v = e.either(), w = e.other(v);      
            if (marked[v] && marked[w]) continue;    
            mst.add(e);                            
            weight += e.weight();
            if (!marked[v]) scan(G, v);            
            if (!marked[w]) scan(G, w);             
        }
    }

    private void scan(EdgeWeightedGraph G, int v) {
        assert !marked[v];
        marked[v] = true;
        for (Edge e : G.adj(v))
            if (!marked[e.other(v)]) pq.insert(e);
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return weight;
    }
}
