package question3;

public class BinarySearch {
	
	int N;
	SymbolTable st;
	
	public BinarySearch(SymbolTable st) {
		// TODO Auto-generated constructor stub
		this.st=st;
		N=st.keys.length;
	}
	 // resize the underlying arrays
    private void resize(int capacity) {
        assert capacity >= N;
        int[]   tempk =  new int[N];
        int[] tempv = new int[N];
        for (int i = 0; i < N; i++) {
            tempk[i] = st.keys[i];
            tempv[i] = st.values[i];
        }
        st.values = tempv;
        st.keys = tempk;
    }


    public Integer get(int key) {
    	if(N==0) return null;
    	int i=rank(key);
        if (st.keys[i]==key) {
        	return st.values[i];
        }
        return null;
        
    } 

  
/*
 * Credits : Sedgewick princeton
 */
    // Search for key. Update value if found; grow table if new. 
    public void put(int key, int val)  {
 
        int i = rank(key);

        // key is already in table
        if ((i < N && (st.keys[i]==key)) == true) {
            st.values[i] = val;
            return;
        }

        // insert new key-value pair
        if (N == st.keys.length) resize(2*st.keys.length);

        for (int j = N; j > i; j--)  {
            st.keys[j] = st.keys[j-1];
            st.values[j] = st.values[j-1];
        }
        st.keys[i] = key;
        st.values[i] = val;
        N++;
    } 
    
    public int rank(int key) {
        int lo = 0, hi = N-1; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2; 
            if      (key < st.keys[mid]) hi = mid - 1; 
            else if (key > st.keys[mid]) lo = mid + 1; 
            else{
           	 return st.values[mid];
            }
        } 
        return lo;
    } 
//
//
//    // Remove the key-value pair if present
//    public void delete(Key key)  {
//        if (isEmpty()) return;
//
//        // compute rank
//        int i = rank(key);
//
//        // key not in table
//        if (i == N || keys[i].compareTo(key) != 0) {
//            return;
//        }
//
//        for (int j = i; j < N-1; j++)  {
//            keys[j] = keys[j+1];
//            vals[j] = vals[j+1];
//        }
//
//        N--;
//        keys[N] = null;  // to avoid loitering
//        vals[N] = null;
//
//        // resize if 1/4 full
//        if (N > 0 && N == keys.length/4) resize(keys.length/2);
//
//        assert check();
//    } 
//
//    // delete the minimum key and its associated value
//    public void deleteMin() {
//        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
//        delete(min());
//    }
//
//    // delete the maximum key and its associated value
//    public void deleteMax() {
//        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
//        delete(max());
//    }
}
