package basic.algorithm;

public class 二分查找 {

    public static void main(String[] args) {
          int[] a = {1, 3, 6, 12, 12, 12, 12, 12, 14, 16, 18, 22};
        //int[] b = {0, 1, 2, 03, 04, 05, 06, 07, 08, 09, 10, 11};
        int value = 13;
//        int res = test1(a, 0, a.length - 1, value);
//        int res2 = test2(a, 0, a.length - 1, value);
//        int res3 = test3(a, 0, a.length, value);
        int res = test4(a, 0, a.length, value);
        System.out.println(res);
    }

    //变体三：查找第一个大于等于给定值的元素
    private static int test4(int[] a, int i, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //变体二：查找最后一个值等于给定值的元素
    private static int test3(int[] a, int i, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == n - 1 || a[mid + 1] != value)
                    return mid;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }

    //二分查找
    private static int test1(int[] a, int low, int high, int value) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    //变体一：查找第一个值等于给定值的元素
    private static int test2(int[] a, int low, int high, int value) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == low || a[mid - 1] != value)
                    return mid;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}
