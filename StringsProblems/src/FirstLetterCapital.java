public class FirstLetterCapital {
    public static void main(String[] args) {

        String string = new String("I am Gourav kundu");
      
        System.out.println(capital(string));
    }

    public static String capital(String str){
        StringBuilder s = new StringBuilder(str);
        int i = 1;
        s.setCharAt(0, Character.toUpperCase(s.charAt(0)));
        while (i < s.length()) {

            if (s.charAt(i) == ' ') {
                s.setCharAt(i + 1, Character.toUpperCase(s.charAt(i + 1)));
                i++;
            }
            i++;
        }
        return s.toString();

    }
}
