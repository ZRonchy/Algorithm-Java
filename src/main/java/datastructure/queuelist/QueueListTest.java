package datastructure.queuelist;

public class QueueListTest {
	public static void main(String[] args) {
	    try {
	    	QueueList queue = new QueueList();
	    	
	    	queue.enQueue(new Integer(1));
	    	queue.enQueue(new Integer(2));
	    	queue.enQueue(new Integer(3));
	    	queue.enQueue(new Integer(4));
	    	queue.enQueue(new Integer(5));
	    	
	    	System.out.println(queue.isEmpty());
	    	
		    } catch (Exception e) {
		      System.out.println(e);
		    }
	}
}
