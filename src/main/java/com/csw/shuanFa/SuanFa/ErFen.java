package com.csw.shuanFa.SuanFa;

public class ErFen {
    public static void main(String[] args) {
        int[] aac = {69, 3, 30, 29, 90, 52, 44, 85, 79, 15};
        int result = biSearch(aac, 85);
        if (result == -1) {
            System.out.println("没找到");
        } else {
            System.out.println("找到了】" + result);
        }
    }

    public static int biSearch(int[] array, int a) {
        int lo = 0;
        int hi = array.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (array[mid] == a) {
                return mid + 1;
            } else if (array[mid] < a) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
