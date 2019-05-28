package com.example.sknoxrecycler;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerview;
  RecyclerView.Adapter mAdapter;
 //  RecyclerView.LayoutManager mLayoutManager;

    List<String> myDataSet =new ArrayList<>();

    private static final String Tag = "RecyclerViewAdapter";
    String[] abc={"test 1","Test 2","Test 3","Test 4","Test 5","Test 6","Test 7","Test 8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RecyclerView progList = findViewById(R.id.programmingList);
        progList.setLayoutManager(new LinearLayoutManager(this));
        progList.setAdapter(new progAdapter(abc));


        RecyclerView.ItemDecoration divider=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        progList.addItemDecoration(divider);

        //drag and drop
        ItemTouchHelper helper=new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,0) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder dragged, RecyclerView.ViewHolder target) {

                
                int position_dragged =dragged.getAdapterPosition();
                int position_target = target.getAdapterPosition();
                List<String> data=Arrays.asList(abc);

               // Collections.swap(data,position_dragged,position_target);
               // new progAdapter(abc).notifyItemMoved(position_dragged,position_target);

                if (position_dragged < position_target) {
                    for (int i = position_dragged; i < position_target; i++) {
                        Collections.swap(data, i, i + 1);
                    }
                } else {
                    for (int i = position_dragged; i > position_target; i--) {
                        Collections.swap(data, i, i - 1);
                    }
                }



               progList.setAdapter(new progAdapter(abc));

                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });
    helper.attachToRecyclerView(progList);
    }

}
