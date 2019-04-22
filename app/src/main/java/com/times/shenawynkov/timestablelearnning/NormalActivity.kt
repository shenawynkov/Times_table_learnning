package com.times.shenawynkov.timestablelearnning

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle


class NormalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)
       var flag=intent.getIntExtra("flag",0)



        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = TimesFragment()
        var bundle=Bundle()
        bundle.putInt("flag",flag)
         fragment.arguments=bundle
        fragmentTransaction.add(R.id.fragment_container, fragment).commit()


    }
}
