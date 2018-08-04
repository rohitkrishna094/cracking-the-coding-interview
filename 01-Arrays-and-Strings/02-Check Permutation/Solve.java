import java.util.*;

public class Solve {

    // Different assumption of the question
    static boolean isPermutation(String a, String b) {
        String min = (a.length() <= b.length()) ? a : b;
        String max = (a.length() > b.length()) ? a : b;
        for (int i = 0; i < min.length(); i++) {
            if (!max.contains(min.charAt(i) + ""))
                return false;
        }
        return true;
    }

    static boolean isPermutation_sort(String a, String b) {
        if (a.length() != b.length())
            return false;

        return sort(a).equals(sort(b));
    }

    static String sort(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    public static void main(String args[]) {
        String[][] list = {{"reap", "ape"}, {"cap", "pack"}, {"rockstar", "star"},
                {"wreck", "break"}, {"ails", "sail"}};

        for (int i = 0; i < list.length; i++) {
            System.out.println(isPermutation_sort(list[i][0], list[i][1]) + " : " + list[i][0]
                    + " ; " + list[i][1]);
        }
    }
}


