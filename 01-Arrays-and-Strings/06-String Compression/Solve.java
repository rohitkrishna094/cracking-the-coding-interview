public class Solve {
    
    static String compressedString(String s) {
        String result = "";
        char prev = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == prev) {
                count++;
            } else {
                result += prev + String.valueOf(count);
                count = 1;
            }
            prev = c;
        }
        result += prev + String.valueOf(count);
        return (result.length() <= s.length()) ? result : s;
    }

    public static void main(String[] args) {
        String[] words = {"aabcccccaaa"};
        for(String s : words) {
            System.out.println(compressedString(s) + " : " + s);
        }
    }
}