package com.bwie.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/22 11:29
 */

public class ShopCarAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<ShopCarBean> list;

    public ShopCarAdapter(Context context, ArrayList<ShopCarBean> list) {
        this.context=context;
        this.list =list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.lv_item,null);
            viewHolder.tv_title= (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.tv_price= (TextView) convertView.findViewById(R.id.tv_price);
            viewHolder.tv_count= (TextView) convertView.findViewById(R.id.tv_count);
            viewHolder.tv_checkBox= (CheckBox) convertView.findViewById(R.id.cb);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_title.setText(list.get(position).getTv_title());
        viewHolder.tv_price.setText(list.get(position).getTv_price()+"");
        viewHolder.tv_count.setText(list.get(position).getTv_count()+"");
        viewHolder.tv_checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断当前是否选中
                boolean checked=viewHolder.tv_checkBox.isChecked();
                list.get(position).setTv_checkBox(checked);
                //重新设置价格
                MainActivity mainActivity= (MainActivity) context;
                mainActivity.setPrice();
            }
        });
        //设置是否选中
        viewHolder.tv_checkBox.setChecked(list.get(position).isTv_checkBox());
        return convertView;
    }
    class ViewHolder{
        TextView tv_title,tv_price,tv_count;
        CheckBox tv_checkBox;
    }
}
