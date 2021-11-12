package com.csw.algorithm;

public class Memery {
    public static void main(String[] args) {
        int total = 8;
        int memerySize = total * 1000;
        int dx4 = memerySize / 8;
        int dx5 = memerySize / 16;
        int maxSize = dx4 - dx5;
        int minSize = dx5;
        System.out.println("maxSize]" + maxSize);
        System.out.println("minSize]" + minSize);
    }
    /*
    * 6GB
    * maxSize]300
minSize]1200
*
* 8GB
*maxSize]400
minSize]1600
*
*
* 16GB
    *maxSize]800
minSize]3200
    * */
}
