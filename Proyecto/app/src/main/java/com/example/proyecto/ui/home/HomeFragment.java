package com.example.proyecto.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.proyecto.R;
import com.example.proyecto.databinding.FragmentHomeBinding;
import com.example.proyecto.ui.slideshow.SlideshowFragment;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Button btnSendSlideshowbutton;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        btnSendSlideshowbutton = binding.btnSendSlideshow;
        // Funcion onclick para redirigir de fragments
        btnSendSlideshowbutton.setOnClickListener(view -> {
            Fragment FragDest = new SlideshowFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_host_fragment_content_menu_lateral, FragDest); // Reemplaza "container" por el ID de tu contenedor de fragmentos
            transaction.addToBackStack(null);
            transaction.commit();
            Toast.makeText(getActivity(), "Ordena lo que gustes!", Toast.LENGTH_SHORT).show();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}