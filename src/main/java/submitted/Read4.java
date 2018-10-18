package submitted;

/**
 * https://leetcode.com/submissions/detail/183724237/
 * Note to copy buf from buf4 and check whether we reach the Nth character
 * reference: https://evelynn.gitbooks.io/google-interview/read_n_characters_given_read4.html
 */
public class Read4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        int total = 0;
        boolean eol = false;

        while (!eol && total < n) {
            int count = read4(buf4);
            eol = count < 4;
            count = Math.min(count, n - total);

            for (int i=0; i<count;i++) {
                buf[total++] = buf4[i];
            }
        }

        return total;

    }

    // Fake method please ignore
    int read4(char[] buf4){
        return 0;
    }
}
