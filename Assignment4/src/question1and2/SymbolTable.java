package question1and2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * 
 * @author Saumya
 *
 */
public class SymbolTable {

	public static void main(String args[]){
		int N=100000;
		//int[] data=new int[]{2,4,1,10,3,6,7,8,9,5};
		int[] data=new int[N];
		for(int i=0;i<N;i++){
			int key=(int)(Math.random()*N);
			data[i]=key;
		}
		TwoThreeTree tree=new TwoThreeTree();
		for(int i=0;i<data.length;i++){			

			int key=data[i];
			double val=(double)i;
			tree.put(key, val);
		}
		System.out.println(tree.toString());
		System.out.println(tree.height(tree.root));
		Arrays.sort(data);
		TwoThreeTree tree1=new TwoThreeTree();
		for(int i=0;i<data.length;i++){			

			int key=data[i];
			double val=(double)i;
			tree1.put(key, val);
		}
		System.out.println(tree1.toString());
		System.out.println(tree1.height(tree1.root));

	}
}
