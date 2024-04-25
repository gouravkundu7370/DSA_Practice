import java.util.HashMap;


public class LongestSubstringwithoutRepeat {
    
    public static void main(String[] args) {
        String s = "abcaabcdba";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring1(s));


    }

    public static int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        if (s.length() == 1 || s.length() == 0) {
            return s.length();
        }
        while (r < s.length()) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(map.get(s.charAt(r)) + 1, l);

            }
            map.put(s.charAt(r), r);
            len = Math.max(r - l + 1, len);
            r++;

        }
        return len;

    }

    // constant space complexity
        public static int lengthOfLongestSubstring1(String s) {
       
        int  n = s.length();

        int[] charIndex = new int[128];
        int maxLength = 0;
        int left = 0;

        for ( int right = 0; right < n; right++ ) {
            char character = s.charAt(right);
            left = Math.max(left,charIndex[character]);
            maxLength = Math.max(maxLength, right-left+1);
            charIndex[character] = right + 1;
        }
        return maxLength;
    }
    
}
