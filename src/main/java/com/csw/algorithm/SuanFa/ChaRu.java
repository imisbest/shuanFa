package com.csw.algorithm.SuanFa;

public class ChaRu {
    public static void main(String[] args) {
        int[] aac = {38, 97, 56, 20, 49, 78, 63, 4, 84, 10};
        int[] aab = sort(aac);
        PrintShuZu.print(aab);
    }

    //有问题
    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int insertVal = arr[i];
            int index = i - 1;
            while (index >= 0 & insertVal < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = insertVal;
        }
        return arr;
    }
}
