package edu.wsu.erikbuck.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.net.URL;
import java.util.List;

public class URLAdapter extends RecyclerView.Adapter<URLAdapter.MyViewHolder> {

    private List<String> URLList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
        }
    }


    public URLAdapter(List<String> URLList) {
        this.URLList = URLList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String url = URLList.get(position);
        holder.title.setText(url);
    }

    @Override
    public int getItemCount() {
        return URLList.size();
    }
}