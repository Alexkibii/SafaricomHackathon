package com.example.a52weekschallenge.Adapter;


import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a52weekschallenge.R;
import com.example.a52weekschallenge.models.WeekModel;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<WeekModel> mWeek;

    private LayoutInflater mInflater;


    // data is passed into the constructor
    public MyRecyclerViewAdapter(Context context, List<WeekModel> weekModel) {
        this.mInflater = LayoutInflater.from(context);
        this.mWeek = weekModel;

    }

    public MyRecyclerViewAdapter(TextWatcher textWatcher, List<WeekModel> weekModels) {
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       WeekModel weekModel = mWeek.get(position);

       holder.weekTv.setText(String.valueOf(weekModel.getWeek()));
       holder.depositTv.setText(String.valueOf(weekModel.getAmount()));
       holder.totalTv.setText(String.valueOf(weekModel.getTotal()));
        // so that it knows what item in mDataset to update

    }

    // total number of rows
    @Override
    public int getItemCount() {


        int itemcount = mWeek.size();
        //return mWeek == null ? 0 : mWeek.size();
        return itemcount;
    }





    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView weekTv;
        TextView depositTv;
        TextView totalTv;

        ViewHolder(View itemView) {
            super(itemView);
            weekTv = itemView.findViewById(R.id.tvWeeks);
            depositTv = itemView.findViewById(R.id.tvDeposit);
            totalTv = itemView.findViewById(R.id.tvTotal);

        }




    }







}