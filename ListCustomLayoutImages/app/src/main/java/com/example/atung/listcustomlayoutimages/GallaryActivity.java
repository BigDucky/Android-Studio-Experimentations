package com.example.atung.listcustomlayoutimages;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

public class GallaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);

        int index = getIntent().getIntExtra("ITEM_ID",-1);
        String [] nameArray = getIntent().getStringArrayExtra("ITEM_ARRAY_NAME");
        if(index > -1){
            int pic = getImage(index);
            ImageView img = (ImageView) findViewById(R.id.imageView);

            scaleImg(img,pic);
        }

        TextView title = (TextView) findViewById(R.id.titleOfTheImage);
        title.setText(nameArray[index]);

    }

    private int getImage(int index){

        switch (index){
            case 0:
                return R.drawable.peach;
            case 1:
                return R.drawable.tomato;
            case 2:
                return R.drawable.squash;
                default:
                    return -1;
        }
    }

    private void scaleImg(ImageView img, int pic){
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic,options);

        int imgWidth = options.outWidth;
        int screenwidth = screen.getWidth();

        if(imgWidth > screenwidth){
            int ratio = Math.round((float) imgWidth / (float) screenwidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic,options);
        img.setImageBitmap(scaledImg);
    }
}
