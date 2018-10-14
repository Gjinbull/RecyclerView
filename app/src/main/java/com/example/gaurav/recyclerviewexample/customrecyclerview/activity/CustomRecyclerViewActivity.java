package com.example.gaurav.recyclerviewexample.customrecyclerview.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gaurav.recyclerviewexample.R;
import com.example.gaurav.recyclerviewexample.activity.BaseActivity;
import com.example.gaurav.recyclerviewexample.customrecyclerview.adapter.CustomAdapter;
import com.example.gaurav.recyclerviewexample.customrecyclerview.interfaces.ClickListener;
import com.example.gaurav.recyclerviewexample.customrecyclerview.model.CustomDataModel;

import java.util.ArrayList;

public class CustomRecyclerViewActivity extends BaseActivity {
    private ArrayList<CustomDataModel> dataModelArrayList = new ArrayList<>();
    CustomAdapter adapter;
    RecyclerView rcvDataList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_recycler_view);
        rcvDataList = findViewById(R.id.rcvDataList);

        setAdapter();
    }

    private void setAdapter() {
        //set Data
        for(int i=1;i<=50;i++)
        {
            CustomDataModel model = new CustomDataModel();
            model.setName("Gaurav Gupta");
            model.setContent("Hii, My name is Gaurav");
            model.setDate("05/10/2018");
            dataModelArrayList.add(model);
        }

        rcvDataList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter(this);
        adapter.setContentListData(dataModelArrayList);
        rcvDataList.setAdapter(adapter);

        rcvDataList.addOnItemTouchListener(new RecyclerViewTouchListener(this, rcvDataList, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                Toast.makeText(CustomRecyclerViewActivity.this,"Single Click : "+position,Toast.LENGTH_SHORT).show();
                ImageView ivPicture = view.findViewById(R.id.ivPicture);
                ivPicture.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(CustomRecyclerViewActivity.this,"On Click Image : "+position,Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(CustomRecyclerViewActivity.this,"Long Click : "+position,Toast.LENGTH_SHORT).show();
            }
        }));
    }

    public class RecyclerViewTouchListener implements RecyclerView.OnItemTouchListener{
        private ClickListener clickListener;
        private GestureDetector gestureDetector;

        public RecyclerViewTouchListener(Context context,final RecyclerView recyclerView,final ClickListener clickListener)
        {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    super.onLongPress(e);
                    View child = recyclerView.findChildViewUnder(e.getX(),e.getY());
                    if(child !=null && clickListener!=null)
                    {
                       clickListener.onLongClick(child,recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(),e.getY());
            if(child != null && clickListener!=null && gestureDetector.onTouchEvent(e))
            {
                clickListener.onClick(child,rv.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
