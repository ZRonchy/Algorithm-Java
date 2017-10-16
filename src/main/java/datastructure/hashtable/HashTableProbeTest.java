package datastructure.hashtable;

public class HashTableProbeTest {
	public static void main(String[] args) throws KeyNotFoundInTableException, TableOverflowException{
		HashTableProbe myLUT = new HashTableProbe(10);

		myLUT.insert("Priscilla", new Integer(41));
		myLUT.insert("Travis", new Integer(34));
		myLUT.insert("Samuel", new Integer(28));
		myLUT.insert("Helena", new Integer(39));
		myLUT.insert("Andrew", new Integer(14));
		myLUT.insert("Kay", new Integer(24));
		myLUT.insert("John", new Integer(67));
		
		myLUT.delete("Travis");
		myLUT.delete("John");
		
		myLUT.insert("Dani", new Integer(15));
		myLUT.insert("John", new Integer(67));
		myLUT.insert("Travis", new Integer(34));

		System.out.println(myLUT.retrieve("Travis"));
		
	}
}
