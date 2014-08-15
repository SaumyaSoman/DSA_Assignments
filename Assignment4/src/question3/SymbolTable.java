package question3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SymbolTable {
	
	static int N=477;

	static ArrayList<Integer> numbers1=new ArrayList<Integer>();

		public static void main(String args[]){
			BST bst=new BST();
			String file1="E:\\graduate\\dsa\\hw\\select-data.txt";
			try {
				BufferedReader br = new BufferedReader(new FileReader(file1));
				String line =null;
				while ((line=br.readLine()) != null) {
					
					int number =Integer.parseInt(line);
					numbers1.add(number);			
				}	
				br.close();
			} catch(FileNotFoundException e){
				e.printStackTrace();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			long bsTime=0;
			//bn.put(mid,450);
			 for(int i=0;i<numbers1.size();i++){
				 int key=numbers1.get(i);
				 double val=(double)i;
				 long startTime = System.nanoTime();
				 bst.put(key,val);
				 long endTime = System.nanoTime();
				 bsTime+=(endTime - startTime);
			 }
			System.out.println("Rank..."+bst.rank(7));
			System.out.println("Select..."+bst.select(7));
			System.out.println("Took bst   "+bsTime + "ns.." );  
		}
}
