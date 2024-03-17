package ca.dmi.uqtr.coiffex3.client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
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
import ca.dmi.uqtr.coiffex3.coiffeur.MessagesCoiffeur;

public class PageClient extends AppCompatActivity {
    Button button,button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_client);
        addFragment(new Home());

        BottomNavigationView bmv = findViewById(R.id.bottomAppBar);
        bmv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FrameLayout frameLayout = findViewById(R.id.framePrincipale);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment f = null;
                if (item.getItemId() == R.id.home){
                    f = new Home();
                }


                if (item.getItemId() == R.id.profil){
                    f = new ProfileClient();
                }
                if (item.getItemId() == R.id.placeholder){
                    f = new MessagesClient();
                }

                if (item.getItemId() == R.id.favoris){
                    f = new Favorite();
                }

                if (item.getItemId() == R.id.settings){
                    f = new Settings();
                }

                if (f != null){
                    frameLayout.removeAllViews();
                    fragmentTransaction.add(R.id.framePrincipale, f);
                    fragmentTransaction.commit();
                }

                return false;
            }

        });

    }

    private void addFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.framePrincipale, fragment)
                .commit();
    }
}