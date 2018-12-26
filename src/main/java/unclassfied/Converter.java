package unclassfied;

public class Converter {
    void convert() {
        // char to String
        char c = 'a';
        String s = Character.toString(c);

        // int to char
        int i = c - 'a';
        c = (char) (i + 'a');

        // char array to String
        char[] ch = s.toCharArray();
        s = new String(ch);

        // char is digit or not
        boolean b = Character.isDigit(c);
    }
}
