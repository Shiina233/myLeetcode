public class Offer10 {
    public static long fibonacci(int n){
        if(n < 0){
            throw new IllegalArgumentException();
        }
        int[] result = {0,1};
        if(n < 2){
            return result[n];
        }
        long fibNMinusOne = 1;
        long fibNMinusTwo = 0;
        long fibN = 0;
        for(int i = 2; i <= n; i++){
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }

    public static void main(String[] args){
        System.out.println(fibonacci(20));
    }
}
