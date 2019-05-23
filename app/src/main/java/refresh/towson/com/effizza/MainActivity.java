package refresh.towson.com.effizza;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button login;
    SharedPreferences sharedPreferences;
    public static final String MyPreferences="MyPrefs";
    ProgressDialog progressDialog;
    public static final String UserEmail = "UserEmail";
    String finalResult ;
    HashMap<String,String> hashMap = new HashMap<>();


    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email= findViewById(R.id.input_email);
        login= findViewById(R.id.login_bt);
        password= findViewById(R.id.input_password);
        sharedPreferences = getSharedPreferences(MyPreferences,Context.MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e=email.getText().toString();
                String p=password.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Email_ID", e);
                editor.commit();
                validate(e,p);

            }
        });
    }





  /*  public void loginAgain(){
        Toast.makeText(getBaseContext(),"Try Again",Toast.LENGTH_LONG).show();
        login.setEnabled(true);
    }

    public void onLoginSuccess(){
        login.setEnabled(true);
        finish();
    }

    public void login(){
        if(!validate()){
            loginAgain();
            return;
        }
    }

    public boolean validate(){
        boolean valid=true;
        String e=email.getText().toString();
        String p=password.getText().toString();
        valid = validate(e,p);
        return valid;
    }*/

    public boolean validate(String e, String p){
        if( e==null){
            email.setError("enter valid email");
            return false;
        }

        if(p==null){
            password.setError("Invalid");
            return false;
        }

        else
        {
            if(e.equals("111")&&p.equals("pass")){
                Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_LONG).show();
            }

        }
        return true;
    }



}
