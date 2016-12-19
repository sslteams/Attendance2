package sslteam.kritagnya.attendance;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button abb,psb,gop,undox;
    TextView rno,abc,psc;
    static int absent_count = 0;
    static int present_count = 0;
    static int roll_no = 0;
    int[] roll = new int[66];
   // public ArrayList<Integer> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        abb=(Button)findViewById(R.id.but1);
        psb=(Button)findViewById(R.id.button);
        gop=(Button)findViewById(R.id.button2);
        undox = (Button) findViewById(R.id.undobtn);
        abc=(TextView)findViewById(R.id.acount);
        psc=(TextView)findViewById(R.id.pcount);
        rno = (TextView) findViewById(R.id.textView);
        //arr = new ArrayList<Integer>(66);
        final Intent intent = new Intent(MainActivity.this,review.class );

        final Animation m = new AlphaAnimation(1,0);
        // final Integer Z = new Integer(rc);

        //m.setDuration(500);
        gop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Size",roll_no);
                intent.putExtra("Valar",roll);
                startActivity(intent);

            }
        });
        abb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (roll_no < 66) {
                    absent_count++;
                    roll[roll_no++] = 1;
                    abc.setText("" + absent_count);
                    rno.setText("" + (roll_no + 1));
                   // abc.setBackgroundColor(Color.DKGRAY);
                    abc.setAnimation(m);
                }
                v.clearAnimation();

            }
        });
        undox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (roll[roll_no - 1] == 1) {
                    roll[--roll_no] = 0;
                    absent_count--;
                    abc.setText("" + absent_count);
                    rno.setText("" + (roll_no + 1));

                } else {
                    roll_no--;
                    present_count--;
                    psc.setText("" + present_count);
                    rno.setText("" + (roll_no + 1));
                }
            }
        });

        psb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (roll_no < 66) {

                    present_count++;
                    roll[roll_no++] = 0;
                    v.clearAnimation();
                    psc.setText("" + present_count);
                    rno.setText("" + (roll_no + 1));
                   // psc.setBackgroundColor(Color.DKGRAY);
                    psc.setAnimation(m);
                }
                v.clearAnimation();

            }
        });




    }
}
