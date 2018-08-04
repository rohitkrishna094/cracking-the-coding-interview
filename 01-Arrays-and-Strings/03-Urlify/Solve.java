public class Solve {

    // from ctci repo
    static String urlify(char[] s, int originalLength) {
        int spaces = 0, i = 0;
        for(i = 0; i < originalLength; i++) {
            if(s[i] == ' ') spaces++;
        }

        int index = originalLength + spaces + 2;
        if(originalLength < s.length) s[originalLength] = '\0';

        for(i = originalLength -1; i >= 0; i--){
            if(s[i] == ' ')       {
                s[index - 1] = '0';
                s[index - 2] = '2';
                s[index - 3] = '%';
                index -= 3;
            } else {
                s[index - 1] = s[i];
                index--;
            }
        }
        return new String(s);
    }

    public static void main(String[] args) {
        String input = "Mr John Smith    ";
        int n = 13;
        String s = urlify(input.toCharArray(), n);
        System.out.println(s);
    }
}
