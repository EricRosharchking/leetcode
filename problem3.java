import java.util.HashMap;
import java.util.HashSet;

public class problem3 {
    public int lengthOfLongestSubstring(String s) {
        //Longest Substring Without Repeating Characters

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            HashSet<Character> set = new HashSet<>();
            for (int k = 0; k < s.length() - i && !set.contains(s.charAt(i+k)); k++) {
                set.add(s.charAt(i+k));
                j++;
            }
            if (res < j) {
                res = j;
            }
        }
        return res;
    }
}
