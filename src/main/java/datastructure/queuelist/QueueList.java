package datastructure.queuelist;

class  QueueListException extends Exception{
	private static final long serialVersionUID = 2887295070926633743L;
	private String message = "Exception: Queue List Exception";
    
    public QueueListException() {
        super();
    }
 
    public QueueListException(String message) {
        super(message);
        this.message = message;
    }
 
    public QueueListException(Throwable cause) {
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

public class QueueList {
	private Node listHead;
	private Node listTail;
	
	protected class Node{
		protected Object datum;
		protected Node next;
		
		public Node(Object o, Node n){
			datum = o;
			next = n;
		}
	}
	
	public QueueList(){
		listHead = null;
		listTail = null;
	}
	
	public void enQueue(Object o){
		if(listHead == null){
			listHead = new Node(o, null);
			listTail = listHead;
		}else{
			listTail.next = new Node(o, null);
			listTail = listTail.next;
		}
	}
	
	public Object deQueue() throws QueueListException{
		if(listHead == null){
			throw new QueueListException();
		}
		
		if(listHead.next == null){
			Object head = listHead.datum;
			listHead = null;
			listTail = null;
			return head;
		}else{
			Object head = listHead.datum;
			listHead = listHead.next;
			return head;
		}
	}
	
	public Object head() throws QueueListException{
		if(listHead != null){
			return listHead.datum;
		}else{
			throw new QueueListException();
		}
	}
	
	public boolean isEmpty(){
		return (listHead == null);
	}
	
	public void clear(){
		listHead = null;
		listTail = null;
	}
}
