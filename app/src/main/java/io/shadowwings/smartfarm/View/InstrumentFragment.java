package io.shadowwings.smartfarm.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.shadowwings.smartfarm.Adapter.RentalAdapter;
import io.shadowwings.smartfarm.Model.RentalItemModel;
import io.shadowwings.smartfarm.InstrumentDetails;
import io.shadowwings.smartfarm.ItemListClickListener;
import io.shadowwings.smartfarm.R;

public class InstrumentFragment extends Fragment {
    RecyclerView RENTAL_RECYCLE;
    DatabaseReference ROOT;
    ConstraintLayout PROGRESS;
    List<RentalItemModel> itemList = new ArrayList<>();
    RentalAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rental, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ROOT = FirebaseDatabase.getInstance("https://smart-farm-c9ae4-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();
        RENTAL_RECYCLE = view.findViewById(R.id.PRODUCT_RECYCLE2);
        PROGRESS = view.findViewById(R.id.PROGRESS_INS);
        PROGRESS.setVisibility(View.VISIBLE);

        adapter = new RentalAdapter(itemList,new ItemListClickListener(){
            @Override
            public void onItemClicked(RentalItemModel model) {
                Intent i = new Intent(getActivity(), InstrumentDetails.class);
                Toast.makeText(requireContext(), "Click on item", Toast.LENGTH_LONG).show();
                i.putExtra("item",model);
                startActivity(i);
            }
        });

        RENTAL_RECYCLE.setAdapter(adapter);
        //RENTAL_RECYCLE.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        PROGRESS.setVisibility(View.GONE);
        RETRIEVE_INSTRUMENT();
    }


    public void RETRIEVE_INSTRUMENT() {
        ROOT.child("INSTRUMENT").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                try {
                    for (DataSnapshot d : snapshot.getChildren()) {
                        RentalItemModel ins = d.getValue(RentalItemModel.class);
                        itemList.add(ins);
                    }
//                    adapter.updateList(itemList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.e("Item listed", new Gson().toJson(itemList));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "Unknown error occurred", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
