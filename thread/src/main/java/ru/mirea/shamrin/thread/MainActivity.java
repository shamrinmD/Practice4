package ru.mirea.shamrin.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText numLessons;
    EditText numDays;
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numDays = findViewById(R.id.numDays);
        numLessons = findViewById(R.id.numLessons);

        resultView = findViewById(R.id.resultView);
        resultView.setText("Среднее количество пар в день");

    }
    public void onClick (View v){
        Runnable runnable = new Runnable() {
            public void run() {
                int num1 = 0;
                int num2 = 0;
                int result = 0;
                num1 = Integer.parseInt(numLessons.getText().toString());
                num2 = Integer.parseInt(numDays.getText().toString());
                result = num1/num2;
                resultView.setText(String.valueOf(result));
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}