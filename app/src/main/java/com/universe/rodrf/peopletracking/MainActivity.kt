package com.universe.rodrf.peopletracking

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import com.universe.rodrf.peopletracking.Adapters.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        vpMain.adapter = fragmentAdapter
        tabs_main.setupWithViewPager(vpMain)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_map) as SupportMapFragment
        mapFragment.getMapAsync(this@MainActivity)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        try {
            googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this@MainActivity, R.raw.google_map_style))
        } catch (e: Resources.NotFoundException) {
            e.printStackTrace()
        }
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))


    }
}
