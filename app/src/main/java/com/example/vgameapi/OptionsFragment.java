package com.example.vgameapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.Locale;
import java.util.concurrent.Executor;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OptionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OptionsFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    // SHARED PREFERENCES
    SharedPreferences prefs;

    // ON ITEM SELECTED LISTENER METHODS
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        if (pos == 0) {
            prefs = getActivity().getSharedPreferences("SharedP", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("lang", "en").commit();
            setAppLocale("en");
        } else if (pos == 1) {
            prefs = getActivity().getSharedPreferences("SharedP", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("lang", "esp").commit();
            setAppLocale("");
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // OnNothingSelected
    }

    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

    private void setAppLocale(String localeCode){
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration config = res.getConfiguration();

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1){
            config.setLocale(new Locale(localeCode.toLowerCase()));
        } else {
            config.locale = new Locale(localeCode.toLowerCase());
        }
        res.updateConfiguration(config, dm);
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OptionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OptionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OptionsFragment newInstance(String param1, String param2) {
        OptionsFragment fragment = new OptionsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_options, container, false);

        // SPINNER
        Spinner spinner = (Spinner) view.findViewById(R.id.lang_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.lang_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        // BIOMETRIC METHODS
        executor = ContextCompat.getMainExecutor(getContext());
        biometricPrompt = new BiometricPrompt(this.getActivity(), executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                //Error
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                prefs = getActivity().getSharedPreferences("SharedP", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.clear().commit();
                setAppLocale("");
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                //Failed
            }
        });

        // PROMPT INFO FOR THE BIOMETRIC
        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric login for my app")
                .setSubtitle("Log in using your biometric credential")
                .setNegativeButtonText("Use account password")
                .build();


        // BUTTONS
        Button btnDeletePref = view.findViewById(R.id.btnDeletePref);
        Button btnBack = view.findViewById(R.id.btnBack);
        Switch nightDaySwitch = view.findViewById(R.id.nightDaySwitch);

        // BUTTONS ACTIONS
        btnDeletePref.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                biometricPrompt.authenticate(promptInfo);
            }
        });

        // NIGHT MODE SWITCH
        prefs = getActivity().getSharedPreferences("SharedP", Context.MODE_PRIVATE);
        boolean nightMode = prefs.getBoolean("nightMode", false);

        if (nightMode) {
            nightDaySwitch.setChecked(false);
        } else {
            nightDaySwitch.setChecked(true);
        }

        nightDaySwitch.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                if (nightDaySwitch.isChecked()) {
                    prefs = getActivity().getSharedPreferences("SharedP", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("nightMode", false).commit();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    prefs = getActivity().getSharedPreferences("SharedP", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("nightMode", true).commit();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentHome()).commit();
            }
        });

        return view;
    }
}