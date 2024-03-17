package ca.dmi.uqtr.coiffex3.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ca.dmi.uqtr.coiffex3.R;

public class ChoixCoiffure extends AppCompatActivity {

    private Button boutonReserv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_choix_coiffure);
        String name = getIntent().getStringExtra("Nom");
        int image = getIntent().getIntExtra("Image",0);


        TextView nom_t = findViewById(R.id.nom_coi);
        ImageView image_t = findViewById(R.id.image_coi);

        nom_t.setText(name);
        image_t.setImageResource(image);


        boutonReserv=(Button) findViewById(R.id.button_coi);
        boutonReserv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openReserv();
            }
        });


    }

    private void openReserv() {
        Intent intent = new Intent(this, ReservationClient.class);
        startActivity(intent);
    }
}