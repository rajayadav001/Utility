package rajviryadav.com.library;

import static androidx.core.content.ContextCompat.getColor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class Toast
{
    public static void toast_simple(Context context, String message)
    {
        android.widget.Toast.makeText(context, ""+message, android.widget.Toast.LENGTH_SHORT).show();
    }

    public static void toast_custom(Context context, String message,int duration, int icon)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.custom_toast, null, false);
        android.widget.Toast toast = new android.widget.Toast(context);
        toast.setView(view);
        TextView textView = view.findViewById(R.id.txt);
        ImageView imageView = view.findViewById(R.id.img);
        imageView.setImageResource(icon);
        textView.setText(message);
        duration(toast,duration);
        toast.show();
    }

    public static void toast_custom(Context context, String message,int duration, int icon, int backGroundColor)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.custom_toast, null, false);
        android.widget.Toast toast = new android.widget.Toast(context);
        toast.setView(view);
        LinearLayout linearLayout = view.findViewById(R.id.lnr);
        linearLayout.setBackgroundColor(getColor(context, backGroundColor));
        TextView textView = view.findViewById(R.id.txt);
        textView.setText(message);
        ImageView imageView = view.findViewById(R.id.img);
        imageView.setImageResource(icon);
        duration(toast,duration);
        toast.show();
    }
    public static void toast_custom(Context context, String message,int duration, int icon, int backGroundColor,int textColor)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.custom_toast, null, false);
        android.widget.Toast toast = new android.widget.Toast(context);
        toast.setView(view);
        LinearLayout linearLayout = view.findViewById(R.id.lnr);
        linearLayout.setBackgroundColor(getColor(context, backGroundColor));
        TextView textView = view.findViewById(R.id.txt);
        textView.setText(message);
        textView.setTextColor(getColor(context, textColor));
        ImageView imageView = view.findViewById(R.id.img);
        imageView.setImageResource(icon);
        duration(toast,duration);
        toast.show();
    }
    public static void toast_custom(Context context, String message, int duration, int icon, int backGroundColor,int textColor, int iconColor)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.custom_toast, null, false);
        android.widget.Toast toast = new android.widget.Toast(context);
        toast.setView(view);
        LinearLayout linearLayout = view.findViewById(R.id.lnr);
        linearLayout.setBackgroundColor(getColor(context, backGroundColor));
        TextView textView = view.findViewById(R.id.txt);
        textView.setText(message);
        textView.setTextColor(getColor(context, textColor));
        ImageView imageView = view.findViewById(R.id.img);
        imageView.setImageResource(icon);
        imageView.setColorFilter(ContextCompat.getColor(context, iconColor));
        duration(toast,duration);
        toast.show();
    }
    public static void toast_custom(Context context, String message, int duration, int icon, int backGroundColor,int textColor, int iconColor,float textSize)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.custom_toast, null, false);
        android.widget.Toast toast = new android.widget.Toast(context);
        toast.setView(view);
        LinearLayout linearLayout = view.findViewById(R.id.lnr);
        linearLayout.setBackgroundColor(getColor(context, backGroundColor));
        TextView textView = view.findViewById(R.id.txt);
        textView.setText(message);
        textView.setTextSize(textSize);
        textView.setTextColor(getColor(context, textColor));
        ImageView imageView = view.findViewById(R.id.img);
        imageView.setImageResource(icon);
        imageView.setColorFilter(ContextCompat.getColor(context, iconColor));
        duration(toast,duration);
        toast.show();
    }

    private static void duration(android.widget.Toast toast, int duration)
    {
        if(duration == 0)
        {
            toast.setDuration(android.widget.Toast.LENGTH_SHORT);
        }
        else if(duration == 1)
        {
            toast.setDuration(android.widget.Toast.LENGTH_LONG);
        }
        else
        {
            toast.setDuration(android.widget.Toast.LENGTH_LONG);
        }
    }
}
