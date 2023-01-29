package xyz.ibudai.sort;

import org.junit.Test;

import java.util.Arrays;

public class SortTest {

    @Test
    public void demo() {
        int[] arr = {9, 7, 3, 8, 4, 2, 8, 6};
        // 冒泡排序
        System.out.println(Arrays.toString(bubbleSort(arr)));
        // 快速排序
        System.out.println(Arrays.toString(QuickSort(arr, 0, arr.length - 1)));
    }

    private int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    private int[] QuickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 将数组划分为满足上述条件的两个子表
            int pivotPos = Partition(arr, low, high);  //划分

            // 依次对两个子表进行递归排序
            QuickSort(arr, low, pivotPos - 1);
            QuickSort(arr, pivotPos + 1, high);
        }
        return arr;
    }

    int Partition(int[] arr, int low, int high) {
        // 将表中第一个元素设为枢轴，对表进行划分
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            // 将比枢轴小的元素移动到左端
            arr[low] = arr[high];

            while (low < high && arr[low] <= pivot) ++low;
            // 将比枢轴大的元素移动到右端
            arr[high] = arr[low];
        }
        // 枢轴元素存放到最终位置
        arr[low] = pivot;
        return low;
    }
}
