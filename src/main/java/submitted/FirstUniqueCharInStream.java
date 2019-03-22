package submitted;
// Find the first unique character in a stram of characters
public class FirstUniqueCharInStream {
    //Insert one char from stringstream
    private int[] occurence = new int[256];
    private int index;

    public FirstUniqueCharInStream() {
        for (int i = 0; i < 256; i++) {
            occurence[i] = -1;
        }
        index = 0;
    }

    void insert(char ch) {
        if (occurence[ch] == -1)
            occurence[ch] = index;
        else if (occurence[ch] >= 0)
            occurence[ch] = -2;

        index++;
    }

    //return the first appearence once char in current stringstream
    char firstAppearingOnce() {
        Character ch = null;
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            if (occurence[i] >= 0 && occurence[i] < minIndex) {
                ch = (char) i;
                minIndex = occurence[i];
            }
        }
        if (ch == null)
            return '#';
        return ch;
    }
}
