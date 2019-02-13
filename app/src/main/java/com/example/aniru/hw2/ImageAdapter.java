package com.example.aniru.hw2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class ImageAdapter extends BaseAdapter
{
    private static final int PADDING = 5;
    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;
    private Context mContext;          // This will have to be passed to the ImageView
    private List<Integer> mThumbIds;   // Adapter must store AdapterView's items
    private List<String> carText;
    private LayoutInflater inflater;
    public ImageAdapter(Context c, List<Integer> ids, List<String> t)
    {
        mContext = c;
        this.mThumbIds = ids;
        this.carText = t;
    }

    @Override
    public int getCount()
    {
        return mThumbIds.size();
    }

    @Override
    public Object getItem(int position)
    {
        return mThumbIds.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return mThumbIds.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        //ImageView imageView = (ImageView) convertView;

        View gridView = convertView;


        if (convertView == null)
        {
            inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.custom_layout,null);
            gridView.setLayoutParams(new GridView.LayoutParams(WIDTH, 500));
            gridView.setPadding(PADDING, PADDING, PADDING, PADDING);
        }

        Bitmap bimage = BitmapFactory.decodeResource(mContext.getResources(),mThumbIds.get(position));
        Bitmap b = Bitmap.createScaledBitmap(bimage,700,600,false);


        ImageView image = (ImageView) gridView.findViewById(R.id.icons);
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        TextView tv = (TextView) gridView.findViewById(R.id.text);

        image.setImageBitmap(b);
        tv.setText(carText.get(position));
        return gridView;
    }
}
