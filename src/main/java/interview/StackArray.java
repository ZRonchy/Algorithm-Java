package Code;
import java.*;
public class StackArray {
    private Object[] objectArray;
    private int stackSize;
    public StackArray(){
    	objectArray = new Object[50];
    	stackSize = 0;
    }
    public StackArray(int size){
    	objectArray = new Object[size];
    	stackSize = 0;    	
    }
	public void push(Object o) throws StackArrayException{
		if(stackSize < objectArray.length){
			objectArray[stackSize] = 0;
			stackSize+= 1;
		}else{
			throw new StackArrayException();
		} 
		
	}
    public Object top() throws StackArrayException{
    	if(stackSize !=0){
    		return objectArray[stackSize-1];
    	}else{
    		throw new StackArrayException();
    	}
    	
    }
    public Object pop() throws StackArrayException{
    	if(stackSize!=0){
    		stackSize -=1;
    		return objectArray[stackSize];
    	}else{
    		throw new StackArrayException();
    	}
    }
	public boolean empty(){
		return (stackSize ==0);
	}
	public void clear(){
		stackSize = 0;
	}
	public int size(){
		return stackSize;
	}
	
	
}
