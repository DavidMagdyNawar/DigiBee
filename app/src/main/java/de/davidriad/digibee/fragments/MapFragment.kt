package de.davidriad.digibee.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import de.davidriad.digibee.R


class MapFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val duisburg = LatLng(51.4344, 6.7623)
        googleMap.addMarker(
            MarkerOptions().position(duisburg).title("Beehive in Duisburg")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.beehive))
        )

        val dusseldorf = LatLng(51.233334, 6.783333)
        googleMap.addMarker(
            MarkerOptions().position(dusseldorf).title("Beehive in Düsseldorf")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.beehive))
        )

        val essen = LatLng(51.4556, 7.0116)
        googleMap.addMarker(
            MarkerOptions().position(essen).title("Beehive in Essen")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.beehive))
        )

        val kali = LatLng(51.4958, 6.5321)
        googleMap.addMarker(
            MarkerOptions().position(kali).title("Beehive in Kamp Lintfort")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.beehive))
        )

        val munich = LatLng(48.1351, 11.5820)
        googleMap.addMarker(
            MarkerOptions().position(munich).title("Beehive in München")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.beehive))
        )
        val paris = LatLng(48.8566, 2.3522)
        googleMap.addMarker(
            MarkerOptions().position(paris).title("Beehive in Paris")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.beehive))
        )

        val rome = LatLng(41.902782, 12.496366)
        googleMap.addMarker(
            MarkerOptions().position(rome).title("Beehive in Rome")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.beehive))
        )
        val cairo = LatLng(30.0444, 31.2357)
        googleMap.addMarker(
            MarkerOptions().position(cairo).title("Beehive in Cairo")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.beehive))
        )
        val delhi = LatLng(28.7041, 77.1025)
        googleMap.addMarker(
            MarkerOptions().position(cairo).title("Beehive in Delhi")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.beehive))
        )

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(duisburg))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}