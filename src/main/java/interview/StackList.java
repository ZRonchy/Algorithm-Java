package interview;

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
    	listHead = new Node(o,listHead);
    }
    public Object pop() throws StackListException{
    	if(listHead != null){
    		Object top = listHead.datum;
    		listHead = listHead.next;
    		return top;
    	}else{
    		throw new StackListException();
    	}
    }
    public Object top() throws StackListException{
    	if(listHead !=null){
    		return listHead.datum;
    	}else{
    		throw new StackListException();
    	}
    }
    public boolean empty(){
    	return (listHead == null);
    }
    public void clear(){
    	listHead = null;
    }
    public int size(){
    	if(listHead == null){
    		return 0;
    	}else{
    		Node nodePointer = listHead;
    		int count = 0;
    		while (nodePointer!=null){
    			nodePointer = nodePointer.next;
    			count++;
    		}
    		return count;
    		
    	}
    }
    public void delete(Object o){

    		Node nodePointer = listHead;
    		if(listHead==null){ System.out.println("Null Linedlist");}
    		else if (listHead.datum.equals(o)){
    			listHead=listHead.next;
    		}else{
    			nodePointer = listHead.next;
                Node pre = listHead;
	    		while ( (nodePointer!=null) && (!nodePointer.datum.equals(o))){	    			
	    			pre = nodePointer;
	    			nodePointer = nodePointer.next;
	    		}
	    		if (nodePointer==null){
	    			System.out.println("Not found");
	    		}else{
	    			pre.next = nodePointer.next;
	    			
	    		}
    		
    		}
    	
    	
    }
    public void insert(Object o, Object x){
		Node nodePointer = listHead;			
		while (nodePointer != null &&  (!nodePointer.datum.equals(o))){

			nodePointer = nodePointer.next;
			
		}
		if (nodePointer==null){
               System.out.println("Not Found");
		}else{
			Node cur = new Node(x,nodePointer.next);
			nodePointer.next = cur;
			
		}
			
    	
    }
    
}
