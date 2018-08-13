public class Solve {
   
    static int[][] solveMatrix(int[][] a) {
        int[][] res = new int[a.length][a[0].length];
        
        // Copy the original array into res
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                res[i][j] = a[i][j];
            }
        }

        int n = a.length;
        // Write code here
        for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; i++) {
				int offset = i - first;
				int top = res[first][i]; // save top

				// left -> top
				res[first][i] = res[last-offset][first]; 			

				// bottom -> left
				res[last-offset][first] = res[last][last - offset]; 

				// right -> bottom
				res[last][last - offset] = res[i][last]; 

				// top -> right
				res[i][last] = top; // right <- saved top
			}
		}
        return res;
    }

    static int[][] solveMatrix_mine(int[][] a) {
        int[][] res = new int[a.length][a[0].length];
        
        // Copy the original array into res
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                res[i][j] = a[i][j];
            }
        }

        // Write code here
        int n = res.length - 1;
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[0].length; j++) {
                res[i][j] = a[n - j][i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][][] a = {
            {
                {1, 2, 3},
                {4, 5, 0},
                {7, 8, 9},
            },
            {
                {0, 2, 3, 8},
                {4, 5, 6, 9},
                {1, 7, 10, 13},
                {15, 14, 16, 11},
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
        System.out.println();
        for(int k = 0; k < a.length; k++) {
            int[][] res = solveMatrix_mine(a[k]);
            printMatrices(a[k], res);
        }
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