package com.example.appgreenflowgroup.ui.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.osmdroid.config.Configuration
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import com.example.appgreenflowgroup.R

class LocationFragment : Fragment() {
    private lateinit var map: MapView
    private lateinit var viewModel: LocationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Load config osmdroid
        Configuration.getInstance().load(requireContext(), requireActivity().getPreferences(0))

        val view = inflater.inflate(R.layout.fragment_location, container, false)
        map = view.findViewById(R.id.mapView)
        map.setMultiTouchControls(true)
        map.setTileSource(org.osmdroid.tileprovider.tilesource.TileSourceFactory.MAPNIK)


        viewModel = ViewModelProvider(this).get(LocationViewModel::class.java)

        // Quan sát dữ liệu vị trí từ ViewModel
        viewModel.getSelectedLocation().observe(viewLifecycleOwner) { (point, title) ->
            map.controller.setZoom(15.0)
            map.controller.setCenter(point)

            // Xóa marker cũ (nếu có)
            map.overlays.clear()

            // Thêm marker mới
            val marker = Marker(map)
            marker.position = point
            marker.title = title
            map.overlays.add(marker)
            map.invalidate()
        }

        return view
    }
}
