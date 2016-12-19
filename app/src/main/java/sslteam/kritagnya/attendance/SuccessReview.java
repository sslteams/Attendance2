package sslteam.kritagnya.attendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SuccessReview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_review);
        TextView tv = (TextView)findViewById(R.id.tvs);
    }
}
