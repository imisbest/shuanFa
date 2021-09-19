package com.csw.algorithm.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class SecurityPasswordS6 {
    private static final Logger logger = LoggerFactory.getLogger(SecurityPasswordS6.class);

    public static void main(String[] args) {
        String[][] signArrayXdst = {//去掉Il1,0O,<,支付密码4、//76
                {"0", "1", "2"},
                {"3", "5", "6"},
                {"7", "8", "9"}
        };


        ArrayList<String> pwd = new ArrayList<>();
        SecureRandom random = new SecureRandom();
        int len = 6;
        //循环密码长度
        int totalCount = 0;
        for (String[] tmpArray : signArrayXdst) {
            int signIndex = random.nextInt(tmpArray.length);
            pwd.add(tmpArray[signIndex]);
            totalCount += tmpArray.length;
        }
        for (int i = 0; i < len - signArrayXdst.length; i++) {
            int indexNei = random.nextInt(signArrayXdst.length);
            String[] tmpArray = signArrayXdst[indexNei];
            int signIndex = random.nextInt(tmpArray.length);
            pwd.add(tmpArray[signIndex]);
        }
        Collections.shuffle(pwd);
        Marker marker = null;
        String resultPwd = pwd.toString().substring(1, pwd.toString().length() - 1).replace(", ", "");
        logger.info(marker, "生成的秘钥为{}", resultPwd);
        double f = Math.pow(totalCount, len) / Math.pow(10, 8);
        BigDecimal b = new BigDecimal(f + "");
        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        logger.info(marker, "按照每秒1亿次破解速度计算破解需要的秒数为{}", f1);
    }
}

