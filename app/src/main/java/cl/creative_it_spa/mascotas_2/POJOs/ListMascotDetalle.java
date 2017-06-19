package cl.creative_it_spa.mascotas_2.POJOs;

/**
 * Created by Rodrigo on 18-06-2017.
 */

public class ListMascotDetalle {

    String puntaje_masc_detalle;
    int foto_mascota_mini_1;

    public ListMascotDetalle(String puntaje_masc_detalle, int foto_mascota_mini_1) {
        this.puntaje_masc_detalle=puntaje_masc_detalle;
        this.foto_mascota_mini_1 = foto_mascota_mini_1;
    }

    public String getPuntaje_masc_detalle() {
        return puntaje_masc_detalle;
    }

    public void setPuntaje_masc_detalle(String puntaje_masc_detalle) {
        this.puntaje_masc_detalle = puntaje_masc_detalle;
    }

    public int getFoto_mascota_mini_1() {
        return foto_mascota_mini_1;
    }

    public void setFoto_mascota_mini_1(int foto_mascota_mini_1) {
        this.foto_mascota_mini_1 = foto_mascota_mini_1;
    }
}
