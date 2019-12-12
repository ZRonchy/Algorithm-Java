package interview;

import interview.StackArray;

public class StackArrayTest {
  public static void main(String[] args){
	  StackArray myStack = new StackArray(25);
	  for (int i=0;i<5;i++){
		  try{
		  myStack.push(new Integer(1));}
		  catch (Exception e){
			  System.out.println(e);
		  }  
	  }
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
