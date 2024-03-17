package ca.dmi.uqtr.coiffex3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;


import com.google.firebase.firestore.FirebaseFirestore;

import ca.dmi.uqtr.coiffex3.coiffeur.PageCoiffeur;


public class MainActivity extends AppCompatActivity {
    // ...


    private Button boutonLogin;
    private Button boutonSign;

    public static FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        db = FirebaseFirestore.getInstance();
        boutonLogin=(Button) findViewById(R.id.button_log);
        boutonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConnexion();
            }
        });

        boutonSign=(Button) findViewById(R.id.button_sign);
        boutonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInscription();
            }
        });

    }

    private void openInscription() {
        Intent intent = new Intent(this, Inscription.class);
        startActivity(intent);
    }

    private void openConnexion() {
        Intent intent = new Intent(this, Connexion.class);
        startActivity(intent);
    }


}





