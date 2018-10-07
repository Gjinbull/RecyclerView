package com.example.gaurav.recyclerviewexample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.gaurav.recyclerviewexample.R;
import com.example.gaurav.recyclerviewexample.adapter.SelectableAdapter;
import com.example.gaurav.recyclerviewexample.adapter.SelectableViewHolder;
import com.example.gaurav.recyclerviewexample.model.Item;
import com.example.gaurav.recyclerviewexample.model.SelectableItem;

import java.util.ArrayList;
import java.util.List;

public class MultipleSelectorActivity  extends AppCompatActivity implements SelectableViewHolder.OnItemSelectedListener {

    RecyclerView recyclerView;
    SelectableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_selector);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) this.findViewById(R.id.selection_list);
        recyclerView.setLayoutManager(layoutManager);
        List<Item> selectableItems = generateItems();
        adapter = new SelectableAdapter(this,selectableItems,false);
        recyclerView.setAdapter(adapter);
    }

    public List<Item> generateItems(){

        List<Item> selectableItems = new ArrayList<>();
        selectableItems.add(new Item("Gaurav","Gupta"));
        selectableItems.add(new Item("Saurabh","Verma"));
        selectableItems.add(new Item("Ram","Sharma"));
        selectableItems.add(new Item("Rohan","Singh"));
        selectableItems.add(new Item("Rajat","Porwal"));
        selectableItems.add(new Item("Nitin","Yadav"));
        selectableItems.add(new Item("Sachin","Saini"));
        selectableItems.add(new Item("Ankur","Jain"));
        selectableItems.add(new Item("Rajat","Porwal"));

        return selectableItems;
    }

    @Override
    public void onItemSelected(SelectableItem selectableItem) {

        List<Item> selectedItems = adapter.getSelectedItems();
        Toast.makeText(getApplicationContext(),"Selected item is "+selectableItem.getName()+
                ", Totally  selectem item count is "+selectedItems.size(),Toast.LENGTH_LONG).show();
    }

    private void newMethod()
    {
        String test = "Test";
    }
}
