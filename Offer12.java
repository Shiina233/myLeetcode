public class Offer12 {
    public static boolean hasPath(char[][] matrix, String str){
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[] ctr = str.toCharArray();
        boolean[][] visited = new boolean[rows][cols];
        Integer pathLength = Integer.valueOf(0);
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(hasPathCore(matrix, rows, cols, row, col, ctr, pathLength, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[][] matrix, int rows, int cols, int row, int col, char[] ctr, Integer pathLength,
                                       boolean[][] visited){
        if(ctr.length == pathLength){
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && col >= 0 && row < rows && col < cols && matrix[row][col] == ctr[pathLength] && !visited[row][col]) {
            pathLength++;
            visited[row][col] = true;
            hasPath = hasPathCore(matrix, rows, cols, row, col - 1, ctr, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, ctr, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, ctr, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, ctr, pathLength, visited);
            if (!hasPath) {
                pathLength--;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args){
        char[][] test = {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
        System.out.println(hasPath(test,"ab"));
    }
}
