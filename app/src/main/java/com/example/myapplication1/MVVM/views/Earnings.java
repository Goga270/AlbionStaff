package com.example.myapplication1.MVVM.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication1.RecycleViewEarnings.EarningAdapter;
import com.example.myapplication1.RecycleViewEarnings.EarningItem;
import com.example.myapplication1.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Earnings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Earnings extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<EarningItem> states = new ArrayList<EarningItem>();
    private boolean flag = true;
    private Fragment fragment;
    private static Earnings instance;

    public Earnings() {
        // Required empty public constructor
    }

    public static Earnings getInstance(){
        return instance;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Earnings.
     */
    // TODO: Rename and change types and number of parameters
    public static Earnings newInstance(String param1, String param2) {
        Earnings fragment = new Earnings();
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
        instance = this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_earnings, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.earn_item);
        if(flag) {
            flag = false;
            setInitialData();
        }
        EarningAdapter earningAdapter = new EarningAdapter(getContext(),states);
        recyclerView.setAdapter(earningAdapter);
        return view;
    }

    public void setInitialData(){
        states.add(new EarningItem(R.drawable.albion,"??????????????: 10-20%","????????????????: ??????-??????","??????????????????", fragment=new TransportationFragment()));
        states.add(new EarningItem(R.drawable.albion,"??????????????: 25-50%","????????????????: ??????","??????????????????", fragment = new PereCraftFragment()));
        //states.add(new EarningItem(R.drawable.albion,"??????????????: -25-50%","????????????????: ??????-??????","???????????? ????????????????????"));
        //states.add(new EarningItem(R.drawable.albion,"??????????????: -10-40%","????????????????: ??????-??????","????????????"));
    }

    public void changeFragment(Fragment first){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.fr, first);
        ft.commit();
    }
}