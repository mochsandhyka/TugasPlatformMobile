package com.example.asus.a1000animestories;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_fragment, container, false);

        List<String> list = new ArrayList<>();
        list.add("Malin Kundang");
        list.add("Roro Jonggrang");
        list.add("Nanatsu No Taizai");
        list.add("Kuzu No Honkai");
        list.add("Free Time");

        RecyclerView recyclerView  = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerViewAdapter(list));

        return view;
    }

    public static Fragment newInstance() {
        return new RecyclerFragment();
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private CardView mCardView;
        private TextView mTextView;
        public RecyclerViewHolder(View itemView){
            super(itemView);
        }
        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup container){
            super(inflater.inflate(R.layout.card_view, container,false
            ));

            mCardView = itemView.findViewById(R.id.card_container);
            mTextView = itemView.findViewById(R.id.text_holder);

        }
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

        List<String> mList;
        public RecyclerViewAdapter(List<String> list){
            this.mList = list;

        }

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new RecyclerViewHolder(inflater,viewGroup);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int position) {
            recyclerViewHolder.mTextView.setText(mList.get(position));

        }

        @Override
        public int getItemCount() {
            return mList.size();
        }
    }
}
