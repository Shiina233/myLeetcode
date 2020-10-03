public class Offer11 {
    public static int min(int[]  a){
        if(a == null){
            throw new IllegalArgumentException();
        }
        int index1 = 0;
        int index2 = a.length - 1;
        int indexMid = index1;
        while(a[index1] >= a[index2]){
            if(index2 - index1 == 1){
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
            if(a[index1] == a[indexMid] && a[index2] == a[indexMid]){
                int result = a[index1];
                for(int i = index1 + 1; i <= index2; i++){
                    if(result > a[i]){
                        result = a[i];
                    }
                }
                return result;
            }
            if(a[index1] <= a[indexMid]){
                index1 = indexMid;
            }
            else if(a[index2] >= a[indexMid]){
                index2 = indexMid;
            }
        }
        return a[indexMid];
    }
}

