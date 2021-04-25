package com.csw.shuanFa.SuanFa;

public class KuaiSu {
    public static void main(String[] args) {
        int[] aac = {48, 71, 19, 67, 58, 9, 99, 38, 89, 25};
        quickSort(aac);
        PrintShuZu.print(aac);
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(arr, low, high);        //将数组分为两部分
        quickSort(arr, low, pivot - 1);                   //递归排序左子数组
        quickSort(arr, pivot + 1, high);                  //递归排序右子数组
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];     //基准
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];             //交换比基准大的记录到左端
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];           //交换比基准小的记录到右端
        }
        //扫描完成，基准到位
        arr[low] = pivot;
        //返回的是基准的位置
        return low;
    }
}
