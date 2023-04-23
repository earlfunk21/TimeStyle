package com.shopnow.timestyle.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.shopnow.timestyle.R;
import com.shopnow.timestyle.activities.ProductActivity;
import com.shopnow.timestyle.models.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder>{

    private Context mContext;
    private List<Product> mData;

    public ProductAdapter(Context mContext, List<Product> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.product_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyViewHolder holder, int position) {
        int thumbnail = mData.get(position).getThumbnail();
        String name = mData.get(position).getName();
        String price = "₱" + mData.get(position).getPrice();
        holder.iv_product_thumbnail.setImageResource(thumbnail);
        holder.tv_product_name.setText(name);
        holder.tv_product_price.setText(price);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, ProductActivity.class);
                mIntent.putExtra("thumbnail", thumbnail);
                mIntent.putExtra("name", name);
                mIntent.putExtra("price", price);
                mContext.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_product_name, tv_product_price;
        ImageView iv_product_thumbnail;

        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_product_name = itemView.findViewById(R.id.tv_product_name);
            tv_product_price = itemView.findViewById(R.id.tv_product_price);
            iv_product_thumbnail = itemView.findViewById(R.id.iv_product_thumbnail);
            cardView = itemView.findViewById(R.id.product_view);
        }
    }
}
