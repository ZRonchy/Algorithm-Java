package datastructure.stackarray;

class  StackArrayException extends Exception{
	private static final long serialVersionUID = 2887295070926633743L;
	private String message = "Exception: Stack Array Exception";
    
    public StackArrayException() {
        super();
    }
 
    public StackArrayException(String message) {
        super(message);
        this.message = message;
    }
 
    public StackArrayException(Throwable cause) {
        super(cause);
    }
 
    @Override
    public String toString() {
        return message;
    }
 
    @Override
    public String getMessage() {
        return message;
    }
}
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
	
	public void push(Object o) throws StackArrayException {
		if(stackSize < objectArray.length) {
			objectArray[stackSize] = o;
			stackSize += 1;
		}else{
			throw new StackArrayException();
		}
	}
	
	public Object pop() throws StackArrayException{
		if(stackSize != 0){
			stackSize -= 1;
			return objectArray[stackSize];
		}else{
			throw new StackArrayException();
		}
	}
	
	public Object top() throws StackArrayException {
		if(stackSize != 0) {
			return objectArray[stackSize-1];
		}else{
			throw new StackArrayException();
		}
	}
	
	public boolean isEmpty(){
		return (stackSize == 0);
	}
	
	public void clear(){
		stackSize = 0;
	}
}
