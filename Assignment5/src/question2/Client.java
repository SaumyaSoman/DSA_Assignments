package question2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Saumya
 *
 */
public class Client {

	public static void main(String[] args) {
		EdgeWeightedGraph graph=new EdgeWeightedGraph(250);
		String file1="E:\\graduate\\dsa\\hw\\mediumEWG.txt";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file1));
			String line =null; int i=0;
			while ((line=br.readLine()) != null) {				
				if(i>=2){
					String[] ints=line.split(" ");

					int a =Integer.parseInt(ints[0]);
					int b=Integer.parseInt(ints[1]);
					double c=Double.parseDouble(ints[2]);
					Edge edge=new Edge(a, b, c);
					graph.addEdge(edge);	
				}
				i++;		
			}	
			br.close();
			long bsTime=0;
			long startTime = System.nanoTime();
			Kruskal mst = new Kruskal(graph);
			//Prim mst1 = new Prim(graph);
			long endTime = System.nanoTime();
			bsTime=(endTime - startTime);
			System.out.println(bsTime);
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
