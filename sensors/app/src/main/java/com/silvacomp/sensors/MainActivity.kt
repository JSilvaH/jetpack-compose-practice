package com.silvacomp.sensors

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.silvacomp.sensors.ui.theme.SensorsTheme

class MainActivity : ComponentActivity() {
    private lateinit var acelerometter: Sensor

    private var pepe = mutableStateOf<String>("")


    private lateinit var sensorManager: SensorManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)
        acelerometter = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        setContent {
            SensorsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {


                    Greeting(deviceSensors)
                }
            }
        }
    }


}

@Composable
fun Greeting(deviceSensor: List<Sensor>) {
    val context = LocalContext.current
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items = deviceSensor, itemContent = { sensor ->
            ItemSensor(sensor, context)
        })
    }
}

@Composable
fun ItemSensor(sensor: Sensor, context: Context) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
            .clickable {
                val intent = Intent(context, DetailActivity::class.java).apply {
                   putExtra("sensor", sensor.name)
                    putExtra("type", sensor.type)
                }
                context.startActivity(intent)
            },
        elevation = 10.dp,
        shape = RoundedCornerShape(20.dp)

    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = sensor.name,
                textAlign = TextAlign.Center,
                fontSize = 19.sp
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SensorsTheme {

    }
}