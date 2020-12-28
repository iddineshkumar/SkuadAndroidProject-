package com.skuad.skuadrestaurantsapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.skuad.skuadrestaurantsapp.R;
import com.skuad.skuadrestaurantsapp.responsepojo.RestaurantsResultsResponse;

import java.util.List;


public class RestaurantsResultsAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final String TAG = "RestaurantsResultsAdapter";
    private final List<RestaurantsResultsResponse.ResultsBean> predictionsBeanList;
    private final Context context;

    RestaurantsResultsResponse.ResultsBean currentItem;

    public RestaurantsResultsAdapter(Context context, List<RestaurantsResultsResponse.ResultsBean> predictionsBeanList) {
        this.predictionsBeanList = predictionsBeanList;
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_restaurants, parent, false);
        return new ViewHolderOne(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        initLayoutOne((ViewHolderOne) holder, position);


    }

    @SuppressLint("SetTextI18n")
    private void initLayoutOne(ViewHolderOne holder, final int position) {
        currentItem = predictionsBeanList.get(position);
             if(currentItem.getName() != null){
                 holder.txt_restname.setText(currentItem.getName());
             } if(currentItem.getRating() != 0){
                 holder.txt_rating.setText(currentItem.getRating()+"");
             }

        if (currentItem.getIcon() != null && !currentItem.getIcon().isEmpty()) {
            Glide.with(context)
                    .load(currentItem.getIcon())
                    .into(holder.img_rest_imge);
        }
        else{
            Glide.with(context)
                    .load(R.drawable.image_thumbnail)
                    .into(holder.img_rest_imge);

        }






   }

    @Override
    public int getItemCount() {
        return predictionsBeanList.size();
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class ViewHolderOne extends RecyclerView.ViewHolder {
        public TextView txt_restname,txt_rest_food,txt_rating;
        public ImageView img_rest_imge;



        public ViewHolderOne(View itemView) {
            super(itemView);

            img_rest_imge = itemView.findViewById(R.id.img_rest_imge);
            txt_restname = itemView.findViewById(R.id.txt_restname);
            txt_rest_food = itemView.findViewById(R.id.txt_rest_food);
            txt_rating = itemView.findViewById(R.id.txt_rating);



        }




    }







}
