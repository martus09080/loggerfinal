package com.example.Graph

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.data2viz.charts.chart.Chart
import io.data2viz.charts.chart.chart
import io.data2viz.charts.chart.discrete
import io.data2viz.charts.chart.mark.area
import io.data2viz.charts.chart.quantitative
import io.data2viz.geom.Size
import io.data2viz.viz.VizContainerView

class GraphMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(CanadaChart(this))
    }
}

class CanadaChart(context: Context) : VizContainerView(context) {

    private val chart: Chart<PopCount> = chart(canPop) {
        size = Size(vizSize, vizSize)
        title = "Temperature measured"

        // Create a discrete dimension for the year of the census
        val time = discrete({ domain.time }) {
            name = "Time of measurement"
        }

        // Create a continuous numeric dimension for the population
        val temperature = quantitative({ domain.temperature }) {
            name = "Temperature (in Celcius)"
        }

        // Using a discrete dimension for the X-axis and a continuous one for the Y-axis
        area(time, temperature)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        chart.size = Size(vizSize, vizSize * h / w)
    }
}

const val vizSize = 500.0

data class PopCount(val time: Double, val temperature: Double)

val canPop = listOf(
    PopCount(10.00, 24.2),
    PopCount(11.00, 25.4),
    PopCount(12.00, 26.6),
    PopCount(13.00, 27.1),
    PopCount(14.00, 23.7),
    PopCount(15.00, 20.9),
    PopCount(16.00, 17.2),
    PopCount(17.00, 31.1),
    PopCount(18.00, 34.6),
    PopCount(19.00, 38.1)
)