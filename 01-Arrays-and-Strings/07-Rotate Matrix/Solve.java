public class Solve {
    public static void main(String[] args) {
        int[][][] a = {
            {
                {1, 2, 3},
                {4, 5, 0},
                {7, 8, 9},
            },
            {
                {1, 2, 3},
                {4, 0, 0},
                {7, 8, 9},
            },
            {
                {0, 2, 3, 8},
                {4, 5, 6, 9},
                {7, 8, 9, 0},
                {7, 8, 9, 10},
            },
            {
                {1, 2, 3, 15, 9},
                {0, 5, 0, 16, 2},
                {7, 8, 9, 17, 10},
                {7, 8, 9, 20, 11},
                {7, 8, 9, 21, 12},
            },
        };

        for(int k = 0; k < a.length; k++) {
            int[][] res = solveMatrix(a[k]);
            printMatrices(a[k], res);
        }
    }

    
    static int[][] solveMatrix(int[][] a) {
        int[][] res = new int[a.length][a[0].length];
        // Just so that we do not modify original array so that we can later on print it.
        // We can avoid this and do the algorithm in place as well
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                res[i][j] = a[i][j];
            }
        }

        return res;
    }

    static void printMatrices(int[][] a, int[][] res) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + "   ");
            }
            System.out.print("\t");
            for(int j = 0; j < a[0].length; j++) {
                System.out.print(res[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------");
    }
}