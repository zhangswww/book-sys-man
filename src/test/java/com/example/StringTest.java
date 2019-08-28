package com.example;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringTest {
//    final


    @Test
    public void testDate() {
        //日期转换
        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateOfBorrowing = sdf.format(date1);
        System.out.println(dateOfBorrowing);
        //算出还书日期  还书日期就是借书日期加上两个月
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.add(Calendar.MONTH, 2);//增加两个月
        Date date2 = calendar.getTime();
        String dateOfReturn = sdf.format(date2);
        System.out.println(dateOfReturn);
    }



    @Test
    public void testString() {
 /*       String h = "";
        String h1 = "aaa";
        String h2 = "bbb";
        String h3 = "ccc";
        h += h1;
        h += h2;
        h += h3;
        System.out.println(h);*/
        String str = "<tr>";
        for (int i = 0; i < 3; i++) {
            String html = "";
            String html1 = "<td>" + i + "</td>\n";
            String html2 = "<td>" + i + "</td>\n";
            String html3 = "<td> <button>删除"+i+"</button></td>\n";
            html += html1;
            html += html2;
            html += html3;

            System.out.println(html);
        }
//        str += html;

    }
}
