package basic.algorithm;

public class _69_平方根 {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(2147395599));
//        System.out.println(sqrt(2147395599));
    }

    private static int sqrt(int n) {
        int l = 0;//low
        int h = n;//high
        int temp = 0;
        while(l <= h){
            int m = l + ((h - l) >> 1);//mid
            if (m*m == n)
                return m;
            if (m*m > 0 && m*m < n)
                l = m + 1;
            else
                h = m - 1;
            temp = m;
        }
        if(temp*temp > n)
            return temp - 1;
        return temp;
    }
}
