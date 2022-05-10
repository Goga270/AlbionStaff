package com.example.myapplication1.MVVM.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication1.MVVM.mv.third_marketViewModel;
import com.example.myapplication1.R;

import org.w3c.dom.Text;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link third_market#newInstance} factory method to
 * create an instance of this fragment.
 */
public class third_market extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private third_marketViewModel viewModel;

    public third_market() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment third_market.
     */
    // TODO: Rename and change types and number of parameters
    public static third_market newInstance(String param1, String param2) {
        third_market fragment = new third_market();
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
            mParam1 = getArguments().getString("ITEM");
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third_market, container, false);
        viewModel = new ViewModelProvider(this).get(third_marketViewModel.class);
        TextView title = view.findViewById(R.id.title);
        TextView bridgewatchCost = view.findViewById(R.id.bridgewatch_cost);
        TextView caerleonCost = view.findViewById(R.id.caerleon_cost);
        TextView lymhurstCost = view.findViewById(R.id.lymhurst_cost);
        TextView fortSterlingCost = view.findViewById(R.id.fortSterling_cost);
        TextView martlockCost = view.findViewById(R.id.martlock_cost);
        TextView thetfordCost = view.findViewById(R.id.thetford_cost);
        ImageView img = view.findViewById(R.id.img);

        int ID = view.getResources().getIdentifier(mParam1.toLowerCase(Locale.ROOT), "drawable", getContext().getPackageName());

        title.setText(mParam1);
        img.setImageResource(ID);

        viewModel.getCostBridgewatch().observe(getViewLifecycleOwner(), cost->{
            bridgewatchCost.setText(cost);
        });

        viewModel.getCostCaerleon().observe(getViewLifecycleOwner(), cost->{
            caerleonCost.setText(cost);
        });

        viewModel.getCostLymhust().observe(getViewLifecycleOwner(), cost->{
            lymhurstCost.setText(cost);
        });

        viewModel.getCostFortSterling().observe(getViewLifecycleOwner(), cost->{
            fortSterlingCost.setText(cost);
        });

        viewModel.getCostMartlock().observe(getViewLifecycleOwner(), cost->{
            martlockCost.setText(cost);
        });

        viewModel.getCostThetford().observe(getViewLifecycleOwner(), cost->{
            thetfordCost.setText(cost);
        });

        viewModel.calculateCost(mParam1);
        return view;
    }
}