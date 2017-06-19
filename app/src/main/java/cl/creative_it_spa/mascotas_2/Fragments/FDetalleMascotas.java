package cl.creative_it_spa.mascotas_2.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pkmmte.view.CircularImageView;

import java.util.ArrayList;

import cl.creative_it_spa.mascotas_2.Adaptadores.AdaptMascotaSeleccionada;
import cl.creative_it_spa.mascotas_2.MainActivity;
import cl.creative_it_spa.mascotas_2.POJOs.ListMascotDetalle;
import cl.creative_it_spa.mascotas_2.POJOs.ListaMascotas;
import cl.creative_it_spa.mascotas_2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FDetalleMascotas extends android.support.v4.app.Fragment {

    private ArrayList<ListaMascotas> mascotas;
    private int id_mascota_seleccionada;
    TextView tv_mascota_seleccionada;
    CircularImageView img_mascota_seleccionada;
    RecyclerView rvMascotaSeleccionada;
    ArrayList<ListMascotDetalle> mascota_seleccionada;


    public FDetalleMascotas(int id_mascota_seleccionada) {
        // Required empty public constructor
        mascotas= MainActivity.mascotas;
        this.id_mascota_seleccionada=id_mascota_seleccionada;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_fdetalle_mascotas, container, false);

        rvMascotaSeleccionada=(RecyclerView) v.findViewById(R.id.rvMascotaSeleccionada);

        GridLayoutManager llm=new GridLayoutManager(getActivity(), 3);
        llm.setOrientation(GridLayoutManager.VERTICAL);
        rvMascotaSeleccionada.setLayoutManager(llm);



        tv_mascota_seleccionada=(TextView) v.findViewById(R.id.tv_nombre_mascota_seleccionada);
        img_mascota_seleccionada=(CircularImageView) v.findViewById(R.id.img_mascota_seleccionada3);


        if(id_mascota_seleccionada!=-1){
            ListaMascotas mascota=mascotas.get(id_mascota_seleccionada);
            mascota_seleccionada= new ArrayList<ListMascotDetalle>();
            mascota_seleccionada=mascota.getMascot();
            mascota_seleccionada.addAll(MainActivity.mascot_resto);

            tv_mascota_seleccionada.setText(mascota.getNombre_mascota());
            img_mascota_seleccionada.setImageResource(mascota.getFoto_mascota());

            inicializarAdaptadorMascotas();
        }
        else{
            ListaMascotas mascota=mascotas.get(0);
            mascota_seleccionada= new ArrayList<ListMascotDetalle>();
            mascota_seleccionada=mascota.getMascot();
            mascota_seleccionada.addAll(MainActivity.mascot_resto);

            FDetalleMascotas fragmento= new FDetalleMascotas(0);
            FragmentTransaction transaccion= ((FragmentActivity) v.getContext()).getSupportFragmentManager().beginTransaction();
            transaccion.replace(R.id.ly_mascota_seleccionada, fragmento);
            transaccion.addToBackStack(null);
            transaccion.commit();
        }


        return v;

    }

    public void inicializarAdaptadorMascotas(){
        AdaptMascotaSeleccionada adaptador=new AdaptMascotaSeleccionada(mascota_seleccionada, getActivity());
        rvMascotaSeleccionada.setAdapter(adaptador);
    }

}
