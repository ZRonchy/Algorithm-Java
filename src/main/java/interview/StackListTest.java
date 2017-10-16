package Code;

public class StackListTest {
	  public static void main(String[] args){
		  StackList myStack = new StackList();
		 			  
	      myStack.push(new Integer(5));
	      myStack.push(new Integer(6));
	      myStack.push(new Integer(7));
		  System.out.println("Size is "+myStack.size());
		 // myStack.delete(new Integer(8));
		  myStack.insert(new Integer(9),new Integer(8));
		  System.out.println("Size is "+myStack.size());
		  while (!myStack.empty()){
			  try{
				  System.out.println(myStack.pop());
			      
			  }
			  catch(Exception e){
				  System.out.println(e);
			  }
			  
		  }
		  
	  } 
}
