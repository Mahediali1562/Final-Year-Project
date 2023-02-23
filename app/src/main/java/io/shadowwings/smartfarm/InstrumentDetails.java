package io.shadowwings.smartfarm;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import io.shadowwings.smartfarm.Model.RentalItemModel;

public class InstrumentDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrument_details);

        TextView instrumentName,instrumentModel,instrumentRent,instrument_State,instrument_Available,owner_Name,owner_Phone_No,owner_Whatsapp_No,fault,conditions,instrument_Age;
        ImageView instrumentImage;
        instrumentImage=findViewById(R.id.ins_img);
        instrumentRent=findViewById(R.id.ins_Rent);
        instrumentName=findViewById(R.id.ins_Name);
        instrumentModel=findViewById(R.id.ins_model);
        instrument_State=findViewById(R.id.ins_State);
        instrument_Available=findViewById(R.id.ins_available);
        instrument_Age=findViewById(R.id.ins_Age);
        fault=findViewById(R.id.ins_fault);
        conditions=findViewById(R.id.ins_Conditions);
        owner_Name=findViewById(R.id.ins_owner);

        Button call_button,message_button;
        call_button=findViewById(R.id.callnow);
        message_button=findViewById(R.id.messagenow);

        RentalItemModel rentalItemModel=(RentalItemModel) getIntent().getSerializableExtra("item");


        instrumentRent.setText(rentalItemModel.RENT+"");
        instrumentName.setText(rentalItemModel.NAME);
        instrumentModel.setText(rentalItemModel.MODEL);
        instrument_State.setText(rentalItemModel.STATE);
        instrument_Available.setText("Available For "+rentalItemModel.AVAILABLE_TIME);
        owner_Name.setText(rentalItemModel.OWNER_NAME);
        fault.setText(rentalItemModel.FAULT);
        conditions.setText(rentalItemModel.CONDITION);
        instrument_Age.setText(rentalItemModel.INSTRUMENT_AGE+" Old");

        if (instrumentImage!=null)
        {
            Picasso.get().load(rentalItemModel.URL).into(instrumentImage);
        }

        call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String Phone_No="tel:"+rentalItemModel.Phone_Number;
                    Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse(Phone_No));
                    startActivity(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        message_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wp_number = "+91"+rentalItemModel.Whatsapp_Number;
                String message = "*Smart Farm: Inquiry Message!!!*\n" +"\nHello "+rentalItemModel.OWNER_NAME+", This Enquiry Message IS For: \n"+rentalItemModel.NAME+"\nModel: "+rentalItemModel.MODEL;

                try {
                    startActivity(
                            new Intent(Intent.ACTION_VIEW,
                                    Uri.parse(
                                            String.format("https://api.whatsapp.com/send?phone=%s&text=%s", wp_number, message)
                                    )
                            )
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        ImageButton save_ins=findViewById(R.id.save_instrument);
        save_ins.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Item Saved Successfully", Toast.LENGTH_LONG).show();
            }
        });

        ImageButton imgImageButton;
        imgImageButton=findViewById(R.id.share_instrument);
        imgImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "*Hey, Check This Instrument\uD83D\uDC47*\n\n*\uD83D\uDC68\u200D\uD83C\uDF3E"+rentalItemModel.NAME+"*\uD83D\uDC68\u200D\uD83C\uDF3E\n\n*Description*\nModel: " +rentalItemModel.MODEL+"\nOwner Name: "+rentalItemModel.OWNER_NAME+"\nInstrument State: "+rentalItemModel.STATE+"\nAny Fault: "+rentalItemModel.FAULT+"\nInstrument Age: "+rentalItemModel.INSTRUMENT_AGE+"\n\n*Condition*\n"+rentalItemModel.CONDITION+"\n\n*RENT => "+rentalItemModel.RENT+"*\n\n*Thanks For Using Smart Farm!!!*";

                try {
                    startActivity(
                            new Intent(Intent.ACTION_VIEW,
                                    Uri.parse(
                                            String.format("https://api.whatsapp.com/send?text=%s", message)
                                    )
                            )
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}