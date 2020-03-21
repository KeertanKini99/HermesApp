package echo.m.demoapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AboutUsActivity extends AppCompatActivity {

    ImageButton kishan, keertan;
    Dialog diopen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

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

    @Override
    public void onBackPressed() {
        this.finishAffinity();
        Intent i = new Intent(AboutUsActivity.this, MainActivity.class);
        startActivity(i);

    }
}
