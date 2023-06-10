package com.example.proyecto.ui.slideshow;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterViewFlipper;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.proyecto.Carrito;
import com.example.proyecto.ListAdapter;
import com.example.proyecto.PlatillosClass;
import com.example.proyecto.R;
import com.example.proyecto.databinding.FragmentSlideshowBinding;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment implements AdapterView.OnItemClickListener {

        private FragmentSlideshowBinding binding;
        private Carrito[] carrito = new Carrito[7];
        private PlatillosClass[] platillosClass = new PlatillosClass[7];
        private ListView listView;
        private ListAdapter listAdapter;
        private List<PlatillosClass> mPlatillos = new ArrayList<>();
        private static int id_carrito = 0, contador_platillos = 0;

        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            binding = FragmentSlideshowBinding.inflate(inflater, container, false);
            View root = binding.getRoot();

            platillosClass[0] = new PlatillosClass(0, 0, "Pozole",      "Caldo/Sopa de maíz y carne.",          80.99, true);
            platillosClass[1] = new PlatillosClass(1, 1, "Tacos",       "Tortillas rellenas con carne.",        15.00, true);
            platillosClass[2] = new PlatillosClass(2, 2, "Tortas",      "Birote remojado en salsa de tomate, con carne.",   65.50, true);
            platillosClass[3] = new PlatillosClass(3, 3, "Flautas",     "Tortilla dorada rellana de pollo.",    25.34, true);
            platillosClass[4] = new PlatillosClass(4, 4, "Enchiladas",  "Tortilla dorada bañada de salsa y crema.",         50.25, true);
            platillosClass[5] = new PlatillosClass(5, 5, "Chilaquiles", "Tortillas partidas y doradas bañadas en salsa.",   43.30, true);
            platillosClass[6] = new PlatillosClass(6, 6, "Menudo",      "Caldo hecho con pancita de res.",      90.00, true);

            listView = binding.listPlatillos;

            mPlatillos.add(new PlatillosClass(R.mipmap.pozole,      "Pozole",       80.99, "Caldo/Sopa de maíz y carne."));
            mPlatillos.add(new PlatillosClass(R.mipmap.tacos,       "Tacos",        15.00, "Tortillas rellenas con carne."));
            mPlatillos.add(new PlatillosClass(R.mipmap.tortas,      "Tortas",       65.50, "Birote remojado en salsa de tomate, con carne."));
            mPlatillos.add(new PlatillosClass(R.mipmap.flautas,     "Flautas",      25.34, "Tortilla dorada rellana de pollo."));
            mPlatillos.add(new PlatillosClass(R.mipmap.enchiladas,  "Enchiladas",   50.25, "Tortilla dorada bañada de salsa y crema."));
            mPlatillos.add(new PlatillosClass(R.mipmap.chilaquiles, "Chilaquiles",  43.30, "Tortillas partidas y doradas bañadas en salsa."));
            mPlatillos.add(new PlatillosClass(R.mipmap.menudo,      "Menudo",       90.00, "Caldo hecho con pancita de res."));

            listAdapter = new ListAdapter(requireContext(), R.layout.item_row, mPlatillos);
            listView.setOnItemClickListener(this);
            listView.setAdapter(listAdapter);

            return root;
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            binding = null;
        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Context context = requireContext();
            carrito[id_carrito] = new Carrito(id_carrito, position, contador_platillos, platillosClass[position].getCosto(), (platillosClass[position].getCosto() * 0.16));
            Toast.makeText(context, carrito[id_carrito].getId(), Toast.LENGTH_SHORT).show();
            Toast.makeText(context, carrito[id_carrito].getId_platillo(), Toast.LENGTH_SHORT).show();
            Toast.makeText(context, "Haz seleccionado " + platillosClass[position].getNombre() + " Se ha agregado a tu carrito", Toast.LENGTH_SHORT).show();
            id_carrito++;
            contador_platillos++;
        }

}