package com.example.nurda.real;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GalleryActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        imageView = findViewById(R.id.image_gallery);
        textView = findViewById(R.id.tv_name_gal);
        textView.setText(getIntent().getStringExtra("name"));
        int imagee = (int) getIntent().getIntExtra("image",0);
        Glide.with(this)
                .asBitmap()
                .load(imagee)
                .into(imageView);

    }
}
