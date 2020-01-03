package com.xzit.garden.util;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateChangeUtil {
    public String changeDate(Date date)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString=formatter.format(date);
      return dateString;
    }
}
