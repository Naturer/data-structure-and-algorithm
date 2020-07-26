package lesson01.function;

public class Demo2 {

	public static void main(String[] args) {
		Integer[] srcArray = {1,5,7,9,12,12};
		int binarySearch = binarySearch(srcArray,12);
		System.out.println(binarySearch);
	}
	
	public static int binarySearch(Integer[] srcArray, int des) {
	    //�����ʼ��С���������
	    int start = 0;
	    int end = srcArray.length - 1;
	    //ȷ����������ظ����ң�Խ��
	    while (start <= end) {
	        //������м�����ֵ
	        int middle = (end + start)/2 ;//��ֹ���
	        if (des == srcArray[middle]) {
	            return middle;
	        //�ж�����
	        } else if (des < srcArray[middle]) {
	            end = middle - 1;
	        //�ж�����
	        } else {
	            start = middle + 1;
	        }
	    }
	    //��û�У��򷵻�-1
	    return -1;
	}
}
