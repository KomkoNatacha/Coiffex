package ca.dmi.uqtr.coiffex3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import ca.dmi.uqtr.coiffex3.db.model.CoiffexInfo;
import ca.dmi.uqtr.coiffex3.db.repos.CoiffexRepository;
import ca.dmi.uqtr.coiffex3.db.repos.CoiffureDB;


public class Inscription extends AppCompatActivity {
    // Déclarer les variables pour les vues ici
    EditText nom, prenom, number, email, password, cnfrmpass;
    Button signup;
    RadioButton cbclient, cbcoiffeur;

    CoiffexRepository repoCoiffex;
    private TextView account;

    // Déclarer la variable de classe ici
    private int checkedId;

    private String role;    // variable pour stocker le rôle sélectionné

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        // Instancier la base de données Room
        CoiffureDB coiffureDB = Room.databaseBuilder(getApplicationContext(),
                CoiffureDB.class, "coiffex_database").build();
        // Obtenir l'objet DAO de la base de données Room
        repoCoiffex = new CoiffexRepository((CoiffexApp) getApplicationContext());

        account = findViewById(R.id.text_account);
        nom = findViewById(R.id.edit_nom);
        prenom = findViewById(R.id.edit_prenom);
        number = findViewById(R.id.edit_number);
        email = findViewById(R.id.edit_email);
        password = findViewById(R.id.edit_password);
        cnfrmpass = findViewById(R.id.edit_confirmation_password);

        signup = findViewById(R.id.button_singup);

        cbclient = findViewById(R.id.radio_client);
        cbcoiffeur = findViewById(R.id.radio_coiffeur);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupBtn(v);
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

        RadioGroup radioGroup = findViewById(R.id.Radio_group);
        // Affecter la valeur à la variable de classe ici
        checkedId = radioGroup.getCheckedRadioButtonId();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_client) {
                    // L'utilisateur a sélectionné l'option "Client"
                    role = "cleint";
                } else if (checkedId == R.id.radio_coiffeur) {
                    // L'utilisateur a sélectionné l'option "Coiffeur"
                    role = "coiffeur";

                }
            }
        });

    }
    // instruction sur le bouton
    public void signupBtn(View view) {
        if (nom.getText().toString().equals("") || email.getText().toString().equals("") ||
                password.getText().toString().equals("") || cnfrmpass.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Please Enter Your Details", Toast.LENGTH_LONG).show();
            return;
        }

        //check if mail is valid
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())
        {
            Toast.makeText(getApplicationContext(), "Please Enter Valid Email", Toast.LENGTH_LONG).show();
            return;
        }

        // check if both password matches
        if(!password.getText().toString().equals(cnfrmpass .getText().toString()))
        {
            Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
        }
        else {


            CoiffexInfo coiffexInfo = new CoiffexInfo(
                    nom.getText().toString(),
                    prenom.getText().toString(),
                    email.getText().toString(),
                    number.getText().toString(),
                    password.getText().toString(),
                    cnfrmpass.getText().toString(),
                    role );

            try {
                repoCoiffex.insert(coiffexInfo);
                Toast.makeText(Inscription.this, "Data Inserted", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Inscription.this, Connexion.class);
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Error inserting data: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }

    }
    private void openActivity3() {
        Intent intent = new Intent(this,Connexion.class);
        startActivity(intent);
    }
}
