package ca.dmi.uqtr.coiffex3.coiffeur;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

import ca.dmi.uqtr.coiffex3.R;


public class ProfileCoiffeur extends Fragment {

    private EditText textNom;
    private EditText textEmail;
    private EditText textNumber;
    private EditText editAdresse;

    private ImageView editImageProfil;
    private Button btnSave;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_coiffeur, container, false);

        textNom =(EditText) view.findViewById(R.id.nom_profil_coiffeur);
        textEmail =(EditText) view.findViewById(R.id.email_profil_coiffeur);
        textNumber =(EditText) view.findViewById(R.id.numero_profile_coiffeur);
        editAdresse =(EditText) view.findViewById(R.id.edit_address_profile_coiffeur);
        editImageProfil =(ImageView) view.findViewById(R.id.photo_profil_coiffeur);
        btnSave =(Button) view.findViewById(R.id.button_enregister_coiffeur);


        ActivityResultLauncher<Intent> galleryLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent data = result.getData();
                            try {
                                // ouvre un flux d'entrée pour lire les données de l'image sélectionnée
                                InputStream inputStream = getContext().getContentResolver().openInputStream(data.getData());
                                // convertit les données de l'image en bitmap
                                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                                // affiche l'image bitmap dans l'image de profil
                                editImageProfil.setImageBitmap(bitmap);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });

        // Définit un écouteur de clic pour l'image
        editImageProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create intent to open the device's gallery
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");

                // launch the gallery
                galleryLauncher.launch(intent);
            }
        });


        // Définit un écouteur de clic pour le bouton btnSave
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Enregistrer les informations entrées par l'utilisateur dans la base de données
            }
        });

        // Retourne la vue du fragment inflatée avec les vues correctement initialisées
        return view;

    } // fin onCreate



}