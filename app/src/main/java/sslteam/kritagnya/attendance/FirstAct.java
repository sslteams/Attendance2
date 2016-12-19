package sslteam.kritagnya.attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
       // setContentView(R.layout.activity_first);
        Button btn = (Button) findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intc = new Intent(FirstAct.this,MainActivity.class);
                startActivity(intc);
            }
            //public SQLiteDatabase.CursorFactory factory ;
        });

    }
    }

