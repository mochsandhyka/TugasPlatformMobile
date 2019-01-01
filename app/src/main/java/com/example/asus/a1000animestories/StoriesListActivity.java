package com.example.asus.a1000animestories;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class StoriesListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_stories);
        new FirebaseDatabaseHelper().readStories(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Stories> storiess, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView,StoriesListActivity.this, storiess,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataisUpdated() {

            }

            @Override
            public void DataisDeleted() {

            }
        });
    }
}
