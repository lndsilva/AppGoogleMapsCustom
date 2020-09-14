package br.com.local.appgooglemapscustom;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Tipo de mapas
        /*
        Normal
            Mapa rodoviário comum. Mostra vias, alguns elementos criados pelo homem e
            recursos naturais importantes, como rios. Etiquetas de estradas e de elementos
             também são visíveis.
        Híbrido
            Dados de fotografia de satélite com mapas rodoviários. Etiquetas de estradas
             e de elementos também são visíveis.
        Satélite
            Dados de fotografia de satélite. Marcadores de estradas e de elementos não são visíveis.
        Relevo
            Dados topográficos. O mapa inclui cores, curvas de nível e etiquetas, além de sombreamento
             de perspectiva. Algumas vias e etiquetas também são visíveis.
        Nenhum
            Nenhum bloco. O mapa será renderizado como uma grade vazia, sem carregar blocos.
        */
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);


        // Add a marker in Sydney and move the camera
        LatLng etecia = new LatLng(-23.701185, -46.7001431);
        //-23.702723,-46.6898242
        //Marcadores
        mMap.addMarker(new MarkerOptions()
                        .position(etecia)
                        .title("Autodromo José Carlos Pace")
                        .icon(BitmapDescriptorFactory.defaultMarker(
                                // Definindo cores para os icones de posicionamento
                                BitmapDescriptorFactory.HUE_RED))
                //Icone costumizado
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.formula))

        );
        //Posicionamento da câmera
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(etecia, 18));
    }
}