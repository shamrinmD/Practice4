package ru.mirea.shamrin.data_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = findViewById(R.id.tvInfo);
        final Runnable runn1 = new Runnable() {
            public void run() {
                tvInfo.setText("runn1");
            }
        };
        final Runnable runn2 = new Runnable() {
            public void run() {
                tvInfo.setText("runn2");
            }
        };
        final Runnable runn3 = new Runnable() {
            public void run() {
                tvInfo.setText("runn3");
            }
        };
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    /* Метод runOnUiThread дает доступ к основному потоку
                       или потоку пользовательского интерфейса.
                       Данный метод будет сразу выполняться. */
                    runOnUiThread(runn1);

                    TimeUnit.SECONDS.sleep(1);
                    /* Метод postDelayed  добавляет отложенное сообщение,
                       которое выполнится через определенный промежуток времени. */
                    tvInfo.postDelayed(runn3, 2000);

                    // Метод post добавляет новое сообщение в конец очереди.
                    tvInfo.post(runn2);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}