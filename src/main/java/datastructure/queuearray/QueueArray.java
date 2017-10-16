package datastructure.queuearray;

class  QueueArrayException extends Exception{
	private static final long serialVersionUID = 2887295070926633743L;
	private String message = "Exception: Queue Array Exception";
    
    public QueueArrayException() {
        super();
    }
 
    public QueueArrayException(String message) {
        super(message);
        this.message = message;
    }
 
    public QueueArrayException(Throwable cause) {
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

public class QueueArray {
	private Object[] objectArray;
	private int queueHead;
	private int queueTail;
	private int queueSize;
	
	public QueueArray(){
		objectArray = new Object[50];
		queueHead = 0;
		queueTail = 0;
		queueSize = 0;
	}
	
	public QueueArray(int size){
		objectArray = new Object[size];
		queueHead = 0;
		queueTail = 0;
		queueSize = 0;
	}
	
	public void enQueue (Object o) throws QueueArrayException{
		if(queueSize < objectArray.length){
			objectArray[queueTail] = o;
			queueTail = (queueTail+1) % objectArray.length;
			queueSize += 1;
		}else{
			throw new QueueArrayException();
		}
	}
	
	public Object deQueue() throws QueueArrayException{
		if (queueSize != 0) {
			int oldQueueHead = queueHead;
			queueHead = (queueHead+1) % objectArray.length;
			queueSize -= 1;
			return objectArray[oldQueueHead];
		}else{
			throw new QueueArrayException();
		}
	}
	
	public Object head() throws QueueArrayException{
		if(queueSize != 0){
			return objectArray[queueHead];
		}else{
			throw new QueueArrayException();
		}
	}
	
	public boolean isEmpty(){
		return (queueSize == 0);
	}
	
	public void clear(){
		queueTail = 0;
		queueHead = 0;
		queueSize = 0;
	}
}
