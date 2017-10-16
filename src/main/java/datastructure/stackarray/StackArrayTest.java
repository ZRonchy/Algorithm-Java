package datastructure.stackarray;

public class StackArrayTest {
	public static void main(String[] args) {
		StackArray myStack = new StackArray(25);
		
		for (int i=0;i<5;i++){
			try{
				myStack.push(new Integer(10*i));
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		while(!myStack.isEmpty()){
			try{
				System.out.println(myStack.pop());
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}
