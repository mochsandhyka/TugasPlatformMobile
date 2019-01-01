package com.example.asus.a1000animestories;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {


    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceStories;
    private List<Stories> storiess = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Stories> storiess, List<String> keys);
        void DataIsInserted();
        void DataisUpdated();
        void DataisDeleted();
    }

    public FirebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceStories = mDatabase.getReference("stories");
    }

    public void readStories(final DataStatus dataStatus){
        mReferenceStories.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                storiess.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Stories stories = keyNode.getValue(Stories.class);
                    storiess.add(stories);
                }
                dataStatus.DataIsLoaded(storiess,keys);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}