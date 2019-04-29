package com.times.shenawynkov.timestablelearnning

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button

class TimeAcivity : AppCompatActivity() , ExamView{
    override fun updatList(list: List<Answer>) {
        viewAdapter.list = list
        viewAdapter.notifyDataSetChanged()

    }

    private lateinit var btNext: Button


    var presenter: ExamPresenter = ExamPresenter(this@TimeAcivity, ExamInteractor())

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: MyAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_acivity)
         var i =intent.getIntExtra("time",0)
          var type =intent.getBooleanExtra("type",false)
        viewManager = LinearLayoutManager(this)
        btNext = findViewById(R.id.btSubmit);

        viewAdapter = MyAdapter(applicationContext, ArrayList<Answer>())
        recyclerView = findViewById<RecyclerView>(R.id.recycler).apply {
            layoutManager = viewManager;
            adapter = viewAdapter
            setHasFixedSize(true)
        }
            if (type)
                presenter.updateList(i)
            else
                presenter.updateList_random(i)



             btNext.setOnClickListener {
            when (btNext.text) {
                resources.getText(R.string.submit).toString() -> {

                    viewAdapter.chVisable = true
                    redraw()
                    presenter.calculateResult(viewAdapter.list)
                    btNext.text = resources.getText(R.string.next).toString()

                    btNext.setBackgroundColor(resources.getColor(R.color.myRed))


                }
                resources.getText(R.string.next).toString() -> {
                    viewAdapter.chVisable = false
                    btNext.text = resources.getText(R.string.submit).toString()
                    btNext.setBackgroundColor(resources.getColor(R.color.blue2))

                    var intent=Intent(this@TimeAcivity,MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                    startActivity(intent)


                }        }}
    }

        fun redraw()
        {


            recyclerView.setAdapter(null);
            recyclerView.setLayoutManager(null);
            recyclerView.setAdapter(viewAdapter);
            recyclerView.setLayoutManager(viewManager);
            viewAdapter.notifyDataSetChanged();
        }
}
