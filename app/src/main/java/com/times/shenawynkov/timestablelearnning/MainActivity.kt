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

            intent .putExtra("flag",0)
            intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY

            startActivity(intent)

        }
        btRandom.setOnClickListener {
            var intent =Intent(this,NormalActivity::class.java )

            intent .putExtra("flag",1)
            intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
            startActivity(intent)

        }
        btRandoml2.setOnClickListener {


            var intent =Intent(this,ChooseActivity::class.java )

            intent .putExtra("type",false)
            intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
            startActivity(intent)
        }
        bt_normal_by_times.setOnClickListener {

            var intent =Intent(this,ChooseActivity::class.java )

            intent .putExtra("type",true)
            intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
            startActivity(intent)
        }
    }
}
