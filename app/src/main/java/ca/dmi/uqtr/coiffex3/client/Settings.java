package ca.dmi.uqtr.coiffex3.client;


import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import ca.dmi.uqtr.coiffex3.R;

public class Settings extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}