
public class Kangaroo {

    public static void main(String[] args) {
//        int n = 13;
        double n = 136000;//11.6亿
//        System.out.println(n-1+"   "+a/2);
//        System.out.println(n-2+"   "+a/4);
//        System.out.println(n-3+"   "+a/8);
//        System.out.println(n-4+"   "+a/16);
//        System.out.println(n-5+"   "+a/32);
//        System.out.println(n-6+"   "+a/64);
//        System.out.println(n-7+"   "+a/128);
//        System.out.println(n-1+"   "+a/256);
//        System.out.println(n-1+"   "+a/512);
//        System.out.println(n-1+"   "+a/1024);
//        System.out.println(n-1+"   "+a/2048);
//        System.out.println(n-1+"   "+a/4096);
        for (int i = 14; i > 0 ; i--) {
            System.out.println(i+"   "+n);
            n = n/2;
        }
    }
}
