package io.shadowwings.smartfarm.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import io.shadowwings.smartfarm.ItemListClickListener;
import io.shadowwings.smartfarm.Model.RentalItemModel;
import io.shadowwings.smartfarm.R;

public class RentalAdapter extends RecyclerView.Adapter<RentalAdapter.InsView> {
    private List<RentalItemModel> ins_list;
    private ItemListClickListener itemListClickListener;
    public static class InsView extends RecyclerView.ViewHolder {

        TextView INS_Name, INS_Rent;
        ImageView INS_Img;
        CardView instrumentcard;
        Button BTN_INQUIRY;

        public InsView(View itemView) {
            super(itemView);
            instrumentcard = itemView.findViewById(R.id.instrumentcard);
            INS_Name = itemView.findViewById(R.id.textView21);
            INS_Rent = itemView.findViewById(R.id.textView23);
            INS_Img = itemView.findViewById(R.id.imageView6);
            BTN_INQUIRY = itemView.findViewById(R.id.BTN_INQUIRY);

        }
    }

    public void updateList(List<RentalItemModel> horizontalList,ItemListClickListener itemListClickListener) {
        this.itemListClickListener = itemListClickListener;
        this.ins_list = horizontalList;
        notifyDataSetChanged();
    }

    public RentalAdapter(List<RentalItemModel> horizontalList, ItemListClickListener itemListClickListener) {
        this.itemListClickListener = itemListClickListener;
        this.ins_list = horizontalList;
    }

    @NonNull
    @Override
    public InsView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View insItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rent_instrument, parent, false);
        return new InsView(insItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final InsView holder, @SuppressLint("RecyclerView") final int position) {
        RentalItemModel modelIns = ins_list.get(position);
        holder.INS_Name.setText(modelIns.NAME);
        holder.INS_Rent.setText(modelIns.RENT + " Rs.");
        holder.BTN_INQUIRY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemListClickListener.onItemClicked(ins_list.get(position));
            }
        });
        Picasso.get().load(modelIns.URL).into(holder.INS_Img);
    }

    @Override
    public int getItemCount() {
        return ins_list.size();
    }


}
