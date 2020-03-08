package echo.m.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String[] sourceval = {"A","B","C","D","E","F"};
    String[] destinationval = {"A","B","C","D","E","F"};
    final String[] start = new String[2];
    Spinner src;
    Spinner dest;
    Button b1;
    static int graph[][];
    static int via[][];
    static int rt[][];
    static int v=6;
    static int e=5;
    int[] val;
    int[] path2;
    int[] path;

    int st,dt,p=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        src = (Spinner) findViewById(R.id.spinner);
        dest = (Spinner) findViewById(R.id.spinner2);
        b1 = (Button) findViewById(R.id.button);
        graph = new int[v][v];
        via = new int[v][v];
        rt = new int[v][v];
        path2=new int[20];
        val=new int[] {0,1,999,1,999,999,1,0,1,999,999,999,999,1,0,999,999,999,1,999,999,0,1,999,999,999,999,1,0,1,999,999,999,999,1,0};
        int d=0;
        for(int i = 0; i < v; i++)
            for(int j = 0; j < v; j++)
            {
                graph[i][j]=val[d];
                d++;
            }

        for(int i = 0; i < v; i++)
        {
            for(int j = 0; j < v; j++)
            {
                if(i == j)
                {
                    rt[i][j] = 0;
                    via[i][j] = i;
                }
                else
                {
                    rt[i][j] = 999;
                    via[i][j] = 100;
                }
            }
        }


        int k = 0;
        for(int i = 0; i < 4*v; i++)
        {
            update_table(k);
            k++;
            if(k == v)
                k = 0;
        }




        final ArrayAdapter<String> a1 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, sourceval);
        ArrayAdapter<String> a2 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, destinationval);
        src.setAdapter(a1);
        dest.setAdapter(a2);
        src.setOnItemSelectedListener(new sourceclass());
        dest.setOnItemSelectedListener(new destclass());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Source: " + start[0] + " \tDestination: " + start[1] ,Toast.LENGTH_SHORT).show();
               // startActivity(new Intent(MainActivity.this, Main2Activity.class));

                /*if(start[1]=="C") {
                    startActivity(new Intent(MainActivity.this, Main2Activity.class));
                }
                else{
                    startActivity(new Intent(MainActivity.this, Main3Activity.class));
                }*/
                //Toast.makeText(getApplicationContext(),""+path.length,Toast.LENGTH_SHORT).show();
                p=0;
                findpath(st,dt);
                path=new int[p];
                //Toast.makeText(getApplicationContext(), "pval:" + p, Toast.LENGTH_SHORT).show();
                for(int i=0;i<p;i++) {
                    path[i] = path2[i];
                    //Toast.makeText(getApplicationContext(), "" + path[i], Toast.LENGTH_SHORT).show();
                }

                Intent i = new Intent(MainActivity.this, Main2Activity.class);

                Bundle bundle = new Bundle();


                bundle.putIntArray("path",path);
                bundle.putInt("pval",p);


                i.putExtras(bundle);


                startActivity(i);
            }
        });


    }
    public void update_table(int source)
    {
        for(int i = 0; i < v; i++)
        {
            if(graph[source][i] != 999)
            {
                int dist = graph[source][i];
                for(int j = 0; j < v; j++)
                {
                    int inter_dist = rt[i][j];
                    if(via[i][j] == source)
                        inter_dist = 999;
                    if(dist + inter_dist < rt[source][j])
                    {
                        rt[source][j] = dist + inter_dist;
                        via[source][j] = i;
                    }
                }
            }
        }


    }
    public void findpath(int i,int j)
    {
      path2[p]=i;

        //Toast.makeText(getApplicationContext(),"path:"+path[p],Toast.LENGTH_SHORT).show();
        p++;
      if(i!=j)
      {
          findpath(via[i][j],j);
      }





    }

    private class sourceclass implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            start[0] = parent.getItemAtPosition(position).toString();
            if(start[0]=="A")
                st=0;
            else if(start[0]=="B")
                st=1;
            else if(start[0]=="C")
                st=2;
            else if(start[0]=="D")
                st=3;
            else if(start[0]=="E")
                st=4;
            else if(start[0]=="F")
                st=5;
            //Toast.makeText(getApplicationContext(),"src:"+st,Toast.LENGTH_SHORT).show();


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class destclass implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //start[1] = parent.getItemAtPosition(position).toString();
            start[1] = parent.getItemAtPosition(position).toString();

            if(start[1]=="A")
                dt=0;
            else if(start[1]=="B")
                dt=1;
            else if(start[1]=="C")
                dt=2;
            else if(start[1]=="D")
                dt=3;
            else if(start[1]=="E")
                dt=4;
            else if(start[1]=="F")
                dt=5;
            //Toast.makeText(getApplicationContext(),"dest:"+dt,Toast.LENGTH_SHORT).show();


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
