package echo.m.demoapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutAppActivity extends AppCompatActivity {

    Button update;
    String theme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  //App is now fullscreen
        setContentView(R.layout.activity_about_app);

        Bundle bundle = getIntent().getExtras();
        theme = bundle.getString("Switch");

        SetAppTheme(theme);

        update = (Button) findViewById(R.id.update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder
                        = new AlertDialog
                        .Builder(AboutAppActivity.this);
                builder.setMessage("App is already up to date.");
                builder.setTitle("Check for Updates");

                builder.setCancelable(false);
                builder
                        .setPositiveButton(
                                "Ok",
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which)
                                    {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }

    private void SetAppTheme(String theme) {
        if(theme.equals("frost")){
            ImageView back = (ImageView) findViewById(R.id.background);
            back.setBackgroundResource(R.drawable.spl1);

            TextView title = (TextView) findViewById(R.id.textView8); // HermesApp
            title.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
            title = (TextView) findViewById(R.id.basetitle); // Base
            title.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

            TextView info = (TextView) findViewById(R.id.textView9);// subtitle
            info.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
            info = (TextView) findViewById(R.id.appversion1);// appversion 1
            info.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
            info = (TextView) findViewById(R.id.appversion2);// appversion 2
            info.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
            info = (TextView) findViewById(R.id.floor1);// floor 1
            info.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
            info = (TextView) findViewById(R.id.floor2);// floor 2
            info.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
            info = (TextView) findViewById(R.id.block1);// block 1
            info.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
            info = (TextView) findViewById(R.id.block2);// block 2
            info.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
            info = (TextView) findViewById(R.id.college1);// college 1
            info.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
            info = (TextView) findViewById(R.id.college2);// college 2
            info.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));


            Button button = (Button) findViewById(R.id.update); //update
            button.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            button.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

        }
        else{
            ImageView back = (ImageView) findViewById(R.id.background);
            back.setBackgroundResource(R.drawable.spl2);

            TextView title = (TextView) findViewById(R.id.textView8); // HermesApp
            title.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            title = (TextView) findViewById(R.id.basetitle); // Base
            title.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

            TextView info = (TextView) findViewById(R.id.textView9);// subtitle
            info.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            info = (TextView) findViewById(R.id.appversion1);// appversion 1
            info.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            info = (TextView) findViewById(R.id.appversion2);// appversion 2
            info.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            info = (TextView) findViewById(R.id.floor1);// floor 1
            info.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            info = (TextView) findViewById(R.id.floor2);// floor 2
            info.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            info = (TextView) findViewById(R.id.block1);// block 1
            info.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            info = (TextView) findViewById(R.id.block2);// block 2
            info.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            info = (TextView) findViewById(R.id.college1);// college 1
            info.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            info = (TextView) findViewById(R.id.college2);// college 2
            info.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

            Button button = (Button) findViewById(R.id.update); //update
            button.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
            button.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        }
    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
        Intent i = new Intent(AboutAppActivity.this, MainActivity.class);
        startActivity(i);
    }
}
