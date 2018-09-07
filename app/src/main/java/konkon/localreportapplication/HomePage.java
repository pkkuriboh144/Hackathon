package konkon.localreportapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;


public class HomePage extends AppCompatActivity {
    Button login, onlineReport, signUp;
    EditText pass, user;
    //TextView title;

    int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        login = findViewById(R.id.LoginButton);
        pass = findViewById(R.id.Password);
        user = findViewById(R.id.EmailAddress);
        onlineReport = findViewById(R.id.OnlineReport);
        signUp = findViewById(R.id.HomeSignUpBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getText().toString().equals("police@police.com") && pass.getText().toString().equals("doughnut"))
                {
                    Toast.makeText(getApplicationContext(), "Redirectiing...", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(HomePage.this, PoliceView.class);
                    startActivity(i);
                }
                else if(user.getText().toString().equals("personInDistress@hotmail.com") && pass.getText().toString().equals("HELP"))
                {
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    //Intent i = new Intent(HomePage.this, MakeReport.class);
                    //startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials. Please Retry.", Toast.LENGTH_SHORT).show();
                    counter -= 1;
                }

                if(counter == 0)
                {
                    login.setEnabled(false);
                }
            }
         });
        onlineReport.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://home.chicagopolice.org/online-services/online-crime-reporting/"));
                startActivity(i);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "Becoming a snitch...", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(HomePage.this, SignUp.class);
                startActivity(i);
            }
        });
    }
}

    //EditText email = (EditText)findViewById(R.id.EmailAddress);
    //EditText password = (EditText)findViewById(R.id.Password);

