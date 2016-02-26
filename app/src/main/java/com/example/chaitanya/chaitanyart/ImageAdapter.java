package com.example.chaitanya.chaitanyart;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.View.OnLongClickListener;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.content.Intent;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public Integer[] mThumbIds = {
            R.drawable.inception, R.drawable.journey,
            R.drawable.sherlock, R.drawable.stupid
    };

    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(400, 700));
        imageView.setPadding(10, 10, 10, 10);

        //sharing the image
        imageView.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view){
                //Toast.makeText(mContext, "You have pressed On An Image", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setPositiveButton("Hide", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        imageView.setVisibility(View.GONE);
                    }
                });
                builder.setNegativeButton("Share", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Bitmap mBitmap = BitmapFactory.decodeResource(mContext.getResources(), mThumbIds[position]);
                        Bitmap icon = mBitmap;
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("image/png");
                        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                        icon.compress(Bitmap.CompressFormat.PNG, 100, bytes);
                        File f = new File(Environment.getExternalStorageDirectory() + File.separator + "temporary_file.png");
                        try {
                            f.createNewFile();
                            FileOutputStream fo = new FileOutputStream(f);
                            fo.write(bytes.toByteArray());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///sdcard/temporary_file.png"));
                        mContext.startActivity(Intent.createChooser(intent, "Share Image"));

                    }
                });

                AlertDialog alert = builder.create();
                alert.show();

                return true;
            }
        });

        return imageView;
    }
}
