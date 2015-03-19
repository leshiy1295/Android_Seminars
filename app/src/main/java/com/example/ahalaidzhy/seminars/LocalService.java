package com.example.ahalaidzhy.seminars;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

import java.util.Random;

/**
 * Created by a.halaidzhy on 19.03.15.
 */
public class LocalService extends IntentService {

    public LocalService(String name) {
        super(name);
    }

    public LocalService() {
        super("LocalService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        ResultReceiver recv = (intent.getParcelableExtra("receiver"));
        Random rnd = new Random();
        Integer max = intent.getIntExtra("max", 10);
        Bundle bundle = new Bundle();
        Integer result = rnd.nextInt(max);
        Log.d("Log", result.toString());
        bundle.putString("result", result.toString());
        recv.send(MainActivity.MyReceiver.RESULT_OK, bundle);
    }
}
