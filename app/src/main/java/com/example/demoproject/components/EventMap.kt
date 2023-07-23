package com.example.demoproject.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.arcgismaps.ApiKey
import com.arcgismaps.ArcGISEnvironment
import com.arcgismaps.mapping.ArcGISMap
import com.arcgismaps.mapping.PortalItem
import com.arcgismaps.mapping.view.MapView
import com.arcgismaps.portal.Portal
import com.example.demoproject.Constants

@Composable
fun EventMap(itemId: String) {
    var lifecycle: Lifecycle.Event by remember { mutableStateOf(Lifecycle.Event.ON_CREATE) }
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            lifecycle = event
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    Card(
        shape = RoundedCornerShape(Constants.ROUNDED_CORNER_SHAPE.dp),
        elevation = CardDefaults.cardElevation(Constants.CARD_ELEVATION.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        modifier = Modifier.padding(0.dp, (Constants.CONTENT_PADDING_LARGE * 0.6).dp, 0.dp, 0.dp)
    ) {
        AndroidView(
            factory = { context ->
                val mapView = MapView(context)
                setApiKey()
                setupMap(mapView, itemId)
                mapView
            },
            update = {
                when (lifecycle) {
                    Lifecycle.Event.ON_CREATE -> it.onCreate(lifecycleOwner)
                    Lifecycle.Event.ON_START -> it.onStart(lifecycleOwner)
                    Lifecycle.Event.ON_RESUME -> it.onResume(lifecycleOwner)
                    Lifecycle.Event.ON_PAUSE -> it.onPause(lifecycleOwner)
                    Lifecycle.Event.ON_STOP -> it.onStop(lifecycleOwner)
                    Lifecycle.Event.ON_DESTROY -> it.onDestroy(lifecycleOwner)
                    else -> Unit
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(314.dp)
        )
    }
}

private fun setupMap(mapView: MapView, itemId: String) {
    val portal = Portal("https://intern-hackathon.maps.arcgis.com/", Portal.Connection.Anonymous)
    val portalItem = PortalItem(portal, itemId)
    val map = ArcGISMap(portalItem)
    mapView.map = map
}

private fun setApiKey() {
    ArcGISEnvironment.apiKey =
        ApiKey.create("AAPK3fcd2907bd2d4af0b222ea32d8ae257flBSjSGxO4KCWdLPKL3ja4Ah9cqWv8k5HMFTBg4Pgux6IDYh5L6unmysx_aIFoPXl")
}