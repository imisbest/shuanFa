package com.csw.shuanFa.SuanFa;

/**
 * 归并排序
 */
public class GuiBing {
    public static void main(String[] args) {
        int[] data = {62, 0, 17, 72, 21, 55, 40, 85, 38, 90};
        PrintShuZu.print(data);
        mergeSort(data);
        System.out.println("排序后的数组");
        PrintShuZu.print(data);
    }

    public static void mergeSort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    public static void sort(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }
        int center = (left + right) / 2;
        sort(data, left, center);
        sort(data, center + 1, right);
        merge(data, left, center, right);
        PrintShuZu.print(data);
    }

    public static void merge(int[] data, int left, int center, int right) {
        int[] temArr = new int[data.length];
        int mid = center + 1;
        int third = left;
        int tmp = left;
        while (left <= center && mid <= right) {
            if (data[left] <= data[mid]) {
                temArr[third++] = data[left++];
            } else {
                temArr[third++] = data[mid++];
            }
        }
        while (mid <= right) {
            temArr[third++] = data[mid++];
        }
        while (left <= center) {
            temArr[third++] = data[left++];
        }
        while (tmp <= right) {
            data[tmp] = temArr[tmp++];
        }
    }

}
