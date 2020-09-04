package com.example.pilleatnow;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class PillAdapter extends RecyclerView.Adapter<PillAdapter.MyViewHolder> {
    private List<PillData> mDataset;
    Context mContext;
    private UserData mUserData;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView pill_char;
        public TextView pill_name;
        public TextView pill_dos;
        public ImageView del_pill;
        public ImageView add_stock;
        public MyViewHolder(View v) {
            super(v);
            pill_char=v.findViewById(R.id.pill_char);
            pill_name=v.findViewById(R.id.pill_name);
            pill_dos=v.findViewById(R.id.pill_dosage);
            del_pill=v.findViewById(R.id.del_pill);
            del_pill.setClickable(true);
            add_stock=v.findViewById(R.id.add_stock);
            add_stock.setClickable(true);
        }
    }
    public PillAdapter(UserData myDataset, Context context) {
        mDataset = myDataset.pillData;
        mUserData=myDataset;
        mContext=context;
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
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        PillData pillX=mDataset.get(position);
        holder.pill_char.setImageResource(pillX.getPill_char());
        holder.pill_name.setText(mDataset.get(position).getPill_name()+" ("+mDataset.get(position).getPill_stock()+"정)");
        holder.add_stock.setImageResource(R.drawable.add_stock);
        holder.add_stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("약 추가");
                builder.setMessage("추가 할 약의 양을 입력해주세요.");
                final EditText et=new EditText(mContext);
                builder.setView(et);
                builder.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(et.getText().toString()!=null) {
                                    int addition=Integer.parseInt(et.getText().toString());
                                    mDataset.get(position).addPill_stock(addition);
                                    Toast.makeText(mContext,
                                            "약 "+mDataset.get(position).getPill_name()+"가"+addition+"정 추가되었습니다.",
                                            Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }
                            }
                        });
                builder.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                builder.show();
            }
        });
        holder.del_pill.setImageResource(R.drawable.del_pill);
        holder.del_pill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("삭제");
                builder.setMessage("해당 약을 삭제하시겠습니까?");
                builder.setPositiveButton("예",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                mUserData.delPillData(position);
                                notifyItemRemoved(position);
                                notifyItemRangeChanged(position, mDataset.size());
                                Log.d("PillAdapter", "delClicked: "+position);
                            }
                        });
                builder.setNegativeButton("아니오",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                builder.show();
            }
        });
        holder.pill_dos.setText(Integer.toString(pillX.getPill_dosage()));
    }
    @Override
    public int getItemCount() {
        return mDataset==null?0:mDataset.size();
    }
}
