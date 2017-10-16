package datastructure.hashtable;

class TableOverflowException extends Exception {

	private static final long serialVersionUID = 2887295070926633743L;
	private String message = "Exception: Table Over Flow Exception";
    
    public TableOverflowException() {
        super();
    }
 
    public TableOverflowException(String message) {
        super(message);
        this.message = message;
    }
 
    public TableOverflowException(Throwable cause) {
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

class KeyNotFoundInTableException extends Exception {

	private static final long serialVersionUID = -7553700037688109831L;
	private String message = "Exception: Key Not Found In Table";
    
    public KeyNotFoundInTableException() {
        super();
    }
 
    public KeyNotFoundInTableException(String message) {
        super(message);
        this.message = message;
    }
 
    public KeyNotFoundInTableException(Throwable cause) {
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

public class HashTableProbe {
	protected class Entry{
		protected String key;
		protected Object value;
		
		public Entry(String key, Object value){
			this.key = key;
			this.value = value;
		}
	}
	
	protected Entry[] entryArray;
	
	public HashTableProbe(){
		entryArray = new Entry[50];
	}
	
	public HashTableProbe(int size){
		entryArray = new Entry[size];
	}
	
	public static int hash(String key, int M){
		int n=0;
		
		for(int i=0;i<key.length();i++){
			n += (int)key.charAt(i);
		}
		
		return n % M;
	}
	
	public void insert(String key, Object value) throws TableOverflowException{
		//Compute the hash value
		int index = hash(key, entryArray.length);
		
		//Probe linearly to find empty slot
		int count = 0;
		
		while(entryArray[index] != null && (!entryArray[index].key.equals("Tombstone"))
				&& count != entryArray.length){
			index = (index + 1) % entryArray.length;
			count += 1;
		}

		if(count == entryArray.length){
			throw new TableOverflowException();
		}else{
			entryArray[index] = new Entry(key, value);
		}
	}
	
	public void delete(String key) throws KeyNotFoundInTableException{
		int index = hash(key, entryArray.length);
		int count = 0;
		
		while (entryArray[index] != null && (!entryArray[index].key.equals(key))
				&& count != entryArray.length){
			index = (index + 1) % entryArray.length;
			count += 1;
		}
		
		if(entryArray[index] == null || count == entryArray.length){
			throw new KeyNotFoundInTableException();
		}
		
		if (entryArray[(index+1) % entryArray.length] != null){
			entryArray[index].key = "Tombstone";
		}else{
			entryArray[index] = null;
			
			//cleanup obsolete tombstones
			index = (index-1) % entryArray.length;
			while(entryArray[index] != null && entryArray[index].key.equals("Tombstone")){
				entryArray[index] = null;
				index = (index - 1) % entryArray.length;
			}
		}
		
	}
	
	public Object retrieve(String key) throws KeyNotFoundInTableException{
		int index = hash(key, entryArray.length);
		int count = 0;
		
		while(entryArray[index] != null && (!entryArray[index].key.equals(key))
				&& count != entryArray.length){
			index = (index + 1) % entryArray.length;
			count += 1;
		}
		
		if(entryArray[index] == null || count == entryArray.length){
			throw new KeyNotFoundInTableException();
		}
		
		return entryArray[index].value;
	}
}
