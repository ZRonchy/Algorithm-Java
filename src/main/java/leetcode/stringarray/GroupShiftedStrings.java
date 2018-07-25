package leetcode.stringarray;

import java.util.*;

/**
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * "abc" -> "bcd" -> ... -> "xyz".

 Given a list of strings which contains only lowercase alphabets, group all strings
 that belong to the same shifting sequence, return:
 [
 ["abc","bcd","xyz"],
 ["az","ba"],
 ["acef"],
 ["a","z"]
 ]
 */
public class GroupShiftedStrings {
    public static void main(String[] args) {
        String[] arr = {"abc", "bcd", "az"};
        System.out.println(groupStrings(arr));
    }

    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String s: strings){
            char[] arr = s.toCharArray();
            if(arr.length>0){
                int diff = arr[0]-'a';
                for(int i=0; i<arr.length; i++){
                    if(arr[i]-diff<'a'){
                        arr[i] = (char) (arr[i]-diff+26);
                    }else{
                        arr[i] = (char) (arr[i]-diff);
                    }

                }
            }

            System.out.println(Arrays.toString(arr));

            String ns = new String(arr);
            if(map.containsKey(ns)){
                map.get(ns).add(s);
            }else{
                ArrayList<String> al = new ArrayList<>();
                al.add(s);
                map.put(ns, al);
            }
        }

        for(Map.Entry<String, ArrayList<String>> entry: map.entrySet()){
            Collections.sort(entry.getValue());
        }

        result.addAll(map.values());

        return result;
    }
}
