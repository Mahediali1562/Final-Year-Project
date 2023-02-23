package io.shadowwings.smartfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import io.shadowwings.smartfarm.Model.ProductModel;

public class ProductDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detailes);

        TextView productName,dealPrice,realPrice,description,brandName;
        ImageView productImage;
        productName=findViewById(R.id.productName);
        dealPrice=findViewById(R.id.dealPrice);
        realPrice=findViewById(R.id.productRealPrice);
        description=findViewById(R.id.productDescription);
        productImage=findViewById(R.id.PRODUCT_IMAGE);
        brandName=findViewById(R.id.brand);

        ProductModel productModel= (ProductModel) getIntent().getSerializableExtra("product");

        productName.setText(productModel.NAME);
        dealPrice.setText(productModel.DEAL_PRICE+" Rs.");
        realPrice.setText("MRP: "+productModel.PRICE+" Rs.");
        realPrice.setPaintFlags(realPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        description.setText(productModel.DESCRIPTION);
        brandName.setText(productModel.brandName);
        Picasso.get().load(productModel.URL).into(productImage);


    }
}