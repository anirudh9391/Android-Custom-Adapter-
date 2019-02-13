package com.example.aniru.hw2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class list_view extends Activity
{

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        int choice = getIntent().getExtras().getInt("index");

        ArrayList<String>  arr = new ArrayList<>();

        //arr = func(choice);

        arr = func(arr,choice);

        //arr.add("a");
        //arr.add("b");
        //arr.add("c");
        ListView lv = (ListView) findViewById(R.id.list_view);

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);


        lv.setAdapter(itemsAdapter);
    }

    ArrayList<String> func(ArrayList<String> ar, int c)
    {
        switch(c)
        {
            case 0:
                ar.add("Howard Orloff Volvo Cars - 1924 N Paulia St, Chicago, IL 60622");
                ar.add("Autobarn Volvo of Oak Park - 1140 Garfield Street, Oak Park, IL 60622");
                ar.add("Fields Volvo - 770 Frontage Road, NorthField, IL 60622");break;

            case 1:
                ar.add("KINGDOM CHEVROLET INC. - 6633 S WESTERN AVE CHICAGO, IL 60636");
                ar.add("Currie Motors Chevrolet, INC. - 8401 W ROOSEVELT RD FOREST PARK, IL 60130");
                ar.add("Rogers Auto Group - 2720 S MICHIGAN AVENUE CHICAGO, IL 60616");break;

            case 2:
                ar.add("Metro Ford Sales & Service, Inc. - 6455 South Western, Chicago, IL 60636");
                ar.add("Fox Ford Lincoln - 2501 North Elston Avenue, Chicago, IL 60647");
                ar.add("Zeigler Ford of North Riverside - 2100 South Harlem Avenue, North Riverside, IL 60546");break;

            case 3:
                ar.add("Fletcher Jones Audi - 1523 W North Avenue, Chicago, IL 60642");
                ar.add("Audi Morton Grove - 7000 Golf Road, Morton Grove, IL 60053");
                ar.add("Audi Westmont - 276 E Ogden Ave, Westmont, IL 60559");break;

            case 4:
                ar.add("McGrath Acura of Downtown Chicago - 1301 N Elston Ave, Chicago, IL 60642");
                ar.add("McGrath Acura of Morton Grove - 9105 Waukegan Rd, Morton Grove, IL 60053");
                ar.add("Ed Napleton Acura, 745 W Lake St, Elmhurst, IL 60126");break;

            case 5:
                ar.add("Volkswagon of Downtown Chicago - 1111 N Clarke St, Chicago, IL 60610");
                ar.add("The Autobarn City - 5330 W Irving Park Rd., Chicago, IL 60641");
                ar.add("Mike Haggerty Volkswagon INC. - 8920 S Cicero Ave., Oak Lawn, IL 60453");break;

            case 6:
                ar.add("Grossinger City Toyota - 1561 North Fremont Street, Chicago, IL 60642");
                ar.add("Midtown Toyota - 2700 North Cicero Avenue, Chicago, IL 60639");
                ar.add("Toyota On Western - 6941 South Western Ave, Chicago, IL 60636");break;

            case 7:
                ar.add("Grossinger City Autoplex Cadillac - 1530 N Dayton, Chicago, IL 60610");
                ar.add("ZEIGLER CADILLAC OF LINCOLNWOOD - 6900 MCCORMICK BLVD. LINCOLNWOOD, IL 60712");
                ar.add("FRANK SHIREY CADILLAC, INC. - 10125 S CICERO OAK LAWN, IL 60453");break;
        }

        return ar;
    }
}
