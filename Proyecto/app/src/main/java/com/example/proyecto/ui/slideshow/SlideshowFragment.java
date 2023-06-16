package com.example.proyecto.ui.slideshow;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.proyecto.Carrito;
import com.example.proyecto.ListAdapter;
import com.example.proyecto.PlatillosClass;
import com.example.proyecto.R;
import com.example.proyecto.databinding.FragmentSlideshowBinding;
import com.example.proyecto.ui.historial.HistorialFragment;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment implements AdapterView.OnItemClickListener {

    private FragmentSlideshowBinding binding;
    private ListView listView;
    private ListAdapter listAdapter;
    private List<PlatillosClass> mPlatillos = new ArrayList<>();

    private static int contador = 0, cantidad_comida_pozole = 0, cantidad_comida_tacos = 0,
            cantidad_comida_tortas = 0, cantidad_comida_flautas = 0, cantidad_comida_enchiladas = 0,
            cantidad_comida_enchiladas2 = 0;
    private Carrito[] carrito;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel = new ViewModelProvider(this).get(SlideshowViewModel.class);

        carrito = new Carrito[7];    // Damos de alta la variable carrito

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listView = binding.listPlatillos;
        listView.setOnItemClickListener(this);

        mPlatillos.add(new PlatillosClass(R.mipmap.pozole,"Pozole",2000.00,"Caldo/Sopa de maíz y carne, acompañada de condimentos"));
        mPlatillos.add(new PlatillosClass(R.mipmap.tacos,"Tacos",2000.00,"Tortillas rellenas con carne, que se les puede poner distintos acompañamientos"));
        mPlatillos.add(new PlatillosClass(R.mipmap.tortas,"Tortas",2000.00,"Birote remojado en salsa de tomate, con carne por dentro"));
        mPlatillos.add(new PlatillosClass(R.mipmap.flautas,"Flautas",2000.00,"Tortilla dorada rellana de pollo"));
        mPlatillos.add(new PlatillosClass(R.mipmap.enchiladas,"Enchiladas",2000.00,"Tortilla dorada acompañada de salsa y crema"));

        // Inicializador de adaptador
        listAdapter = new ListAdapter(requireContext(), R.layout.item_row, mPlatillos);

        listView.setAdapter(listAdapter);

        //final TextView textView = binding.textView17; //.textSlideshow;
        //slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(i == 0){
            carrito[contador] = new Carrito(contador, i, cantidad_comida_pozole, 2000.00, 1234.00);
            cantidad_comida_pozole++;
            Toast.makeText(getActivity(), "Elemetno seleccionado: Pozole", Toast.LENGTH_SHORT).show();
        } else if(i == 1){
            carrito[contador] = new Carrito(contador, i, cantidad_comida_tacos, 2000.00, 1234.00);
            cantidad_comida_tacos++;
            Toast.makeText(getActivity(), "Elemetno seleccionado: Tacos", Toast.LENGTH_SHORT).show();
        } else if(i == 2){
            carrito[contador] = new Carrito(contador, i, cantidad_comida_tortas, 2000.00, 1234.00);
            cantidad_comida_tortas++;
            Toast.makeText(getActivity(), "Elemetno seleccionado: Tortas", Toast.LENGTH_SHORT).show();
        } else if(i == 3){
            carrito[contador] = new Carrito(contador, i, cantidad_comida_flautas, 2000.00, 1234.00);
            cantidad_comida_flautas++;
            Toast.makeText(getActivity(), "Elemetno seleccionado: Flautas", Toast.LENGTH_SHORT).show();
        } else if(i == 4){
            carrito[contador] = new Carrito(contador, i, cantidad_comida_enchiladas, 2000.00, 1234.00);
            cantidad_comida_enchiladas++;
            Toast.makeText(getActivity(), "Elemetno seleccionado: Enchiladas", Toast.LENGTH_SHORT).show();
        } else if(i == 5){
            carrito[contador] = new Carrito(contador, i, cantidad_comida_enchiladas2, 2000.00, 1234.00);
            cantidad_comida_enchiladas2++;
            Toast.makeText(getActivity(), "Elemetno seleccionado: Enchiladas2", Toast.LENGTH_SHORT).show();
        }
        contador++;
    }
}