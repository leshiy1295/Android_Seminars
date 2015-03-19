package com.example.ahalaidzhy.seminars;

import android.content.Intent;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.edit);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LocalService.class);
                intent.putExtra("max", 10);
                intent.putExtra("receiver", new MyReceiver());
                startService(intent);
            }
        });
    }

    public class MyReceiver extends ResultReceiver {
        public static final int RESULT_OK = 0;

        public MyReceiver() {
            super(new Handler());
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            if (resultCode == RESULT_OK) {
                mEditText.setText(resultData.getString("result"));
            }
            super.onReceiveResult(resultCode, resultData);
        }
    }
}
