package com.example.appgreenflowgroup.ui.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.osmdroid.util.GeoPoint

class LocationViewModel : ViewModel() {
    private val selectedLocation = MutableLiveData(
        Pair(GeoPoint(21.028511, 105.854167), "Thủ đô Việt Nam") // Hà Nội
    )

    fun setSelectedLocation(point: GeoPoint, title: String) {
        selectedLocation.value = Pair(point, title)
    }

    fun getSelectedLocation(): LiveData<Pair<GeoPoint, String>> {
        return selectedLocation
    }
}
