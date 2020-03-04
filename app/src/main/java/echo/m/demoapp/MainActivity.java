package echo.m.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String[] source = {"A"};
    String[] destination = {"C","F"};
    final String[] start = new String[2];
    Spinner src;
    Spinner dest;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        src = (Spinner) findViewById(R.id.spinner);
        dest = (Spinner) findViewById(R.id.spinner2);
        b1 = (Button) findViewById(R.id.button);

        final ArrayAdapter<String> a1 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, source);
        ArrayAdapter<String> a2 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, destination);
        src.setAdapter(a1);
        dest.setAdapter(a2);
        src.setOnItemSelectedListener(new sourceclass());
        dest.setOnItemSelectedListener(new destclass());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Source: " + start[0] + " \tDestination: " + start[1] ,Toast.LENGTH_SHORT).show();
                if(start[1]=="C") {
                    startActivity(new Intent(MainActivity.this, Main2Activity.class));
                }
                else{
                    startActivity(new Intent(MainActivity.this, Main3Activity.class));
                }
            }
        });

    /*
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] start = new String[2];
                String end;
                //Find the starting position
                src.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String item = parent.getItemAtPosition(position).toString();
                        start[0] = item;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                //Find the destination
                dest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        start[1] = parent.getItemAtPosition(position).toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                Toast.makeText(getApplicationContext(), "Source: " + start[0] + "\nDestination: " + start[1] ,Toast.LENGTH_SHORT).show();

            }
        });
     */
    }

    private class sourceclass implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            start[0] = parent.getItemAtPosition(position).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class destclass implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            start[1] = parent.getItemAtPosition(position).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
