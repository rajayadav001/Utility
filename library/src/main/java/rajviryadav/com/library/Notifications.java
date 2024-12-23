package rajviryadav.com.library;

import static android.content.Context.NOTIFICATION_SERVICE;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;

public class Notifications
{
    public static void showNotification(Context context,int NOTIFICATION_ID,String CHANNEL_ID,String CHANNEL_NAME,String title, String message,int appIcon,Boolean cancel)
    {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        boolean cn = cancel ? true : false;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            notification = new Notification.Builder(context)
                    .setSmallIcon(appIcon)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setChannelId(CHANNEL_ID)
                    .setAutoCancel(cancel)
                    .setOngoing(cn)
                    .build();
            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH));
        }
        else
        {
            notification = new Notification.Builder(context)
                    .setSmallIcon(appIcon)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setAutoCancel(cancel)
                    .setOngoing(cn)
                    .build();
        }

        if(notificationManager!=null)
        {
            notificationManager.notify(NOTIFICATION_ID,notification);
        }
    }

    public static void showNotification(Context context,int NOTIFICATION_ID,String CHANNEL_ID,String CHANNEL_NAME,String title, String message,int appIcon,Boolean cancel,int largeIcon)
    {
        boolean cn = cancel ? true : false;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification;


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            notification = new Notification.Builder(context)
                    .setLargeIcon(getBitmap(context,largeIcon))
                    .setSmallIcon(appIcon)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setChannelId(CHANNEL_ID)
                    .setAutoCancel(cancel)
                    .setOngoing(cn)
                    .build();
            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH));

        }
        else
        {
            notification = new Notification.Builder(context)
                    .setLargeIcon(getBitmap(context,largeIcon))
                    .setSmallIcon(appIcon)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setAutoCancel(cancel)
                    .setOngoing(cn)
                    .build();
        }

        if(notificationManager!=null)
        {
            notificationManager.notify(NOTIFICATION_ID,notification);
        }

    }

    public static void showNotification(Context context,int NOTIFICATION_ID,String CHANNEL_ID,String CHANNEL_NAME,String title, String message,int appIcon,Boolean cancel,int largeIcon,Intent intent,int REQUEST_CODE)
    {
        boolean cn = cancel ? true : false;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,REQUEST_CODE,intent,PendingIntent.FLAG_MUTABLE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            notification = new Notification.Builder(context)
                    .setLargeIcon(getBitmap(context,largeIcon))
                    .setSmallIcon(appIcon)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setChannelId(CHANNEL_ID)
                    .setAutoCancel(cancel)
                    .setContentIntent(pendingIntent)
                    .setOngoing(cn)
                    .build();
            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH));

        }
        else
        {
            notification = new Notification.Builder(context)
                    .setLargeIcon(getBitmap(context,largeIcon))
                    .setSmallIcon(appIcon)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setAutoCancel(cancel)
                    .setContentIntent(pendingIntent)
                    .setOngoing(cn)
                    .build();
        }

        if(notificationManager!=null)
        {
            notificationManager.notify(NOTIFICATION_ID,notification);
        }

    }

    public static void showNotification(Context context,int NOTIFICATION_ID,String CHANNEL_ID,String CHANNEL_NAME,String title, String message,int appIcon,Boolean cancel,int largeIcon,int bigPicture,String bigTitle,String bigMessage)
    {
        boolean cn = cancel ? true : false;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(getBitmap(context,bigPicture))
                .setBigContentTitle(bigTitle)
                .setSummaryText(bigMessage);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            notification = new Notification.Builder(context)
                    .setLargeIcon(getBitmap(context,largeIcon))
                    .setSmallIcon(appIcon)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setChannelId(CHANNEL_ID)
                    .setStyle(bigPictureStyle)
                    .setAutoCancel(cancel)
                    .setOngoing(cn)
                    .build();
            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH));

        }
        else
        {
            notification = new Notification.Builder(context)
                    .setLargeIcon(getBitmap(context,largeIcon))
                    .setSmallIcon(appIcon)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setStyle(bigPictureStyle)
                    .setAutoCancel(cancel)
                    .setOngoing(cn)
                    .build();
        }

        if(notificationManager!=null)
        {
            notificationManager.notify(NOTIFICATION_ID,notification);
        }

    }

    public static void showNotification(Context context,int NOTIFICATION_ID,String CHANNEL_ID,String CHANNEL_NAME,String title, String message,int appIcon,Boolean cancel,int largeIcon,Intent intent,int REQUEST_CODE,int bigPicture,String bigTitle,String bigMessage)
    {
        boolean cn = cancel ? true : false;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(getBitmap(context,bigPicture))
                .setBigContentTitle(bigTitle)
                .setSummaryText(bigMessage);

        //Intent intent = new Intent(context,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,REQUEST_CODE,intent,PendingIntent.FLAG_MUTABLE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            notification = new Notification.Builder(context)
                    .setLargeIcon(getBitmap(context,largeIcon))
                    .setSmallIcon(appIcon)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setChannelId(CHANNEL_ID)
                    .setContentIntent(pendingIntent)
                    .setStyle(bigPictureStyle)
                    .setAutoCancel(cancel)
                    .setOngoing(cn)
                    .build();
            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH));

        }
        else
        {
            notification = new Notification.Builder(context)
                    .setLargeIcon(getBitmap(context,largeIcon))
                    .setSmallIcon(appIcon)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setContentIntent(pendingIntent)
                    .setStyle(bigPictureStyle)
                    .setAutoCancel(cancel)
                    .setOngoing(cn)
                    .build();
        }

        if(notificationManager!=null)
        {
            notificationManager.notify(NOTIFICATION_ID,notification);
        }

    }

    public static void showNotification(Context context,int NOTIFICATION_ID,String CHANNEL_ID,String CHANNEL_NAME,String title, String message,int appIcon,Boolean cancel,int largeIcon,String bigTitle,String bigMessage,String line1,String line2,String line3,String line4,String line5,String line6,String line7)
    {
        boolean cn = cancel ? true : false;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine(line1)
                .addLine(line2)
                .addLine(line3)
                .addLine(line4)
                .addLine(line5)
                .addLine(line6)
                .addLine(line7)
                .setBigContentTitle(bigTitle)
                .setSummaryText(bigMessage);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            notification = new Notification.Builder(context)
                    .setLargeIcon(getBitmap(context,largeIcon))
                    .setSmallIcon(appIcon)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setChannelId(CHANNEL_ID)
                    .setStyle(inboxStyle)
                    .setAutoCancel(cancel)
                    .setOngoing(cn)
                    .build();
            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH));

        }
        else
        {
            notification = new Notification.Builder(context)
                    .setLargeIcon(getBitmap(context,largeIcon))
                    .setSmallIcon(appIcon)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setStyle(inboxStyle)
                    .setAutoCancel(cancel)
                    .setOngoing(cn)
                    .build();
        }

        if(notificationManager!=null)
        {
            notificationManager.notify(NOTIFICATION_ID,notification);
        }

    }

    public static void showNotification(Context context,int NOTIFICATION_ID,String CHANNEL_ID,String CHANNEL_NAME,String title, String message,int appIcon,Boolean cancel,int largeIcon,Intent intent,int REQUEST_CODE,String bigTitle,String bigMessage,String line1,String line2,String line3,String line4,String line5,String line6,String line7)
    {
        boolean cn = cancel ? true : false;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine(line1)
                .addLine(line2)
                .addLine(line3)
                .addLine(line4)
                .addLine(line5)
                .addLine(line6)
                .addLine(line7)
                .setBigContentTitle(bigTitle)
                .setSummaryText(bigMessage);

        //Intent intent = new Intent(context,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,REQUEST_CODE,intent,PendingIntent.FLAG_MUTABLE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            notification = new Notification.Builder(context)
                    .setLargeIcon(getBitmap(context,largeIcon))
                    .setSmallIcon(appIcon)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setChannelId(CHANNEL_ID)
                    .setContentIntent(pendingIntent)
                    .setStyle(inboxStyle)
                    .setAutoCancel(cancel)
                    .setOngoing(cn)
                    .build();
            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH));

        }
        else
        {
            notification = new Notification.Builder(context)
                    .setLargeIcon(getBitmap(context,largeIcon))
                    .setSmallIcon(appIcon)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setContentIntent(pendingIntent)
                    .setStyle(inboxStyle)
                    .setAutoCancel(cancel)
                    .setOngoing(cn)
                    .build();
        }

        if(notificationManager!=null)
        {
            notificationManager.notify(NOTIFICATION_ID,notification);
        }

    }


    private static Bitmap getBitmap(Context context, int image)
    {
        Drawable drawable = ResourcesCompat.getDrawable(context.getResources(),image,null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        return bitmap;
    }
}
