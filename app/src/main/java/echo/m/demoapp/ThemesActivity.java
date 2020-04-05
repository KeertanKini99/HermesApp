package echo.m.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class ThemesActivity extends AppCompatActivity {

    Switch change;
    TextView theme, title, base;
    ImageView back;
    String PREFS_NAME = "SwitchState";
    String switchstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  //App is now fullscreen
        setContentView(R.layout.activity_themes);
        change = (Switch) findViewById(R.id.themeswitch);
        theme = (TextView) findViewById(R.id.cur_theme);
        title = (TextView) findViewById(R.id.pagetitle);
        base = (TextView) findViewById(R.id.pagebase);
        back = (ImageView) findViewById(R.id.background);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        boolean silent = settings.getBoolean("switchkey", false);
        change.setChecked(silent);

        change.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true)
                {
                    back.setImageResource(R.drawable.spl2);
                    theme.setText("EMBER");
                    theme.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    title.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    base.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    switchstatus = "ember";
                }
                else {
                    back.setImageResource(R.drawable.spl1);
                    theme.setText("FROST");
                    theme.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                    title.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                    base.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                    switchstatus = "frost";
                }

                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("switchkey", isChecked);
                editor.commit();
            }
        });

        if(change.isChecked()){
            back.setImageResource(R.drawable.spl2);
            theme.setText("EMBER");
            theme.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            title.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            base.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            switchstatus = "ember";
        }
        else {
            back.setImageResource(R.drawable.spl1);
            theme.setText("FROST");
            theme.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
            title.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
            base.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
            switchstatus = "frost";
        }
    }



    @Override
    public void onBackPressed() {

        Intent i = new Intent(ThemesActivity.this, MainActivity.class);
        i.putExtra("Switch", switchstatus);
        this.finishAffinity();
        startActivity(i);

    }
}
