package com.gquasar.galgotiasunifest2017;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Prakhar on 1/10/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder>
{
    ArrayList<DataModel> arrayList;
    private Context context;

    public RecyclerAdapter(ArrayList<DataModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.cardview, parent, false);

        RecyclerViewHolder listHolder = new RecyclerViewHolder(mainGroup);

        return listHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        final DataModel model = arrayList.get(position);

        RecyclerViewHolder mainHolder = (RecyclerViewHolder) holder;// holder

        Bitmap image = BitmapFactory.decodeResource(context.getResources(),
                model.getImage());

        mainHolder.title.setText(model.getTitle());

        mainHolder.imageview.setImageBitmap(image);
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }

}