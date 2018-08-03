package notification.android.tutos.com.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinActivity extends AppCompatActivity {

    private TextView score ;
    private Button retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);

        score = (TextView) findViewById(R.id.score);
        retour = (Button) findViewById(R.id.retour);

        Bundle resul = getIntent().getExtras();
        int scoreN = (Integer) resul.get("score");
        score.setText(scoreN);

        retour.setOnClickListener(retourButton);
    }
    private View.OnClickListener retourButton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent =  new Intent(FinActivity.this,Main2Activity.class);
            startActivity(intent);

        }
    };
}
