package submitted;

/**
 * 从前向后记录‘ ’数目，从后向前替换‘ ’。 重点：从后向前替换的时候的技巧
 */
public class StringReplaceString {
    public String replaceSpace(StringBuffer str) {
        int spaceNum = 0;//spacenum为计算空格数
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')
                spaceNum++;
        }
        int indexOld = str.length()-1; //indexOld为为替换前的str下标
        int newLength = str.length() + spaceNum*2;//计算空格转换成%20之后的str长度
        int indexNew = newLength-1;//indexOld为为把空格替换为%20后的str下标
        str.setLength(newLength);//使str的长度扩大到转换成%20之后的长度,防止下标越界
        for(;indexOld>=0 && indexOld<newLength;--indexOld){
            if(str.charAt(indexOld) == ' '){  //
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--, '2');
                str.setCharAt(indexNew--, '%');
            }else{
                str.setCharAt(indexNew--, str.charAt(indexOld));
            }
        }
        return str.toString();
    }

    public String replaceSpace1(StringBuffer str) {
        String sti = str.toString();
        char[] strChar = sti.toCharArray();
        StringBuffer stb = new StringBuffer();
        for(int i=0;i<strChar.length;i++){
            if(strChar[i]==' '){
                stb.append("%20");
            }else{
                stb.append(strChar[i]);
            }
        }
        return stb.toString();
    }
}
