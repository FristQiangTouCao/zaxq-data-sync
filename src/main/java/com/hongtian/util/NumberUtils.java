package com.hongtian.util;

import java.text.DecimalFormat;

/**
 * @author weed
 * @date 2020/10/12 0012 22:10
 * @description
 */

public class NumberUtils {
    private NumberUtils(){}


    /**
     *
     * @param divisor  除数
     * @param dividend 被除数
     * @param keepCount 保留的小数点位数
     * @return
     */
    public static double division(long divisor,int dividend,int keepCount) {
        if(dividend == 0 || divisor == 0) {
            return 0;
        }
        StringBuffer stringBuffer = new StringBuffer("#");
        if(keepCount > 0) {
            stringBuffer.append(".");
            for(int i = 0; i < keepCount; i++) {
                stringBuffer.append("#");
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat(stringBuffer.toString());
        return Double.parseDouble(decimalFormat.format(divisor/(double)dividend));
    }

    /**
     * 累加求和
     * @param numbers
     * @return
     */
    public static int cumulative(int...numbers){
        int total = 0;
        for(int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }
        return total;
    }
}
