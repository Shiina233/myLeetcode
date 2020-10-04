public class Offer16 {
    public static double power1(double base, int exponent){
        Double Base = Double.valueOf(base);
        double result = 1;
        if(Base.equals(0)){
            return 0;
        }
        else{
            if(exponent == 0){
                return 1;
            }
            else if(exponent > 0){
                for(int i = 1; i <= exponent; i++){
                    result *= base;
                }
                return result;
            }
            else{
                exponent = -exponent;
                base = 1 / base;
                for(int i = 1; i <= exponent; i++){
                    result *= base;
                }
                return result;
            }
        }
    }
    public static double power2(double x, int n){
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        if(n == -1)
            return 1/x;
        double result = power2(x, n / 2);
        result *= result;
        if(n % 2 == 1){
            result *= x;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(power2(34.00515,-3));
    }
}
