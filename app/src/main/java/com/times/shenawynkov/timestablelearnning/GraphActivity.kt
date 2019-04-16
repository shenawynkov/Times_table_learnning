package com.times.shenawynkov.timestablelearnning

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jjoe64.graphview.ValueDependentColor
import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint


class GraphActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)
        var list=intent.extras.getIntegerArrayList("result")

        val graph = findViewById(R.id.graph) as GraphView
        val series = BarGraphSeries<DataPoint>();
        var i = 2;
         for(x in list)
         {
             var result=((x.toDouble()*100)/12).toInt();

             series.appendData(DataPoint(i.toDouble(),result.toDouble()),false,100)
i++;
         }
        graph.addSeries(series)

// styling
        series.setValueDependentColor { data ->
            Color.rgb(
                (data.getX()  * 255 / 4).toInt() ,
                Math.abs(data.getY() * 255 / 6).toInt(),
                100
            )
        }

        series.setSpacing(50)

// draw values on top
        series.setDrawValuesOnTop(true)
        series.setValuesOnTopColor(Color.RED)
    }
}
