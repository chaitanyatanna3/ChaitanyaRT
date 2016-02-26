package com.example.chaitanya.chaitanyart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class GalleryRT extends AppCompatActivity {

    Button BTN_Inception, BTN_Journey, BTN_Sherlock, BTN_Stupid, BTN_Next, BTN_Previous;
    ImageView mImageView;
   // ImageSwitcher mImageSwitcher;
    int[] ImageIds = {
            R.drawable.inception, R.drawable.journey,
            R.drawable.sherlock, R.drawable.stupid
    };
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);

        //mImageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        mImageView = (ImageView) findViewById(R.id.imageView);
        BTN_Inception = (Button) findViewById(R.id.btn_inception);
        BTN_Journey = (Button) findViewById(R.id.btn_journey);
        BTN_Sherlock = (Button) findViewById(R.id.btn_sherlock);
        BTN_Stupid = (Button) findViewById(R.id.btn_stupid);
        BTN_Next = (Button) findViewById(R.id.btn_next);
        BTN_Previous = (Button) findViewById(R.id.btn_previous);

       // mImageSwitcher.setFactory(this);

        BTN_Inception.setOnClickListener(mButtonChangeImageListener);
        BTN_Journey.setOnClickListener(mButtonChangeImageListener);
        BTN_Sherlock.setOnClickListener(mButtonChangeImageListener);
        BTN_Stupid.setOnClickListener(mButtonChangeImageListener);

        BTN_Previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 0) {
                    count--;
                    try {
                       // mImageSwitcher.setImageResource(ImageIds[count]);
                        mImageView.setImageResource(ImageIds[count]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(GalleryRT.this, "First", Toast.LENGTH_SHORT).show();
                }
            }
        });

        BTN_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count < ImageIds.length) {
                    try {
                       // mImageSwitcher.setImageResource(ImageIds[count]);
                        mImageView.setImageResource(ImageIds[count]);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    count++;
                } else {
                    Toast.makeText(GalleryRT.this, "Last", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//    @Override
//    public View makeView() {
//
//        mImageView = new ImageView(this);
//        mImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//        mImageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        return mImageView;
//    }

    View.OnClickListener mButtonChangeImageListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_inception:
                    mImageView.setImageResource(R.drawable.inception);
                    break;
                case R.id.btn_journey:
                    mImageView.setImageResource(R.drawable.journey);
                    break;
                case R.id.btn_sherlock:
                    mImageView.setImageResource(R.drawable.sherlock);
                    break;
                case R.id.btn_stupid:
                    mImageView.setImageResource(R.drawable.stupid);
                    break;
                default: mImageView.setImageResource(R.drawable.inception);
            }
        }
    };

}
