package com.dimon.tryjava.myDateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by limeng on 2018/10/3.
 */
public class StringFormatDate {
    public static void main(String[] args) {
        String time1 = "2018年06月19日 23时10分05秒";
        String time2 = "18/06/19 23:10";
        String time3 = "2018-06-19 23:10:05";
        String time4 = "2018年06月19日 23时10分05秒 Tue";

        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        SimpleDateFormat myFmt1 = new SimpleDateFormat("yy/MM/dd HH:mm");
        SimpleDateFormat myFmt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//等价于now.toLocaleString()
        SimpleDateFormat myFmt3 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E");

        Date date1 = null;
        try {
            date1 = myFmt.parse(time1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date1);

        Date date2 = null;
        try {
            date2 = myFmt1.parse(time2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date2);

        Date date3 = null;
        try {
            date3 = myFmt2.parse(time3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date3);

        Date date4 = null;
        try {
            date4 = myFmt3.parse(time4);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date4);
    }
}
