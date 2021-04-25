package com.csw.shuanFa.SuanFa;

public class HangChangeLieString {
    public static void main(String[] args) {
        int line = 3, hang = 4;
        //四行三列
        String arr[][] = new String[][]{{"委室", "总计", "农业农村"}, {"法制", "1", "2"}, {"监察", "3", "4"}, {"司法", "5", "6"}};
        System.out.println("行列互调前：");
        // 输出二维数组
        for (int i = 0; i < hang; i++) {// 遍历数组
            for (int j = 0; j < line; j++) {
                System.out.print(arr[i][j] + " ");// 不换行输出数组元素
            }
            System.out.println();    //换行
        }
        //换行，建立新数组，三行四列
        String arrNew[][] = new String[line][hang];
        for (int i = 0; i < line; i++) {// 调整数组行列数据
            for (int j = 0; j < hang; j++) {
                arrNew[i][j] = arr[j][i];
            }
        }
        System.out.println("行列互调后：");
        // 输出行列互调后的二维数组
        for (int i = 0; i < line; i++) {// 遍历数组
            for (int j = 0; j < hang; j++) {
                System.out.print(arrNew[i][j] + " ");// 不换行输出数组元素
            }
            System.out.println();    //换行
        }
    }


}
