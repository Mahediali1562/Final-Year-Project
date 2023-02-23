package io.shadowwings.smartfarm.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.shadowwings.smartfarm.Adapter.MainPostAdapter;
import io.shadowwings.smartfarm.Adapter.ProductAdapter;
import io.shadowwings.smartfarm.Model.MainPostModel;
import io.shadowwings.smartfarm.Model.ProductModel;
import io.shadowwings.smartfarm.ProductDetails;
import io.shadowwings.smartfarm.ProductListClickListener;
import io.shadowwings.smartfarm.R;

public class SearchFragment extends Fragment {

    RecyclerView PRODUCT_RECYCLE;
    DatabaseReference ROOT;
    ConstraintLayout PROGRESS;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ROOT = FirebaseDatabase.getInstance("https://smart-farm-c9ae4-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();
        PRODUCT_RECYCLE = view.findViewById(R.id.PRODUCT_RECYCLE);
        PROGRESS = view.findViewById(R.id.PROGRESS);
        PROGRESS.setVisibility(View.VISIBLE);

        RETRIEVE_PRODUCTS();
    }

    public void RETRIEVE_PRODUCTS() {
        List<ProductModel> LIST = new ArrayList<>();
        ROOT.child("PRODUCTS").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snap: snapshot.getChildren()){
                    LIST.add(new ProductModel(snap.child("NAME").getValue().toString(),snap.child("DESCRIPTION").getValue().toString(),
                            snap.child("URL").getValue().toString(), snap.child("brandName").getValue().toString(), snap.getKey().toString(),
                            snap.child("DEAL_PRICE").getValue().toString(), snap.child("PRICE").getValue().toString()));
                }
                ProductAdapter adapter = new ProductAdapter(LIST);
                PRODUCT_RECYCLE.setAdapter(adapter);
                PRODUCT_RECYCLE.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                PROGRESS.setVisibility(View.GONE);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "Unknown error occurred", Toast.LENGTH_SHORT).show();
            }
        });
    }

}