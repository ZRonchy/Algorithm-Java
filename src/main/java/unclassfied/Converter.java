package unclassfied;

public class Converter {
    void convert() {
        // char to String
        char c = 'a';
        String s = Character.toString(c);

        // int to char, char to int
        int i = c - 'a';
        c = (char) (i + 'a');

        // char to int
        int j = Character.getNumericValue(c);

        // char array to String
        char[] ch = s.toCharArray();
        s = new String(ch);

        // char is digit or not
        boolean b = Character.isDigit(c);

    }
}
