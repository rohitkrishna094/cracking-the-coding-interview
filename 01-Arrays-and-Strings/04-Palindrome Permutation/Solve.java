public class Solve {

    // Assumes lowercase
    static boolean palindromePermutation(String s) {
        
        // By choice
        s = s.toLowerCase();

        int nOdd = 0, a[] = new int[128];
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            a[index]++;
            // Improved from ctci solutions
            if(a[index] % 2 == 1) {
                nOdd++;
            } else {
                nOdd--;
            }
        }
        
        // My first attempt
        
        // boolean flag = false;
        // for(int i = 0; i < a.length; i++) {
        //     if(flag && (a[i] % 2 != 0)) {
        //         return false;
        //     }
        //     if(a[i] % 2 != 0) {
        //         flag = true;
        //     }
        // }
        // return true;

        return nOdd <= 1;
    }

    public static void main(String[] args) {
        String[] input = {"TactCoa", "refer", "erref", "referr"};
        for(int i = 0; i < input.length; i++) {
            System.out.println(palindromePermutation(input[i]) + " : " + input[i]);
        }
    }
}
