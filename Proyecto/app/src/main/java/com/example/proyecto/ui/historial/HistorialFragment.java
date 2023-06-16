package com.example.proyecto.ui.historial;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.proyecto.Carrito;
import com.example.proyecto.ListAdapter;
import com.example.proyecto.ListAdapterHistory;
import com.example.proyecto.PlatillosClass;
import com.example.proyecto.R;
import com.example.proyecto.databinding.FragmentHistorialBinding;

import java.util.ArrayList;
import java.util.List;

public class HistorialFragment extends Fragment {

    private @NonNull FragmentHistorialBinding mViewModel;

    private Carrito[] carrito;

    private ListView listView;

    private ListAdapterHistory listAdapterHistory;

    private List<Carrito> mCarritosList = new ArrayList<>();

    public static HistorialFragment newInstance(Carrito[] carrito) {
        HistorialFragment fragment = new HistorialFragment();
        fragment.carrito = carrito;
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel = FragmentHistorialBinding.inflate(inflater, container, false);
        View root = mViewModel.getRoot();
        try {
            for (int i = 0; i < 7; i++) {
                if (carrito[i] != null) {
                    int id = carrito[i].getId();

                    if (id == 0) {
                        mCarritosList.add(new Carrito(R.mipmap.pozole, 1, 2000.00));
                    } else if (id == 1) {
                        mCarritosList.add(new Carrito(R.mipmap.pozole, 2, 2000.00));
                    } else if (id == 2) {
                        mCarritosList.add(new Carrito(R.mipmap.pozole, 3, 2000.00));
                    } else if (id == 3) {
                        mCarritosList.add(new Carrito(R.mipmap.pozole, 4, 2000.00));
                    } else if (id == 4) {
                        mCarritosList.add(new Carrito(R.mipmap.pozole, 5, 2000.00));
                    } else if (id == 5) {
                        mCarritosList.add(new Carrito(R.mipmap.pozole, 6, 2000.00));
                    }
                }
            }

            // Inicializador de adaptador
            listAdapterHistory = new ListAdapterHistory(requireContext(), R.layout.item_row, mCarritosList);

            listView.setAdapter(listAdapterHistory);

        } catch (Exception e){
            System.out.println("Error: "+e);
        }
        return root;
    }
}