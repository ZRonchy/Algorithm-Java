package leetcode.stringarray;

/**
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function
 * search(char pat[], char txt[]) that prints all occurrences of pat[]
 * in txt[]. You may assume that n > m.
 * Examples:
 * Input:  txt[] = "THIS IS A TEST TEXT"
 * pat[] = "TEST"
 * Output: Pattern found at index 10
 * <p>
 * Input:  txt[] =  "AABAACAADAABAABA"
 * pat[] =  "AABA"
 * Output: Pattern found at index 0
 * Pattern found at index 9
 * Pattern found at index 12
 * The best case occurs when the first character of the pattern is not present
 * in text at all, best case is O(n)
 * Worst case also occurs when only the last character is different, worst case is O(m*(n-m+1))
 */
public class SearchingforPatterns_Naive {
    public static void search_naive(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();

        /* A loop to slide pat one by one */
        for (int i = 0; i <= N - M; i++) {
            int j;

            /* For current index i, check for pattern
              match */
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }

            if (j == M) {// if pat[0...M-1] = txt[i, i+1, ...i+M-1]
                System.out.println("Pattern found at index " + i);
            }
        }
    }

    public static void search_naive_improved(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();
        int i = 0;

        while (i <= N - M) {
            int j;

            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }

            if (j == M) {
                System.out.println("Pattern found at index " + i);
                i = i + M;
            } else if (j == 0) {
                i++;
            } else {
                i = i + j;
            }
        }
    }

    public static void main(String[] args) {
        String txt = "AABAACAADAABAAABAA";
        String pat = "AABA";
        search_naive(txt, pat);
        search_naive_improved(txt, pat);
    }
}
