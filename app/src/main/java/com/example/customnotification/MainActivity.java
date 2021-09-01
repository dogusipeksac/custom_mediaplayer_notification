package com.example.customnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageButton play;
    TextView title;
    List<Track> trackList;
    NotificationManager notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=findViewById(R.id.play);
        title=findViewById(R.id.title);
        popluateTracks();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            createChannel();
        }
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateNotification.createNotification(MainActivity.this,
                        trackList.get(1),
                        R.drawable.pause_image,
                        1,
                        trackList.size()-1);
            }
        });
    }

    private void createChannel() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CreateNotification.CHANNEL_ID_1,
                    "channel",
                    NotificationManager.IMPORTANCE_LOW);
            notificationManager=getSystemService(NotificationManager.class);
            if (notificationManager!=null ){
                notificationManager.createNotificationChannel(channel);
            }
        }

    }

    private void popluateTracks(){
        trackList=new ArrayList<>();

        trackList.add(new Track("Track1",R.drawable.image1,"Artist1"));
        trackList.add(new Track("Track2",R.drawable.image2,"Artist2"));
        trackList.add(new Track("Track3",R.drawable.image3,"Artist3"));
        trackList.add(new Track("Track4",R.drawable.image1,"Artist4"));
        trackList.add(new Track("Track5",R.drawable.image2,"Artist5"));

    }
}