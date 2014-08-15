package question3;

public class Sequential {
	
	int N=0;
	SymbolTable st;
	
	public Sequential(SymbolTable st) {
		// TODO Auto-generated constructor stub
		this.st=st;
		N=st.keys.length;
	}
	
	 public Integer get(int key) {
	        
		 if(N==0){
			return null; 
		 }
		 Integer val=null;
	        for(int i=0; i<N; i++){
	        	if(key==st.keys[i]){
	        		val=st.values[i];
	        	}
	        }
			return val;
	    }
}
