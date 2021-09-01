package com.example.customnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class CreateNotification {
    public static final String CHANNEL_ID_1="channel1";
    public static final String ACTION_PREVIOUS="actionprevios";
    public static final String ACTION_NEXT="actionnext";
    public static final String ACTION_PLAY="actionplay";

    public static Notification notification;

    public static void createNotification(Context context,
                                          Track track,
                                          int playButton,
                                          int pos,
                                          int size){

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationManagerCompat notificationManagerCompat=
                    NotificationManagerCompat.from(context);
            MediaSessionCompat mediaSessionCompat=new MediaSessionCompat(context,"tag");
            Bitmap icon= BitmapFactory.decodeResource(context.getResources(),track.getImage());
            notification=new NotificationCompat.Builder(context,CHANNEL_ID_1)
                    .setSmallIcon(R.drawable.audiotrack)
                    .setContentTitle(track.getTitle())
                    .setContentText(track.getArtist())
                    .setLargeIcon(icon)
                    .setOnlyAlertOnce(true) //show notificaiton for only first time
                    .setShowWhen(false)
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                    .build();
            notificationManagerCompat.notify(1,notification);
        }
    }
}
