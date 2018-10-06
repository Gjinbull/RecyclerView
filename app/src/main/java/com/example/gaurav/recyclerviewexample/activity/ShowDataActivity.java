package com.example.gaurav.recyclerviewexample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gaurav.recyclerviewexample.R;
import com.example.gaurav.recyclerviewexample.adapter.ShowDataAdapter;

public class ShowDataActivity extends BaseActivity {
    private RecyclerView rcvList;
    private ShowDataAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        rcvList = findViewById(R.id.rcvList);

        rcvList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShowDataAdapter(this);
        rcvList.setAdapter(adapter);

    }
}
