package io.shadowwings.smartfarm.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import io.shadowwings.smartfarm.R;

public class EditProfileActivity extends AppCompatActivity {

    ImageButton DonNotSaveChanges;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        DonNotSaveChanges=findViewById(R.id.dontsaveit);
        DonNotSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}