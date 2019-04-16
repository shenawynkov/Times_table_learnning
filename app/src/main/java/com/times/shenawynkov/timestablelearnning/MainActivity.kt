package com.times.shenawynkov.timestablelearnning

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btNormal.setOnClickListener {
            var intent =Intent(this,NormalActivity::class.java )

            intent .putExtra("flag",true)
            intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY

            startActivity(intent)

        }
        btRandom.setOnClickListener {
            var intent =Intent(this,NormalActivity::class.java )

            intent .putExtra("flag",false)
            intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
            startActivity(intent)

        }
    }
}
