package submitted;

/**
 * https://leetcode.com/submissions/detail/183508460/
 * Pay attention to the adding bits and use a global variable to indicate carry
 */
public class AddBinary {
    class Solution {
        public String addBinary(String a, String b) {
            String small = a;
            String large = b;

            if (a.length() > b.length()) {
                small = b;
                large = a;
            }

            String[] result = new String[large.length()];
            int carry = 0;
            int resultCount = 0;
            int largeCount = large.length()-1;

            for (int i = small.length()-1; i>=0; i--) {
                int si = Character.getNumericValue(small.charAt(i));
                int li = Character.getNumericValue(large.charAt(largeCount--));
                int sumi = si + li + carry;
                if (sumi >= 2) {
                    carry = 1;
                    sumi = sumi-2;
                } else {
                    carry = 0;
                }

                result[resultCount++] = Integer.toString(sumi);
            }

            for (int k = largeCount; k>=0; k--) {
                int sumTemp = carry + Character.getNumericValue(large.charAt(k));
                if (sumTemp >= 2) {
                    carry = 1;
                    sumTemp = sumTemp-2;
                } else {
                    carry = 0;
                }
                result[resultCount++] = Integer.toString(sumTemp);
            }


            StringBuilder finalStr = new StringBuilder();
            if(carry==1) {
                finalStr = new StringBuilder("1");
            }
            for (int j=result.length-1; j>=0;j--) {
                finalStr.append(result[j]);
            }

            return finalStr.toString();

        }
    }
}
