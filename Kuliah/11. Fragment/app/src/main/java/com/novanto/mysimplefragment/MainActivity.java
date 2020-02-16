package com.novanto.mysimplefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button BtnFragment;
    Boolean isFragmentDisplayed=false;
    static final String STATE_FRAGMENT = "state_of_fragment";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnFragment = findViewById(R.id.btn_article);
        BtnFragment.setOnClickListener(this);

        if(savedInstanceState != null){
            isFragmentDisplayed = savedInstanceState.getBoolean(STATE_FRAGMENT);
            if(isFragmentDisplayed){
                BtnFragment.setText("close2");
            }
        }

    }

    public void displayFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        SimpleFragment simpleFragment = SimpleFragment.newInstance();
        Fragment fragment = fragmentManager.findFragmentByTag(SimpleFragment.class.getSimpleName());


        if (!(fragment instanceof SimpleFragment)){
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container,simpleFragment,"")
                    .commit();
        }
        BtnFragment.setText("Close");
        isFragmentDisplayed = true;
    }

    public void closeFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        SimpleFragment simpleFragment = (SimpleFragment) fragmentManager.findFragmentById(R.id.fragment_container);

        if(simpleFragment !=null ){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.remove(simpleFragment).commit();
        }
        BtnFragment.setText("Open");
        isFragmentDisplayed = false;
    }

    @Override
    public void onClick(View view) {
            if (!isFragmentDisplayed){
                displayFragment();
            }
            else {
                closeFragment();
            }
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean(STATE_FRAGMENT, isFragmentDisplayed);
        super.onSaveInstanceState(savedInstanceState);
    }

}
