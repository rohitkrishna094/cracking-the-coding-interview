public class Solve {

    static boolean isSubstring(String a, String b) {
        return a.indexOf(b) >= 0;
    }

    static boolean solve(String a, String b) {
        if(a.length() != b.length()) return false;
        String c = a + b;
        return isSubstring(c, b);
    }

    public static void main(String[] args) {
        String[][] s = {{"waterbottle", "erbottlewat"}, {"waterbottle", "erbottlewate"}, {"computers", "puterscom"}};

        for(int i = 0; i < s.length; i++) {
            System.out.println(solve(s[i][0], s[i][1]) + " : " + s[i][0] + " ; " + s[i][1]);
        }
    }
}