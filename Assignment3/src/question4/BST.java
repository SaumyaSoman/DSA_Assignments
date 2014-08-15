package question4;

/**
 * 
 * Crredits Sedgewick
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

		private int size(Node x) {
			// TODO Auto-generated method stub
			if(x==null)return 0;
			return x.N;
		}

		@Override
		public String toString() {
			return "BST [root=" + root + "]";
		}

	   
	   /*****************************************************************************
	    *  Test client
	    *****************************************************************************/
//	    public static void main(String[] args) { 
//	        BST st = new BST();
//	        for (int i = 0; !StdIn.isEmpty(); i++) {
//	            String key = StdIn.readString();
//	            st.put(key, i);
//	        }
//
//	        for (String s : st.levelOrder())
//	            StdOut.println(s + " " + st.get(s));
//
//	        StdOut.println();
//
//	        for (String s : st.keys())
//	            StdOut.println(s + " " + st.get(s));
//	    }
}
