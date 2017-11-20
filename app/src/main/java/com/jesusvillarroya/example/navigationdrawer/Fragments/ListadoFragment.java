package com.jesusvillarroya.example.navigationdrawer.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.jesusvillarroya.example.navigationdrawer.Adapters.Adaptador;
import com.jesusvillarroya.example.navigationdrawer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListadoFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listView;
    private List<String> names;

    public ListadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listado, container, false);

        listView = (ListView)view.findViewById(R.id.listado);

        names = new ArrayList<String>();
        names.add("Pepe");names.add("María");names.add("José");names.add("Noelia");names.add("Laura");names.add("David");
        names.add("Pepe");names.add("María");names.add("José");names.add("Noelia");names.add("Laura");names.add("David");
        names.add("Pepe");names.add("María");names.add("José");names.add("Noelia");names.add("Laura");names.add("David");
        names.add("Pepe");names.add("María");names.add("José");names.add("Noelia");names.add("Laura");names.add("David");

       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, names);
       // listView.setAdapter(adapter);




        //Adaptador personalizado
        Adaptador adaptador = new Adaptador(getContext(), R.layout.list_item, names);
        listView.setAdapter(adaptador);
        listView.setOnItemClickListener(this);


        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
        Toast.makeText(getContext(), "Nombre: "+ names.get(posicion), Toast.LENGTH_SHORT).show();
    }
}

