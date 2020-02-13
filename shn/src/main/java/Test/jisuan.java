package Test;


import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import sun.util.calendar.CalendarUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class jisuan {
    public static void main(String[] args) throws ParseException {
        String date1="20170822";
        String date2="20180222";
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date d1=df.parse(date1);
        Date d2=df.parse(date2);
//        DateUtil.
        Calendar c1=Calendar.getInstance();
        c1.setTime(d1);
        c1.add(Calendar.DATE,184);
        System.out.println(df.format(c1.getTime()));
//        long i=DateUtil.between(d1,d2,DateUnit.DAY);

//        System.out.println(i);
    }
}
