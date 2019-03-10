package com.ar.argallery.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ar.argallery.ArActivity;
import com.ar.argallery.R;
import com.ar.argallery.models.GalleryListItem;

import java.util.List;

public class GalleryListAdapter extends RecyclerView.Adapter<GalleryListAdapter.ListItemViewHolder> {
    private List<GalleryListItem> data;
    private Context context;

    public GalleryListAdapter(List<GalleryListItem> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.gallery_list_item, parent, false);
        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder holder, int position) {
        final GalleryListItem currentData = data.get(position);
        holder.imageView.setImageURI(null);
        holder.imageView.setImageURI(currentData.thumbnailUri);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ArActivity.class);
                intent.putExtra("model_location", currentData.modelLocation);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ListItemViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView imageView;
        public ListItemViewHolder(View view) {
            super(view);
            this.view = view;
            imageView = view.findViewById(R.id.list_item_image);
        }
    }

}
