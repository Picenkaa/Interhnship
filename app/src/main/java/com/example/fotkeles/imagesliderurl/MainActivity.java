package com.example.fotkeles.imagesliderurl;

import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.viewpagerindicator.CirclePageIndicator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {


    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    String data = "";
    LinkedList<String> list = new LinkedList<String>();

    public MainActivity() throws MalformedURLException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//MainActivity.
        data();
        init();

    }

@RequiresApi(api = Build.VERSION_CODES.N)
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
          //  data += ch + jsonArray.getString(i)+ ch + ",\n";
list.add(jsonArray.getString(i));


        }
        for (String value : list) {
            Log.i("values", value);
            data +=value + "," ;
           
        }
      //  String [] array = new String[list.size()];
      //  list.toArray(array);

    } catch (JSONException | IOException e) {e.printStackTrace();}

}
String getData(){
        return data;
    }

   //public  String[] urls  = new String[] {getData()};
    public  String[] urls  = new String[] { "https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg",
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
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1126.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1128.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_11432.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1145.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_115.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1150.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_11570.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_11584.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1167.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1186.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_11953.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1222.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1234.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_12364.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1254.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_12563.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1259.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_12664.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1270.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_12867.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_12879.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_12945.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1301.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_13011.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_13145.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_13270.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1335.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_13442.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_13502.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1357.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1370.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_13742.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_13879.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_13907.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_13909.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1406.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1410.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1430.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1459.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1475.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1479.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1534.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1592.jpg",
           "https://images.dog.ceo/breeds/hound-afghan/n02088094_1611.jpg",};

    // NOTE: Turetu buti   public  String[] urls  = new String[] {data}, bet niekam neatidaro url file, nors String data kuo puikiausiai nuskiato
// neledzia isvesti String data

    private void init() {
       // Toast.makeText(this, getData(), Toast.LENGTH_LONG).show();
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
