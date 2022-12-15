package com.silvacomp.sensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.silvacomp.sensors.ui.theme.SensorsTheme

class DetailActivity : ComponentActivity(), SensorEventListener {
    private var sensorReceived: String? = null
    private var typeSensorReceived: Int? = null
    private lateinit var sensorManager: SensorManager
    private lateinit var sensor: Sensor
    private lateinit var viewModel: DetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sensorReceived = intent.getStringExtra("sensor")
        typeSensorReceived = intent.getIntExtra("type", 0)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        viewModel = DetailViewModel()
        sensor = sensorManager.getDefaultSensor(typeSensorReceived!!)
        setContent {
            SensorsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting2(sensorReceived ?: "No sensor", viewModel.valueAccelerometer.value)
                }
            }
        }
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        viewModel.onChangedValue(p0!!.values[0].toString())
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onResume() {
        super.onResume()
        sensor.also { sensor ->
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}

@Composable
fun Greeting2(name: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp),
            text = name,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 24.sp,
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(2.0f, 6.0f),
                    blurRadius = 3f
                )
            ),
            fontStyle = FontStyle.Italic


        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = value,
                textAlign = TextAlign.Center
            )
        }


    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    SensorsTheme {

    }
}