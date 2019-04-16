package com.times.shenawynkov.timestablelearnning

import android.support.v7.widget.RecyclerView

class ExamPresenter (var examView: ExamView,var examInteractor: ExamInteractor)
{

fun updateList( i :Int )
{
    examView.updatList(examInteractor.get_exam(i))
}
    fun calculateResult( list: List<Answer>  )
    {
        var i=0;
           for(answer in list)
           {
               if(answer.answer==answer.correct_ans)
                   i++;
            }
        examInteractor.results.add(i)
    }

}