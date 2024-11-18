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

public class Date_Time
{
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
        if (startdates.before(enddates) || startdates.equals(enddates))
        {
            datecompares = true;
        }
        else
        {
            datecompares = false;
        }

        return datecompares;
    }
}
