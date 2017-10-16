package datastructure.stacklist;

public class StackListTest {
	public static void main(String[] args) {
	    try {
	    	StackList stack = new StackList();
	    	
	    	stack.push(new Integer(1));
	    	stack.push(new Integer(2));
	    	stack.push(new Integer(3));
	    	stack.push(new Integer(4));
	    	stack.push(new Integer(5));
	    	
	    	System.out.println(stack.pop());
	    	
		    } catch (Exception e) {
		      System.out.println(e);
		    }
	}
}
