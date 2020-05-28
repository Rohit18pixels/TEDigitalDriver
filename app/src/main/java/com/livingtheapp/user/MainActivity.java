package com.livingtheapp.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import me.relex.circleindicator.CircleIndicator;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    private ViewPager vp_slider;
    private int images_vp[] = {R.drawable.a, R.drawable.b, R.drawable.c};

    private SliderPagerAdapter myCustomPagerAdapter;

    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<ImageModel> imageModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageModelArrayList = new ArrayList<>();
//        imageModelArrayList = populateList();

        vp_slider = findViewById(R.id.vp_slider);


        myCustomPagerAdapter = new SliderPagerAdapter(this, images_vp);
        vp_slider.setAdapter(myCustomPagerAdapter);

        CircleIndicator indicator =  findViewById(R.id.indicator);
        indicator.setViewPager(vp_slider);

        NUM_PAGES = imageModelArrayList.size();
        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = () -> {
            if (currentPage == NUM_PAGES) {
                currentPage = 0;

            }

            vp_slider.setCurrentItem(currentPage++, true);
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2000, 2000);



    }



    public static class ImageModel {

        private int image_drawable;

        public int getImage_drawable() {
            return image_drawable;
        }

        public void setImage_drawable(int image_drawable) {
            this.image_drawable = image_drawable;
        }
    }

    class SliderPagerAdapter extends PagerAdapter {
        Context context;
        int[] images;
        LayoutInflater layoutInflater;


        public SliderPagerAdapter(Context context, int[] images) {
            this.context = context;
            this.images = images;
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View itemView = layoutInflater.inflate(R.layout.vp_slider_item, container, false);

            ImageView iv_vp_slider = itemView.findViewById(R.id.iv_vp_slider);
            iv_vp_slider.setImageResource(images[position]);

            container.addView(itemView);

            //listening to image click
            iv_vp_slider.setOnClickListener(v -> {
                //Toast.makeText(context, "you clicked image " + (position + 1), Toast.LENGTH_LONG).show();
            });

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }





}
