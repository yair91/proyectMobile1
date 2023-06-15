package com.example.proyecto;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

public class ListAdapterHistory extends ArrayAdapter<Carrito> {

    private List<Carrito> CarritoList;
    private Context context;
    private int resourceLayout;


    public ListAdapterHistory(@NonNull Context context, int resource, @NonNull Carrito[] objects) {
        super(context, resource, objects);
    }
}
