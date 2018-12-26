package submitted;

import java.util.*;

/**
 * https://leetcode.com/submissions/detail/197216691/
 * Topology Sort, 无环有向图拓扑排序，有环则无解。
 * 由AOV网构造拓扑序列的拓扑排序算法主要是循环执行以下两步，直到不存在入度为0的顶点为止。
 * (1) 选择一个入度为0的顶点并输出之；
 * (2) 从网中删除此顶点及所有出边。
 * 循环结束后，若输出的顶点数小于网中的顶点数，则输出“有回路”信息，否则输出的顶点序列就是一种拓扑序列
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";

        StringBuilder res = new StringBuilder();
        HashMap<Character, Set<Character>> map = new HashMap<>();
        int[] degree = new int[26]; //计算入度/in degree
        int count = 0; //有多少个字母/顶点

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (degree[c - 'a'] == 0) {
                    count++;
                    degree[c - 'a'] = 1;
                }
            }
        }

        //compare two words a time, so words.length-1
        for (int i = 0; i < words.length - 1; i++) {
            char[] cur = words[i].toCharArray();
            char[] next = words[i + 1].toCharArray();
            //"er" "erf" non-comparable, nothing useful here, so only
            // consider min length of the two words
            int len = Math.min(cur.length, next.length);
            for (int j = 0; j < len; j++) {
                if (cur[j] != next[j]) {
                    //build the graph
                    if (!map.containsKey(cur[j])) {
                        map.put(cur[j], new HashSet<>());
                    }
                    if (map.get(cur[j]).add(next[j])) {
                        degree[next[j] - 'a']++; // in degree increase by 1
                    }
                    break;
                }
            }
        }

        // Use BFS to do the topology sort
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (degree[i] == 1) {
                queue.offer((char) ('a' + i)); // put the vertex with lease in degree
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            res.append(c);
            if (map.containsKey(c)) { // some char doesn't point to other char
                for (char ch : map.get(c)) {
                    // After removing c, if the next vertex has the lease in degree (1 in this case),
                    // put it in the queue
                    if (--degree[ch - 'a'] == 1) {
                        queue.offer(ch);
                    }
                }
            }
        }

        if (res.length() != count) return "";
        return res.toString();
    }
}
