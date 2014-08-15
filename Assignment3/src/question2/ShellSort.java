package question2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ShellSort {

	static int arrayCapacity=32768;
	static int count=0;
	private static int count1=0;
	
	public static void main(String args[]){

		int[] numbers=new int[arrayCapacity];	
				
		//read the sorted file
		String file1="E:\\graduate\\dsa\\hw\\dataset-problem2-hw2\\data1.32768";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file1));
			String line =null;
			int index=0;
			while ((line=br.readLine()) != null) {
				
				int number =Integer.parseInt(line);
				numbers[index]=number;
				index++;			
			}	
			br.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		long startTime = System.currentTimeMillis();
		//shellSort(numbers);
		insertionSort(numbers);
		System.out.println(Arrays.toString(numbers));
		long endTime = System.currentTimeMillis();
		System.out.println("Took "+(endTime - startTime) + "ms");  
		System.out.println(count);
		System.out.println("count"+count1);
	}

	private static void shellSort(int[] numbers) {
		// TODO Auto-generated method stub
		int N=numbers.length;
		int h=1,n=2;
		while(h<N/2){
			h= (int) (Math.pow(2, n)-1);
			n++;
			System.out.print(h+" ");
		}
		
		while(h>=1){
			
			for(int i=h;i<N;i++){
				for(int j=i;j>=h && compare(numbers[j],numbers[j-h],h); j=j-h){
					int temp=numbers[j];
					numbers[j]=numbers[j-h];
					numbers[j-h]=temp;
				}
			}
			h= h/2;
		}
	}
	private static void insertionSort(int[] a) {
		// TODO Auto-generated method stub
		int N=a.length; int h=2;
		for(int i=0;i<N;i++){
			for(int j=i;j>0;j--){
				if(compare(a[j],a[j-1],h)){
					int temp=a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
				}
			}
		}
	}
	private static boolean compare(int a ,int b,int h){
		
		if(h==1){
			count1++;
		}else{
			count++;
		}
		
		
		if(a<=b){
			return true;
		}
		return false;
	}
}
