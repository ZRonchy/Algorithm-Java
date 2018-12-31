package submitted;

/**
 * https://leetcode.com/submissions/detail/198168717/
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();

        add(sb1, S);
        add(sb2, T);

        return sb1.toString().equals(sb2.toString());
    }

    public void add(StringBuilder sb, String st){
        int ignore=0;

        char[] ca=st.toCharArray();

        for(int i=ca.length-1 ; i>=0 ; i--){
            if(ca[i]=='#') ignore++;
            else{
                if(ignore>0) ignore--;
                else{
                    sb.append(ca[i]);
                }
            }
        }
    }
}
