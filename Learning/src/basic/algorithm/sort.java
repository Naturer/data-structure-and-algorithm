package basic.algorithm;

import java.util.Arrays;
import java.util.Random;

import util.Times;

public class sort {

    public static void main(String[] args) {
        int[] a = {22,5,3,14,31,30,36,48,50,4,38,36,4,33,19,7,23,5};
        int[] clone = a.clone();

//        double[] aa = {1.3, 5, 2.7, 4, 2, 3.4};
//        System.out.println(Arrays.toString(mergeSort02(aa,0,aa.length-1)));
//        System.out.println(Arrays.toString(mergeSort(a,0,a.length-1)));
//        merge_sort_recursive(a, clone,0,a.length -1);
//        System.out.println(Arrays.toString(clone));

//        testQuickSort();
//        testBubbleAndSelection();
        //测试数据量大时的耗时
                testMultipleData();
        //测试稳定性
//                testStable();
    }

    private static void testQuickSort() {
        int n1 = 2000;
        int n2 = 1000;
        int[][] arr1 = new int[n1][n2];
        initArr(n1, n2, arr1);
        int[][] arr2 = new int[n1][n2];
        int[][] arr3 = new int[n1][n2];
        int[][] arr4 = new int[n1][n2];
        int[][] arr5 = new int[n1][n2];
        int[][] arr6 = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            arr2[i] = arr1[i].clone();
            arr3[i] = arr1[i].clone();
            arr4[i] = arr1[i].clone();
        }
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                arr5[i][j] = new Random().nextInt(10);
                arr6[i][j] = new Random().nextInt(10);
            }
        }
        Times.test("QuickSort", () -> {
            for (int i = 0; i < n1; i++) {
//                quickSort(arr5[i],0,arr5[i].length -1);
                countingSort(arr5[i]);
            }
        });
        Times.test("QuickSort", () -> {
            for (int i = 0; i < n1; i++) {
//                quickSort(arr6[i],0,arr6[i].length -1);
                countingSort(arr6[i]);
            }
        });
        Times.test("RandomQuickSort", () -> {
            for (int i = 0; i < n1; i++) {
//                quickSort(arr1[i],0,arr1[i].length -1);
                countingSort(arr1[i]);
            }
        });
        Times.test("RandomQuickSort", () -> {
            for (int i = 0; i < n1; i++) {
//                quickSort(arr2[i],0,arr2[i].length -1);
                countingSort(arr2[i]);
            }
        });
        Times.test("RandomQuickSort", () -> {
            for (int i = 0; i < n1; i++) {
//                quickSort(arr3[i],0,arr3[i].length -1);
                countingSort(arr3[i]);
            }
        });
        Times.test("RandomQuickSort", () -> {
            for (int i = 0; i < n1; i++) {
//                quickSort(arr4[i],0,arr4[i].length -1);
                countingSort(arr4[i]);
            }
        });
    }

    private static void testBubbleAndSelection() {
        int n1 = 2000;
        int n2 = 1000;
        int[][] arr1 = new int[n1][n2];

        initArr(n1,n2,arr1);

        int[][] arr2 = new int[n1][n2];
        int[][] arr3 = new int[n1][n2];
        int[][] arr4 = new int[n1][n2];
        int[][] arr5 = new int[n1][n2];
        int[][] arr6 = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            arr2[i] = arr1[i].clone();
            arr3[i] = arr1[i].clone();
            arr4[i] = arr1[i].clone();
            arr5[i] = arr1[i].clone();
            arr6[i] = arr1[i].clone();
        }
        Times.test("bubbleSort", () -> {
            for (int i = 0; i < n1; i++) {
                bubbleSort(arr1[i]);
            }
        });
//        Times.test("bubbleSort03", () -> {
//            for (int i = 0; i < n1; i++) {
//                bubbleSort03(arr3[i]);
//            }
//        });
//        Times.test("bubbleSort04", () -> {
//            for (int i = 0; i < n1; i++) {
//                bubbleSort04(arr4[i]);
//            }
//        });
        Times.test("selectionSort", () -> {
            for (int i = 0; i < n1; i++) {
                selectionSort(arr2[i]);
            }
        });
    }

    /*
     * 快速排序
     * 我的思路如下：
     * 令int start = 0; int end = arr.length - 1; p(pivotIndex)指向第一个数(pivot)，s(storeIndex)指向pivot后面一个数。
     * i从指向s到指向end，依次比较arr[i]是否小于pivot,如果arr[i]<pivot，则arr[i]与arr[s]交换，i++；
     * [3,5,1,4,3,2]
     * 5 > 3; 1 < 3, 1与5交换。s指向5
     * [3,1,5,4,3,2]
     * 4 > 3; 3 = 3; 2 < 3, 2与5交换。s指向4
     * [3,1,2,4,3,5]
     * pivot再与arr[s-1]交换
     * [2,1,3,4,3,5]
     * 此时pivot左边的都小于pivot，右边的都大于等于pivot
     * 再让左边[2,1]、右边[4,3,5]递归进行快排、只到start >= end, 结束递归
     * 复杂度：
     * 稳定性：不稳定，如[5,7,7,1]
     */
    public static int[] quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return arr;
        }
        int p = start;//pivotIndex
        int s = start + 1;//storeIndex
        for (int i = s; i <= end; i++) {
            if (arr[i] < arr[p]) {
                swap(arr, s, i);
                s++;
            }
        }
        swap(arr, p, --s);//此处用s--的话，是不是执行完swap方法，才会执行--？答：是的
        p = s;
        quickSort(arr, p + 1, end);
        quickSort(arr, start, p - 1);
        return arr;
    }

    /*
    计数排序
    计数排序只能用在数据范围不大的场景中
    我的思路：
    如数组A:[3,5,2,4,2,4,7,4], 先取出最大值7，最小值2，遍历A，在数组B从0到6的下标中分别存2到7这几个数出现的频率。B:[2,1,3,1,0,1]
    遍历B，2出现2次，往最终结果数组R中添加2次2,3出现1次，添加1次3...依次类推
    稳定性：我写的不算是稳定的，并且只能排序非负整数（可以实现一种稳定的计数排序）
     */
    public static int[] countingSort02(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int element : arr) {
            if (element < min)
                min = element;
            if (element > max)
                max = element;
        }
        int[] arrB = new int[max - min + 1];
        for (int value : arr) {
            arrB[value - min] = arrB[value - min] + 1;
        }
        int[] arrR = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arrB.length; i++) {
            int item = min + i;
            for (int j = 0; j < arrB[i]; j++) {
                arrR[index++] = item;
            }
        }
        return arrR;
    }

    /*
    计数排序（稳定的）
    计数排序只能用在数据范围不大的场景中
    思路：
    如数组A:[3,5,2,4,2,4,7,4], 先取出最大值7，最小值2，遍历A，在数组B从0到6的下标中分别存2到7这几个数出现的频率。B:[2,1,3,1,0,1]
    遍历B，计算B中每个元素与元素前面所有元素的和，重新存到B中，B:[2,3,6,7,7,8]
    从后往前遍历A（从前往后的话不稳定），比如：取到4，在C中对应6，说明当前这个4在结果数组R中对应第6个数，放进去。
    稳定性：稳定，可以排序非负数，或者带有非负数的对象
     */
    public static int[] countingSort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int element : arr) {
            if (element < min)
                min = element;
            if (element > max)
                max = element;
        }
        int[] arrB = new int[max - min + 1];
        for (int value : arr) {
            arrB[value - min] = arrB[value - min] + 1;
        }
        for (int i = 1; i < arrB.length; i++) {
            arrB[i] = arrB[i] + arrB[i - 1];
        }
        int[] arrR = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int item = arr[i];
            arrR[arrB[item - min] - 1] = item;
            arrB[item - min]--;
        }
        return arrR;
    }

    /*
    计数排序（稳定的）
    计数排序只能用在数据范围不大的场景中
    思路：
    如数组A:[3,5,2,4,2,4,7,4], 先取出最大值7，最小值2，遍历A，在数组B从0到6的下标中分别存2到7这几个数出现的频率。B:[2,1,3,1,0,1]
    遍历B，计算B中每个元素与元素前面所有元素的和，重新存到B中，B:[2,3,6,7,7,8]
    从后往前遍历A（从前往后的话不稳定），比如：取到4，在C中对应6，说明当前这个4在结果数组R中对应第6个数，放进去。
    稳定性：稳定，可以排序非负数，或者带有非负数的对象。（非负数就行，小数可以转换为整数）
     */
    public static Person[] countingSort02(Person[] arr) {
        int min = arr[0].getIntAge();
        int max = arr[0].getIntAge();
        for (Person person : arr) {
            if (person.getIntAge() < min)
                min = person.getIntAge();
            if (person.getIntAge() > max)
                max = person.getIntAge();
        }
        int[] arrB = new int[max - min + 1];
        for (Person person : arr) {
            int value = person.getIntAge();
            arrB[value - min] = arrB[value - min] + 1;
        }
        for (int i = 1; i < arrB.length; i++) {
            arrB[i] = arrB[i] + arrB[i - 1];
        }
        Person[] arrR = new Person[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            Person item = arr[i];
            arrR[arrB[item.getIntAge() - min] - 1] = item;
            arrB[item.getIntAge() - min]--;
        }
        return arrR;
    }

    //传入引用对象，测试稳定性
    public static Person[] quickSort(Person[] arr, int start, int end) {
        if (start >= end) {
            return arr;
        }
        int p = start;//pivotIndex
        int s = start + 1;//storeIndex
        for (int i = s; i <= end; i++) {
            if (arr[i].age < arr[p].age) {
                swap(arr, s, i);
                s++;
            }
        }
        swap(arr, p, --s);//此处用s--的话，是不是执行完swap方法，才会执行--？答：是的
        p = s;
        quickSort(arr, p + 1, end);
        quickSort(arr, start, p - 1);
        return arr;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void swap(Person[] arr, int a, int b) {
        Person temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /*
     * 归并排序
     * 最好情况、最坏情况，还是平均情况，时间复杂度都是 O(nlogn)
     */
    public static int[] mergeSort(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        if (mid == end || mid == start) {
            if (arr[start] > arr[end]){
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            return arr;
        }

        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        mergeArr(arr,start,mid,end);
        return arr;
    }

    /**
     * 别人的代码，待验证
     * @param arr
     * @return
     */
    public static int[] mergeSortIterate(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        int block, start;

        // 原版代码的迭代次数少了一次，没有考虑到奇数列数组的情况
        for (block = 1; block < len * 2; block *= 2) {
            for (start = 0; start < len; start += 2 * block) {
                int low = start;
                int mid = Math.min((start + block), len);
                int high = Math.min((start + 2 * block), len);
                //两个块的起始下标及结束下标
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                //开始对两个block进行归并排序
                while (start1 < end1 && start2 < end2) {
                    result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
                }
                while (start1 < end1) {
                    result[low++] = arr[start1++];
                }
                while (start2 < end2) {
                    result[low++] = arr[start2++];
                }
            }
            int[] temp = arr;
            arr = result;
            result = temp;
        }
        result = arr;
        return result;
    }
    //别人写的，待验证
    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }
    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        merge_sort_recursive(arr, result, 0, len - 1);
    }

    public static double[] mergeSort02(double[] arr, int start, int end) {
        int mid = (start + end) / 2;
        if (mid == end || mid == start) {
            if (arr[start] > arr[end]){
                double temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            return arr;
        }
        mergeSort02(arr, start, mid);
        mergeSort02(arr, mid+1, end);
        mergeArr02(arr,start,mid,end);
        return arr;
    }

    private static double[] mergeArr02(double[] arr, int start, int mid, int end) {
        double[] temp = arr.clone();
        int i = 0;
        int aCur = start;
        int bCur = mid+1;
        boolean traverseA = true;
        boolean traverseB = true;
        while (i <= end - start) {
            if (aCur > mid) {
                traverseA = false;
            }
            if (bCur > end) {
                traverseB = false;
            }
            if (!traverseB && traverseA) {
                arr[i+start] = temp[aCur];
                aCur++;
                i++;
                continue;
            } else if(traverseB && !traverseA){
                arr[i+start] = temp[bCur];
                bCur++;
                i++;
                continue;
            }
            if (temp[aCur] < temp[bCur]) {
                arr[i+start] = temp[aCur];
                aCur++;

            } else {
                arr[i+start] = temp[bCur];
                bCur++;
            }
            i++;
        }
        return arr;
    }

    private static int[] mergeArr(int[] arr, int start, int mid, int end) {
        int[] temp = arr.clone();
        int i = 0;
        int aCur = start;
        int bCur = mid+1;
        boolean traverseA = true;
        boolean traverseB = true;
        while (i <= end - start) {
            if (aCur > mid) {
                traverseA = false;
            }
            if (bCur > end) {
                traverseB = false;
            }
            if (!traverseB && traverseA) {
                arr[i+start] = temp[aCur];
                aCur++;
                i++;
                continue;
            } else if(traverseB && !traverseA){
                arr[i+start] = temp[bCur];
                bCur++;
                i++;
                continue;
            }
            if (temp[aCur] < temp[bCur]) {
                arr[i+start] = temp[aCur];
                aCur++;

            } else {
                arr[i+start] = temp[bCur];
                bCur++;
            }
            i++;
        }
        return arr;
    }

    private static int[] mergeArr(int[] a, int[] b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        int[] mergedArr = new int[a.length+b.length];
        int i = 0;
        int aCur = 0;
        int bCur = 0;
        boolean traverseA = true;
        boolean traverseB = true;
        while (i < a.length + b.length) {
            if (aCur == a.length) {
                traverseA = false;
            }
            if (bCur == b.length) {
                traverseB = false;
            }
            if (!traverseB && traverseA) {
                mergedArr[i] = a[aCur];
                aCur++;
                i++;
                continue;
            } else if(traverseB && !traverseA){
                mergedArr[i] = b[bCur];
                bCur++;
                i++;
                continue;
            }
            if (a[aCur] < b[bCur]) {
                mergedArr[i] = a[aCur];
                aCur++;
                
            } else {
                mergedArr[i] = b[bCur];
                bCur++;
            }
            i++;
        }
        return mergedArr;
    }

    /*
     * 插入排序
     * 最好时间复杂度O(n)，最坏时间复杂度O(n^2)，平均时间复杂度为O(n^2)
     */
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int item = arr[i];
            int j = i - 1;
            while (j >= 0 && item < arr[j]) {//注意：如果此行写成item <= arr[j]，那就是不稳定的
                arr[j + 1] = arr[j];// 数据移动
                //arr[j] = item;
                j--;
            }
            arr[j + 1] = item;// 插入数据//把上面注释的代码(arr[j] = item)放到了这里和上面其实差不多。
        }
        return arr;
    }

    /*
     * 冒泡排序(最好时间复杂度O(n))
     * 相邻元素，两两相比较，大的放到后面
     * 每冒一次把最大的数排到了最后
     * 如：5,1,1,2,0,0
     * 步骤如下：
     * 1,5,1,2,0,0
     * 1,1,5,2,0,0
     * ...
     * 1,1,2,0,0,5
     */
    private static int[] bubbleSort(int[] arr) {
        for (int j = 0; j < arr.length - 1; j++) { //此处写arr.length - 1，为了少进行一次判断，其实直接用arr.length也行
            // 优化：提前退出冒泡循环的标志位
            boolean flag = false;
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag = true; // 表示有数据交换
                }
            }
            if (!flag)
                break; // 没有数据交换，提前退出
        }
        return arr;
    }

    //从后往前冒泡的冒泡法
    private static int[] bubbleSort2(int[] arr) {
        for (int j = 0; j < arr.length - 1; j++) {//此处写arr.length - 1，为了少进行一次判断，其实直接用arr.length也行
            for (int i = arr.length - 1; i > j; i--) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
        }
        return arr;
    }

    /*
     * 选择排序
     * 最好时间复杂度O(n^2)，最坏时间复杂度O(n^2)
     */
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int item = arr[i];
            int j = i + 1;
            int min = item;
            int cur = i;
            for (; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    cur = j;
                }
            }
            //互换min和item
            arr[i] = min;
            arr[cur] = item;
        }
        return arr;
    }

    //随机生成2000个数组，每个数组1000个元素，然后排序。
    private static void testMultipleData() {
        int n1 = 2000;
        int n2 = 1000;
        int[][] arr1 = new int[n1][n2];
        initArr(n1, n2, arr1);
        int[][] arr2 = new int[n1][n2];
        int[][] arr3 = new int[n1][n2];
        int[][] arr4 = new int[n1][n2];
        int[][] arr5 = new int[n1][n2];
        int[][] arr6 = new int[n1][n2];
        int[][] arr7 = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            arr2[i] = arr1[i].clone();
            arr3[i] = arr1[i].clone();
            arr4[i] = arr1[i].clone();
            arr5[i] = arr1[i].clone();
            arr6[i] = arr1[i].clone();
            arr7[i] = arr1[i].clone();
        }
        Times.test("bubbleSort", () -> {
            for (int i = 0; i < n1; i++) {
                bubbleSort(arr1[i]);
            }
        });
        Times.test("selectionSort", () -> {
            for (int i = 0; i < n1; i++) {
                selectionSort(arr2[i]);
            }
        });
        Times.test("insertionSort", () -> {
            for (int i = 0; i < n1; i++) {
                insertionSort(arr3[i]);
            }
        });
        Times.test("mergeSort", () -> {
            for (int i = 0; i < n1; i++) {
//                mergeSortIterate(arr6[i]);
                merge_sort_recursive(arr6[i], arr1[i],0,arr6[i].length -1);
            }
        });
        Times.test("mergeSort", () -> {
            for (int i = 0; i < n1; i++) {
                mergeSortIterate(arr7[i]);
//                merge_sort_recursive(arr6[i], arr1[i],0,arr6[i].length -1);
            }
        });
        Times.test("quickSort", () -> {
            for (int i = 0; i < n1; i++) {
                quickSort(arr4[i],0,arr4[i].length -1);
            }
        });
        Times.test("countingSort", () -> {
            for (int i = 0; i < n1; i++) {
                countingSort(arr5[i]);
            }
        });
    }

    private static void initArr(int n1, int n2, int[][] arr) {
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                arr[i][j] = (int) (Math.random() * 100);
            }
        }
    }

    private static void testStable() {
        Person p1 = new Person(0.5, "p1");
        Person p2 = new Person(0.07, "p2");
        Person p3 = new Person(7, "p3");
        Person p4 = new Person(0.1, "p4");
        Person p5 = new Person(0.1, "p5");
        Person[] arr = { p1, p2, p3, p4 ,p5};
        System.out.println(Arrays.toString(countingSort02(arr)));
    }

    public static Person[] insertionSort(Person[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Person item = arr[i];
            int j = i - 1;
            while (j >= 0 && item.age < arr[j].age) {//注意：如果此行写成item.age <= arr[j].age，那就是不稳定的
                arr[j + 1] = arr[j];// 数据移动
                //arr[j] = item;
                j--;
            }
            arr[j + 1] = item;// 插入数据
        }
        return arr;
    }
}