package lesson01.function;

public class Demo2 {

	public static void main(String[] args) {
		Integer[] srcArray = {1,5,7,9,12,12};
		int binarySearch = binarySearch(srcArray,12);
		System.out.println(binarySearch);
	}
	
	public static int binarySearch(Integer[] srcArray, int des) {
	    //定义初始最小、最大索引
	    int start = 0;
	    int end = srcArray.length - 1;
	    //确保不会出现重复查找，越界
	    while (start <= end) {
	        //计算出中间索引值
	        int middle = (end + start)/2 ;//防止溢出
	        if (des == srcArray[middle]) {
	            return middle;
	        //判断下限
	        } else if (des < srcArray[middle]) {
	            end = middle - 1;
	        //判断上限
	        } else {
	            start = middle + 1;
	        }
	    }
	    //若没有，则返回-1
	    return -1;
	}
}
