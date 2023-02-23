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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.shadowwings.smartfarm.Adapter.CartItemAdapter;
import io.shadowwings.smartfarm.Adapter.ProductAdapter;
import io.shadowwings.smartfarm.CartItemClickListener;
import io.shadowwings.smartfarm.Model.CartItemModel;
import io.shadowwings.smartfarm.Model.ProductModel;
import io.shadowwings.smartfarm.ProductDetails;
import io.shadowwings.smartfarm.R;

public class ShoppingCartFragment extends Fragment {

    RecyclerView cartItemRecycler;
    DatabaseReference root;
    ConstraintLayout progress;
    List<CartItemModel> productList = new ArrayList<>();
    CartItemAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shopig_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        root = FirebaseDatabase.getInstance("https://smart-farm-c9ae4-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();
        cartItemRecycler=view.findViewById(R.id.cart_recycler);
        progress=view.findViewById(R.id.cartProgress);
        progress.setVisibility(View.VISIBLE);

        adapter=new CartItemAdapter(productList, new CartItemClickListener() {
            @Override
            public void onItemClicked(CartItemModel model) {
                Intent i = new Intent(getActivity(), ProductDetails.class);
                Toast.makeText(requireContext(), "Click on item", Toast.LENGTH_LONG).show();
                i.putExtra("item", model);
                startActivity(i);
            }
        });
        cartItemRecycler.setAdapter(adapter);
        cartItemRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        cartItemRecycler.setVisibility(View.GONE);
        retrive_cart_items();
    }

    private void retrive_cart_items() {
        root.child("CART").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                try {
                    for (DataSnapshot d : snapshot.getChildren()) {
                        CartItemModel tD = d.getValue(CartItemModel.class);
                        productList.add(tD);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.e("Cart Item listed", new Gson().toJson(productList));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "Unknown error occurred", Toast.LENGTH_SHORT).show();

            }
        });
    }

}