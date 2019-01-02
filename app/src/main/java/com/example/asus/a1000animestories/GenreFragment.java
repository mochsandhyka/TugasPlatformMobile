package com.example.asus.a1000animestories;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GenreFragment extends Fragment  {

    RecyclerView recyclerView;
    View view;
    ProgressDialog progressDialog;
    RecyclerView_Config recyclerView_config;
    private List<Stories> dataset = new ArrayList<>();
    private List<String> mDatakey = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.genre_fragment,container,false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        init();
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Sync");
        progressDialog.setCancelable(false);
        progressDialog.show();
        loaddatabase();
    }

    private void loaddatabase() {
        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("stories");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                dataset.clear();
                mDatakey.clear();
                for(DataSnapshot single:dataSnapshot.getChildren()){
                    dataset.add(single.getValue(Stories.class));
                    mDatakey.add(single.getKey().toString());
                }

                progressDialog.dismiss();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void init() {

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview_stories);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


    }

}
