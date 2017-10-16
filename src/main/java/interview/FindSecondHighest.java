package Programming;

public class FindSecondHighest {
	public static void main(String[] args) {
	    int b[] = {2,3,1,0,5};
	    int highest = Integer.MIN_VALUE;
	    int highest2nd = Integer.MIN_VALUE;
	    for(int i :b ) 
	        if (i>=highest) { 
	            highest2nd = highest;
	            highest = i;
	        } else if (i>= highest2nd)
	            highest2nd = i;
	    System.out.println(highest2nd);
	}
}
