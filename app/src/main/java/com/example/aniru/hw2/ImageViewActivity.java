package com.example.aniru.hw2;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageViewActivity extends Activity
{

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        // Make a new ImageView
        ImageView imageView = new ImageView(getApplicationContext());

        // Get the ID of the image to display and set it as the image for this ImageView
      //  int im = intent.getIntExtra("image", 0);
       // imageView.setImageResource(im);

        int im = intent.getExtras().getInt("image");
        final int index = intent.getExtras().getInt("index");

        imageView.setImageResource(im);
        setContentView(imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);


        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+website(index)));
                    startActivity(myIntent);
                } catch (ActivityNotFoundException e)
                {
                    System.out.println(e);
                }
            }
        });
    }

    String website(int c)
    {

        switch(c)
        {

            case 0: return "www.volvocars.com/us/cars/new-models/s60";
            case 1: return "www.chevrolet.com/cars/impala-full-size-car";

            case 2: return "www.ford.com/cars/focus/";
            case 3: return "www.audiusa.com/models/audi-a4";

            case 4: return "www.acura.com/tlx";
            case 5: return "www.vw.com/models/passat/section/colors/";

            case 6: return "www.toyota.com/landcruiser/";
            case 7: return "www.cadillac.com/sedans/ct6-sedan";

        }
        return "";
    }


}
