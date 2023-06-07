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
    private CostruCuenta[] costrucuenta;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        costrucuenta = new CostruCuenta[1];
        costrucuenta[0] = new CostruCuenta();

        pre = root.findViewById(R.id.txtprecio);
        po = root.findViewById(R.id.txtdinero);

        return root;
    }
    public void obtenervalor(View view){
        if (pre.getText().length() == 0) {
            Toast.makeText(getActivity(), "Falta cantidad a agregar", Toast.LENGTH_SHORT).show();
        } else {
            int pr = Integer.parseInt(pre.getText().toString());
            costrucuenta[0].setAumento(pr);
            actualizar(view);
            pre.setText("");
        }
    }

    public void actualizar(View view){
        int v1 = costrucuenta[0].getAumento();
        int v2 = costrucuenta[0].getAumneto2();
        int valor = v1 + v2;
        costrucuenta[0].setAumneto2(valor);
        po.setText(String.valueOf(valor));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}