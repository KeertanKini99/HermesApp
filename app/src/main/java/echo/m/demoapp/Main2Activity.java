package echo.m.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button next2, prev2;
    ImageView im2;
    int go_c_count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        next2 = (Button) findViewById(R.id.m2next);
        prev2 = (Button) findViewById(R.id.m2prev);
        im2 = (ImageView) findViewById(R.id.imageView2);


        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();
                TypedArray next = res.obtainTypedArray(R.array.go_c);
                int length = next.length();
                go_c_count++;
                if(go_c_count < length) {
                    Drawable x = next.getDrawable(go_c_count);
                    im2.setImageDrawable(x);
                }
                else{
                    go_c_count=length;
                    Toast.makeText(getApplicationContext(), "Destination arrived!", Toast.LENGTH_SHORT).show();
                }
                next.recycle();
            }
        });

        prev2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();
                TypedArray next = res.obtainTypedArray(R.array.go_c);
                //int length = next.length();
                go_c_count--;
                if(go_c_count > -1) {
                    Drawable x = next.getDrawable(go_c_count);
                    im2.setImageDrawable(x);
                }
                else{
                    go_c_count=0;
                    Toast.makeText(getApplicationContext(), "Source arrived!", Toast.LENGTH_SHORT).show();
                }
                next.recycle();
            }
        });
    }
}
