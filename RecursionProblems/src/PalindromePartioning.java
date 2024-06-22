import java.util.ArrayList;
import java.util.List;

public class PalindromePartioning {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> ans = partition(s);
            
        System.out.println("The Palindromic partitions are :-");
        System.out.print(" [ ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("[ ");
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.print("] ");
        }
        System.out.print("]");
    }
    

    public static List<List<String>> partition(String s) {
List < List < String >> res = new ArrayList < > ();
List<String> path = new ArrayList<>();
palindromePart(s, 0, res, path);
return res;
    }

    public static void palindromePart(String s, int index, List<List<String>> ans, List<String> ds) {

        if (index == s.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                ds.add(s.substring(index, i + 1));
                palindromePart(s, i + 1, ans, ds);
                ds.remove(ds.size() - 1);   
            }
        }
    }

    public static boolean isPalindrome(String s,int start,int end){
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
