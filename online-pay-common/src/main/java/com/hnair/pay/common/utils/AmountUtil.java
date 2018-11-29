package com.hnair.pay.common.utils;

import java.math.BigDecimal;

/**
 * 金額相關工具類
 */
public class AmountUtil {

    private static final double WXSCALE = 0.006; //微信分賬利率

    /**
     * 获取分账金额
     * @param amount int
     * @return
     */
    public static Integer getSharingFenAmonut(Integer amount) {//TODO
        double doubleAmount = amount * WXSCALE * 0.01;
        Integer scle = new BigDecimal(doubleAmount).setScale(2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100")).intValue();
        if (scle < 1) {
            return amount;
        } else {
            Integer res = amount - scle;
            return res;
        }

    }


}
