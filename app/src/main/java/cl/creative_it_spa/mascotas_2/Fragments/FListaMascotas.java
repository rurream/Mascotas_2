package cl.creative_it_spa.mascotas_2.Fragments;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cl.creative_it_spa.mascotas_2.Adaptadores.AdaptadorMascotas;
import cl.creative_it_spa.mascotas_2.MainActivity;
import cl.creative_it_spa.mascotas_2.POJOs.ListaMascotas;
import cl.creative_it_spa.mascotas_2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FListaMascotas extends android.support.v4.app.Fragment {

    private ArrayList<ListaMascotas> mascotas;
    RecyclerView rvlistaMascotas;

    public FListaMascotas() {
        // Required empty public constructor
        mascotas= MainActivity.mascotas;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_flista_mascotas, container, false);

        rvlistaMascotas=(RecyclerView) v.findViewById(R.id.rvTotalMascotas);

        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvlistaMascotas.setLayoutManager(llm);

        inicializarAdaptadorMascotas();
        return v;
    }



    public void inicializarAdaptadorMascotas(){
        AdaptadorMascotas adaptador =new AdaptadorMascotas(mascotas, getActivity());
        rvlistaMascotas.setAdapter(adaptador);

    }

}
