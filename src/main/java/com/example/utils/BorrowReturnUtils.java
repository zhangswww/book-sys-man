package com.example.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BorrowReturnUtils {
    //日期转换
//    private
//    private

    public static String ReturnBookDate(Date date1,int count){
        /*Date date1 = new Date();*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateOfBorrowing = sdf.format(date1);
        System.out.println(dateOfBorrowing);
        //算出还书日期  还书日期就是借书日期加上两个月
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.add(Calendar.MONTH, count);//增加两个月
        Date date2 = calendar.getTime();
        String dateOfReturn = sdf.format(date2);
        return dateOfReturn;
    }
}
