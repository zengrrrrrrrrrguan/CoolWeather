package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        this.textView=(TextView) findViewById(R.id.abc);
        String weatherId="CN101020200";
        String weatherUrl = "http://guolin.tech/api/weather?cityid=" + weatherId + "&key=36106df4462540a8bb58ad9bb847526e";

        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException{

                final String responseText = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        textView.setText(responseText);
                    }
                });
                textView.setText(responseText);
            }

            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }
        });
    }
}


