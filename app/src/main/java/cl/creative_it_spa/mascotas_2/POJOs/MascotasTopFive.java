package cl.creative_it_spa.mascotas_2.POJOs;

import java.util.ArrayList;

import cl.creative_it_spa.mascotas_2.MainActivity;

/**
 * Created by Rodrigo on 13-06-2017.
 */

public class MascotasTopFive {

    ArrayList<ListaMascotas> listado_total_LOCAL, lista_top_5;




    public ArrayList<ListaMascotas> mascotas_top(){

        listado_total_LOCAL=new ArrayList<ListaMascotas>();
        listado_total_LOCAL= MainActivity.mascotas;




        ArrayList mascota_ya_seleccionada=new ArrayList() ;
        int puntaje=0, numero_mascotas=0, posición_de_la_lista=0;
        lista_top_5=new ArrayList<ListaMascotas>();
        while (numero_mascotas<5){
            puntaje=0;
            posición_de_la_lista=-1;
            for(int x=0; x<listado_total_LOCAL.size();x++){
                if (!mascota_ya_seleccionada.contains(x)) {
                    ListaMascotas mascota_x= listado_total_LOCAL.get(x);
                    if (puntaje<mascota_x.getPuntaje_mascota()){
                        posición_de_la_lista=x;
                        puntaje=mascota_x.getPuntaje_mascota();
                    }
                }
            }
            if (posición_de_la_lista==-1){
                for(int x=0;x<5;x++){
                    if (!mascota_ya_seleccionada.contains(x)) {
                        posición_de_la_lista=x;
                        break;
                    }
                }
            }


            ListaMascotas mascota_seleccionada= listado_total_LOCAL.get(posición_de_la_lista);
            lista_top_5.add(new ListaMascotas(
                    mascota_seleccionada.getNombre_mascota(),
                    mascota_seleccionada.getPuntaje_mascota(),
                    mascota_seleccionada.getFoto_mascota(),
                    mascota_seleccionada.getMascot()));
            numero_mascotas++;
            mascota_ya_seleccionada.add(posición_de_la_lista);
        }
        return lista_top_5;
    }
}
