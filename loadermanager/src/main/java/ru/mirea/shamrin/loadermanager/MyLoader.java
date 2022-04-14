package ru.mirea.shamrin.loadermanager;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.concurrent.ThreadLocalRandom;

public class MyLoader extends AsyncTaskLoader<String> {
    private String inputText;
    private String resultText;
    private int index;
    private StringBuffer bufferText;

    public static final String ARG_WORD = "word";

    public MyLoader(@NonNull Context context, Bundle args) {
        super(context);
        if (args != null)
            inputText = args.getString(ARG_WORD);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        bufferText = new StringBuffer(inputText);
        resultText = "";
        while (bufferText.length() != 0) {
            // Выбираем случайным образом символ из строки bufferText:
            index = ThreadLocalRandom.current().nextInt(bufferText.length());
            // Добавляем символ в строку resultText:
            resultText = resultText + bufferText.charAt(index);
            // Удаляем символ из строки bufferText:
            bufferText.deleteCharAt(index);
            }
        return resultText;
    }
}
