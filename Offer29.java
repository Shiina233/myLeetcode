import org.junit.Test;

public class Offer29 {
    public void printMatrixClockWisely(int[][] array){
        if(array == null || array.length == 0){
            return;
        }
        int start = 0;
        while(array[0].length > start * 2 && array.length > start * 2) {
            printMatrixClockWisely(array, array.length, array[0].length, start);
            start++;
        }
    }

    private void printMatrixClockWisely(int[][] array, int row, int col, int x) {
        int endX = col - 1 - x;
        int endY = row - 1 - x;

        for(int i = x; i <= endX; i++){
            System.out.println(array[x][i]);
        }

        if(x < endY){
            for(int i = x + 1; i <= endY; i++){
                int number = array[i][endX];
                System.out.println(number);
            }
        }

        if(x < endX && x < endY){
            for(int i = endX - 1; i >= x; i--){
                int number = array[endY][i];
                System.out.println(number);
            }
        }

        if(x < endX && x < endY - 1){
            for(int i = endY - 1; i >= x + 1; i--){
                System.out.println(array[i][x]);
            }
        }

    }
    @Test
    public void test(){
        int[][] test = {{1,2,3},{4,5,6},{7,8,9}};
        printMatrixClockWisely(test);
    }
}
