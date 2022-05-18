package com.example.myapplication1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.myapplication1.DI.serviceLocator;
import android.content.ClipData;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication1.MVVM.views.TransportationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    private static MainActivity INSTANCE = new MainActivity();

    TextView textView;
    private Fragment fragment = null;
    private Market fragment1 = null;
    private String[] f = { "Ybrbnf ", "Seva" };



    public static MainActivity getINSTANCE(){
        return INSTANCE;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = new Home();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fr, fragment);
        ft.addToBackStack(null);
        ft.commit();
        try {
            serviceLocator.getServiceLocator().getRepository().setItemsJsonFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.page_1:
                        fragment = new Home();
                        break;
                    case R.id.page_2:
                        fragment = new Market();
                        break;
                    case R.id.page_3:
                        fragment = new Earnings();
                        break;
                    case R.id.page_4:
                        fragment = new TransportationFragment();
                        break;
                }

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.fr, fragment);
                ft.commit();

                return true;
            }
        });

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_home, container, false);

        BottomNavigationView bottomNavigationView = rootView.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.page_1:
                        break;
                    case R.id.page_2:
                        fragment = new Market();
                        break;
                    case R.id.page_3:
                        fragment = new Earnings();
                        break;
                    case R.id.page_4:
                        fragment = new Builds();
                        break;
                }

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.fr, fragment);
                ft.attach(fragment);
                ft.commit();

                return true;
            }
        });
        return rootView;
    }


    public void changeFragment(Fragment first){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.addToBackStack(null);
        ft.add(R.id.fr,first);
        /*ft.replace(R.id.fr, fragment);*/
        ft.commit();
    }

}