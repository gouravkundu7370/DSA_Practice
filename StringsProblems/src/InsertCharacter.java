import java.util.Arrays;

public class InsertCharacter {
    public static void main(String[] args) {
        char[] ch = { 'a', 'b', 'a', 'b' };
        System.out.println(Arrays.toString(insert(ch, 'd', 5)));

    }

    public static char[] insert(char[] ch, char c, int n) {
        int mid = ch.length / 2;
        char[] newChar = new char[n + ch.length];
  
        for (int i = 0; i < mid; i++) {
            newChar[i] = ch[i];
        }
        for (int i = mid; i < n+mid; i++) {
            newChar[i] = c;
        }
        for (int i = mid+ n, j = mid; i < newChar.length && j < ch.length; j++, i++) {
            newChar[i] = ch[j];
        }
        return newChar;
    }
}
