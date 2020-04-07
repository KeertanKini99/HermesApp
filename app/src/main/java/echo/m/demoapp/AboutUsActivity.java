package echo.m.demoapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AboutUsActivity extends AppCompatActivity {

    ImageButton kishan, keertan;
    Dialog diopen;
    String theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  //App is now fullscreen
        setContentView(R.layout.activity_about_us);

        Bundle bundle = getIntent().getExtras();
        theme = bundle.getString("Switch");
        SetAppTheme(theme);

        kishan = (ImageButton) findViewById(R.id.kishanButton);
        keertan = (ImageButton) findViewById(R.id.keertanButton);
        diopen=new Dialog(this);

        kishan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diopen.setContentView(R.layout.prof_kishan);
                diopen.setCanceledOnTouchOutside(true);
                diopen.show();
            }
        });

        keertan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diopen.setContentView(R.layout.prof_keertan);
                diopen.setCanceledOnTouchOutside(true);
                diopen.show();
            }
        });
    }

    private void SetAppTheme(String theme) {
        if(theme.equals("frost")){

            ImageView back = (ImageView) findViewById(R.id.background); //background
            back.setBackgroundResource(R.drawable.spl1);

            TextView title = (TextView) findViewById(R.id.textView9); //title
            title.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
            title = (TextView) findViewById(R.id.textView10); //base
            title.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));

        }
        else{
            ImageView back = (ImageView) findViewById(R.id.background); //background
            back.setBackgroundResource(R.drawable.spl2);

            TextView title = (TextView) findViewById(R.id.textView9); //title
            title.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            title = (TextView) findViewById(R.id.textView10); //base
            title.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        }

    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
        Intent i = new Intent(AboutUsActivity.this, MainActivity.class);
        startActivity(i);

    }
}
