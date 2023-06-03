package com.example.proyecto.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.proyecto.CostruCuenta;
import com.example.proyecto.R;
import com.example.proyecto.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private EditText pre;
    private TextView po;
    private CostruCuenta[] costrucuentas;
    private int conta = 1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        costrucuentas = new CostruCuenta[1];

        pre = root.findViewById(R.id.txtprecio);
        po = root.findViewById(R.id.txtdinero);

        int por = costrucuentas[1].getAumento();

        po.setText("saldo disponible: " + por);

        return root;
    }

    private void obtenervalor(){
        int pr = 0;
        int pr2 = costrucuentas[1].getAumento();

        if (pre.getText().length() == 0) {
            Toast.makeText(getActivity(), "Falta cantida a agregar", Toast.LENGTH_SHORT).show();
        } else {
            pr = Integer.parseInt(pre.getText().toString());
        }
            int suma = pr + pr2;
        costrucuentas[conta] = new CostruCuenta(suma);
        pre.setText("");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}