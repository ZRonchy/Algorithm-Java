package datastructure.pointer;

import java.util.Vector;

public class PointerTest {
	public static void main(String[] args){
		Vector<String> s = new Vector<String>();
		s.add("hi");
		
		Vector<String> x = s;
		x.add("hello");

		System.out.println(s.get(1));
	}
}
