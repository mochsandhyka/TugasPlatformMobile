package com.example.asus.a1000animestories;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerView_Config {

    private Context mContext;
    private StoriesAdapter mStoriesAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Stories> stories, List<String> keys){
        mContext = context;
        mStoriesAdapter = new StoriesAdapter(stories, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mStoriesAdapter);
    }

    class StoriesItemView extends RecyclerView.ViewHolder{

        private TextView mjudul;
        private TextView mgenre;
        private TextView misi;

        private String key;

        public StoriesItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).
            inflate(R.layout.stories_list_item, parent, false));

            mjudul = (TextView) itemView.findViewById(R.id.judul_textView);
            mgenre = (TextView) itemView.findViewById(R.id.genre_textView);
            misi = (TextView) itemView.findViewById(R.id.isi_textView);
        }

        public void bind(Stories stories,String key){
            mjudul.setText(stories.getJudul());
            mgenre.setText(stories.getGenre());
            misi.setText(stories.getIsi());
            this.key = key;
        }



    }
    class StoriesAdapter extends RecyclerView.Adapter<StoriesItemView>{

        private List<Stories> mStoriesList;
        private List<String> mKeys;

        public StoriesAdapter(List<Stories> mStoriesList, List<String> mKeys) {
            this.mStoriesList = mStoriesList;
            this.mKeys = mKeys;


        }

        @NonNull
        @Override
        public StoriesItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new StoriesItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull StoriesItemView holder, int position) {
            holder.bind(mStoriesList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mStoriesList.size();
        }
    }
}
