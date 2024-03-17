package ca.dmi.uqtr.coiffex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import ca.dmi.uqtr.coiffex3.client.PageClient;
import ca.dmi.uqtr.coiffex3.coiffeur.PageCoiffeur;
import ca.dmi.uqtr.coiffex3.db.model.CoiffexInfo;
import ca.dmi.uqtr.coiffex3.db.repos.CoiffexRepository;

public class Connexion extends AppCompatActivity {

    private TextView register;
    private Button login;
    CoiffexRepository repoCoiffex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        register=(TextView) findViewById(R.id.text_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }

        });

        repoCoiffex = new CoiffexRepository((CoiffexApp) getApplicationContext());



        login = findViewById(R.id.buttonLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText email = findViewById(R.id.edit_mail);
                EditText password = findViewById(R.id.edit_mot_de_pas);
                password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                String txtemail = email.getText().toString();
                String txtpassword = password.getText().toString();

                CoiffexInfo user = null;
                try {
                    user = repoCoiffex.getUser(txtemail, txtpassword);
                } catch (ExecutionException | InterruptedException e) {
                    Log.d("asdasd" , e.toString());
                    Toast.makeText(Connexion.this, "Echec COnnexion" + e.toString(), Toast.LENGTH_LONG).show();
                }

                boolean isLoggedIn = false;

                if (user != null) {
                    Toast.makeText(Connexion.this, "Bravo vous pouvez utiliser notre application", Toast.LENGTH_LONG).show();
                    String userRole = user.getRole();
                    if(userRole.equals("coiffeur")){
                        openPageCoiffeur();
                    } else {
                        openPageClient();
                    }
                }
                else {
                    Toast.makeText(Connexion.this, "Echec COnnexion", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void openPageCoiffeur() {
        Intent intent = new Intent(Connexion.this, PageCoiffeur.class);
        startActivity(intent);
    }

    private void openPageClient() {
        Intent intent = new Intent(Connexion.this, PageClient.class);
        startActivity(intent);
    }






    private void openActivity2() {
        Intent intent = new Intent(this, Inscription.class);
        startActivity(intent);
    }
}

