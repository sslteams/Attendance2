package sslteam.kritagnya.attendance;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class review extends AppCompatActivity implements View.OnClickListener {

    static int count = 0;
    public int d = new Date().getDate();

    public     String dateEq = "the date is   \n" + d + "- " + new Date().getMonth() + " -  " + new Date().getYear();

    public static int [] dupX= new int[66];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        final Intent in = getIntent();

        //final int[] bufA = new int[0];
          final int[] x = in.getIntArrayExtra("Valar");
        dupX = x;
       CharSequence c = "" + x;

        final int lenX = in.getIntExtra("Size", 0);
        for (int i = 0; i < lenX; i++) {
            if (x[i] == 1) {

                LinearLayout ll = (LinearLayout) findViewById(R.id.activity_review);
                // LinearLayout ll = (LinearLayout) findViewById(R.id.elementRow);
                TextView tv = new TextView(this);
                tv.setText("" + (i + 1));
                ll.addView(tv);
                tv.setGravity(View.FOCUS_LEFT);
                //abl.append("\n"+ x[i]);
                final Button myButton = new Button(this);
                myButton.setId(i);
                myButton.setText("absent");
                myButton.setGravity(View.FOCUS_RIGHT);
                myButton.setBackgroundColor(Color.RED);
                ll.addView(myButton);
                myButton.setOnClickListener(this);

            }
            Button saveB = (Button)findViewById(R.id.button5);
            saveB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dbStarter dbs  = new dbStarter(getApplicationContext(),"attendance.db",null ,1);

                    for(int i =0;i<66;i++)
                {

                    dbs.addMe(i,dupX[i]);
                }
                    Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(review.this,SuccessReview.class);
                    startActivity(intent);
                }
            });

        }




    }
    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View v) {

        int idx = v.getId();
        Button btn = (Button) findViewById(idx);
        if((btn.getText())=="absent")
        {
            dupX[idx]=0;
            btn.setText("present");
            btn.setBackgroundColor(Color.GREEN);
        }
        else if (btn.getText()=="present")
        {
            dupX[idx]=1;
            btn.setText("absent");
            btn.setBackgroundColor(Color.RED);
        }

    }
}
