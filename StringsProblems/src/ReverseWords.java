public class ReverseWords {
    public static void main(String[] args) {

        String string = new String(" I am    gourav ");
        System.out.println(reverseWords(string));
    }

    // varoug    ma I

  public static String reverseWords(String s) {
    char[] chars = s.trim().toCharArray();
    int start = 0;
    int end = 0;
    
    // Reverse the entire string
    reverse(chars, 0, chars.length - 1);
    
    // Reverse each word separately
    while (end < chars.length) {
        // Find the start of the word
        while (end < chars.length && chars[end] == ' ') {
            end++;
        }
        start = end;
        // Find the end of the word
        while (end < chars.length && chars[end] != ' ') {
            end++;
        }
        // Reverse the word
        reverse(chars, start, end - 1);
    }
    
    // Remove extra spaces
    int index = 0;
    for (int i = 0; i < chars.length; i++) {
        if (chars[i] != ' ' || (i > 0 && chars[i - 1] != ' ')) {
            chars[index++] = chars[i];
        }
    }
    
    // Trim the array to remove any trailing spaces
    return new String(chars, 0, index);
}

public static void reverse(char[] chars, int start, int end) {
    while (start < end) {
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
        start++;
        end--;
    }
}
//
 public String reverseWords1(String s) {
       s=s.trim();
      
       int endPointer= findEndPointer(s,s.length()-1);
       int startPointer = findStartPointer(s,endPointer); 
        StringBuilder sb = new StringBuilder();  
       while(startPointer>0)
       {
            sb.append(s,startPointer,endPointer+1);
            endPointer= findEndPointer(s,startPointer);
            startPointer = findStartPointer(s,endPointer); 

       }
        sb.append(" ");
        sb.append(s,startPointer,endPointer+1);

        return sb.toString().trim();

    }

    public int findEndPointer(String s , int index)
    {
        while(index>0 && s.charAt(index)==' ')
            index--;

        return index;

    }

      public int findStartPointer(String s , int index)
    {
       while(index>0 && s.charAt(index)!=' ')
        {
            index--;
        }

        return index;
        
    }
}
