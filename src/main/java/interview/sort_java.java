package interview;
import java.util.Arrays;

public class sort_java {

   public static void main(String[] args) {

    // initializing unsorted int array
    int iArr[] = {2, 1, 9, 6, 4};
    char[]Haystack = {'a','d','e','b','c'};
    // let us print all the elements available in list

    // sorting array
    Arrays.sort(iArr);
    Arrays.sort(Haystack);
    // let us print all the elements available in list
    System.out.println("The sorted int array is:");
    for (int number : iArr) {
      System.out.println("Number = " + number);
    }
    
    for (char num : Haystack) {
        System.out.println("Num = " + num);
      }
    if ('a'<'c'){System.out.println("True");}
    
  }
}