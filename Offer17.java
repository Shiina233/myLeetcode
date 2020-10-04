public class Offer17 {
    public static void print1ToMaxN1(int n){
        char[] num = new char[n];
        for(int i = 0; i < n; i++){
            num[i] = '0';
        }
        while(true){
            if(!addOne(num)){
                boolean firstZero = false;
                for(int i = 0; i < num.length; i++){
                    if(num[i]=='0' && !firstZero){
                        continue;
                    }
                    else {
                        System.out.print(num[i]);
                        firstZero = true;
                    }
                }
                System.out.println("");
            }
            else
                break;
        }
    }

    private static boolean addOne(char[] num){
        char over = '9' + 1;
        int n = num.length;
        boolean max = false;
        num[n-1] = (char)(num[n-1] + 1);
        for(int i = n - 1; i >= 0; i--){
            if(num[i] == over){
                if( i == 0){
                    max = true;
                }
                num[i] = '0';
                if(i != 0)
                    num[i - 1] = (char) (num[i-1] + 1);
            }
        }
        return max;
    }

    public static void print1ToMaxN2(int n){
        char[] num = new char[n];
        for(int i = 0; i < 10; i++){
            num[0] = (char) (i + '0');
            print1ToMaxN2Core(num,num.length,0);
        }
    }

    private static void print1ToMaxN2Core(char[] num, int length, int index){
        if(index == length - 1){
            boolean firstZero = false;
            for(int i = 0; i < num.length; i++){
                if(num[i]=='0' && !firstZero){
                    firstZero = false;
                }
                else {
                    System.out.print(num[i]);
                    firstZero = true;
                }
            }
            if(firstZero == false)//all is '0'
                return;
            System.out.println("");
            return;
        }
        for(int i = 0; i < 10; i++){
            num[index + 1] = (char) (i + '0');
            print1ToMaxN2Core(num,length,index + 1);
        }
    }

    public static void main(String[] args){
        print1ToMaxN2(2);
    }
}
