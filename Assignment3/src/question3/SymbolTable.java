package question3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SymbolTable {
	
	static int N=5;
	static int mid=(int) (.75*N);
	int[] keys=new int[N];
	int[] values=new int[N];
	
	 public SymbolTable(){
		 for(int i=0;i<N;i++){
			 keys[i]=i;
			 values[i]=(int) (Math.random()*N);
		 }
	 }

		public static void main(String args[]){
			SymbolTable st=new SymbolTable();
			BinarySearch bn=new BinarySearch(st);
			Sequential ss=new Sequential(st);
			
			long startTime1 = System.nanoTime();
			
			ss.get(mid);
			long endTime1 = System.nanoTime();
			
			long startTime = System.nanoTime();
			bn.get(mid);
			long endTime = System.nanoTime();
			
			System.out.println("Took bn "+(endTime - startTime) + "ns.." );  
			System.out.println("Took ss "+(endTime1 - startTime1) + "ns...");
		}
}
