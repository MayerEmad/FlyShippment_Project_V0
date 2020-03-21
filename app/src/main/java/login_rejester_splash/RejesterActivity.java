package login_rejester_splash;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flyshippment_project.MainActivity;
import com.example.flyshippment_project.R;

public class RejesterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejester);

        /*
           We will create a form to get
           name
           id
           passport number
           phone number
           age
           gender
           countery
           address
           bank account
           email
           password

           And we need to send it To data base
         */

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
