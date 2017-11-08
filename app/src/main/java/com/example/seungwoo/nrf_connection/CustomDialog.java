package com.example.seungwoo.nrf_connection;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by seungwoo on 11/8/17.
 */

public class CustomDialog extends Dialog {

    private Activity activity;
    // 리스트뷰 어뎁터
//    private ListAdapter listAdapter;
    // 닫기 버튼
    private Button closeBtn;
    // 리스트뷰
//    public ListView listView;

    public CustomDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 메인 layout
        setContentView(R.layout.scan_device);

        closeBtn = (Button) findViewById(R.id.dialog_close_btn);
//        listView = (ListView) findViewById(R.id.listview);

        // 리스트뷰 설정
//        listView.setAdapter(listAdapter);
        // 버튼 리스너 설정
        closeBtn.setOnClickListener(
            new Button.OnClickListener() {
                public void onClick(View v) {
                    dismiss();
                }
            }
        );
    }

//    public CustomDialog(Activity activity, ListAdapter listAdapter) {
//        super(activity, android.R.style.Theme_Translucent_NoTitleBar);
//        this.activity = activity;
//        this.listAdapter = listAdapter;
//    }
}
