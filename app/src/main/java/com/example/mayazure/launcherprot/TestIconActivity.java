package com.example.mayazure.launcherprot;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TestIconActivity extends AppCompatActivity {

    private ImageView dragg;
    private LinearLayout target;
    private Button show;
    private TextView console;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_icon);
        initViews();
    }

    private void initViews(){
        dragg = (ImageView)findViewById(R.id.dragg);
        target = (LinearLayout)findViewById(R.id.target);

        console = (TextView)findViewById(R.id.console);
        console.setText("-gfuyeg");
        show = (Button)findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                console.setText("=-------------Show");
            }
        });

        target.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_UP){
                    console.setText("----------UP");
                    ImageView iv = new ImageView(TestIconActivity.this);
                    iv.setBackgroundColor(getResources().getColor(R.color.foreground));
                    target.addView(iv);
                    return true;
                }
                else return false;
            }
        });

        dragg.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                    v.startDragAndDrop(null,shadowBuilder,v,0);
                    return true;
                }
                return false;
            }
        });

        dragg.getRootView().setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {

                if(event.getAction()==DragEvent.ACTION_DROP){
                    float X = event.getX();
                    float Y = event.getY();
                    View view = (View)event.getLocalState();
                    view.setX(X);
                    view.setY(Y);
                    return true;
                }
                return false;
            }
        });
    }
}

