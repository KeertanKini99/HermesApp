package echo.m.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import static android.view.View.GONE;
import static android.widget.RelativeLayout.TRUE;


public class MainActivity extends AppCompatActivity {

    String[] sourceval = {"A","B","C","D","E","F"};
    String[] destinationval = {"A","B","C","D","E","F"};
    final String[] start = new String[2];
    Spinner src;
    Spinner dest;
    Button b1,b2;
    EditText c1,c2,c3,c4,c5,c6;
    View lineAD,lineAB,lineBC,lineDE,lineEF;
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
        //setContentView(new MyView(this));
        src = (Spinner) findViewById(R.id.spinner);
        dest = (Spinner) findViewById(R.id.spinner2);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        c1=(EditText)findViewById(R.id.c1);
        c2=(EditText)findViewById(R.id.c2);
        c3=(EditText)findViewById(R.id.c3);
        c4=(EditText)findViewById(R.id.c4);
        c5=(EditText)findViewById(R.id.c5);
        c6=(EditText)findViewById(R.id.c6);
        lineAB=(View)findViewById(R.id.lineAB);
        lineAD=(View)findViewById(R.id.lineAD);
        lineBC=(View)findViewById(R.id.lineBC);
        lineDE=(View)findViewById(R.id.lineDE);
        lineEF=(View)findViewById(R.id.lineEF);

        graph = new int[v][v];
        via = new int[v][v];
        rt = new int[v][v];
        path2=new int[20];
        val=new int[] {0,1,999,1,999,999,
                1,0,1,999,999,999,999,1,0,999,999,999,1,999,999,0,1,999,999,999,999,1,0,1,999,999,999,999,1,0};
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
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c1.setBackgroundColor(Color.YELLOW);
                c2.setBackgroundColor(Color.YELLOW);
                c3.setBackgroundColor(Color.YELLOW);
                c4.setBackgroundColor(Color.YELLOW);
                c5.setBackgroundColor(Color.YELLOW);
                c6.setBackgroundColor(Color.YELLOW);
                lineAB.setBackgroundColor(Color.RED);
                lineBC.setBackgroundColor(Color.RED);
                lineAD.setBackgroundColor(Color.RED);
                lineDE.setBackgroundColor(Color.RED);
                lineEF.setBackgroundColor(Color.RED);


                p=0;
                findpath(st,dt);
                path=new int[p];
                //Toast.makeText(getApplicationContext(), "pval:" + p, Toast.LENGTH_SHORT).show();
                for(int i=0;i<p;i++) {
                    path[i] = path2[i];
                    //Toast.makeText(getApplicationContext(), "" + path[i], Toast.LENGTH_SHORT).show();
                }

                for(int i=0;i<p;i++)
                { switch(path[i])
                {
                    case 0: c1.setBackgroundColor(Color.GREEN);

                              /* if (path[i + 1] == 1)
                                   lineAB.setBackgroundColor(Color.GREEN);
                               if (path[i + 1] == 3)
                                   lineAD.setBackgroundColor(Color.GREEN);*/



                        break;
                    case 1: c2.setBackgroundColor(Color.GREEN);

                            /*if (path[i + 1] == 2)
                                lineBC.setBackgroundColor(Color.GREEN);*/

                        break;
                    case 2: c3.setBackgroundColor(Color.GREEN);
                        break;
                    case 3: c4.setBackgroundColor(Color.GREEN);

                           /*if (path[i + 1] == 4)
                               lineDE.setBackgroundColor(Color.GREEN);*/

                        break;
                    case 4: c5.setBackgroundColor(Color.GREEN);

                          /*if (path[i + 1] == 5)
                              lineEF.setBackgroundColor(Color.GREEN);*/


                        break;
                    case 5: c6.setBackgroundColor(Color.GREEN);
                        break;

                }


                }

                for(int i=0;i<p;i++) {
                    if (i + 1 < p) {
                        if ((path[i] == 0 && path[i + 1] == 1) || (path[i] == 1 && path[i + 1] == 0))
                            lineAB.setBackgroundColor(Color.GREEN);


                        if ((path[i] == 1 && path[i + 1] == 2) || (path[i] == 2 && path[i + 1] == 1))
                            lineBC.setBackgroundColor(Color.GREEN);

                        if ((path[i] == 0 && path[i + 1] == 3) || (path[i] == 3 && path[i + 1] == 1))
                            lineAD.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 3 && path[i + 1] == 4) || (path[i] == 4 && path[i + 1] == 3))
                            lineDE.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 4 && path[i + 1] == 5) || (path[i] == 5 && path[i + 1] == 4))
                            lineEF.setBackgroundColor(Color.GREEN);
                    }
                }








            }
        });

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


                Intent i = new Intent(MainActivity.this, Main2Activity.class);

                Bundle bundle = new Bundle();


                bundle.putIntArray("path",path);
                bundle.putInt("pval",p);


                i.putExtras(bundle);


                startActivity(i);

            }
        });


    }
    /*public class MyView extends View{
        public MyView(Context context)
        {super(context);

        }
        @Override
        protected void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);
            int x=getWidth();
            int y=getHeight();
            int radius=50;
            Paint paint=new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);
            paint.setColor(Color.RED);
            canvas.drawCircle(x/2,y/2,radius,paint);

        }

        }*/


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
