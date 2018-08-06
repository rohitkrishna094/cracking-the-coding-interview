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
                {1, 2, 0},
                {4, 5, 6},
                {0, 8, 9},
            },
            {
                {0, 2, 3, 8},
                {4, 5, 6, 9},
                {7, 8, 9, 0},
                {7, 8, 9, 10},
            },
            {
                {1, 2, 3},
                {0, 5, 0},
                {17, 18, 19},
                {7, 8, 9},
                {7, 8, 9},
            },
        };

        for(int k = 0; k < a.length; k++) {
            int[][] res = solveMatrix(a[k]);
            printMatrices(a[k], res);
        }
    } // end main

    static int[][] solveMatrix(int[][] a) {
        int[][] res = new int[a.length][a[0].length];
        // Just so that we do not modify original array so that we can later on print it.
        // We can avoid this and do the algorithm in place as well
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                res[i][j] = a[i][j];
            }
        }

        boolean[] row = new boolean[a.length];
        boolean[] col = new boolean[a[0].length];

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                if(a[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i = 0; i < row.length; i++) {
            if(row[i]) {
                // set row to zero
                for(int j = 0; j < a[0].length; j++) {
                    res[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < col.length; i++) {
            if(col[i]) {
                // set col to zero
                for(int j = 0; j < a.length; j++) {
                    res[j][i] = 0;
                }
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
        System.out.println("------------------------------------");
    }
}