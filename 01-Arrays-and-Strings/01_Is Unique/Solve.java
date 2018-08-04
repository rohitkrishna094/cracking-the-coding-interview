public class Solve {

    // Assumes that s has only lowercase alphabets
    static boolean isUnique(String s) {
        char a[] = new char[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (a[index] != 0)
                return false;
            a[index]++;
        }
        return true;
    }

    // Assumes that s has only lowercase alphabets
    // From CTCI Solutions Github Repo
    static boolean isUnique_inPlace(String s) {
        if (s.length() > 26)
            return false;

        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if ((checker & 1 << index) > 0)
                return false;
            checker |= (1 << index);
        }
        return true;
    }

    public static void main(String args[]) {
        String[] list = { "rohit", "keep", "unique", "repeat" };
        for (int i = 0; i < list.length; i++) {
            System.out.println(isUnique(list[i].toLowerCase()) + " : " + list[i].toLowerCase());
        }
    }
}