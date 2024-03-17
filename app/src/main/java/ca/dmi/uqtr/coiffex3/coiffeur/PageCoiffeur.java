package ca.dmi.uqtr.coiffex3.coiffeur;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import ca.dmi.uqtr.coiffex3.R;
import ca.dmi.uqtr.coiffex3.client.Favorite;
import ca.dmi.uqtr.coiffex3.client.Home;
import ca.dmi.uqtr.coiffex3.client.MessagesClient;
import ca.dmi.uqtr.coiffex3.client.ProfileClient;
import ca.dmi.uqtr.coiffex3.client.Settings;

public class PageCoiffeur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_coiffeur);
        addFragment(new MessagesCoiffeur());

        BottomNavigationView bmv = findViewById(R.id.AppBarCoiffeur);
        bmv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FrameLayout frameLayout = findViewById(R.id.frameCoiffeur);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Fragment f =null;

                if (item.getItemId() == R.id.messages_coif){
                    f = new MessagesCoiffeur();
                }


                if (item.getItemId() == R.id.mes_reservations_coif){
                    f = new ReservationCoiffeur();
                }
                if (item.getItemId() == R.id.maps_coif){
                    f = new Maps();
                }

                if (item.getItemId() == R.id.profil_coif){
                    f = new ProfileCoiffeur();
                }


                if (f != null){
                    frameLayout.removeAllViews();
                    fragmentTransaction.add(R.id.frameCoiffeur, f);
                    fragmentTransaction.commit();
                }

                return false;
            }

        });


    }

    private void addFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameCoiffeur, fragment)
                .commit();
    }

}