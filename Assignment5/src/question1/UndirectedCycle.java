package question1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

/**
 * 
 * Credits-: Sedgewick
 * http://algs4.cs.princeton.edu/home/
 *
 */
public class UndirectedCycle {

    private boolean[] marked; 
    private int[] edgeTo;   
    private Stack<Integer> cycle;    

    public UndirectedCycle(Graph G) {
        if (hasSelfLoop(G)) return;
        if (hasParallelEdges(G)) return;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v])
                dfs(G, -1, v);
    }
    private boolean hasSelfLoop(Graph G) {
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) {
                    cycle = new Stack<Integer>();
                    cycle.push(v);
                    cycle.push(v);
                    return true;
                }
            }
        }
        return false;
    }
    private void dfs(Graph G, int u,int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (cycle != null) return;

            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, v, w);
            }
            else if (w != u) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
    }

    private boolean hasParallelEdges(Graph G) {
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++) {

            // check for parallel edges incident to v
            for (int w : G.adj(v)) {
                if (marked[w]) {
                    cycle = new Stack<Integer>();
                    cycle.push(v);
                    cycle.push(w);
                    cycle.push(v);
                    return true;
                }
                marked[w] = true;
            }

            // reset so marked[v] = false for all v
            for (int w : G.adj(v)) {
                marked[w] = false;
            }
        }
        return false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    private boolean check(Graph G) {

        if (hasCycle()) {
            // verify cycle
            int first = -1, last = -1;
            for (int v : cycle()) {
                if (first == -1) first = v;
                last = v;
            }
            if (first != last) {
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }


        return true;
    }

    /**
     * Unit tests the <tt>DirectedCycle</tt> data type.
     */
    public static void main(String[] args) {
		Graph graph=new Graph(250);
		String file1="E:\\graduate\\dsa\\hw\\mediumEWG.txt";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file1));
			String line =null; int i=0;
			while ((line=br.readLine()) != null) {				
				if(i>=2){
					String[] ints=line.split(" ");
					 int a =Integer.parseInt(ints[0]);
			            int b=Integer.parseInt(ints[1]);
			            graph.addEdge(a,b);	
				}
	           	i++;		
			}	
			br.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		System.out.println(graph);

        UndirectedCycle finder = new UndirectedCycle(graph);
        if (finder.hasCycle()) {
            System.out.println("Cycle: ");
            for (int v : finder.cycle()) {
            	 System.out.println(v + " ");
            }
            System.out.println();
        }

        else {
        	 System.out.println("No cycle");
        }
    }
}
