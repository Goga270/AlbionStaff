package com.example.myapplication1;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication1.DI.serviceLocator;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link second_market#newInstance} factory method to
 * create an instance of this fragment.
 */
public class second_market extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<MarketItem> states = new ArrayList<MarketItem>();
    private static second_market instance;

    public second_market() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment second_market.
     */
    // TODO: Rename and change types and number of parameters
    public static second_market newInstance(String param1, String param2) {
        second_market fragment = new second_market();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static second_market getInstance() {
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            mParam1 = getArguments().getString("ID");
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        instance = this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootView = inflater.inflate(R.layout.fragment_second_market, container, false);
       RecyclerView recyclerView = rootView.findViewById(R.id.list);
       setInitialData(rootView);
       StateAdapter stateAdapter = new StateAdapter(getContext(),states);
       recyclerView.setAdapter(stateAdapter);
       return rootView;
    }

    private void setInitialData(View view) {
        String[] apiNames = serviceLocator.getServiceLocator().getRepository().getOneApiNames(mParam1);
        System.out.println(apiNames.length);
        for (int i = 0; i < apiNames.length; i++) {
            int ID = view.getResources().getIdentifier(apiNames[i].toLowerCase(Locale.ROOT), "drawable", getContext().getPackageName());
            String tier = apiNames[i].split("")[1];
            states.add(new MarketItem(ID, apiNames[i], "Тир: " + tier, "Чар: 0"));

        }
    }

    public void changeFragment(Fragment fragment){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.fr, fragment);
        ft.commit();
    }
}