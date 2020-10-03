public class Offer13 {
    public static int moveCount(int k, int rows, int cols){
        if(k < 0 || rows <= 0 || cols <= 0){
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        int count = moveCountCore(k,rows,cols,0,0,visited);
        return count;
    }

    private static int moveCountCore(int k, int rows, int cols, int row, int col, boolean[][] visited){
        int count = 0;
        if(check(k,rows,cols,row,col,visited)){
            visited[row][col] = true;
            count = 1 + moveCountCore(k, rows, cols, row-1, col, visited)
                    + moveCountCore(k, rows, cols, row, col-1, visited)
                    + moveCountCore(k, rows, cols, row+1, col, visited)
                    + moveCountCore(k, rows, cols, row, col+1, visited);
        }
        return count;
    }

    private static boolean check(int k, int rows, int cols, int row, int col, boolean[][] visited){
        if(row >= 0 && row < rows && col >= 0 && col < cols && getDigitSum(row) + getDigitSum(col) <= k && !visited[row][col]){
            return true;
        }
        return false;
    }

    private static int getDigitSum(int number){
        int sum = 0;
        while(number > 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }


}
