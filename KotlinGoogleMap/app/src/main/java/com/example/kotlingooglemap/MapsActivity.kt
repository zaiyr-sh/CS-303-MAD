package com.example.kotlingooglemap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.BitmapDescriptorFactory

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val zoomLevel = 15f
        // Add a marker in Sydney and move the camera
        val bishkek = LatLng(42.882004, 74.582748)
        mMap.addMarker(MarkerOptions().position(bishkek).title("Marker in Bishkek, Kyrgyzstan").icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pointer)))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bishkek, zoomLevel))

        val issyk_kul = LatLng(42.483, 78.400)
        mMap.addMarker(MarkerOptions().position(issyk_kul).title("Marker in Issyk-kul, Kyrgyzstan").icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pointer)))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(issyk_kul, zoomLevel))

        val tokmok = LatLng(42.833, 75.283)
        mMap.addMarker(MarkerOptions().position(tokmok).title("Marker in Tokmok, Kyrgyzstan").icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pointer)))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tokmok, zoomLevel))
    }
}