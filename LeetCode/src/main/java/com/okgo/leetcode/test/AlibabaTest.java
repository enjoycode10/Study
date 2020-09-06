package com.okgo.leetcode.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * @author Shawn
 * @date 2020/9/2 22:24
 * @title Function
 */
public class AlibabaTest {
    // 笔试题1
    // 背景描述：
    // 在金融业务中，经常涉及到交易日期的计算，交易日和自然日是有区别的，比如法定节假日，周末，都是不能交易的，我们叫非交易日，允许交易的日我们称之为交易日。
    // 交易日每天也不是24小时，比如中国股市的股票交易时间在每个交易日的[AM9:30-11:30) 和 [PM13:00-15:00)
    // 为了满足7*24小时服务，我们对用户提供的服务在非交易日或是非交易时段也是有支持的，所以将非交易时段产生的业务，它的交易日会算到下一个最近交易时段的交易日中，
    // 为了表述方便，我们用T+0表示当前交易日，T+1表示下一个交易日。D+0表示当天自然日，D+1表示下一个自然日，以此类推可能会有：D+n，D-n T+n，T-n等这样的日期表述方式。
    // 举例说明：20160701 20160704 20160705 是交易日，交易日的交易时间是[AM9:30-11:30) 和 [PM13:00-15:00),20160702和20160703是非交易日，
    // 则 20160701上午8点的交易日是20160701 ，20160701下午5点的交易日则是 20160704 ，用T+0标示某个时间的当前交易日，
    // 如20160701下午5点的T+0为20160704，T+1为20160705。

    // 写一个交易日期的计算工具类：
    // 1、根据交易日历初始化交易日工具
    // 2、给定任意时间，返回给定时间的T+n交易日。
    //: TODO 可自行定义需要的变量
    static Map<String, Boolean> map = new HashMap<>();
    static SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
    static SimpleDateFormat af = new SimpleDateFormat("yyyy-MM-dd-HH:mm");

    /**
     * • 工具初始化，初始化的目的是让工具具备更加合适各的数据结构，方便计算提高效率
     * • @param tradeDayList 包含一年内所有的交易日期，格式如：20160701 20160704 20160705，非交易日20160702 20160703不在其中.
     */
    public static void init(List tradeDayList) {
        //: TODO 完成此处的代码
        if (tradeDayList == null) return;
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
    public static String getTradeDay(Date time, int offsetDays) {
        //: TODO
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        if (calendar.get(Calendar.YEAR) != 2016) return "Warning: Please kindly input one time in 2016";

        String keyDate = df.format(calendar.getTime());
        if (!map.containsKey(keyDate)) {
            do {
                calendar.add(Calendar.DATE, 1);
                keyDate = df.format(calendar.getTime());
            } while (!map.containsKey(keyDate));
        }
        keyDate = getNextTradingDay(time, calendar, keyDate);
        return getTradingOffsetDay(offsetDays, calendar, keyDate);
    }

    /**
     * 获取交易日偏移量后的交易日
     * @param offsetDays    偏移量
     * @param calendar      日历实例
     * @param keyDate       交易日在Map中的键
     * @return              偏移量后的交易日
     */
    private static String getTradingOffsetDay(int offsetDays, Calendar calendar, String keyDate) {
        if (offsetDays == 0) {
            return keyDate;
        } else if (offsetDays < 0) {
            int i = 0;
            while (i < Math.abs(offsetDays)) {
                calendar.add(Calendar.DATE, -1);
                keyDate = df.format(calendar.getTime());
                if (map.containsKey(keyDate)) {
                    i++;
                }
            }
            return keyDate;
        } else {
            int i = 0;
            while (i < offsetDays) {
                calendar.add(Calendar.DATE, 1);
                keyDate = df.format(calendar.getTime());
                if (map.containsKey(keyDate)) {
                    i++;
                }
            }
            return keyDate;
        }

    }

    /**
     *
     * @param time          输入的时间
     * @param calendar      日历实例
     * @param keyDate       交易日在Map中的键
     * @return              最近的交易日
     */
    private static String getNextTradingDay(Date time, Calendar calendar, String keyDate) {
        if (!isBeforeTradingTime(time)) {
            do {
                calendar.add(Calendar.DATE, 1);
                keyDate = df.format(calendar.getTime());
            } while (!map.containsKey(keyDate));
        }
        return keyDate;
    }

    /**
     * 判断时间是否在交易时间段内
     *
     * @param time      输入的时间
     * @return          是否在15:00之前：true是，false不是
     */
    public static boolean isBeforeTradingTime(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        return cal.get(Calendar.HOUR_OF_DAY) < 15;
    }


    /**
     * 计算交易日工具类
     *
     * @param  path 交易日文件数据所在的路径
     * @return   包含全年交易日的List集合
     */
    public static List getTradeDayTools(String path) throws IOException {
        if (path == null || path.equals(""))  return null;
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = bufferedReader.readLine();
        String[] a = str.split(",");

        return Arrays.asList(a);
    }

    /**
     *      测试数据           偏移日期         返回结果
     *  2016-09-30-00:00        0           20160930
     *  2016-09-30-00:00       -1           20160929
     *  2016-09-30-00:00        1           20161010
     *  2016-09-30-14:59        0           20160930
     *  2016-09-30-14:59       -1           20160929
     *  2016-09-30-14:59        1           20161010
     *  2016-09-30-14:59        2           20161011
     *  2016-09-30-15:59        0           20161010
     *  2016-09-30-15:59       -1           20160930
     *  2016-09-30-15:59        1           20161011
     *  2016-09-30-15:59        2           20161012
     */
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {

//        init(getTradeDayTools("C:\\Userdata\\MyFiles\\Spring\\Study\\LeetCode\\src\\main\\java\\com\\okgo\\leetcode\\test\\交易日.txt"));
//        Date date1 = af.parse("2016-09-30-15:59");
//        System.out.println("date:" + date1);
//        System.out.println(getTradeDay(date1, 2));


        List<String> list = new ArrayList<String>();
        list.add("type1");
        list.add("type2");
        list.add("type3");
        list.add("type4");
        list.add("type5");
        list.add("type6");
        List result = filterDisablePayment(list);
        System.out.println("Available Payment type: ");
        for (Object o : result) {
            System.out.print(o.toString()+", ");
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
    public static List filterDisablePayment(List allPaymentList) throws InterruptedException {
        //: TODO 完成此处的代码
        if (allPaymentList == null) return null;
        int count = allPaymentList.size();
        CountDownLatch countDownLatch = new CountDownLatch(count);
        List<String> availablePaymentType = new CopyOnWriteArrayList<>();
        for (Object o : allPaymentList) {
            String paymentType = (String) o;
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

    /**
     * 判断支付方式是否可用
     * @param paymentType       支付类型
     * @return      是否可用：true可用，false不可用
     */
    public static ConsultResult isEnabled(String paymentType) {
        if (paymentType == null) return new ConsultResult(false, "paymentType is null");
        Random random = new Random();
        boolean isEnable = random.nextBoolean();
        System.out.println(paymentType +"\t"+ isEnable);
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

