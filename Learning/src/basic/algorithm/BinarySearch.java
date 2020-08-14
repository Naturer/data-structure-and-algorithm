package basic.algorithm;

public class BinarySearch {
    public static void main(String[] args) {
//        int[] arr = {1,3,5,7,10,34,59,107};
        int[] arr = {2,5,9,9,9,9,13,16,31};
        System.out.println(binarySearch(arr, 11));
//        System.out.println(binarySearchRecursive(arr, 0,arr.length - 1, 2));
    }

    private static int binarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static boolean binarySearchRecursive(int[] arr,int low, int high, int value) {
        if (low > high)
            return false;
        int mid =  low + ((high - low) >> 1);
        if (arr[mid] == value) {
            return true;
        } else if (arr[mid] < value) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
        return binarySearchRecursive(arr, low, high, value);
    }

    private static boolean search02(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid= (end + start)/2;
        while (start < end && mid != start && mid != end) {
            if (arr[mid] == target)
                return true;
            if (arr[mid] < target){
                start = mid;
            } else {
                end = mid;
            }
            mid= (end + start)/2;
        }
        return arr[start] == target || arr[end] == target;
    }
}
