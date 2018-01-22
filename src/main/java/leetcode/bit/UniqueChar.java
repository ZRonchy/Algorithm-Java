package leetcode.bit;

public class UniqueChar {
    public static boolean isUniqueChars(String str) {
        int checker = 0; //bit storage
        for (int i = 0; i < str.length(); ++i) {
            int val = str.charAt(i) - 'a';
            // if bit at index val is 1, then it already exists
            if ((checker & (1 << val)) > 0) {
                return false;
            }

            //Set bit of index val to 1
            checker |= (1 << val);
        }
        return true;
    }
}
