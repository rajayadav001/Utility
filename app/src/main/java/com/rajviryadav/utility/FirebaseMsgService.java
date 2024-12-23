package com.rajviryadav.utility;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import rajviryadav.com.library.Notifications;


public class FirebaseMsgService extends FirebaseMessagingService
{
    private static final String CHANNEL_ID = "update";
    private static final int NOTIFICATION_ID = 100;
    private static final int REQUEST_CODE = 110;

   /* @Override
    public void onNewToken(@NonNull String token)
    {
        super.onNewToken(token);
        Log.d("TAG_token", "onNewToken: "+token);
    }*/

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message)
    {
        super.onMessageReceived(message);
        Log.d("TAG_message", "onMessageReceived: "+message.getNotification().getTitle()+"---"+message.getNotification().getBody());
        Notifications.showNotification(getBaseContext(),100,"update","update",message.getNotification().getTitle(),message.getNotification().getBody(),R.drawable.cs_logo,false);

    }

}
