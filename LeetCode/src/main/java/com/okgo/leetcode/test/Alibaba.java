package com.okgo.leetcode.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * @author Shawn
 * @date 2020/9/2 22:24
 * @title Function
 */
public class Alibaba {
    // 笔试题1
    // 背景描述：
    // 在金融业务中，经常涉及到交易日期的计算，交易日和自然日是有区别的，比如法定节假日，周末，都是不能交易的，我们叫非交易日，允许交易的日我们称之为交易日。
    // 交易日每天也不是24小时，比如中国股市的股票交易时间在每个交易日的[AM9:30-11:30) 和 [PM13:00-15:00)
    // 为了满足7*24小时服务，我们对用户提供的服务在非交易日或是非交易时段也是有支持的，所以将非交易时段产生的业务，它的交易日会算到下一个最近交易时段的交易日中，
    // 为了表述方便，我们用T+0表示当前交易日，T+1表示下一个交易日。D+0表示当天自然日，D+1表示下一个自然日，以此类推可能会有：D+n，D-n T+n，T-n等这样的日期表述方式。
    // 举例说明：20160701 20160704 20160705 是交易日，交易日的交易时间是[AM9:30-11:30) 和 [PM13:00-15:00),20160702和20160703是非交易日，
    // 则 20160701上午8点的交易日是20160701 ，20160701下午5点的交易日则是 20160704 ，用T+0标示某个时间的当前交易日，
    // 如20160701下午5点的T+0为20160704，T+1为20160705。

    // 编程要求：
    // 写一个交易日期的计算工具类：
    // 1、根据交易日历初始化交易日工具
    // 2、给定任意时间，返回给定时间的T+n交易日。
    //: TODO 可自行定义需要的变量
    Map<String, Boolean> map = new HashMap<>();
    /**
     * • 工具初始化，初始化的目的是让工具具备更加合适各的数据结构，方便计算提高效率
     * • @param tradeDayList 包含一年内所有的交易日期，格式如：20160701 20160704 20160705，非交易日20160702 20160703不在其中.
     */
    public void init(List tradeDayList) {
        //: TODO 完成此处的代码
        for (Object tradeDay : tradeDayList) {
            map.put(String.valueOf(tradeDay), true);
        }
    }

    /**
     * •
     * • 给定任意时间，返回给定时间的T+n交易日
     * •
     * • @param time 给定要计算的时间。
     * • @param offsetDays 交易日偏移量，offsetDays可以为负数，表示T-n的计算。
     */
    public String getTradeDay(Date time, int offsetDays) {
        //: TODO 完成此处的代码
        Date tradingDate = time;
        if (0 == offsetDays) {
//            AndCondition andCondition = new AndCondition();
//            andCondition.put("yyyymmdd", "=", tradingDate);
//            if (0 < holidayDao.countHoliday(andCondition)) {
//                // 判断当天是否为交易日，不是则取下一交易日，未考虑取历史交易日
//                getTradingDate(tradingDate, 1);
//            }
        } else {
            // 上days交易日或下days交易日
            offsetDays = Math.abs(offsetDays);
            while (offsetDays > 0) {
//                tradingDate = DateUtils.add(time, offsetDays, Calendar.DATE);
//                offsetDays = getHolidaysNum(startDate, tradingDate);
                time = tradingDate;
            }
        }
        return tradingDate.toString();
    }

    /**
     * 判断时间是否在交易时间段内
     *
     * @param time
     * @return
     */
    public static boolean belongCalendar(Date time) {

        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date beginTimeAM = null;
        Date endTimeAM = null;
        Date beginTimePM = null;
        Date endTimePM = null;
        try {
            time = df.parse(df.format(time));
            beginTimeAM = df.parse("9:30");
            endTimeAM = df.parse("11:30");
            beginTimePM = df.parse("13:00");
            endTimePM = df.parse("15:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar validatedTime = Calendar.getInstance();
        validatedTime.setTime(time);

        Calendar beginAM = Calendar.getInstance();
        beginAM.setTime(beginTimeAM);

        Calendar endAM = Calendar.getInstance();
        endAM.setTime(endTimeAM);

        Calendar beginPM = Calendar.getInstance();
        beginPM.setTime(beginTimePM);

        Calendar endPM = Calendar.getInstance();
        endPM.setTime(endTimePM);

        if ((validatedTime.after(beginTimeAM) && validatedTime.before(endTimeAM)) || (validatedTime.after(beginTimePM) && validatedTime.before(endTimePM))) {
            return true;
        } else {
            return false;
        }
    }

    //笔试题2--并发设计
    //场景描述： 用户在支付宝拥有多种支付方式（余额、红包、余额宝等，每种支付工具分布在不同系统），每种支付方式通过调用远程服务获取可用性。
    //        在外部资源环境不变情况下，请设计程序以最短响应时间获得尽可能多的可用支付方式列表。
    //补充：假定支付方式可用性咨询接口统一为
    //ConsultResult  PaymentRemoteSerivce.isEnabled(String paymentType);
    //返回结果
    // public class ConsultResult {
    //    /** 咨询结果是否可用*/
    //    private boolean isEnable;
    //    /** 错误码 */
    //    private String errorCode;
    // }

    /**
     * • 过滤不可用支付方式类型
     * • @param paymentTypeList 原始支付方式类型列表
     * • @return 可用支付方式类型列表
     */
    public List filterDisablePayment(List allPaymentList) throws InterruptedException {
        //: TODO 完成此处的代码
        if (allPaymentList == null) return null;
        int count = allPaymentList.size();
        CountDownLatch countDownLatch = new CountDownLatch(count);
        List<String> availablePaymentType = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String paymentType = (String) allPaymentList.get(i);
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                if (PaymentRemoteSerivce.isEnabled(paymentType).isEnable()) availablePaymentType.add(paymentType);
                countDownLatch.countDown();
            }, ("Call PaymentRemoteSerivce: " + paymentType)).start();
        }
        countDownLatch.await();
        return availablePaymentType;
    }
}

class PaymentRemoteSerivce {
    public static ConsultResult isEnabled(String paymentType) {
        if (paymentType == null) return new ConsultResult(false, "paymentType is null");
        Random random = new Random();
        boolean isEnable = random.nextBoolean();
        return new ConsultResult(isEnable, "paymentType is " + (isEnable ? "available" : "unavailable"));
    }
}

class ConsultResult {
    /**
     * 咨询结果是否可用
     */
    private boolean isEnable;
    /**
     * 错误码
     */
    private String errorCode;

    public ConsultResult(boolean isEnable, String errorCode) {
        this.isEnable = isEnable;
        this.errorCode = errorCode;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}

