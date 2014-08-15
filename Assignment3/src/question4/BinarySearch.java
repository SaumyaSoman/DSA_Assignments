package question4;

import java.util.Arrays;

public class BinarySearch {
	
	int N=0,capacity=10;
	SymbolTable st;
	int[] keys=new int[capacity];
	double[] values=new double[capacity];

	 // resize the underlying arrays
    private void resize(int capacity) {
        assert capacity >= N;
        int[]   tempk =  new int[capacity];
        double[] tempv = new double[capacity];
        for (int i = 0; i < N; i++) {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
    }

 
/*
 * Credits : Sedgewick princeton
 */
    // Search for key. Update value if found; grow table if new. 
    public void put(Integer key, double val)  {
 
        int i = rank(key);

        // key is already in table
        if (i < N && (keys[i]==(key)) == true) {
            values[i] = val;
            return;
        }

        // insert new key-value pair
        if (N == keys.length) resize(2*keys.length);

        for (int j = N; j > i; j--)  {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = val;
        N++;
    } 
    
    public int rank(int key) {
        int lo = 0, hi = N-1; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2; 
            if      (key < keys[mid]) hi = mid - 1; 
            else if (key > keys[mid]) lo = mid + 1; 
            else{
           	 return (int)values[mid];
            }
        } 
        return lo;
    }


	@Override
	public String toString() {
		return "BinarySearch [N=" + N + ", keys=" + Arrays.toString(keys)
				+ ", values=" + Arrays.toString(values) + "]";
	} 
    

}
