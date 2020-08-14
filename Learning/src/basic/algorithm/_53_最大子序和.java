package basic.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * 输出一个int型数组的最大连续子数组（所有元素相加和最大）各个元素之和。（保证数组至少有一个正数）
 * 如，输入{1,2,5,-7,8,-10}，输出9（子数组为{1,2,5,-7,8}）
 * 
 * 我的思路：不知道是不是分治法。复杂度为O(n),据说分治法复杂度更小？？？
 * -2,1,-3,4,-1,2,1,-5,4
 * 把它分为四组：-2,1     -3,4    -1,2,1      -5,4
 * 每组记下当前组的和[-1, 1, 2, -1]及当前组所有正数和[1, 4, 3, 4]
 * 如果当前组的和>0,则要考虑要不要与上一组的正数合并：如果当前组的和+上一组的正数>当前组的正数和，则合并为一组。如[4]与[-1,2,1]的和大于[3],则4,-1,2,1合并在一起
 * 最后取出值最大的那一个组
 */
public class _53_最大子序和 {

    public static void main(String[] args) {
        //可测试的数据：
        //        int[] intArr = {-3,1,2,5,-7,8,-100,83,-5,-80,74,10};
        //        int[] intArr = {-50,-100,-3,5,6,-12,15,-7,8};
        //        int[] intArr = {-100,-37,3,2,5,-7,-100,-2,8,-10};//负数在开头的情况
        //        int[] intArr = {-37,3,2,5,-7,-100,-2,8,59,-10};//中间值很大的情况
        //        int[] intArr = { -5, 1, 2, 5, -7, 8, -100, 83, 10 };
        int[] intArr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        //        int[] intArr = {-3,1,81,-7,-1,9,-100,80,3,-10};
        System.out.println(getResult(intArr));
    }

    public static int getResult(int[] arr) {
        List<Integer> aList = new ArrayList<Integer>();
        List<Integer> bList = new ArrayList<Integer>();
        int segmentSum = 0;
        int positiveSum = 0;
        boolean preIsPositive = false;//用来判断前一个数是否是负数，及用来保存当前数是否是正数以服务于下一数的判断。
        for (int i = 0; i < arr.length; i++) {
            int item = arr[i];
            if (item > 0) {
                if (!preIsPositive) {
                    positiveSum = 0;
                }
                positiveSum += item;
                segmentSum += item;
                preIsPositive = true;
            } else {
                if (preIsPositive) {//前一个数是正数，现在是负数，说明此时是新一段的开始，把上一段的信息存起来，并把segmentSum设为0
                    aList.add(segmentSum);
                    bList.add(positiveSum);
                    segmentSum = 0;
                }
                segmentSum += item;
                preIsPositive = false;
            }
            if (i == arr.length - 1) {//最后一个元素时，把最后一段数据保存
                aList.add(segmentSum);
                bList.add(positiveSum);
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(aList);
        System.out.println(bList);
        for (int i = 1; i < aList.size(); i++) {
            if (aList.get(i) > 0) {
                int temp = aList.get(i) + bList.get(i - 1);
                if (temp > bList.get(i)) {
                    bList.set(i, temp);
                }
            }
        }
        System.out.println(bList);
        //取出bList中的最大值
        return Collections.max(bList);
    }
}
