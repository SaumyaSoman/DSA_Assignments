package question3;

/**
 * 
 * Credits Sedgewick
 *
 */
public class BST {
	
	  private Node root;             // root of BST

	    private class Node {
	        private int key;           // sorted by key
	        private double val;         // associated data
	        private Node left, right;  // left and right subtrees
	        private int N;             // number of nodes in subtree

	        public Node(int key, Double val, int N) {
	            this.key = key;
	            this.val = val;
	            this.N = N;
	        }

			@Override
			public String toString() {
				return "Node [key=" + key + ", val=" + val + ", left=" + left
						+ ", right=" + right + ", N=" + N + "]";
			}
	        
	    }


	    public void put(int key, Double val) {
	        root = put(root, key, val);
	    }

	    private Node put(Node x, Integer key, Double val) {
	        if (x == null) return new Node(key, val, 1);
	        int cmp = key.compareTo(x.key);
	        if      (cmp < 0) x.left  = put(x.left,  key, val);
	        else if (cmp > 0) x.right = put(x.right, key, val);
	        else              x.val   = val;
	        x.N = 1 +size(x.left) + size(x.right);
	        return x;
	    }
	    
	    public int size() {
	        return size(root);
	    }
	    
		private int size(Node x) {
			// TODO Auto-generated method stub
			if(x==null)return 0;
			return x.N;
		}

		@Override
		public String toString() {
			return "BST [root=" + root + "]";
		}

	    public Integer select(int k) {
	        if (k < 0 || k >= size())  return null;
	        Node x = select(root, k);
	        return x.key;
	    }

	    // Return key of rank k. 
	    private Node select(Node x, int k) {
	        if (x == null) return null; 
	        int t = size(x.left); 
	        if      (t > k) return select(x.left,  k); 
	        else if (t < k) return select(x.right, k-t-1); 
	        else            return x; 
	    } 

	    public int rank(Integer key) {
	        return rank(key, root);
	    } 

	    // Number of keys in the subtree less than key.
	    private int rank(Integer key, Node x) {
	        if (x == null) return 0; 
	        int cmp = key.compareTo(x.key); 
	        if      (cmp < 0) return rank(key, x.left); 
	        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); 
	        else              return size(x.left); 
	    } 
}
