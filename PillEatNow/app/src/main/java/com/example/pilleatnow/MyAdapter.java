package com.example.pilleatnow;

import android.graphics.drawable.Icon;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<PillData> mDataset;
    private int mode;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView pill_char;
        public ImageView pill_yes, pill_no;
        public TextView pill_name;
        public TextView pill_dos;
        public boolean yes=false, no=false;
        public MyViewHolder(View v) {
            super(v);
            pill_char=v.findViewById(R.id.pill_char);
            pill_name=v.findViewById(R.id.pill_name);
            pill_dos=v.findViewById(R.id.pill_dosage);
            pill_yes=v.findViewById(R.id.pill_yes);
            pill_no=v.findViewById(R.id.pill_no);

            pill_yes.setClickable(true);
            pill_no.setClickable(true);

            pill_yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    yes=!yes;
                    if(yes) {
                        pill_yes.setImageResource(R.drawable.pill_yes_c);
                        pill_no.setImageResource(R.drawable.pill_no);
                    }
                    else pill_yes.setImageResource(R.drawable.pill_yes);
                    int pos = getAdapterPosition();
                }
            });
            pill_no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    no=!no;
                    if(no){
                        pill_no.setImageResource(R.drawable.pill_no_c);
                        pill_yes.setImageResource(R.drawable.pill_yes);
                    }
                    else pill_no.setImageResource(R.drawable.pill_no);
                    int pos = getAdapterPosition();
                }
            });
        }
    }

    public MyAdapter(List<PillData> myDataset, int myMode) {
        Log.d("MyAdapter", "mode: "+String.valueOf(myMode));
        mDataset = myDataset;
        mode=myMode;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_pill, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PillData pillX=mDataset.get(position);
        if(mode==1) {
            if(pillX.getPill_dosage()>=2) {
                Log.d("mode1", mDataset.get(position).getPill_name());
                holder.pill_char.setImageResource(pillX.getPill_char());
                holder.pill_name.setText(mDataset.get(position).getPill_name());
                holder.pill_yes.setImageResource(R.drawable.pill_yes);
                holder.pill_no.setImageResource(R.drawable.pill_no);
                holder.pill_dos.setText("아침약");
            }
        }
        else if(mode==2) {
            if(pillX.getPill_dosage()>=3) {
                Log.d("mode2", mDataset.get(position).getPill_name());
                holder.pill_char.setImageResource(pillX.getPill_char());
                holder.pill_name.setText(mDataset.get(position).getPill_name());
                holder.pill_yes.setImageResource(R.drawable.pill_yes);
                holder.pill_no.setImageResource(R.drawable.pill_no);
                holder.pill_dos.setText("점심약");
            }
        }
        else if(mode==3) {
            if(pillX.getPill_dosage()>=1) {
                Log.d("mode3", mDataset.get(position).getPill_name());
                holder.pill_char.setImageResource(pillX.getPill_char());
                holder.pill_name.setText(mDataset.get(position).getPill_name());
                holder.pill_yes.setImageResource(R.drawable.pill_yes);
                holder.pill_no.setImageResource(R.drawable.pill_no);
                holder.pill_dos.setText("저녁약");
            }
        }
    }
    @Override
    public int getItemCount() {
        return mDataset==null?0:mDataset.size();
    }
}
