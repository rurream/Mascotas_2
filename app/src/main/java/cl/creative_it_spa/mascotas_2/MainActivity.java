package cl.creative_it_spa.mascotas_2;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

import cl.creative_it_spa.mascotas_2.Adaptadores.PageAdapterMascotas;
import cl.creative_it_spa.mascotas_2.Fragments.FDetalleMascotas;
import cl.creative_it_spa.mascotas_2.Fragments.FListaMascotas;
import cl.creative_it_spa.mascotas_2.POJOs.ListMascotDetalle;
import cl.creative_it_spa.mascotas_2.POJOs.ListaMascotas;
import cl.creative_it_spa.mascotas_2.POJOs.MascotasTopFive;

public class MainActivity extends AppCompatActivity {

    private Toolbar barra1, barra2;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public static ArrayList<ListaMascotas> mascotas;
    public static ArrayList<ListaMascotas> mascotas_top;
    public static ArrayList<ListMascotDetalle> mascot1, mascot2, mascot3, mascot4, mascot5, mascot6,
            mascot7, mascot8, mascot9, mascot10, mascot11, mascot_resto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        barra1 = (Toolbar) findViewById(R.id.barra_sup);
        tabLayout=(TabLayout) findViewById(R.id.tabLayout);
        viewPager=(ViewPager) findViewById(R.id.viewPager);
        setSupportActionBar(barra1);
        barra1.setTitleTextColor(getResources().getColor(R.color.colorBlanco));

        barra2=(Toolbar) findViewById(R.id.toolbar);

        inicializarListMascotSelected();
        inicializarListaMascotas();

        setSupportActionBar(barra1);

        setUpViewPager();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action_view, menu);
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.m_about:
                Intent i = new Intent(this, AcernaDe.class);
                startActivity(i);
                break;
            case R.id.m_contacto:
                Intent u = new Intent(this, Contacto.class);
                startActivity(u);
                break;
            case R.id.mTop_Five:
                MascotasTopFive mascotas_seleccionadas=new MascotasTopFive();
                mascotas_top=new ArrayList<ListaMascotas>();
                mascotas_top=mascotas_seleccionadas.mascotas_top();

                Intent llamado=new Intent(getApplicationContext(), Marcador.class);
                startActivity(llamado);
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments= new ArrayList<>();

        fragments.add(new FListaMascotas());
        fragments.add(new FDetalleMascotas(-1));

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapterMascotas(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_name);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog_negro_lleno);
    }


    public void inicializarListMascotSelected(){
        mascot1=new ArrayList<>();
        mascot1.add(new ListMascotDetalle("5", R.drawable.m1_1));
        mascot1.add(new ListMascotDetalle("0", R.drawable.m1_2));
        mascot1.add(new ListMascotDetalle("8", R.drawable.m1_3));

        mascot2=new ArrayList<>();
        mascot2.add(new ListMascotDetalle("3", R.drawable.m2_1));
        mascot2.add(new ListMascotDetalle("1", R.drawable.m2_2));
        mascot2.add(new ListMascotDetalle("0", R.drawable.m2_3));

        mascot3=new ArrayList<>();
        mascot3.add(new ListMascotDetalle("3", R.drawable.m3_1));
        mascot3.add(new ListMascotDetalle("0", R.drawable.m3_2));
        mascot3.add(new ListMascotDetalle("5", R.drawable.m3_3));

        mascot4=new ArrayList<>();
        mascot4.add(new ListMascotDetalle("1", R.drawable.m4_1));
        mascot4.add(new ListMascotDetalle("1", R.drawable.m4_2));
        mascot4.add(new ListMascotDetalle("3", R.drawable.m4_3));

        mascot5=new ArrayList<>();
        mascot5.add(new ListMascotDetalle("7", R.drawable.m5_1));
        mascot5.add(new ListMascotDetalle("0", R.drawable.m5_2));
        mascot5.add(new ListMascotDetalle("0", R.drawable.m5_3));

        mascot6=new ArrayList<>();
        mascot6.add(new ListMascotDetalle("2", R.drawable.m6_1));
        mascot6.add(new ListMascotDetalle("2", R.drawable.m6_2));
        mascot6.add(new ListMascotDetalle("1", R.drawable.m6_3));

        mascot7=new ArrayList<>();
        mascot7.add(new ListMascotDetalle("5", R.drawable.m7_1));
        mascot7.add(new ListMascotDetalle("3", R.drawable.m7_2));
        mascot7.add(new ListMascotDetalle("0", R.drawable.m7_3));

        mascot8=new ArrayList<>();
        mascot8.add(new ListMascotDetalle("0", R.drawable.m8_1));
        mascot8.add(new ListMascotDetalle("1", R.drawable.m8_2));
        mascot8.add(new ListMascotDetalle("3", R.drawable.m8_3));

        mascot9=new ArrayList<>();
        mascot9.add(new ListMascotDetalle("3", R.drawable.m9_1));
        mascot9.add(new ListMascotDetalle("3", R.drawable.m9_2));
        mascot9.add(new ListMascotDetalle("3", R.drawable.m9_3));

        mascot10=new ArrayList<>();
        mascot10.add(new ListMascotDetalle("1", R.drawable.m10_1));
        mascot10.add(new ListMascotDetalle("3", R.drawable.m10_2));
        mascot10.add(new ListMascotDetalle("2", R.drawable.m10_3));

        mascot11=new ArrayList<>();
        mascot11.add(new ListMascotDetalle("3", R.drawable.m11_1));
        mascot11.add(new ListMascotDetalle("1", R.drawable.m11_2));
        mascot11.add(new ListMascotDetalle("1", R.drawable.m11_3));

        mascot_resto=new ArrayList<>();
        mascot_resto.add(new ListMascotDetalle("0", R.drawable.default_dog));
        mascot_resto.add(new ListMascotDetalle("0", R.drawable.default_dog));
        mascot_resto.add(new ListMascotDetalle("0", R.drawable.default_dog));
        mascot_resto.add(new ListMascotDetalle("0", R.drawable.default_dog));
        mascot_resto.add(new ListMascotDetalle("0", R.drawable.default_dog));
        mascot_resto.add(new ListMascotDetalle("0", R.drawable.default_dog));
    }


    public void inicializarListaMascotas(){
        mascotas=new ArrayList<>();
        mascotas.add(new ListaMascotas("Cheef", 0, R.drawable.m1, mascot1));
        mascotas.add(new ListaMascotas("Niña", 0, R.drawable.m2, mascot2));
        mascotas.add(new ListaMascotas("Twins", 0, R.drawable.m3, mascot3));
        mascotas.add(new ListaMascotas("Pancho Malo", 0,  R.drawable.m4, mascot4));
        mascotas.add(new ListaMascotas("Math", 0,  R.drawable.m5, mascot5));
        mascotas.add(new ListaMascotas("Loquillo", 0,  R.drawable.m6, mascot6));
        mascotas.add(new ListaMascotas("Paco", 0,  R.drawable.m7, mascot7));
        mascotas.add(new ListaMascotas("Cachupin", 0,  R.drawable.m8, mascot8));
        mascotas.add(new ListaMascotas("Dentin", 0,  R.drawable.m9, mascot9));
        mascotas.add(new ListaMascotas("Lucky", 0,  R.drawable.m10, mascot10));
        mascotas.add(new ListaMascotas("Epidemia", 0,  R.drawable.m11, mascot11));




    }

}
