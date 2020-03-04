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

public class Main3Activity extends AppCompatActivity {

    Button next3, prev3;
    ImageView im3;
    int go_f_count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        next3 = (Button) findViewById(R.id.m3next);
        prev3 = (Button) findViewById(R.id.m3prev);
        im3 = (ImageView) findViewById(R.id.imageView3);

        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();
                TypedArray next = res.obtainTypedArray(R.array.go_f);
                int length = next.length();
                go_f_count++;
                if(go_f_count < length) {
                    Drawable x = next.getDrawable(go_f_count);
                    im3.setImageDrawable(x);
                }
                else{
                    go_f_count=length;
                    Toast.makeText(getApplicationContext(), "Destination arrived!", Toast.LENGTH_SHORT).show();
                }
                next.recycle();
            }
        });

        prev3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();
                TypedArray next = res.obtainTypedArray(R.array.go_f);
                //int length = next.length();
                go_f_count--;
                if(go_f_count > -1) {
                    Drawable x = next.getDrawable(go_f_count);
                    im3.setImageDrawable(x);
                }
                else{
                    go_f_count=0;
                    Toast.makeText(getApplicationContext(), "Source arrived!", Toast.LENGTH_SHORT).show();
                }
                next.recycle();
            }
        });
    }
}
