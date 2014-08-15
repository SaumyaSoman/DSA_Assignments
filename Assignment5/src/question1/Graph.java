package question1;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 
 * @author Saumya
 * Reference- Sedgewick
 */
public class Graph {

	private int V;
	private ArrayList[] adjacentVertices;

	public Graph(int numberOfVertices){
		this.V=numberOfVertices;
		adjacentVertices=new  ArrayList[numberOfVertices+1];
		for(int i=0;i<this.V+1;i++){
			adjacentVertices[i]=new ArrayList<Integer>();
		}
	}

	public void addEdge(int vertex1, int vertex2){
		adjacentVertices[vertex1].add(vertex2);
		adjacentVertices[vertex2].add(vertex1);
	}

	public Iterable<Integer> adj(int v) {
		return adjacentVertices[v];
	}

	public int V() {
		return V;
	}

	public void setNumberOfVertices(int numberOfVertices) {
		this.V = numberOfVertices;
	}

	@Override
	public String toString() {
		return "Graph [numberOfVertices=" + V
				+ ", adjacentVertices=" + Arrays.toString(adjacentVertices)
				+ "]";
	}
}
