import java.util.HashMap;
import java.util.HashSet;

public class problem3 {
    public int lengthOfLongestSubstring(String s) {
        //Longest Substring Without Repeating Characters

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            HashSet<Character> set = new HashSet<>();
            for (int k = 0; k < s.length() - i && !set.contains(s.charAt(i+k)); k++) {
                set.add(s.charAt(i+k));
                j++;
            }
            map.put(i, j);
        }

        int res = 0;
        for (int i: map.values()) {
            if (res < i) {
                res = i;
            }
        }

        return res;
    }
}
