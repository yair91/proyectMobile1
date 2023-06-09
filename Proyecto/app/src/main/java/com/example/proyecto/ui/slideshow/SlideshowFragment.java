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
import com.example.proyecto.ListAdapter;
import com.example.proyecto.PlatillosClass;
import com.example.proyecto.R;
import com.example.proyecto.databinding.FragmentSlideshowBinding;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment implements AdapterView.OnItemClickListener {

    private FragmentSlideshowBinding binding;
    private ListView listView;
    private ListAdapter listAdapter;
    private List<PlatillosClass> mPlatillos = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listView = binding.listPlatillos;

        mPlatillos.add(new PlatillosClass(R.mipmap.pozole,"Pozole",2000.00,"Caldo/Sopa de maíz y carne."));
        mPlatillos.add(new PlatillosClass(R.mipmap.tacos,"Tacos",2000.00,"Tortillas rellenas con carne."));
        mPlatillos.add(new PlatillosClass(R.mipmap.tortas,"Tortas",2000.00,"Birote remojado en salsa de tomate, con carne."));
        mPlatillos.add(new PlatillosClass(R.mipmap.flautas,"Flautas",2000.00,"Tortilla dorada rellana de pollo"));
        mPlatillos.add(new PlatillosClass(R.mipmap.enchiladas,"Enchiladas",2000.00,"Tortilla dorada bañada de salsa y crema"));

        listAdapter = new ListAdapter(requireContext(), R.layout.item_row, mPlatillos);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(this);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Context context = requireContext();
        Toast.makeText(context, "Elemento clickeado: " + i, Toast.LENGTH_SHORT).show();
    }
}
