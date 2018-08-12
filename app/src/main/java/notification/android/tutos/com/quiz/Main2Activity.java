package notification.android.tutos.com.quiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2Activity extends AppCompatActivity {


   // public static final String MESSAGE= "score";

    Question question1 = new Question("Who is the creator of Android?",
            Arrays.asList("Andy Rubin",
                    "Steve Wozniak",
                    "Jake Wharton",
                    "Paul Smith"),
            0);

    Question question2 = new Question("When did the first man land on the moon?",
            Arrays.asList("1958",
                    "1962",
                    "1967",
                    "1969"),
            3);

    Question question3 = new Question("What is the house number of The Simpsons?",
            Arrays.asList("42",
                    "101",
                    "666",
                    "742"),
            3);

    Question mesQuestion = new Question();


    QuestionBank<Question>  questionsnBank =   new QuestionBank<Question>(Arrays.asList(question1,question2,question3))  ;

    private TextView titre;
    private Button ansewr1;
    private Button ansewr2;
    private Button ansewr3;
    private Button ansewr4;
    public Integer mNumberOfQuestions = 3;
    int indice =questionsnBank.getmNextQuestionIndex();
    public Integer score =0;
    public Integer i = 0;
    public static final String SCORE= "score";
    public static final String NAME ="name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        reLoad(questionsnBank.getmQuestionList().get(indice));

        ansewr1.setOnClickListener(listchoix);
        ansewr2.setOnClickListener(listchoix);
        ansewr3.setOnClickListener(listchoix);
        ansewr4.setOnClickListener(listchoix);



    }
    public void reLoad(Question question ) {

        if (mNumberOfQuestions != 0 ) {

            titre = (TextView) findViewById(R.id.activity_game_question_text);
            String titre1 = questionsnBank.getmQuestionList().get(indice).getmQuestion();
            titre.setText(titre1);
            ansewr1 = (Button) findViewById(R.id.activity_game_answer1_btn);
            ansewr2 = (Button) findViewById(R.id.activity_game_answer2_btn);
            ansewr3 = (Button) findViewById(R.id.activity_game_answer3_btn);
            ansewr4 = (Button) findViewById(R.id.activity_game_answer4_btn);
            ansewr1.setText(questionsnBank.getmQuestionList().get(indice).getmChoiceList().get(0));
            ansewr2.setText(questionsnBank.getmQuestionList().get(indice).getmChoiceList().get(1));
            ansewr3.setText(questionsnBank.getmQuestionList().get(indice).getmChoiceList().get(2));
            ansewr4.setText(questionsnBank.getmQuestionList().get(indice).getmChoiceList().get(3));

        }
        else{
            AlertDialog.Builder builder =new AlertDialog.Builder(this);
            View mview = getLayoutInflater().inflate(R.layout.activity_fin, null);
            final TextView textViewscore = (TextView) mview.findViewById(R.id.score);
            final TextView textViewnom = (TextView) mview.findViewById(R.id.nom);
            final Button buttonRetout = (Button) mview.findViewById(R.id.retour);
            final  Intent intent = getIntent();
            final String nom = intent.getStringExtra(MainActivity.MESSAGE);
            textViewscore.setText("Votre score est : "+score);
            textViewnom.setText(nom);
            builder.setView(mview);
            final AlertDialog alartDialog = builder.create();
            alartDialog.show();

            buttonRetout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    Bundle bundel1 = new Bundle();
                    bundle.putInt(Main2Activity.SCORE, score);
                    bundle.putString(Main2Activity.NAME,nom);
                    intent.putExtras(bundel1);
                    intent.putExtras(bundle);
                    setResult(Activity.RESULT_OK, intent);
                    finish();


                }
            });

            }

    }
    private View.OnClickListener listchoix = new View.OnClickListener() {
        public static final String TAG = "Test";
        @Override
        public void onClick(View view) {

            switch (view.getId())

            {

               case R.id.activity_game_answer1_btn :
                   int id = view.getId();



                       if(questionsnBank.getmQuestionList().get(indice).getmAnswerIndex()==(0) ){


                            score ++ ;
                           Toast.makeText(Main2Activity.this, "True", Toast.LENGTH_SHORT).show();


                       }
                       else {
                           Toast.makeText(Main2Activity.this, "False", Toast.LENGTH_SHORT).show();}
                          mNumberOfQuestions -= 1;
                   new Handler().postDelayed(new Runnable() {
                       @Override
                       public void run() {

                           reLoad(questionsnBank.getmQuestionList().get(indice++));

                       }
                   },500);

                    break;



                case R.id.activity_game_answer2_btn :

                    id = view.getId();



                    if(questionsnBank.getmQuestionList().get(indice).getmAnswerIndex()==(1) ){

                        score ++ ;
                        Toast.makeText(Main2Activity.this, "True", Toast.LENGTH_SHORT).show();


                    }
                    else {
                        Toast.makeText(Main2Activity.this, "False", Toast.LENGTH_SHORT).show();}
                    mNumberOfQuestions -- ;

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            reLoad(questionsnBank.getmQuestionList().get(indice++));

                        }
                    },500);

                    break ;

                case R.id.activity_game_answer3_btn :

                     id = view.getId();



                    if(questionsnBank.getmQuestionList().get(indice).getmAnswerIndex()==(2
                    ) ){

                        score ++ ;
                        Toast.makeText(Main2Activity.this, "True", Toast.LENGTH_SHORT).show();


                    }
                    else {
                        Toast.makeText(Main2Activity.this, "False", Toast.LENGTH_SHORT).show();}
                    mNumberOfQuestions -= 1;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            reLoad(questionsnBank.getmQuestionList().get(indice++));

                        }
                    },500);

                    break;

                case  R.id.activity_game_answer4_btn :

                     id = view.getId();



                    if(questionsnBank.getmQuestionList().get(indice).getmAnswerIndex()==(3) ){

                        score ++ ;
                        Toast.makeText(Main2Activity.this, "True", Toast.LENGTH_SHORT).show();
                        mNumberOfQuestions -= 1;



                    }
                    else {

                        Toast.makeText(Main2Activity.this, "False", Toast.LENGTH_SHORT).show();
                    }


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            reLoad(questionsnBank.getmQuestionList().get(indice++));

                        }
                    },500);
                    break;

                default:
                    break;
            }


        }
    };
}
