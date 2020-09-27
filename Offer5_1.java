public class Offer5_1 {
    public static void merge(int[] numsA, int[] numsB){
        int numsALength = 0;
        for(int i = 0; i < numsA.length; i++){
            if(numsA[i] != 0){
                numsALength++;
            }
            else{
                break;
            }
        }
        try {
            if (numsA.length < numsALength + numsB.length) {
                throw new IllegalArgumentException();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        int p1 = numsALength - 1;
        int p2 = numsA.length - 1;
        int p3 = numsB.length - 1;
        System.out.println(p1+" "+p2+" "+p3);
        while(p2 >= 0){
            if(numsA[p1] > numsB[p3]){
                numsA[p2] = numsA[p1];
                if(p1 > 0)
                    p1--;
                p2--;
            }
            else if(numsA[p1] < numsB[p3]){
                numsA[p2] = numsB[p3];
                if(p3>0)
                    p3--;
                p2--;
            }
            else{
                numsA[p2] = numsA[p1];
                if(p1 > 0)
                    p1--;
                p2--;
                numsA[p2] = numsB[p3];
                if(p3>0)
                    p3--;
                p2--;
            }
        }
    }

    public static void main(String[] args){
        int[] a = new int[13];
        a[0]=1;
        a[1]=4;
        a[2]=6;
        a[3]=8;
        a[4]=9;
        a[5]=11;
        int[] b = {2,3,5,6,7,7,10};
        merge(a,b);
        for(int i : a){
            System.out.println(i);
        }
    }
}
