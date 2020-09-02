package com.example.pilleatnow;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PillAdapter extends RecyclerView.Adapter<PillAdapter.MyViewHolder> {
    private List<PillData> mDataset;
    private static int delIndex=-1;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView pill_char;
        public TextView pill_name;
        public TextView pill_dos;
        public ImageView del_pill;
        public MyViewHolder(View v) {
            super(v);
            pill_char=v.findViewById(R.id.pill_char);
            pill_name=v.findViewById(R.id.pill_name);
            pill_dos=v.findViewById(R.id.pill_dosage);
            del_pill=v.findViewById(R.id.del_pill);
            del_pill.setClickable(true);
            del_pill.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    delIndex=pos;
                }
            });
        }
    }
    public static int getDelIndex() {
        return delIndex;
    }
    public void resetDelIndex() {
        delIndex=-1;
    }
    public PillAdapter(List<PillData> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public PillAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_pillpage, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PillData pillX=mDataset.get(position);
        Log.d("mode1", mDataset.get(position).getPill_name());
        holder.pill_char.setImageResource(pillX.getPill_char());
        holder.pill_name.setText(mDataset.get(position).getPill_name());
        holder.del_pill.setImageResource(R.drawable.del_pill);
        holder.pill_dos.setText(Integer.toString(pillX.getPill_dosage()));
    }
    @Override
    public int getItemCount() {
        return mDataset==null?0:mDataset.size();
    }
}
