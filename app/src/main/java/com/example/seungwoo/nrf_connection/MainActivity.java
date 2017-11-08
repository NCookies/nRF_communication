package com.example.seungwoo.nrf_connection;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static CustomDialog customDialog;

//    private Activity activity;
    public static ListViewAdapter listviewadapter;

    private Button connectBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adapter 클래스 생성
//        listviewadapter = new ListViewAdapter(activity);

        customDialog = new CustomDialog(this);

        connectBtn = (Button) findViewById(R.id.connect_btn);
        connectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.show();

                customDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        System.out.println("Hello World");
                    }
                });
            }
        });
    }
}
