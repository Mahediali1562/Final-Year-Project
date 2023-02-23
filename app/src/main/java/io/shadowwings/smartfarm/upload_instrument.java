package io.shadowwings.smartfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class upload_instrument extends AppCompatActivity {

    TextView cancle_Button;
    Button submit_Instrument;
    EditText ins_Name, ins_model, ins_own_name, ins_con, ins_fault, ins_puc_date, ins_con_num, ins_ava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_instrument);
        cancle_Button = findViewById(R.id.cancle_add_ins);
        cancle_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        submit_Instrument = findViewById(R.id.submit_ins_button);
        submit_Instrument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isAllFieldsChecked = CheckAllFields();

                // the boolean variable turns to be true then
                // only the user must be proceed to the activity2
                if (isAllFieldsChecked) {
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "First Finish All Details !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean CheckAllFields() {
        ins_Name = findViewById(R.id.USER_NAME);
        ins_model = findViewById(R.id.USER_PHONE_NUMBER);
        ins_own_name = findViewById(R.id.USER_MAIL);
        ins_con = findViewById(R.id.USER_BDAY);
        ins_fault = findViewById(R.id.USER_ADDRESS);
        ins_puc_date = findViewById(R.id.USER_LOCATION);
        ins_con_num = findViewById(R.id.INSTRUMENT_CONTACT_NUMBER);
        ins_ava = findViewById(R.id.INSTRUMENT_AVAILABILITY);

        boolean isfalsevalue=false;
        if (ins_Name.length() == 0) {
            ins_Name.setError("This field is required");
            isfalsevalue=true;
        }
        if (ins_model.length() == 0) {
            ins_model.setError("This field is required");
            isfalsevalue=true;
        }
        if (ins_own_name.length() == 0) {
            ins_own_name.setError("This field is required");
            isfalsevalue=true;
        }
        if (ins_con.length() == 0) {
            ins_con.setError("This field is required");
            isfalsevalue=true;
        }
        if (ins_fault.length() == 0) {
            ins_fault.setError("This field is required");
            isfalsevalue=true;
        }
        if (ins_puc_date.length() == 0) {
            ins_puc_date.setError("This field is required");
            isfalsevalue=true;
        }
        if (ins_con_num.length() == 0) {
            ins_con_num.setError("This field is required");
            isfalsevalue=true;
        }
        if (ins_ava.length() == 0) {
            ins_ava.setError("This field is required");
            isfalsevalue=true;
        }
        if (isfalsevalue)
        {
            return false;
        }
        Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
        return true;
    }


}