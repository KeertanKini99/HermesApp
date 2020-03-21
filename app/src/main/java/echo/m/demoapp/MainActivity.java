package echo.m.demoapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
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

    String[] sourceval = {"CSL04","CSL03","HOD's CABIN","CSL05","CSL06","STAFF ROOM","CABIN (Dr. SHARADA U. SHENOY)","CABIN (Dr. D.K. SREEKANTHA)","CSL07","ISL01","ISL02","BALCONY","ISL03","CSL02","CSL01","STAIRS","PG LAB","CABIN (Dr. ARAVINDA C.V.)","CABIN (Dr. VENUGOPAL P.S.)","CABIN (Dr. ROSHAN FERNANDES)","CABIN (Mr. RADHAKRISHNA D.)","WASHROOMS"};
    String[] destinationval = {"CSL04","CSL03","HOD's CABIN","CSL05","CSL06","STAFF ROOM","CABIN (Dr. SHARADA U. SHENOY)","CABIN (Dr. D.K. SREEKANTHA)","CSL07","ISL01","ISL02","BALCONY","ISL03","CSL02","CSL01","STAIRS","PG LAB","CABIN (Dr. ARAVINDA C.V.)","CABIN (Dr. VENUGOPAL P.S.)","CABIN (Dr. ROSHAN FERNANDES)","CABIN (Mr. RADHAKRISHNA D.)","WASHROOMS"};
    String[] navigate = {"NAVIGATION","About The App", "About Us"}; //For the app and us pages
    final String[] start = new String[2];
    Spinner src;
    Spinner dest;
    Spinner nav; //For the app and us pages
    Button b1,b2;
    Button c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22;
    View lineAB,lineAQ,lineBC,lineCD,lineCL,lineDE,lineDU,lineEF,lineER,lineFG,lineGH,lineHI,lineIJ,lineJS,lineJK,lineKT,lineKL,lineLM,lineMN,lineNO,lineNP,linePQ,lineRS,lineRU,lineST,lineVD,lineVC;
    static int graph[][];
    static int via[][];
    static int rt[][];
    static int v=22;
    static int e=27;
    int[] val;
    int[] path2;
    int[] path;
    int[] pathl;
    int flag=0,count=0;

    int st,dt,p=0;

    Dialog myDialog;
    TextView tclose;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  //App is now fullscreen
        setContentView(R.layout.activity_main);
        //setContentView(new MyView(this));

        //About App and Us Page Navigation
        nav = (Spinner) findViewById(R.id.navspinner);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        final ArrayAdapter<String> about = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, navigate);
        nav.setAdapter(about);

        constraintLayout.setOnTouchListener(new OnSwipeTouchListener(this));

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
        c22=(Button) findViewById(R.id.c22);



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
        lineVD=(View)findViewById(R.id.lineVD);
        lineVC=(View)findViewById(R.id.lineVC);

        myDialog=new Dialog(this);



        graph = new int[v][v];
        via = new int[v][v];
        rt = new int[v][v];
        path2=new int[20];
                       //A B C   D   E   F   G   H   I   J    K   L   M  N   O   P   Q  R  S   T    U
        val=new int[] {
                /*A*/ 0,1,999,999,999,999,999,999,999,999,999,999,999,999,999,999,1,999,999,999,999,999,
                /*B*/ 1,0,1,999,999,999,999,999,999,999,999,999,999,999,999,999,999,999,999,999,999,999,
                /*C*/ 999,1,0,1,999,999,999,999,999,999,999,1,999,999,999,999,999,999,999,999,999,1,
                /*D*/ 999,999,1,0,1,999,999,999,999,999,999,999,999,999,999,999,999,999,999,999,1,1,
                /*E*/ 999,999,999,1,0,1,999,999,999,999,999,999,999,999,999,999,999,1,999,999,999,999,
                /*F*/ 999,999,999,999,1,0,1,999,999,999,999,999,999,999,999,999,999,999,999,999,999,999,
                /*G*/ 999,999,999,999,999,1,0,1,999,999,999,999,999,999,999,999,999,999,999,999,999,999,
                /*H*/ 999,999,999,999,999,999,1,0,1,999,999,999,999,999,999,999,999,999,999,999,999,999,
                /*I*/ 999,999,999,999,999,999,999,1,0,1,999,999,999,999,999,999,999,999,999,999,999,999,
                /*J*/ 999,999,999,999,999,999,999,999,1,0,1,999,999,999,999,999,999,999,1,999,999,999,
                /*K*/ 999,999,999,999,999,999,999,999,999,1,0,1,999,999,999,999,999,999,999,1,999,999,
                /*L*/ 999,999,1,999,999,999,999,999,999,999,1,0,1,999,999,999,999,999,999,999,999,999,
                /*M*/ 999,999,999,999,999,999,999,999,999,999,999,1,0,1,999,999,999,999,999,999,999,999,
                /*N*/ 999,999,999,999,999,999,999,999,999,999,999,999,1,0,1,1,999,999,999,999,999,999,
                /*O*/ 999,999,999,999,999,999,999,999,999,999,999,999,999,1,0,999,999,999,999,999,999,999,
                /*P*/ 999,999,999,999,999,999,999,999,999,999,999,999,999,1,999,0,1,999,999,999,999,999,
                /*Q*/ 1,999,999,999,999,999,999,999,999,999,999,999,999,999,999,1,0,999,999,999,999,999,
                /*R*/ 999,999,999,999,1,999,999,999,999,999,999,999,999,999,999,999,999,0,1,999,1,999,
                /*S*/ 999,999,999,999,999,999,999,999,999,1,999,999,999,999,999,999,999,1,0,1,999,999,
                /*T*/ 999,999,999,999,999,999,999,999,999,999,1,999,999,999,999,999,999,999,1,0,999,999,
                /*U*/ 999,999,999,1,999,999,999,999,999,999,999,999,999,999,999,999,999,1,999,999,0,999,
                /*V*/ 999,999,1,1,999,999,999,999,999,999,999,999,999,999,999,999,999,999,999,999,999,0};
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
               myDialog.setCanceledOnTouchOutside(true);
                /*
                 tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();

                    }
                });
*/                myDialog.show();

            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupb);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();

                    }
                });
                */myDialog.show();


            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupc);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupd);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupe);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();

            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupf);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupg);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popuph);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupi);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });
        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupj);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupk);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });
        c12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupl);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });
        c13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupm);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });
        c14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupn);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });
        c15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupo);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });
        c16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupp);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });
        c17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupq);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });
        c18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupr);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });
        c19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popups);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });
        c20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupt);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupu);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.popupv);
                myDialog.setCanceledOnTouchOutside(true);
                /*tclose=(TextView)myDialog.findViewById(R.id.close);
                tclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });
                */myDialog.show();
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {                  //Generate Button
            @Override
            public void onClick(View view) {
                flag=1;
                c1.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c2.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c3.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c4.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c5.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c6.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c7.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c8.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c9.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c10.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c11.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c12.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c13.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c14.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c15.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c16.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c17.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c18.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c19.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c20.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c21.setBackgroundColor(Color.rgb(244, 246, 247 ));
                c22.setBackgroundColor(Color.rgb(244, 246, 247 ));



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
                lineVD.setBackgroundColor(Color.RED);
                lineVC.setBackgroundColor(Color.RED);



                p=0;
                //Toast.makeText(getApplicationContext(), "pval:" + p, Toast.LENGTH_SHORT).show();
                findpath(st,dt);
                path=new int[p];
                //Toast.makeText(getApplicationContext(), "pval:" + p, Toast.LENGTH_SHORT).show();
                for(int i=0;i<p;i++) {
                    path[i] = path2[i];
                    //Toast.makeText(getApplicationContext(), "" + path[i], Toast.LENGTH_SHORT).show();
                }
                pathl=new int[p-1];

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
                    case 21: c22.setBackgroundColor(Color.GREEN);
                        break;

                }


                }

                for(int i=0;i<p;i++) {
                    if (i + 1 < p) {
                        if ((path[i] == 0 && path[i + 1] == 1) || (path[i] == 1 && path[i + 1] == 0)) {
                            lineAB.setBackgroundColor(Color.GREEN);
                            pathl[i] = 0;
                        }
                        if ((path[i] == 0 && path[i + 1] == 16) || (path[i] == 16 && path[i + 1] == 0)) {
                            lineAQ.setBackgroundColor(Color.GREEN);
                            pathl[i]=1;
                        }
                        if ((path[i] == 1 && path[i + 1] == 2) || (path[i] == 2 && path[i + 1] == 1)) {
                            lineBC.setBackgroundColor(Color.GREEN);
                            pathl[i] = 2;
                        }
                        if ((path[i] == 2 && path[i + 1] == 3) || (path[i] == 3 && path[i + 1] == 2)) {
                            lineCD.setBackgroundColor(Color.GREEN);
                            pathl[i]=3;
                        }
                        if ((path[i] == 2 && path[i + 1] == 11) || (path[i] == 11 && path[i + 1] == 2)) {
                            lineCL.setBackgroundColor(Color.GREEN);
                            pathl[i]=4;
                        }
                        if ((path[i] == 3 && path[i + 1] == 4) || (path[i] == 4 && path[i + 1] == 3)) {
                            lineDE.setBackgroundColor(Color.GREEN);
                            pathl[i]=5;
                        }
                        if ((path[i] == 3 && path[i + 1] == 20) || (path[i] == 20 && path[i + 1] == 3)) {
                            lineDU.setBackgroundColor(Color.GREEN);
                            pathl[i]=6;

                        }
                        if ((path[i] == 4 && path[i + 1] == 5) || (path[i] == 5 && path[i + 1] == 4)) {
                            lineEF.setBackgroundColor(Color.GREEN);
                            pathl[i]=7;

                        }
                        if ((path[i] == 4 && path[i + 1] == 17) || (path[i] == 17 && path[i + 1] == 4)) {
                            lineER.setBackgroundColor(Color.GREEN);
                            pathl[i]=8;

                        }
                        if ((path[i] == 5 && path[i + 1] == 6) || (path[i] == 6 && path[i + 1] == 5)) {
                            lineFG.setBackgroundColor(Color.GREEN);
                            pathl[i]=9;

                        }
                        if ((path[i] == 6 && path[i + 1] == 7) || (path[i] == 7 && path[i + 1] == 6)) {
                            lineGH.setBackgroundColor(Color.GREEN);
                            pathl[i]=10;
                        }
                        if ((path[i] == 7 && path[i + 1] == 8) || (path[i] == 8 && path[i + 1] == 7)) {
                            lineHI.setBackgroundColor(Color.GREEN);
                            pathl[i]=11;

                        }
                        if ((path[i] == 8 && path[i + 1] == 9) || (path[i] == 9 && path[i + 1] == 8)) {
                            lineIJ.setBackgroundColor(Color.GREEN);
                            pathl[i] = 12;
                        }
                        if ((path[i] == 9 && path[i + 1] == 18) || (path[i] == 18 && path[i + 1] == 9)) {
                            lineJS.setBackgroundColor(Color.GREEN);
                            pathl[i] = 13;
                        }
                        if ((path[i] == 9 && path[i + 1] == 10) || (path[i] == 10 && path[i + 1] == 9)) {
                            lineJK.setBackgroundColor(Color.GREEN);
                            pathl[i] = 14;
                        }
                        if ((path[i] == 10 && path[i + 1] == 19) || (path[i] == 19 && path[i + 1] == 10)) {
                            lineKT.setBackgroundColor(Color.GREEN);
                            pathl[i] = 15;
                        }
                        if ((path[i] == 10 && path[i + 1] == 11) || (path[i] == 11 && path[i + 1] == 10)) {
                            lineKL.setBackgroundColor(Color.GREEN);
                            pathl[i] = 16;
                        }
                        if ((path[i] == 11 && path[i + 1] == 12) || (path[i] == 12 && path[i + 1] == 11)) {
                            lineLM.setBackgroundColor(Color.GREEN);
                            pathl[i] = 17;
                        }
                        if ((path[i] == 12 && path[i + 1] == 13) || (path[i] == 13 && path[i + 1] == 12)) {
                            lineMN.setBackgroundColor(Color.GREEN);
                            pathl[i] = 18;
                        }
                        if ((path[i] == 13 && path[i + 1] == 14) || (path[i] == 14 && path[i + 1] == 13)) {
                            lineNO.setBackgroundColor(Color.GREEN);
                            pathl[i] = 19;
                        }
                        if ((path[i] == 13 && path[i + 1] == 15) || (path[i] == 15 && path[i + 1] == 13)) {
                            lineNP.setBackgroundColor(Color.GREEN);
                            pathl[i] = 20;
                        }
                        if ((path[i] == 15 && path[i + 1] == 16) || (path[i] == 16 && path[i + 1] == 15)) {
                            linePQ.setBackgroundColor(Color.GREEN);
                            pathl[i] = 21;
                        }
                       if ((path[i] == 17 && path[i + 1] == 18) || (path[i] == 18 && path[i + 1] == 17)) {
                           lineRS.setBackgroundColor(Color.GREEN);
                           pathl[i] = 22;
                       }
                        if ((path[i] == 17 && path[i + 1] == 20) || (path[i] == 20 && path[i + 1] == 17)) {
                            lineRU.setBackgroundColor(Color.GREEN);
                            pathl[i] = 23;
                        }
                        if ((path[i] == 18 && path[i + 1] == 19) || (path[i] == 19 && path[i + 1] == 18)) {
                            lineST.setBackgroundColor(Color.GREEN);
                            pathl[i] = 24;
                        }
                        if ((path[i] == 21 && path[i + 1] == 3) || (path[i] == 3 && path[i + 1] == 21)) {
                            lineVD.setBackgroundColor(Color.GREEN);
                            pathl[i] = 25;
                        }
                        if ((path[i] == 21 && path[i + 1] == 2) || (path[i] == 2 && path[i + 1] == 21)) {
                            lineVC.setBackgroundColor(Color.GREEN);
                            pathl[i] = 26;
                        }

                    }
                }

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {          //Go button
            @Override
            public void onClick(View v) {

             if(flag==0 && count==0) {
                  //Toast.makeText(getApplicationContext(), "PLEASE GENERATE A PATH!!", Toast.LENGTH_SHORT).show();
                 AlertDialog.Builder builder
                         = new AlertDialog
                         .Builder(MainActivity.this);
                 builder.setMessage("No generated path recorded.");
                 builder.setTitle("ALERT");

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
              else { flag=0;
                      count++;

                  Intent i = new Intent(MainActivity.this, Main2Activity.class);

                  Bundle bundle = new Bundle();


                  bundle.putIntArray("path", path);
                  bundle.putInt("pval", p);
                  bundle.putIntArray("pathline", pathl);


                  i.putExtras(bundle);


                  startActivity(i);
              }

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
            if(start[0]=="CSL04")
                st=0;
            else if(start[0]=="CSL03")
                st=1;
            else if(start[0]=="HOD's CABIN")
                st=2;
            else if(start[0]=="CSL05")
                st=3;
            else if(start[0]=="CSL06")
                st=4;
            else if(start[0]=="STAFF ROOM")
                st=5;
            else if(start[0]=="CABIN (Dr. SHARADA U. SHENOY)")
                st=6;
            else if(start[0]=="CABIN (Dr. D.K. SREEKANTHA)")
                st=7;
            else if(start[0]=="CSL07")
                st=8;
            else if(start[0]=="ISL01")
                st=9;
            else if(start[0]=="ISL02")
                st=10;
            else if(start[0]=="BALCONY")
                st=11;
            else if(start[0]=="ISL03")
                st=12;
            else if(start[0]=="CSL02")
                st=13;
            else if(start[0]=="CSL01")
                st=14;
            else if(start[0]=="STAIRS")
                st=15;
            else if(start[0]=="PG LAB")
                st=16;
            else if(start[0]=="CABIN (Dr. ARAVINDA C.V.)")
                st=17;
            else if(start[0]=="CABIN (Dr. VENUGOPAL P.S.)")
                st=18;
            else if(start[0]=="CABIN (Dr. ROSHAN FERNANDES)")
                st=19;
            else if(start[0]=="CABIN (Mr. RADHAKRISHNA D.)")
                st=20;
            else if(start[0]=="WASHROOMS")
                st=21;
           // Toast.makeText(getApplicationContext(),"src:"+st,Toast.LENGTH_SHORT).show();


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

            if(start[1]=="CSL04")
                dt=0;
            else if(start[1]=="CSL03")
                dt=1;
            else if(start[1]=="HOD's CABIN")
                dt=2;
            else if(start[1]=="CSL05")
                dt=3;
            else if(start[1]=="CSL06")
                dt=4;
            else if(start[1]=="STAFF ROOM")
                dt=5;
            else if(start[1]=="CABIN (Dr. SHARADA U. SHENOY)")
                dt=6;
            else if(start[1]=="CABIN (Dr. D.K. SREEKANTHA)")
                dt=7;
            else if(start[1]=="CSL07")
                dt=8;
            else if(start[1]=="ISL01")
                dt=9;
            else if(start[1]=="ISL02")
                dt=10;
            else if(start[1]=="BALCONY")
                dt=11;
            else if(start[1]=="ISL03")
                dt=12;
            else if(start[1]=="CSL02")
                dt=13;
            else if(start[1]=="CSL01")
                dt=14;
            else if(start[1]=="STAIRS")
                dt=15;
            else if(start[1]=="PG LAB")
                dt=16;
            else if(start[1]=="CABIN (Dr. ARAVINDA C.V.)")
                dt=17;
            else if(start[1]=="CABIN (Dr. VENUGOPAL P.S.)")
                dt=18;
            else if(start[1]=="CABIN (Dr. ROSHAN FERNANDES)")
                dt=19;
            else if(start[1]=="CABIN (Mr. RADHAKRISHNA D.)")
                dt=20;
            else if(start[1]=="WASHROOMS")
                dt=21;
            //Toast.makeText(getApplicationContext(),"dest:"+dt,Toast.LENGTH_SHORT).show();


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }


    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(MainActivity.this);

        builder.setMessage("Do you want to exit ?");

        builder.setTitle("Close App");

        builder.setCancelable(false);
        builder
                .setPositiveButton(
                        "Yes",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {
                                //Toast.makeText(getApplicationContext(), "App closed", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });


        builder
                .setNegativeButton(
                        "No",
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

    //Handling double tap on the screen
    class OnSwipeTouchListener implements View.OnTouchListener {

        private final GestureDetector gestureDetector;

        public OnSwipeTouchListener(Context ctx) {
            gestureDetector = new GestureDetector(ctx, new GestureListener());
        }
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return gestureDetector.onTouchEvent(event);
        }
        private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
            private static final int SWIPE_THRESHOLD = 300;
            private static final int SWIPE_VELOCITY_THRESHOLD = 300;
            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                return true;
            }
            @Override
            public void onLongPress(MotionEvent e) {
            }
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                nav.performClick();
                nav.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String jump = parent.getItemAtPosition(position).toString();

                        if(jump=="About Us")
                        {
                            Intent i1 = new Intent(getApplicationContext(), AboutUsActivity.class);
                            startActivity(i1);
                        }
                        if(jump=="About The App")
                        {
                            Intent i2 = new Intent(getApplicationContext(), AboutAppActivity.class);
                            startActivity(i2);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                return true;
            }
        }
    }
}
