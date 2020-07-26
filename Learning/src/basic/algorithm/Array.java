package basic.algorithm;

public class Array {

    public static void main(String[] args) {
        int[] intArr = {3,2,5,-7,-100,-2,8,-10};
//        int[] intArr = {-100,-37,3,2,5,-7,-100,-2,8,-10};//负数在开头的情况
//        int[] intArr = {-37,3,2,5,-7,-100,-2,8,59,-10};//中间值很大的情况
        System.out.println(getResult(intArr));
    }
    
    public static int getResult(int[] intArr){
        //int[] result = {};
        //List list = new LinkedList<Integer>();
        int result = 0;
        //int flag = 0;
        boolean addFlag = false;
        int temp = 0;
//        boolean f1;
        for(int i= 0; i<intArr.length; i++){
            int item = intArr[i];
            if(item < 0){
                //flag = i;
                temp += item;
                addFlag = false;
            }
            if(item > 0){
                if(!addFlag){
                    temp += item;
                    if(temp > 0){
                        result += temp;
                        addFlag = true;
                        temp = 0;
                    }
                } else{
                    result += item;
                    addFlag = true;
                }
            }
        }
        return result;
    }
}
