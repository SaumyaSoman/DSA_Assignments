package question1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MergeSort {
	
	static int arrayCapacity=1024;
	static int count=0;
	
	public static void main(String args[]){

		int[] numbers=new int[arrayCapacity];	
				
		//read the sorted file
		String file1="E:\\graduate\\dsa\\hw\\dataset-problem2-hw2\\data1."+arrayCapacity;
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
		mergeBUSort(numbers);
		//mergeSort(numbers,0,numbers.length-1);
		System.out.println(Arrays.toString(numbers));
		long endTime = System.currentTimeMillis();
		System.out.println("Took "+(endTime - startTime) + "ms");  
		System.out.println(count);
	}
	
	
	/********** Bottom-up approach*********************/
	
	private static void mergeBUSort(int[] numbers) {
		// TODO Auto-generated method stub
		
		int len=numbers.length;
		for(int n=1;compare1(n,len);n+=n){
			for(int i=0;compare1(i, len-n);i+=n+n){
				int lo = i;
                int mid  = i+n-1;
                int hi = Math.min(i+n+n-1, len-1);
                merge(numbers, lo, mid, hi);
			}
		}
		
	}

	
	
	/********** Top-down approach*********************/

	private static void mergeSort(int[] numbers, int lo, int hi) {
		// TODO Auto-generated method stub
		if(compare1(lo,hi)){
			int mid= lo+ (hi-lo)/2;
			mergeSort(numbers,lo,mid);
			mergeSort(numbers,mid+1,hi);
			merge(numbers,lo,mid,hi);
		}
		
	}

	private static void merge(int[] numbers, int lo, int mid, int hi) {
		// TODO Auto-generated method stub
		
		int[] temp=new int[hi+1];
		for(int i=lo;compare(i,hi);i++){
			temp[i]=numbers[i];
		}
		
		int k=lo,i=lo,j=mid+1;
		
		while(compare(i,mid)&& compare(j,hi)){
			
			if(compare(temp[i],temp[j])){
				numbers[k]=temp[i];
				i++;
			}else{
				numbers[k]=temp[j];
				j++;
			}
			k++;
		}
		while(compare(i,mid)){
			numbers[k]=temp[i];
			i++;k++;
		}
		while(compare(j,hi)){
			numbers[k]=temp[j];
			j++;k++;
		}
		
	}
	
	private static boolean compare(int a ,int b){
		
		count++;
		if(a<=b){
			return true;
		}
		return false;
	}

	private static boolean compare1(int a ,int b){
		
		count++;
		if(a<b){
			return true;
		}
		return false;
	}
}
