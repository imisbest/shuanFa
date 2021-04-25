package com.csw.shuanFa;

import java.util.List;

public class StudentScore {
    int score;

    public void setScore(int score) {

    }
    public int delete () {
        return score;
    }

    public int minScore() {
        List list = null;
        int min=Integer.MIN_VALUE;
        assert false;
        for (Object o : list) {
            if ((int)o < min) {
                min = (int)o;
            }
        }
        return min;
    }
}
