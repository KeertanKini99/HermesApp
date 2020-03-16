package echo.m.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
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
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.GONE;
import static android.widget.RelativeLayout.TRUE;


public class MainActivity extends AppCompatActivity {

    String[] sourceval = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U"};
    String[] destinationval = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U"};
    final String[] start = new String[2];
    Spinner src;
    Spinner dest;
    Button b1,b2;
    Button c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21;
    View lineAB,lineAQ,lineBC,lineCD,lineCL,lineDE,lineDU,lineEF,lineER,lineFG,lineGH,lineHI,lineIJ,lineJS,lineJK,lineKT,lineKL,lineLM,lineMN,lineNO,lineNP,linePQ,lineRS,lineRU,lineST;
    static int graph[][];
    static int via[][];
    static int rt[][];
    static int v=21;
    static int e=25;
    int[] val;
    int[] path2;
    int[] path;

    int st,dt,p=0;

    Dialog myDialog;
    TextView tclose;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(new MyView(this));
        src = (Spinner) findViewById(R.id.spinner);
        dest = (Spinner) findViewById(R.id.spinner2);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        c1=(Button) findViewById(R.id.c1);
        c2=(Button) findViewById(R.id.c2);
        c3=(Button) findViewById(R.id.c3);
        c4=(Button) findViewById(R.id.c4);
        c5=(Button) findViewById(R.id.c5);
        c6=(Button) findViewById(R.id.c6);

        c7=(Button) findViewById(R.id.c7);
        c8=(Button) findViewById(R.id.c8);
        c9=(Button) findViewById(R.id.c9);
        c10=(Button) findViewById(R.id.c10);
        c11=(Button) findViewById(R.id.c11);
        c12=(Button) findViewById(R.id.c12);
        c13=(Button) findViewById(R.id.c13);
        c14=(Button) findViewById(R.id.c14);
        c15=(Button) findViewById(R.id.c15);
        c16=(Button) findViewById(R.id.c16);
        c17=(Button) findViewById(R.id.c17);
        c18=(Button) findViewById(R.id.c18);
        c19=(Button) findViewById(R.id.c19);
        c20=(Button) findViewById(R.id.c20);
        c21=(Button) findViewById(R.id.c21);



        lineAB=(View)findViewById(R.id.lineAB);
        lineAQ=(View)findViewById(R.id.lineAQ);
        lineBC=(View)findViewById(R.id.lineBC);
        lineCD=(View)findViewById(R.id.lineCD);
        lineCL=(View)findViewById(R.id.lineCL);
        lineDE=(View)findViewById(R.id.lineDE);
        lineDU=(View)findViewById(R.id.lineDU);
        lineEF=(View)findViewById(R.id.lineEF);
        lineER=(View)findViewById(R.id.lineER);
        lineFG=(View)findViewById(R.id.lineFG);
        lineGH=(View)findViewById(R.id.lineGH);
        lineHI=(View)findViewById(R.id.lineHI);
        lineIJ=(View)findViewById(R.id.lineIJ);
        lineJS=(View)findViewById(R.id.lineJS);
        lineJK=(View)findViewById(R.id.lineJK);
        lineKT=(View)findViewById(R.id.lineKT);
        lineKL=(View)findViewById(R.id.lineKL);
        lineLM=(View)findViewById(R.id.lineLM);
        lineMN=(View)findViewById(R.id.lineMN);
        lineNO=(View)findViewById(R.id.lineNO);
        lineNP=(View)findViewById(R.id.lineNP);
        linePQ=(View)findViewById(R.id.linePQ);
        lineRS=(View)findViewById(R.id.lineRS);
        lineRU=(View)findViewById(R.id.lineRU);
        lineST=(View)findViewById(R.id.lineST);

        myDialog=new Dialog(this);

        graph = new int[v][v];
        via = new int[v][v];
        rt = new int[v][v];
        path2=new int[20];
                     //A B C   D   E   F   G   H   I   J    K   L   M  N   O   P   Q  R  S   T    U
        val=new int[] {0,1,999,999,999,999,999,999,999,999,999,999,999,999,999,999,1,999,999,999,999,
                       1,0,1,999,999,999,999,999,999,999,999,999,999,999,999,999,999,999,999,999,999,
                       999,1,0,1,999,999,999,999,999,999,999,1,999,999,999,999,999,999,999,999,999,
                       999,999,1,0,1,999,999,999,999,999,999,999,999,999,999,999,999,999,999,999,1,
                       999,999,999,1,0,1,999,999,999,999,999,999,999,999,999,999,999,1,999,999,999,
                      999,999,999,999,1,0,1,999,999,999,999,999,999,999,999,999,999,999,999,999,999,
                     999,999,999,999,999,1,0,1,999,999,999,999,999,999,999,999,999,999,999,999,999,
                     999,999,999,999,999,999,1,0,1,999,999,999,999,999,999,999,999,999,999,999,999,
                     999,999,999,999,999,999,999,1,0,1,999,999,999,999,999,999,999,999,999,999,999,
                     999,999,999,999,999,999,999,999,1,0,1,999,999,999,999,999,999,999,1,999,999,
                     999,999,999,999,999,999,999,999,999,1,0,1,999,999,999,999,999,999,999,1,999,
                     999,999,1,999,999,999,999,999,999,999,1,0,1,999,999,999,999,999,999,999,999,
                     999,999,999,999,999,999,999,999,999,999,999,1,0,1,999,999,999,999,999,999,999,
                     999,999,999,999,999,999,999,999,999,999,999,999,1,0,1,1,999,999,999,999,999,
                     999,999,999,999,999,999,999,999,999,999,999,999,999,1,0,999,999,999,999,999,999,
                     999,999,999,999,999,999,999,999,999,999,999,999,999,1,999,0,1,999,999,999,999,
                     1,999,999,999,999,999,999,999,999,999,999,999,999,999,999,1,0,999,999,999,999,
                     999,999,999,999,1,999,999,999,999,999,999,999,999,999,999,999,999,0,1,999,1,
                     999,999,999,999,999,999,999,999,999,1,999,999,999,999,999,999,999,1,0,1,999,
                     999,999,999,999,999,999,999,999,999,999,1,999,999,999,999,999,999,999,1,0,999,
                     999,999,999,1,999,999,999,999,999,999,999,999,999,999,999,999,999,1,999,999,0};
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
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               myDialog.setContentView(R.layout.popupa);
                 tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();

                    }
                });
                myDialog.show();

            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupb);
                tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();

                    }
                });
                myDialog.show();


            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupc);
                tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                myDialog.show();
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupd);
                tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                myDialog.show();
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupe);
                tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                myDialog.show();

            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupf);
                tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                myDialog.show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c1.setBackgroundColor(Color.YELLOW);
                c2.setBackgroundColor(Color.YELLOW);
                c3.setBackgroundColor(Color.YELLOW);
                c4.setBackgroundColor(Color.YELLOW);
                c5.setBackgroundColor(Color.YELLOW);
                c6.setBackgroundColor(Color.YELLOW);
                c7.setBackgroundColor(Color.YELLOW);
                c8.setBackgroundColor(Color.YELLOW);
                c9.setBackgroundColor(Color.YELLOW);
                c10.setBackgroundColor(Color.YELLOW);
                c11.setBackgroundColor(Color.YELLOW);
                c12.setBackgroundColor(Color.YELLOW);
                c13.setBackgroundColor(Color.YELLOW);
                c14.setBackgroundColor(Color.YELLOW);
                c15.setBackgroundColor(Color.YELLOW);
                c16.setBackgroundColor(Color.YELLOW);
                c17.setBackgroundColor(Color.YELLOW);
                c18.setBackgroundColor(Color.YELLOW);
                c19.setBackgroundColor(Color.YELLOW);
                c20.setBackgroundColor(Color.YELLOW);
                c21.setBackgroundColor(Color.YELLOW);



                lineAB.setBackgroundColor(Color.RED);
                lineAQ.setBackgroundColor(Color.RED);
                lineBC.setBackgroundColor(Color.RED);
                lineCD.setBackgroundColor(Color.RED);
                lineCL.setBackgroundColor(Color.RED);
                lineDE.setBackgroundColor(Color.RED);
                lineDU.setBackgroundColor(Color.RED);
                lineEF.setBackgroundColor(Color.RED);
                lineER.setBackgroundColor(Color.RED);
                lineFG.setBackgroundColor(Color.RED);
                lineGH.setBackgroundColor(Color.RED);
                lineHI.setBackgroundColor(Color.RED);
                lineIJ.setBackgroundColor(Color.RED);
                lineJS.setBackgroundColor(Color.RED);
                lineJK.setBackgroundColor(Color.RED);
                lineKT.setBackgroundColor(Color.RED);
                lineKL.setBackgroundColor(Color.RED);
                lineLM.setBackgroundColor(Color.RED);
                lineMN.setBackgroundColor(Color.RED);
                lineNO.setBackgroundColor(Color.RED);
                lineNP.setBackgroundColor(Color.RED);
                linePQ.setBackgroundColor(Color.RED);
                lineRS.setBackgroundColor(Color.RED);
                lineRU.setBackgroundColor(Color.RED);
                lineST.setBackgroundColor(Color.RED);



                p=0;
                Toast.makeText(getApplicationContext(), "pval:" + p, Toast.LENGTH_SHORT).show();
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
                             break;
                    case 1: c2.setBackgroundColor(Color.GREEN);
                             break;
                    case 2: c3.setBackgroundColor(Color.GREEN);
                              break;
                    case 3: c4.setBackgroundColor(Color.GREEN);
                              break;
                    case 4: c5.setBackgroundColor(Color.GREEN);
                              break;
                    case 5: c6.setBackgroundColor(Color.GREEN);
                              break;
                    case 6: c7.setBackgroundColor(Color.GREEN);
                              break;
                    case 7: c8.setBackgroundColor(Color.GREEN);
                              break;
                    case 8: c9.setBackgroundColor(Color.GREEN);
                              break;
                    case 9: c10.setBackgroundColor(Color.GREEN);
                              break;
                    case 10: c11.setBackgroundColor(Color.GREEN);
                        break;
                    case 11: c12.setBackgroundColor(Color.GREEN);
                        break;
                    case 12: c13.setBackgroundColor(Color.GREEN);
                        break;
                    case 13: c14.setBackgroundColor(Color.GREEN);
                        break;
                    case 14: c15.setBackgroundColor(Color.GREEN);
                        break;
                    case 15: c16.setBackgroundColor(Color.GREEN);
                        break;
                    case 16: c17.setBackgroundColor(Color.GREEN);
                        break;
                    case 17: c18.setBackgroundColor(Color.GREEN);
                        break;
                    case 18: c19.setBackgroundColor(Color.GREEN);
                        break;
                    case 19: c20.setBackgroundColor(Color.GREEN);
                        break;
                    case 20: c21.setBackgroundColor(Color.GREEN);
                        break;

                }


                }

                for(int i=0;i<p;i++) {
                    if (i + 1 < p) {
                        if ((path[i] == 0 && path[i + 1] == 1) || (path[i] == 1 && path[i + 1] == 0))
                            lineAB.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 0 && path[i + 1] == 16) || (path[i] == 16 && path[i + 1] == 0))
                            lineAQ.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 1 && path[i + 1] == 2) || (path[i] == 2 && path[i + 1] == 1))
                            lineBC.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 2 && path[i + 1] == 3) || (path[i] == 3 && path[i + 1] == 2))
                            lineCD.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 2 && path[i + 1] == 11) || (path[i] == 11 && path[i + 1] == 2))
                            lineCL.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 3 && path[i + 1] == 4) || (path[i] == 4 && path[i + 1] == 3))
                            lineDE.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 3 && path[i + 1] == 20) || (path[i] == 20 && path[i + 1] == 3))
                            lineDU.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 4 && path[i + 1] == 5) || (path[i] == 5 && path[i + 1] == 4))
                            lineEF.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 4 && path[i + 1] == 17) || (path[i] == 17 && path[i + 1] == 4))
                            lineER.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 5 && path[i + 1] == 6) || (path[i] == 6 && path[i + 1] == 5))
                            lineFG.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 6 && path[i + 1] == 7) || (path[i] == 7 && path[i + 1] == 6))
                            lineGH.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 7 && path[i + 1] == 8) || (path[i] == 8 && path[i + 1] == 7))
                            lineHI.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 8 && path[i + 1] == 9) || (path[i] == 9 && path[i + 1] == 8))
                            lineIJ.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 9 && path[i + 1] == 18) || (path[i] == 18 && path[i + 1] == 9))
                            lineJS.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 9 && path[i + 1] == 10) || (path[i] == 10 && path[i + 1] == 9))
                            lineJK.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 10 && path[i + 1] == 19) || (path[i] == 19 && path[i + 1] == 10))
                            lineKT.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 10 && path[i + 1] == 11) || (path[i] == 11 && path[i + 1] == 10))
                            lineKL.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 11 && path[i + 1] == 12) || (path[i] == 12 && path[i + 1] == 11))
                            lineLM.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 12 && path[i + 1] == 13) || (path[i] == 13 && path[i + 1] == 12))
                            lineMN.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 13 && path[i + 1] == 14) || (path[i] == 14 && path[i + 1] == 13))
                            lineNO.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 13 && path[i + 1] == 15) || (path[i] == 15 && path[i + 1] == 13))
                            lineNP.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 15 && path[i + 1] == 16) || (path[i] == 16 && path[i + 1] == 15))
                            linePQ.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 17 && path[i + 1] == 18) || (path[i] == 18 && path[i + 1] == 17))
                            lineRS.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 17 && path[i + 1] == 20) || (path[i] == 20 && path[i + 1] == 17))
                            lineRU.setBackgroundColor(Color.GREEN);
                        if ((path[i] == 18 && path[i + 1] == 19) || (path[i] == 19 && path[i + 1] == 18))
                            lineST.setBackgroundColor(Color.GREEN);
                    }
                }








            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



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

        Toast.makeText(getApplicationContext(),"path:"+path[p],Toast.LENGTH_SHORT).show();
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
            else if(start[0]=="G")
                st=6;
            else if(start[0]=="H")
                st=7;
            else if(start[0]=="I")
                st=8;
            else if(start[0]=="J")
                st=9;
            else if(start[0]=="K")
                st=10;
            else if(start[0]=="L")
                st=11;
            else if(start[0]=="M")
                st=12;
            else if(start[0]=="N")
                st=13;
            else if(start[0]=="O")
                st=14;
            else if(start[0]=="P")
                st=15;
            else if(start[0]=="Q")
                st=16;
            else if(start[0]=="R")
                st=17;
            else if(start[0]=="S")
                st=18;
            else if(start[0]=="T")
                st=19;
            else if(start[0]=="U")
                st=20;
            Toast.makeText(getApplicationContext(),"src:"+st,Toast.LENGTH_SHORT).show();


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
            else if(start[1]=="G")
                dt=6;
            else if(start[1]=="H")
                dt=7;
            else if(start[1]=="I")
                dt=8;
            else if(start[1]=="J")
                dt=9;
            else if(start[1]=="K")
                dt=10;
            else if(start[1]=="L")
                dt=11;
            else if(start[1]=="M")
                dt=12;
            else if(start[1]=="N")
                dt=13;
            else if(start[1]=="O")
                dt=14;
            else if(start[1]=="P")
                dt=15;
            else if(start[1]=="Q")
                dt=16;
            else if(start[1]=="R")
                dt=17;
            else if(start[1]=="S")
                dt=18;
            else if(start[1]=="T")
                dt=19;
            else if(start[1]=="U")
                dt=20;
            Toast.makeText(getApplicationContext(),"dest:"+dt,Toast.LENGTH_SHORT).show();


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
