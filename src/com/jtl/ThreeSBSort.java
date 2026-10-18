package com.jtl;


import java.util.Arrays;

/**
 * 三傻排序
 */
public class ThreeSBSort {

    public static void main(String[] args) {
        int[] arr = createArr(100, 100);
        int[] copy = copyArr(arr);
        Arrays.sort(arr);
        //selectionSort(copy);
        //bubbleSort(copy);
        insertSort(copy);
        boolean b = isSameArr(arr, copy);
        System.out.println(b ? "成功" : "失败了！！");
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 创建一个正负数都有的数组
     * @param n
     * @param N
     * @return
     */
    public static int[] createArr(int n,int N){
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            double isNeg = Math.random();
            arr[i] = isNeg > 0.5 ? (int) (Math.random() * N) : -(int) (Math.random() * N);
        }
        return arr;
    }

    /**
     * 判断两个数组是否一致
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isSameArr(int[] arr1,int[] arr2){
        if(arr1.length != arr2.length){
            return false;
        }
        boolean flag = true;
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static int[] copyArr(int[] arr){
        int[] copy = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            copy[i] = arr[i];
        }
        return copy;
    }


    /**
     * 选择排序
     * @param arr
     * 1 5 4 2 3 6
     *   i j
     *   m
     */
    public static void selectionSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }


    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for(int end = arr.length - 1; end > 0; end--){
            for(int i = 0; i < end; i++){
                if(arr[i] > arr[i + 1]){
                    swap(arr,i,i + 1);
                }
            }
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            //j在i的前一个位置，如果前一个位置大于当前位置，且j没有走到头，就交换。
            //当前一个位置与当前位置相等或者更小的时候，意味着前面已经有序，无需继续交换。
            for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--){
                swap(arr,j,j + 1);
            }
        }
    }


}
