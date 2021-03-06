package notification.android.tutos.com.quiz;
        import android.annotation.SuppressLint;
        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.gson.Gson;
        import com.google.gson.GsonBuilder;
        import com.google.gson.JsonArray;
        import com.google.gson.reflect.TypeToken;

        import org.json.JSONArray;
        import org.json.JSONObject;

        import java.lang.reflect.GenericArrayType;
        import java.lang.reflect.Type;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.Collections;
        import java.util.Comparator;
        import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String MESSAGE= "nom";
    public static final String MYPREF= "myPref";
    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton , listScore;
    public ArrayList<User> userList  ;
    private  User user = new User();
    private ListView listUser;
    private  UserAdapter userAdapter;
    private String scoreFinal;
    Gson gson = new GsonBuilder().create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
        mGreetingText = (TextView) findViewById(R.id.activity_main_greeting_txt);
        mNameInput = (EditText) findViewById(R.id.activity_main_name_input);
        mPlayButton = (Button) findViewById(R.id.activity_main_play_btn);
        listScore = (Button) findViewById(R.id.listScore);
        listUser = (ListView) findViewById(R.id.listUser);
        mPlayButton.setEnabled(false);


        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                mPlayButton.setEnabled(charSequence.toString().length() != 0);

            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });
    listScore.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            userAdapter = new UserAdapter(MainActivity.this,userList);
            listUser.setAdapter(userAdapter);
            userAdapter.notifyDataSetChanged();

        }
    });
    mPlayButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent gameActivity = new Intent(MainActivity.this, Main2Activity.class);
            String nameUser = user.setmFirstName(mNameInput.getText().toString());
            gameActivity.putExtra(MESSAGE, nameUser);
            startActivityForResult(gameActivity,2);
            mNameInput.setText("");

        }
    });


    }
    @Override
    protected  void onActivityResult(int requestCode ,int resultCode ,Intent data){

        super.onActivityResult(requestCode,resultCode,data);
        switch(requestCode) {
            case 2:
            if (resultCode == Activity.RESULT_OK) {

                SharedPreferences sharedPreferences = getSharedPreferences(MYPREF,Context.MODE_PRIVATE);
                Bundle res = data.getExtras();
                Integer scorefinale = res.getInt(Main2Activity.SCORE);
                String name = res.getString(Main2Activity.NAME);
                userList.add(new User(name, scorefinale));
                saveData();


                break;
            }
        }
    }
    public void loadData(){
        final SharedPreferences sharedPreferences = getSharedPreferences(MYPREF,Context.MODE_PRIVATE);
        String jsonPreferences = sharedPreferences.getString("userlist","");
        Type type = new TypeToken<ArrayList<User>>(){}.getType();
       // ArrayList<User>  userFromPreferences = gson.fromJson(jsonPreferences,type);
        userList = gson.fromJson(jsonPreferences,type);
        if(userList == null){
            userList = new ArrayList<>();
        }

        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getScore().compareTo(o2.getScore());
            }
        });

    }
    public void saveData(){

        SharedPreferences sharedPreferences = getSharedPreferences(MYPREF,Context.MODE_PRIVATE);
        JsonArray userJsonArray = gson.toJsonTree(userList).getAsJsonArray();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userlist",userJsonArray+"");
        editor.commit();
        Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();

    }

}


