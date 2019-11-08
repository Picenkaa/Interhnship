package com.example.fotkeles.imagesliderurl;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.viewpagerindicator.CirclePageIndicator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {


    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    String data = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//MainActivity.
        data();
        init();

    }

public void data() {
    String strJson=null;
    char ch='"';
    try {
        InputStream inputStream = getAssets().open("dog_urls.json");
        int size = inputStream.available();
        byte [] buffer = new byte[size];
        inputStream.read(buffer);
        inputStream.close();
        strJson = new String(buffer,"UTF-8");
        // Create the root JSONObject from the JSON string.
        JSONObject jsonRootObject = new JSONObject(strJson);

        //Get the instance of JSONArray that contains JSONObjects
        JSONArray jsonArray = jsonRootObject.optJSONArray("urls");

        //Iterate the jsonArray and print the info of JSONObjects
        for(int i=0; i < jsonArray.length(); i++){
            data += ch + jsonArray.getString(i)+ ch + ",\n";


        }

      //  Toast.makeText(this,data, Toast.LENGTH_LONG).show();
//paraso visus url


    } catch (JSONException | IOException e) {e.printStackTrace();}

     //   return data;
}

    public  String[] urls  = new String[] {"https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_1007.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_1023.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_10263.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_10715.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_10822.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_10832.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_10982.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_11006.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_11172.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_11182.jpg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_1126.jpg",};
    // NOTE: Turetu buti   public  String[] urls  = new String[] {data}, bet niekam neatidaro url file, nors String data kuo puikiausiai nuskiato
// neledzia isvesti String data

    private void init() {

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(MainActivity.this,urls));

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(4 * density);

        NUM_PAGES = urls.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }

}
