package com.vijayjaidewan01vivekrai.viewpager_github;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MR VIVEK RAI on 28-05-2018.
 */

public class Adapter extends PagerAdapter {

    private Context context;
    private LayoutInflater inflater;

    public int[] backgroundColor = {
            Color.rgb(55, 55, 55),
            Color.rgb(239, 85, 85),
            Color.rgb(110, 49, 89),
            Color.rgb(55, 55, 55),
    };

    public int[] images = {
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4
    };

    public String[] name = {
            "Jason Roy",
            "Gary Sobers",
            "Bella Smith",
            "Angela Ilievska"
    };


    public Adapter() {
    }

    public Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

//        Inflating Layout
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.swipe_layout, container, false);
        ConstraintLayout layout = view.findViewById(R.id.constraint_layout);

//        Setting Background
        layout.setBackgroundColor(backgroundColor[position]);

//        Setting ImageView
        ImageView imageView = view.findViewById(R.id.image_view);
        imageView.setImageResource(images[position]);

//        Setting TextView
        TextView textView = view.findViewById(R.id.text_view);
        textView.setText(name[position]);

//        Setting view on the conatiner
        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
