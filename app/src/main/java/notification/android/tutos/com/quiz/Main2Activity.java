package notification.android.tutos.com.quiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

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

    QuestionBank<Question>  questionsnBank =   new QuestionBank<Question>(Arrays.asList(question1,question2,question3))  ;

    private TextView titre;
    private Button ansewr1;
    private Button ansewr2;
    private Button ansewr3;
    private Button ansewr4;
    public int mNumberOfQuestions = 4;
    int indice =questionsnBank.getmNextQuestionIndex();
    public int score= 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       // Intent intent = getIntent();
        //Integer value = Integer.parseInt(intent.getStringExtra("key"));
        //String titre2 = question2.getmQuestion();
        //String titre3 = question3.getmQuestion();

        reLoad(questionsnBank.getmQuestionList().get(indice));

        ansewr1.setOnClickListener(listchoix);
        ansewr2.setOnClickListener(listchoix);
        ansewr3.setOnClickListener(listchoix);
        ansewr4.setOnClickListener(listchoix);



    }
    public void reLoad(Question question ) {
        if (indice <3 ) {

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
            final  Intent intent = getIntent();
            String nom = intent.getStringExtra(MainActivity.MESSAGE);
            builder.setTitle("Score "+nom)
                    .setMessage(" Votre score est :"+ score)
                    .setPositiveButton ("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .create()
                    .show();
            //Intent intent =  new Intent(Main2Activity.this,FinActivity.class);
             // intent.putExtra(MESSAGE,score);
           // startActivityForResult(intent,0);
           // startActivity(intent
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
                   reLoad(questionsnBank.getmQuestionList().get(indice++));
                    break;



                case R.id.activity_game_answer2_btn :

                    id = view.getId();



                    if(questionsnBank.getmQuestionList().get(indice).getmAnswerIndex()==(1) ){

                        score ++ ;
                        Toast.makeText(Main2Activity.this, "True", Toast.LENGTH_SHORT).show();


                    }
                    else {
                        Toast.makeText(Main2Activity.this, "False", Toast.LENGTH_SHORT).show();}


                    reLoad(questionsnBank.getmQuestionList().get(indice++));
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
                    reLoad(questionsnBank.getmQuestionList().get(indice++));

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


                    reLoad(questionsnBank.getmQuestionList().get(indice++));
                    break;

                default:
                    break;
            }


        }
    };

