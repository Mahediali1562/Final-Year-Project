package io.shadowwings.smartfarm.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.shadowwings.smartfarm.Model.MainPostModel;
import io.shadowwings.smartfarm.R;

public class MainPostAdapter extends RecyclerView.Adapter<MainPostAdapter.MyView> {

    private List<MainPostModel> list;

    public class MyView extends RecyclerView.ViewHolder{

        TextView TXT_TITLE, TXT_ITEM_USERNAME;
        TextView TXT_ITEM_TIME;
        ImageView IMG_ITEM;

        public MyView(View view) {
            super(view);
            TXT_ITEM_USERNAME = view.findViewById(R.id.TXT_ITEM_USERNAME);
            TXT_TITLE = (TextView)view.findViewById(R.id.TXT_POST_TITLE);
            TXT_ITEM_TIME = view.findViewById(R.id.TXT_ITEM_TIME);
            IMG_ITEM = view.findViewById(R.id.IMG_ITEM);
            IMG_ITEM.setVisibility(View.GONE);
        }
    }

    public MainPostAdapter(List<MainPostModel> horizontalList) {
        this.list = horizontalList;
    }

    @Override
    public MyView onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final MyView holder, @SuppressLint("RecyclerView") final int position) {
        holder.TXT_TITLE.setText(list.get(position).getPOST_TITLE());
        holder.TXT_ITEM_USERNAME.setText(list.get(position).getPOST_ID());
        holder.TXT_ITEM_TIME.setText("Uploaded " + ToDuration(System.currentTimeMillis() - Long.parseLong(list.get(position).getPOST_TIME())));


        if (list.get(position).getPOST_TYPE().equals("IMAGE")){
            Picasso.get().load(list.get(position).getPOST_URL()).into(holder.IMG_ITEM);
            holder.IMG_ITEM.setVisibility(View.VISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), "You got it", Toast.LENGTH_SHORT).show();
            }
        });
    }

    List<Long> times = Arrays.asList(
                TimeUnit.DAYS.toMillis(365),
                TimeUnit.DAYS.toMillis(30),
                TimeUnit.DAYS.toMillis(1),
                TimeUnit.HOURS.toMillis(1),
                TimeUnit.MINUTES.toMillis(1),
                TimeUnit.SECONDS.toMillis(1) );

    List<String> timesString = Arrays.asList("year","month","day","hour","minute","second");

    String ToDuration(long duration) {
        StringBuffer res = new StringBuffer();
        for(int i=0;i< times.size(); i++) {
            Long current = times.get(i);
            long temp = duration/current;
            if(temp>0) {
                res.append(temp).append(" ").append(timesString.get(i) ).append(temp != 1 ? "s" : "").append(" ago");
                break;
            }
        }
        if("".equals(res.toString()))
            return "0 seconds ago";
        else
            return res.toString();
    }

    @Override
    public int getItemCount() { return list.size(); }
}