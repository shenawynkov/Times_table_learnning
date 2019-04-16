package com.times.shenawynkov.timestablelearnning

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class TimesFragment : Fragment(), ExamView {

    var presenter: ExamPresenter = ExamPresenter(this@TimesFragment, ExamInteractor())
    private lateinit var btNext: Button

    var i = 2;
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: MyAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.frament_times, container, false)

        var flag=arguments!!.getBoolean("flag")



        viewManager = LinearLayoutManager(activity)

        viewAdapter = MyAdapter(activity!!.applicationContext, ArrayList<Answer>())
        recyclerView = root!!.findViewById<RecyclerView>(R.id.recycler).apply {
            layoutManager = viewManager;
            adapter = viewAdapter
            setHasFixedSize(true)

            btNext = root.findViewById(R.id.btSubmit);

            if(flag)
            {
                presenter.updateList(i)

                btNext.setOnClickListener(View.OnClickListener {
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
                            i++;
                            btNext.text = resources.getText(R.string.submit).toString()
                            btNext.setBackgroundColor(resources.getColor(R.color.blue2))
                            if(i>12)
                            {
                                var intent=Intent(activity,GraphActivity::class.java)
                                intent.putExtra("result",presenter.examInteractor.results)

                                startActivity(intent)
                            }
                            else

                                presenter.updateList(i)
                        }


                    }


                })

            }
            else
            { presenter.updateList(100)
                btNext.setOnClickListener(View.OnClickListener {
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

                                var intent=Intent(activity,MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                            startActivity(intent)


                        }


                    }


                })

            }




        }

        return root
    }

    override fun updatList(list: List<Answer>) {

        viewAdapter.list = list
        viewAdapter.notifyDataSetChanged()

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