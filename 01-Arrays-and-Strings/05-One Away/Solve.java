public class Solve {

    // from ctci solutions
    static boolean oneEditAway(String a, String b) {
        if(Math.abs(a.length() - b.length()) > 1) {
            return false;
        }

        String s1 = a.length() <= b.length() ? a : b;
        String s2 = a.length() > b.length() ? a : b;

        int index1 = 0, index2 = 0;
        boolean foundDiff = false;
        while(index2 < s2.length() && index1 < s1.length()) {
            if(s1.charAt(index1) != s2.charAt(index2)) {
                if(foundDiff) return false;
                foundDiff = true;
                if(s1.length() == s2.length()) index1++;
            } else index1++;
            index2++;
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] s = {{"pale", "ple"}, {"pales", "pale"}, {"pale", "bale"}, {"pale", "bake"}};
        for(int i = 0; i < s.length; i++) {
            boolean res = oneEditAway(s[i][0], s[i][1]);
            System.out.println(res + " : " + s[i][0] + " ; " + s[i][1]);
        }
    }
}