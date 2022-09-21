package com.example.day5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mys.ItemsG;
import com.example.mys.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView nametext = findViewById(R.id.textView);
        TextView pricetext = findViewById(R.id.textViewprice);
        ImageView img = findViewById(R.id.imageView);



        Bundle bundle = getIntent().getExtras();

        ItemsG item = (ItemsG) bundle.getSerializable("Iteem");

        nametext.setText(ItemsG.gameName());
        img.setImageResource(ItemsG.gameImg());
        pricetext.setText(ItemsG.gamePrice() +" KD");
    }
}