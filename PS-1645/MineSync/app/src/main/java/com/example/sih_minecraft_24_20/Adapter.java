package com.example.sih_minecraft_24_20;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ItemClickListerner listerner;
    private final Context context;
    public TextView pdfTitle;
    public Adapter(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
        pdfTitle = itemView.findViewById(R.id.pdfTitle);
    }

    @Override
    public void onClick(View view) {
        listerner.onClick(view,getAdapterPosition(),false);

    }
}
