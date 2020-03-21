package echo.m.demoapp;
import androidx.appcompat.app.AppCompatActivity;
        import androidx.constraintlayout.widget.ConstraintLayout;

        import android.content.res.Resources;
        import android.content.res.TypedArray;
        import android.graphics.drawable.Drawable;
        import android.os.Bundle;
        import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button next2, prev2;
    ImageView im2;
    int go_c_count=0,go_c_count2=0;
    int[] path22;
    int[] pathl22;
    int pval22,flag=0,flag22=0,flag23=0,flagl=0,flagr=0;
    int length,length2;
    Resources res;
    TypedArray next,next22;
    Drawable x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  //App is now fullscreen
        setContentView(R.layout.activity_main2);
        next2 = (Button) findViewById(R.id.m2next);
        prev2 = (Button) findViewById(R.id.m2prev);
        im2 = (ImageView) findViewById(R.id.imageView2);
        Bundle bundle = getIntent().getExtras();
        pval22=bundle.getInt("pval");
        //path22=new int[pval22];
        path22= bundle.getIntArray("path");
        pathl22=bundle.getIntArray("pathline");
         res = getResources();
        next = res.obtainTypedArray(R.array.go_c);
        next22 = res.obtainTypedArray(R.array.go_l);
         x = next.getDrawable(path22[go_c_count]);

        im2.setImageDrawable(x);
        go_c_count++;
        //g_fin++;
        length = path22.length;
        length2 = pathl22.length;

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prev2.setVisibility(View.VISIBLE);
                res = getResources();
                next = res.obtainTypedArray(R.array.go_c);
                next22 = res.obtainTypedArray(R.array.go_l);

                flag = 0;
                flag22 = 1;
                if (flag23 == 1) {
                    flag23 = 0;
                    //g_fin++:

                   if(flagr==0 ){
                        go_c_count++;
                        }
                     else {
                        go_c_count2++;

                    }

                }



                if(go_c_count2<length2 && flagl==0 && flagr==0 ){


                y = next22.getDrawable(pathl22[go_c_count2]);
                im2.setImageDrawable(y);
                go_c_count2++;
                    flagl=1;
                    flagr=1;
               // g_fin++;

            }

                else  if(go_c_count < length && flagl==1 && flagr==1 ) {

                           x = next.getDrawable(path22[go_c_count]);
                           im2.setImageDrawable(x);
                           go_c_count++;
                          // g_fin++;

                       flagl=0;
                       flagr=0;





                }
                else {
                    //go_c_count=length;
                    Toast.makeText(getApplicationContext(), "Destination arrived!", Toast.LENGTH_SHORT).show();
                    next2.setVisibility(View.INVISIBLE);
                    flag=1;

                }
                if(flag==1) {
                   // g_fin=path22.length+pathl22.length;
                    go_c_count2=length2;
                    go_c_count=length;
                    //flagr=0;
                }
                else {
                    //g_fin++;

                }
                next.recycle();
            }
        });

        prev2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                next2.setVisibility(View.VISIBLE);
                Resources res = getResources();
                TypedArray next = res.obtainTypedArray(
                        R.array.go_c);
                TypedArray next22 = res.obtainTypedArray(R.array.go_l);

                //int length = next.length();
                flag23=1;
                if(flag22==1) {
                    flag22 = 0;
                    //g_fin--;
                   if(flagr==0 && go_c_count!=length ) {

                        go_c_count--;
                    }
                   else if(flagr==1 ){
                        go_c_count2--;

                    }
                   if(go_c_count==length && go_c_count2==length2) {
                       //go_c_count2--;
                       go_c_count--;
                   }

                }
                //g_fin--;
                //if(flagr==0) {


                if(go_c_count2 >0 && flagr==0) {
                    //if(go_c_count2==length2)
                   // {
                        go_c_count2--;
                        y = next22.getDrawable(pathl22[go_c_count2]);
                        im2.setImageDrawable(y);
                        flagr=1;
                        flagl=1;

                   /* }else {
                        go_c_count2--;
                        y = next22.getDrawable(pathl22[go_c_count2]);
                        im2.setImageDrawable(y);
                        flagr = 1;
                        flagl = 1;
                        // go_c_count--;
                    }*/





                }
                else if(go_c_count >0 && flagr==1)
                {
                    go_c_count--;


                    //go_c_count2--;
                    x = next.getDrawable(path22[go_c_count]);
                    im2.setImageDrawable(x);
                    flagr=0;
                    flagl=0;




                }
                else{
                    //g_fin=0;
                    go_c_count=0;
                    go_c_count2=0;
                    //flagr=0;
                    //flagl = 0;
                    Toast.makeText(getApplicationContext(), "Source arrived!", Toast.LENGTH_SHORT).show();
                    prev2.setVisibility(View.INVISIBLE);
                }

                next.recycle();
            }
        });
    }
}
