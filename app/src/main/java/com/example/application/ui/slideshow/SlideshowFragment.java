package com.example.application.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.application.R;
import com.example.application.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    private EditText nbrEuro;
    private Button btnEuro;
    private TextView résultat;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        View rootView = inflater.inflate(R.layout.fragment_slideshow, container, false);
        Button login = (Button)rootView.findViewById(R.id.btnConv);
        TextView res = (TextView) rootView.findViewById(R.id.res) ;
        EditText nbrEuro = (EditText) rootView.findViewById(R.id.txtEuro);
        login.setOnClickListener(v->{
            float euro = Float.parseFloat(nbrEuro.getText().toString());
            float mad = euro * 11.5f;
            res.setText(String.valueOf(mad)+" mad");
        });
        /*nbrEuro = root.findViewById(R.id.btnConv);
        btnEuro = root.findViewById(R.id.btnConv);
        résultat = root.findViewById(R.id.res);

        btnEuro.setOnClickListener(v->{
            float euro = Float.parseFloat(nbrEuro.getText().toString());
            float mad = euro * 11.5f;
            résultat.setText(String.valueOf(mad)+" mad");
        });*/

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}