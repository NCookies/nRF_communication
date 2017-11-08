package com.example.seungwoo.nrf_connection;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by seungwoo on 11/8/17.
 */

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<String> list;
    private Activity activity;

    // 생성할 클래스
    ListViewAdapter(Activity activity){
        this.activity = activity;
        list = new ArrayList<String>();
    }

    // 리스트에 값을 추가할 메소드
    public void setName(String name)
    {
        list.add(name);
    }
    @Override
    public int getCount() {
        // 리스트뷰 갯수 리턴
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // 리스트 값 리턴
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewHolder    holder  = null;
        final int pos = position;
        TextView name;

        // 최초 뷰 생성
        if(convertView == null)
        {
//            LayoutInflater inflater = (LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//            convertView = inflater.inflate(R.layout.list_row, parent, false);
//            name    = (TextView) convertView.findViewById(R.id.name_text);
//
//            holder = new ListViewHolder();
//            holder.name = "Hello";
//
//            // list values save
//            convertView.setTag(holder);
//            // 텍스트 보이기
//            name.setVisibility(View.VISIBLE);
        }
        else
        {
            // list values get
            holder = (ListViewHolder) convertView.getTag();
            name = holder.name;
        }

        // 리스트 아이템을 터치 했을 때 이벤트 발생
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity.getApplicationContext(), "선택한 이름:" + list.get(pos), Toast.LENGTH_SHORT).show();
            }
        });

        // 리스트 아이템을 길게 터치 했을 떄 이벤트 발생
        convertView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(activity.getApplicationContext(), list.get(pos) + " 삭제합니다.", Toast.LENGTH_SHORT).show();
                // list choice remove
                list.remove(pos);
                // listview update
//                MainActivity.customDialog.listView.clearChoices();
                MainActivity.listviewadapter.notifyDataSetChanged();
                return false;
            }
        });

        return convertView;
    }

    // list values class
    private class ListViewHolder {
        TextView name;
    }
}