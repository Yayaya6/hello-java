package com.dimon.tryjava.myTimer;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTask extends TimerTask {

    public void run() {
        System.out.println("运行了！时间为：" + new Date());
    }


    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
        MyTask task = new MyTask();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2015-10-6 12:14:00";
        Date dateRef = sdf.parse(dateString);
        System.out.println(
                "字符串时间：" + dateRef.toLocaleString() + " 当前时间：" + new Date().toLocaleString());
        timer.schedule(task, dateRef);
    }
}