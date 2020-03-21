package echo.m.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AboutUsActivity extends AppCompatActivity {

    ImageButton kishan, keertan;
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        kishan = (ImageButton) findViewById(R.id.kishanButton);
        keertan = (ImageButton) findViewById(R.id.keertanButton);

        kishan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.prof_kishan);
                myDialog.setCanceledOnTouchOutside(true);
            }
        });

        keertan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.prof_keertan);
                myDialog.setCanceledOnTouchOutside(true);
            }
        });
    }


}
