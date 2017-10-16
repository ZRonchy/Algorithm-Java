package datastructure.stacklist;
class StackListException extends Exception {

	private static final long serialVersionUID = 2887295070926633743L;
	private String message = "Exception: Stack List Exception";
    
    public StackListException() {
        super();
    }
 
    public StackListException(String message) {
        super(message);
        this.message = message;
    }
 
    public StackListException(Throwable cause) {
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

public class StackList {
	private Node listHead;
	
	protected class Node{
		protected Object datum;
		protected Node next;
		
		public Node(Object o, Node n){
			datum = o;
			next = n;
		}
	}
	
	public StackList(){
		listHead = null;
	}
	
	public void push(Object o){
		listHead = new Node(o, listHead);
	}
	
	public Object pop() throws StackListException {
		if (listHead != null){
			Object top = listHead.datum;
			listHead = listHead.next;
			return top;
		}else{
			throw new StackListException();
		}
	}
	
	public Object top() throws StackListException {
		if (listHead != null){
			return listHead.datum;
		}else{
			throw new StackListException();
		}
	}
	
	public boolean isEmpty(){
		return (listHead == null);
	}
	
	public void empty(){
		listHead = null;
	}
	
	public void clear(){
		listHead = null;
	}
	
	public int size(){
		Node currPointer = listHead;
		int size = 0;
		
		while (currPointer != null){
			currPointer = currPointer.next;
			size++;
		}
		
		return size;
	}
	
	
	
}
