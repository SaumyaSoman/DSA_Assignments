package question1and2;


public class Node {
	int leftKey,rightKey;   // sorted by key	        
	double leftVal;    double rightVal;      // associated data
	Node left,middle, right;  // left, middle and right subtrees
	private boolean twoNode;
	public Node(){

	}
	public Double val() {
		assert isTwoNode();
		return leftVal;
	}
	/**
	 * @return the twoNode
	 */
	public boolean isTwoNode() {
		return twoNode;
	}
	public boolean isTerminal() {
		return left == null && right == null && middle==null;
	}
	/**
	 * @param twoNode the twoNode to set
	 */
	public void setTwoNode(boolean twoNode) {
		this.twoNode = twoNode;
	}

	public static Node newTwoNode(int key, Double value) {
		Node node = new Node();
		node.leftVal = value;
		node.leftKey=key;
		node.twoNode = true;
		return node;
	}


	public static Node newThreeNode(Double leftVal, Integer leftKey, Double rightVal, Integer rightKey) {
		Node node = new Node();
		if (leftKey.compareTo(rightKey) > 0) {
			node.rightVal = leftVal;
			node.leftVal = rightVal;
			node.leftKey= rightKey;
			node.rightKey= leftKey;
		} else {
			node.leftVal = leftVal;
			node.rightVal = rightVal;
			node.leftKey=leftKey;
			node.rightKey=rightKey;
		}
		node.twoNode = false;
		return node;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	 @Override
	 public String toString() {
		 return "Node [leftKey=" + leftKey + ", rightKey=" + rightKey
				 + ", left=" + left + ", middle=" + middle + ", right="
				 + right + ", twoNode=" + twoNode + "]";
	 }




}