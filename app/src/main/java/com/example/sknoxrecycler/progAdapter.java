package com.example.sknoxrecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class progAdapter extends RecyclerView.Adapter<progAdapter.ProgViewHolder> {

    private String[] data;
    private ArrayList<String > mdata;
    public progAdapter(String[] data)
    {
       this.data=data;
    }
    Context context;
    @Override
    public ProgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_item_layout, parent, false);
        return new ProgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgViewHolder holder, int position) {
        String title=data[position];
        holder.txtTitle.setText(title);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ProgViewHolder extends RecyclerView.ViewHolder{
        ImageView imageIcon;
        TextView txtTitle;

        public ProgViewHolder(View itemView) {
            super(itemView);
            imageIcon= itemView.findViewById(R.id.imgIcon);
            txtTitle= itemView.findViewById(R.id.txtTitle);
        }
    }
}
