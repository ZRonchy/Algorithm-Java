package submitted;

/**
 * https://leetcode.com/submissions/detail/183737566/
 * Note we need to keep track of the
 */
public class Read4II {
    private char[] buf4 = new char[4];
    private int offset = 0;
    private int charactersInBuf4 = 0;

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int totalCharactersRead = 0;
        boolean eol = false;

        while (!eol && totalCharactersRead < n) {
            if (charactersInBuf4 == 0) {
                charactersInBuf4 = read4(buf4);
                eol = charactersInBuf4 < 4;
            }

            int numOfCharactersUsed = Math.min(charactersInBuf4, n - totalCharactersRead);
            for (int i = 0; i < numOfCharactersUsed; i++) {
                buf[totalCharactersRead + i] = buf4[offset + i];
            }
            totalCharactersRead += numOfCharactersUsed;
            charactersInBuf4 -= numOfCharactersUsed;
            offset = (offset + numOfCharactersUsed) % 4;
        }

        return totalCharactersRead;
    }

    // Fake method please ignore
    int read4(char[] buf4){
        return 0;
    }
}
