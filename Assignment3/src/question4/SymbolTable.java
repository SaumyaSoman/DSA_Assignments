package question4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SymbolTable {
	
	static int N=477;



		public static void main(String args[]){
			BinarySearch bn=new BinarySearch();
			BST bst=new BST();

			long bsTime=0;
			long binaryTime=0;
			//bn.put(mid,450);
			 for(int i=0;i<N;i++){
				 int key=(int)(Math.random()*N);
				 double val=(double)i;

				 long startTime1 = System.nanoTime();
				 bn.put(key,val);
				 long endTime1 = System.nanoTime();
				 binaryTime+=(endTime1 - startTime1);
				 long startTime = System.nanoTime();
				 bst.put(key,val);
				 long endTime = System.nanoTime();
				 bsTime+=(endTime - startTime);
			 }
			

			System.out.println("Took bst   "+bsTime + "ns.." );  
			System.out.println("Took biary "+binaryTime + "ns...");
		}
}
