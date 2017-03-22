package com.bwie.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AbsListView.OnScrollListener {

    private Button all_select;
    private Button fan_select;
    private ListView listView;
    private ShopCarAdapter adapter;
    private ArrayList<ShopCarBean> list = new ArrayList<>();;
    private TextView text;
    //原始数据30条
    private int currentIndex=0;
    private int each_count=30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        all_select = (Button) findViewById(R.id.all_select);
        fan_select = (Button) findViewById(R.id.fan_select);
        listView = (ListView) findViewById(R.id.listView);
        text = (TextView) findViewById(R.id.price);
        initData();
        adapter = new ShopCarAdapter(this,list);
        listView.setAdapter(adapter);
        all_select.setOnClickListener(this);
        fan_select.setOnClickListener(this);
        listView.setOnScrollListener(this);
    }

    private void initData() {
        
        for (int i = currentIndex; i < currentIndex+each_count; i++) {
            list.add(new ShopCarBean("花花公子"+i,10+i,i));
        }
    }
    //计算价格/总价
    public void setPrice() {
        int price=0;
        for (int i = 0; i < list.size(); i++) {
            boolean flag=list.get(i).isTv_checkBox();
            if (flag){
                price+=list.get(i).getTv_price()*list.get(i).getTv_count();
            }
        }
        text.setText("总价格："+price);
    }
    //设置全选
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.all_select:
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setTv_checkBox(true);
                }
                adapter.notifyDataSetChanged();
                setPrice();
                break;
            case R.id.fan_select:
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setTv_checkBox(!list.get(i).isTv_checkBox());
                }
                adapter.notifyDataSetChanged();
                setPrice();
                break;
        }
       
        
    }
    //滑动状态改变监听
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        //判断他是否滑动到底部静止状态
        if (scrollState==AbsListView.OnScrollListener.SCROLL_STATE_IDLE){
            //最后一条可见条目
            int lastVisiblePosition = view.getLastVisiblePosition();
            if (lastVisiblePosition==list.size()-1){
                //添加数据
                currentIndex+=each_count;
                initData();
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
