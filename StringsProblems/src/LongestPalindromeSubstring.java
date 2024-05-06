public class LongestPalindromeSubstring {
    public static void main(String[] args) {

        String str = "babad";
        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String lps = "";

        for (int i = 1; i < s.length(); i++) {

            // odd length
            int low = i;
            int high = i;

            while (s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                if (low == -1 || high == s.length()) {
                    break;

                }

            }
            lps = compare(s.substring(low + 1, high), lps);

            // even length
            low = i - 1;
            high = i;
            while (s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                if (low == -1 || high == s.length()) {
                    break;

                }

            }
            lps = compare(s.substring(low + 1, high), lps);

        }

        return lps;
    }
     public static String compare(String str1 , String str2){
            if (str1.length() > str2.length()) {
                return str1;
            }
            return str2;
        }
    }

