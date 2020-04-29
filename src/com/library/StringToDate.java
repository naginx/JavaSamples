package com.library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringToDate {
   public static void main(String[] args) throws ParseException {

       // 登録日をDate型に変換
       String userRegDateString = "20200428203542";
       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
       Date userRegDate = sdf.parse(userRegDateString);

       // 3日前の日付を求める
       Date today = new Date();
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(today);
       calendar.add(Calendar.DATE, -3);
       Date threeDaysAgo = calendar.getTime();

       System.out.println(userRegDate.after(threeDaysAgo));
   }
}
