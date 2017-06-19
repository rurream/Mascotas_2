package cl.creative_it_spa.mascotas_2.Adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import cl.creative_it_spa.mascotas_2.POJOs.ListMascotDetalle;
import cl.creative_it_spa.mascotas_2.R;

/**
 * Created by Rodrigo on 18-06-2017.
 */

public class AdaptMascotaSeleccionada extends RecyclerView.Adapter<AdaptMascotaSeleccionada.MascotaSelectViewHolder>{

    ArrayList<ListMascotDetalle> mascota_seleccionada;
    Activity activity;

    public AdaptMascotaSeleccionada(ArrayList<ListMascotDetalle> mascota_seleccionada, Activity activity) {
        this.mascota_seleccionada = mascota_seleccionada;
        this.activity = activity;
    }

    @Override
    public MascotaSelectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_mascota_seleccionada, parent, false);
        return new MascotaSelectViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaSelectViewHolder holder, int position) {
        final ListMascotDetalle mascota_sel= mascota_seleccionada.get(position);

        holder.img_mascota_seleccionada_lib.setImageResource(mascota_sel.getFoto_mascota_mini_1());
        holder.tv_mascota_seleccionada.setText(mascota_sel.getPuntaje_masc_detalle());
    }

    @Override
    public int getItemCount() {
        return mascota_seleccionada.size();
    }



    public static class MascotaSelectViewHolder extends RecyclerView.ViewHolder{
        ImageView img_mascota_seleccionada_lib, img_hueso_color_s;
        TextView tv_mascota_seleccionada;

        public MascotaSelectViewHolder(View itemView) {
            super(itemView);
            img_mascota_seleccionada_lib=(ImageView) itemView.findViewById(R.id.img_mascota_seleccionada_lib);
            img_hueso_color_s=(ImageView) itemView.findViewById(R.id.img_hueso_color_s);
            tv_mascota_seleccionada=(TextView) itemView.findViewById(R.id.tv_mascota_seleccionada);
        }
    }
}



