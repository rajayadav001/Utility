package rajviryadav.com.library;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Date_Time
{

    /*
    d single digit date e.g. 5
    dd double digit date e.g. 05
    M single digit month e.g. 1
    MM double digit month e.g. 01
    MMM three-letter abbreviation for month e.g. Jan
    MMMM month spelled out in full e.g. January
    yy double digit year eLg. 13
    УУУУ four digit year e.g. 2013

    h single digit hours in 12 hour format e.g. 9
    hh double digit hours in 12 hour format e.g. 09
    H single digit hours in 24 hour format e.g. 9PM as 21
    HH double digit hours in 24 hour format e.g. 9PM as 21
    m single digit mints e.g. 9
    mm double digit mints e.g. 09
    S single digit seconds e.g. 9
    SS double digit seconds e.g. 09
    a am/pm marker

    G   Era designator (before christ, after christ)
    y   Year (e.g. 12 or 2012). Use either yy or yyyy.
    M   Month in year. Number of M's determine length of format (e.g. MM, MMM or MMMMM)
    d   Day in month. Number of d's determine length of format (e.g. d or dd)
    h   Hour of day, 1-12 (AM / PM) (normally hh)
    H   Hour of day, 0-23 (normally HH)
    m   Minute in hour, 0-59 (normally mm)
    s   Second in minute, 0-59 (normally ss)
    S   Millisecond in second, 0-999 (normally SSS)
    E   Day in week (e.g Monday, Tuesday etc.)
    D   Day in year (1-366)
    F   Day of week in month (e.g. 1st Thursday of December)
    w   Week in year (1-53)
    W   Week in month (0-5)
    a   AM / PM marker
    k   Hour in day (1-24, unlike HH's 0-23)
    K   Hour in day, AM / PM (0-11)
    z   Time Zone
    */

    String set_day,set_year,set_month1,set_month2;
    public static void select_date(Context context, TextView textView)
    {
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                String strday="";
                String strmonth1="";
                String strmonth2="";
                monthOfYear++;
                //Toast.makeText(getActivity(),dayOfMonth + "-" + monthOfYear + "-" + year, Toast.LENGTH_SHORT).show();
                if (dayOfMonth < 10) {
                    strday = "0" + dayOfMonth;
                } else {
                    strday = "" + dayOfMonth;
                }

                if (monthOfYear == 1) {
                    strmonth1 = "Jan";
                } else if (monthOfYear == 2) {
                    strmonth1 = "Feb";
                } else if (monthOfYear == 3) {
                    strmonth1 = "March";
                } else if (monthOfYear == 4) {
                    strmonth1 = "April";
                } else if (monthOfYear == 5) {
                    strmonth1 = "May";
                } else if (monthOfYear == 6) {
                    strmonth1 = "June";
                } else if (monthOfYear == 7) {
                    strmonth1 = "July";
                } else if (monthOfYear == 8) {
                    strmonth1 = "Aug";
                } else if (monthOfYear == 9) {
                    strmonth1 = "Sep";
                } else if (monthOfYear == 10) {
                    strmonth1 = "Oct";
                } else if (monthOfYear == 11) {
                    strmonth1 = "Nov";
                } else if (monthOfYear == 12) {
                    strmonth1 = "Dec";
                }

                if (monthOfYear < 10)
                {
                    strmonth2 = "0" + monthOfYear;
                } else {
                    strmonth2 = "" + monthOfYear;
                }

                textView.setText(strday + "-" + strmonth2 + "-" + year);
            }
        },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        //datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 0));
        datePickerDialog.show();
    }

    public static void select_time(Context context, TextView textView)
    {
        TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute)
            {
                String strminute,strhour;

                if(minute < 10)
                {
                    strminute = "0" + minute;
                }
                else
                {
                    strminute = ""+ minute;
                }
                if(hourOfDay < 10)
                {
                    strhour  = "0" + hourOfDay ;
                }
                else
                {
                    strhour  = "" + hourOfDay ;
                }

                textView.setText(strhour + ":" + strminute);
            }
        },
                Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                Calendar.getInstance().get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }

    public static void select_datetime(Context context, TextView textView)
    {
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                String strday="";
                String strmonth1="";
                String strmonth2="";
                monthOfYear++;
                //Toast.makeText(getActivity(),dayOfMonth + "-" + monthOfYear + "-" + year, Toast.LENGTH_SHORT).show();
                if (dayOfMonth < 10) {
                    strday = "0" + dayOfMonth;
                } else {
                    strday = "" + dayOfMonth;
                }

                if (monthOfYear == 1) {
                    strmonth1 = "Jan";
                } else if (monthOfYear == 2) {
                    strmonth1 = "Feb";
                } else if (monthOfYear == 3) {
                    strmonth1 = "March";
                } else if (monthOfYear == 4) {
                    strmonth1 = "April";
                } else if (monthOfYear == 5) {
                    strmonth1 = "May";
                } else if (monthOfYear == 6) {
                    strmonth1 = "June";
                } else if (monthOfYear == 7) {
                    strmonth1 = "July";
                } else if (monthOfYear == 8) {
                    strmonth1 = "Aug";
                } else if (monthOfYear == 9) {
                    strmonth1 = "Sep";
                } else if (monthOfYear == 10) {
                    strmonth1 = "Oct";
                } else if (monthOfYear == 11) {
                    strmonth1 = "Nov";
                } else if (monthOfYear == 12) {
                    strmonth1 = "Dec";
                }

                if (monthOfYear < 10)
                {
                    strmonth2 = "0" + monthOfYear;
                } else {
                    strmonth2 = "" + monthOfYear;
                }

                String finalStrday = strday;
                String finalStrmonth = strmonth2;
                TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener()
                {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute)
                    {
                        String strminute,strhour;

                        if(minute < 10)
                        {
                            strminute = "0" + minute;
                        }
                        else
                        {
                            strminute = ""+ minute;
                        }
                        if(hourOfDay < 10)
                        {
                            strhour  = "0" + hourOfDay ;
                        }
                        else
                        {
                            strhour  = "" + hourOfDay ;
                        }

                        textView.setText(finalStrday + "-" + finalStrmonth + "-" + year+ ":"+strhour + ":" + strminute);
                    }
                },
                        Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                        Calendar.getInstance().get(Calendar.MINUTE), true);
                timePickerDialog.show();
                //textView.setText(strday + "-" + strmonth2 + "-" + year);
            }
        },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        //datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 0));
        datePickerDialog.show();
    }

    public static String current_date()
    {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd/M/yyyy");
        return df.format(c.getTime());
    }
    public static String current_time()
    {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
        return df.format(c.getTime());
    }
    public static String current_datetime()
    {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
        return df.format(c.getTime());
    }

    // check details of date format....
    /*
    dd	Date in numeric value
    E	Day in String (short form. Ex: Mon)
    EEEE	Day in String (full form. Ex: Monday)
    MM	Month in numeric value
    yyyy	Year in numeric value
    LLL	Month in String (short form. Ex: Mar)
    LLLL	Month in String (full form. Ex: March)
    HH	Hour in numeric value (24hrs timing format)
    KK	Hour in numeric value (12hrs timing format)
    mm	Minute in numeric value
    ss	Seconds in numeric value
    aaa	Displays AM or PM (according to 12hrs timing format)
    z	Displays the time zone of the region
    */
    public static String change_date_format(String date,String input_format,String output_format)
    {
        String datetime=null;
        DateFormat inputFormat = new SimpleDateFormat(input_format);
        SimpleDateFormat d= new SimpleDateFormat(output_format);
        try
        {
            Date convertedDate = inputFormat.parse(date);
            datetime = d.format(convertedDate);
        }
        catch (ParseException e)
        {

        }
        return  datetime;
    }

    public static long date_difference(Date startDate, Date endDate) {
        //milliseconds
        long different = endDate.getTime() - startDate.getTime();

        System.out.println("startDate : " + startDate);
        System.out.println("endDate : "+ endDate);
        System.out.println("different : " + different);

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        System.out.printf(
                "%d days, %d hours, %d minutes, %d seconds%n",
                elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);

        return minutesInMilli;
    }

    public static boolean date_compare(String startdate,String enddate,String format)
    {
        Boolean datecompares;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date startdates = null;
        Date enddates = null;
        try {
            startdates = sdf.parse(startdate);
            enddates = sdf.parse(enddate);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        if (startdates.before(enddates))
        {
            datecompares = true;
        }
        else
        {
            datecompares = false;
        }
        return datecompares;
    }

    public void daterange_lastfromdatemonth(TextView fromdate, int month)
    {
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        cal.add(Calendar.MONTH, -month);
        cal.set(Calendar.DATE, 1);
        int firstMonth = cal.get(Calendar.MONTH)+1;
        int firstYear = cal.get(Calendar.YEAR);
        String firstday,firstmonth;

        if (firstMonth < 10)
        {
            firstmonth = "0" + firstMonth;
        } else {
            firstmonth = "" + firstMonth;
        }
        //fromdate.setText(firstmonth+"-01-"+firstYear);
        fromdate.setText("01-"+firstmonth+"-"+firstYear);

        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE)); // changed calendar to cal

        int lastDay = cal.get(Calendar.DAY_OF_MONTH);
        int lastMonth = cal.get(Calendar.MONTH)+1;
        int lastYear = cal.get(Calendar.YEAR);
        String lastday,lastmonth;
        if (lastDay < 10)
        {
            lastday = "0" + lastDay;
        } else {
            lastday = "" + lastDay;
        }

        if (lastMonth < 10)
        {
            lastmonth = "0" + lastMonth;
        } else {
            lastmonth = "" + lastMonth;
        }
        //todate.setText(lastday+"-"+lastmonth+"-"+lastYear);
    }

    public void daterange_lasttodatemonth(TextView todate)
    {
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DATE, 1);
        int firstMonth = cal.get(Calendar.MONTH)+1;
        int firstYear = cal.get(Calendar.YEAR);
        String firstday,firstmonth;

        if (firstMonth < 10)
        {
            firstmonth = "0" + firstMonth;
        } else {
            firstmonth = "" + firstMonth;
        }
        //fromdate.setText("01-"+firstmonth+"-"+firstYear);

        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE)); // changed calendar to cal

        int lastDay = cal.get(Calendar.DAY_OF_MONTH);
        int lastMonth = cal.get(Calendar.MONTH)+1;
        int lastYear = cal.get(Calendar.YEAR);
        String lastday,lastmonth;
        if (lastDay < 10)
        {
            lastday = "0" + lastDay;
        } else {
            lastday = "" + lastDay;
        }

        if (lastMonth < 10)
        {
            lastmonth = "0" + lastMonth;
        } else {
            lastmonth = "" + lastMonth;
        }
        todate.setText(lastday+"-"+lastmonth+"-"+lastYear);
    }

    public void daterange_currentmonth(TextView fromdate, TextView todate)
    {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        String day,month;
        if (currentDay < 10)
        {
            day = "0" + currentDay;
        } else {
            day = "" + currentDay;
        }

        if (currentMonth < 10)
        {
            month = "0" + currentMonth;
        } else {
            month = "" + currentMonth;
        }

        fromdate.setText("01-"+month+"-"+currentYear);
        todate.setText(day+"-"+month+"-"+currentYear);
    }

    public void daterange_financialyear(TextView fromdate, TextView todate, int fromyear,int toyear)
    {
        int CurrentYear = Calendar.getInstance().get(Calendar.YEAR);
        int CurrentMonth = (Calendar.getInstance().get(Calendar.MONTH)+1);
        String financiyalYearFrom="";
        String financiyalYearTo="";
        if (CurrentMonth<4)
        {
            financiyalYearFrom="01-04-"+(CurrentYear-fromyear);
            financiyalYearTo="31-03-"+(CurrentYear-toyear);
            fromdate.setText(""+financiyalYearFrom);
            todate.setText(""+financiyalYearTo);
        }
        else
        {
            financiyalYearFrom="01-04-"+(CurrentYear);
            financiyalYearTo="31-03-"+(CurrentYear+1);
            fromdate.setText(""+financiyalYearFrom);
            todate.setText(""+financiyalYearTo);
        }
    }
}
