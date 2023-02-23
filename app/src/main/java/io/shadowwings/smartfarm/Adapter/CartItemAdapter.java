package io.shadowwings.smartfarm.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import io.shadowwings.smartfarm.CartItemClickListener;
import io.shadowwings.smartfarm.Model.CartItemModel;
import io.shadowwings.smartfarm.Model.ProductModel;
import io.shadowwings.smartfarm.R;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartView> {
    private final List<CartItemModel> cart_list;
    CartItemClickListener cartItemClickListener;

    public class CartView extends RecyclerView.ViewHolder {

        TextView itemName,itemBrand,itemOffer,itemPrice,itemMRP,itemCount;
        ImageView itemImage;

        public CartView(View view) {
            super(view);
            itemName = view.findViewById(R.id.cart_item_brand_name);
            itemBrand = view.findViewById(R.id.cart_brandName);
            itemOffer = view.findViewById(R.id.cart_item_offer);
            itemPrice = view.findViewById(R.id.cart_item_price);
            itemMRP = view.findViewById(R.id.cart_item_mrp);
            itemImage = view.findViewById(R.id.cart_Item_img);
            itemCount=view.findViewById(R.id.cart_item_count);
        }

    }
    public CartItemAdapter(List<CartItemModel> verticalList, CartItemClickListener cartItemClickListener) {
        this.cart_list = verticalList;
        this.cartItemClickListener=cartItemClickListener;
    }

    @NonNull
    @Override
    public CartView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_card, parent, false);
        return new CartView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartView holder,  @SuppressLint("RecyclerView") final int position) {

        CartItemModel model = cart_list.get(position);
        Context context = holder.itemView.getContext();
        double discount=((model.PRICE- model.DEAL_PRICE)*100)/ model.PRICE;
        holder.itemName.setText(model.NAME);
        holder.itemBrand.setText(model.brandName);
        holder.itemPrice.setText(model.DEAL_PRICE+"");
        holder.itemMRP.setText(model.PRICE+"");
        holder.itemMRP.setPaintFlags(holder.itemMRP.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.itemOffer.setText("( "+String.format("%.2f",discount)+"% off on this order)");
        Picasso.get().load(model.URL).into(holder.itemImage);
    }

    @Override
    public int getItemCount() {
        return cart_list.size();
    }
}
