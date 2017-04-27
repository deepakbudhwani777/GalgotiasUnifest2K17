package com.gquasar.galgotiasunifest2017;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Prakhar on 1/10/2017.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public ImageView imageview;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        this.title = (TextView) itemView.findViewById(R.id.card_item_text);
        this.imageview = (ImageView) itemView.findViewById(R.id.card_item_image);
    }
}
