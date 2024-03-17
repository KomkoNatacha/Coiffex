package ca.dmi.uqtr.coiffex3.client;





import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import ca.dmi.uqtr.coiffex3.R;



public class ReservationClient extends AppCompatActivity  {

    TextView heure;
    TextView date;
    //TextView nom;

    Button reserver;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_client);

        db = FirebaseFirestore.getInstance();

        // Lier les TextView et le bouton à leurs éléments correspondants dans le layout
        date = (TextView) findViewById(R.id.date_ed);
        heure = (TextView) findViewById(R.id.heure_ed);
        //nom = (TextView) findViewById(R.id.coiffeur_tx);
        reserver = findViewById(R.id.button_suivant);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDate();
            }
        });

        heure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               setTime();
            }
        });

        reserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Récupérer les informations de la réservation
                String heureText = heure.getText().toString();
                String dateText = date.getText().toString();
                //String nomText = nom.getText().toString();


                // Créer un nouveau document pour la réservation
                Map<String, Object> reservation = new HashMap<>();
                reservation.put("heure", heureText);
                reservation.put("date", dateText);
                //reservation.put("nom", nomText);

                // Ajouter le document à la collection "reservations"
                db.collection("reservations")
                        .add(reservation)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {

                            public void onSuccess(DocumentReference documentReference) {
                                // Reservation added successfully
                                Toast.makeText(ReservationClient.this, "Réservation ajoutée avec succès!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ReservationClient.this, "Erreur lors de l'ajout de la réservation.", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }



    private void setTime() {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        TimePickerDialog t = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String showTime = hourOfDay + " : " + minute;
                heure.setText(showTime);
            }
        } ,hour,minute,true );
        t.show();

    }

    public void setDate() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog d = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String showDate = dayOfMonth + " / " + month + " / " + year;
                date.setText(showDate);
            }
        }, year, month, day);
        d.show();

    }


}