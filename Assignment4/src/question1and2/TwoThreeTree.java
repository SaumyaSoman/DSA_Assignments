package question1and2;

/**
 * 
 * @author Saumya
 *
 */
public class TwoThreeTree {

	Node root;

	private Node put(Node x, Integer key, Double value) {	        
		if (x == null) return Node.newTwoNode(key,value);
		int cmp = key.compareTo(x.leftKey);
		int cmp1 = key.compareTo(x.rightKey);
		if(x.isTwoNode()){
			//System.out.println(x.isTerminal());
			if(cmp==0){
				//System.out.println("duplicate");
				return x;}
			if(x.isTerminal()){

				Node thnode = Node.newThreeNode(value,key,x.val(),x.leftKey);
				x=thnode;
				//System.out.println(thnode);
			}else{
				if      (cmp < 0) x.left  = put(x.left,  key, value);
				else if (cmp > 0) x.right = put(x.right, key, value);
				else    x.leftVal   = value;
			}
		}else{

			if (cmp == 0 || cmp1 == 0) {
				// System.out.println("duplicate");
				return x;
			}
			if(cmp<0)x.left  = put(x.left,  key, value);
			else if(cmp1<0) x.middle= put(x.middle, key, value);
			else  x.right = put(x.right, key, value);		   

		}

		return x;
	}

	public void put(int key, Double val) {
		root=put(root, key, val);
	}

	int height(Node root){
		if(root == null )
			return 0;
		int a=Math.max(height(root.left), height(root.right));
		int b=Math.max(a, height(root.middle));

		return 1+b;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TwoThreeTree [root=" + root + "]";
	}






}
