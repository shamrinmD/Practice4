package ru.mirea.shamrin.looper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class MyLooper extends Thread {
    Handler handler;
    int timeSleep;

    @SuppressLint("HandlerLeak")
    @Override
    public void run() {
        Log.d("MyLooper", "run");
        Looper.prepare();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                timeSleep = 20;
                int age = msg.getData().getInt("AGE");
                String work = msg.getData().getString("WORK");
                try {
                    Thread.sleep(age);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("MyLooper", "Возраст: " + age);
                Log.d("MyLooper", "Работа: " + work);
            }
        };
        Looper.loop();
    }
}
