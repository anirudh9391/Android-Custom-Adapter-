package com.example.aniru.hw2;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity
{
    private ArrayList<Integer> carImages = new ArrayList<>(
            Arrays.asList(R.drawable.volvo_s60, R.drawable.impala, R.drawable.ford_focus,
                    R.drawable.audi,R.drawable.acura_tlx,R.drawable.passat, R.drawable.toyota_landcruiser, R.drawable.cadillac_sedan)
    );

    private ArrayList<String> carText = new ArrayList<>(Arrays.asList("Volvo S60","Chevrolet Impala","FOrd Focus",
            "Audi A4","Acura TLX","Volkswagon Passat","Toyota LandCruiser","Cadillac Sedan ct6"));


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridView grid = (GridView) findViewById(R.id.gridview);
        grid.setAdapter(new ImageAdapter(this, carImages, carText));


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id)
            {
                Intent in = new Intent(MainActivity.this, ImageViewActivity.class);

                Bundle b = new Bundle();

                System.out.println("id is :"+carImages.get(i));

                b.putInt("image",carImages.get(i));
                b.putInt("index",i);

                in.putExtras(b);
                startActivity(in);


            }
        });

        grid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                System.out.println("Long click "+view.getId());
                registerForContextMenu(grid);
                return false;

            }
        });


    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
      //  menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "View Full Picture");
        menu.add(0, v.getId(), 0, "Go To Website");
        menu.add(0, v.getId(), 0, "Dealers");

    }
    public boolean onContextItemSelected(MenuItem item)
    {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;
        if (item.getTitle() == "View Full Picture")
        {

            Intent i = new Intent(MainActivity.this, ImageViewActivity.class);
            Bundle b = new Bundle();
            b.putInt("image",carImages.get(index));
            b.putInt("index",index);

            i.putExtras(b);
            startActivity(i);
        }
        else if(item.getTitle() == "Go To Website")
        {

            ImageViewActivity obj= new ImageViewActivity();
            try
            {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+obj.website(index)));
                startActivity(myIntent);
            } catch (ActivityNotFoundException e)
            {
                System.out.println(e);
            }
        }
        else if(item.getTitle() == "Dealers")
        {
            Intent i = new Intent(MainActivity.this,list_view.class);
            Bundle b = new Bundle();

            b.putInt("index",index);

            i.putExtras(b);

            startActivity(i);

        }
        else
        {
            return  false;
        }
        return true;
    }

}
