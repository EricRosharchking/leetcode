import java.util.HashMap;
import java.util.HashSet;

public class problem3 {
    public int lengthOfLongestSubstring(String s) {
        // Longest Substring Without Repeating Characters

        int res = 0;

        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int k = map.get(s.charAt(i)) + 1;
                System.out.println("k:" + k);
                j = (k > j) ? k : j;
                System.out.println("map contains " + s.charAt(i) + ", j:" + j);
            }
            map.put(s.charAt(i), i);
            res = res > (i - j + 1) ? res : (i - j + 1);
            System.out.println("j:" + j);
            System.out.println("map:" + map.toString());
            System.out.println("res:" + res);
        }
        return res;
        // int[] cache = new int[256];
        // for (int i = 0, j = 0; i < s.length(); i++) {
        // j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
        // cache[s.charAt(i)] = i + 1;
        // result = Math.max(result, i - j + 1);
        // }
    }

    /**
     * 滑动窗口sliding window法：起始位置i，j = 0； i为遍历指针
     * 当从j位置遍历到i位置时，如果第一次出现了j位置上重复字符，那么从j位置以前的任何一个位置都无法超越j到i的不重复字符串
     * 从j+1位置到i位置一定不会有重复字符串，所以从j+1到i的遍历可以省略（j到i的遍历-最长字符串信息-被重复利用了）
     * 
     */
}
