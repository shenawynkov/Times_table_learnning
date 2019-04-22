package com.times.shenawynkov.timestablelearnning

import kotlin.random.Random

class ExamInteractor{

     var results= ArrayList<Int>()

    fun get_exam (x :Int ):List<Answer>
    {
        var list=ArrayList<Answer>();

        if(x==100)
        {
            for (i in 1..12)
            {
                var answer=Answer()
                answer.first=Random.nextInt(1,12)
                answer.second=Random.nextInt(1,12)
                answer.correct_ans=answer.first*answer.second
                list.add(answer)
            }

        }
        else
        {



            for (i in 1..12)
            {
                var answer=Answer()
                answer.first=x;
                answer.second=i
                answer.correct_ans=x*i
                list.add(answer)

            }


        }

        return list
    }
    fun get_random_exam (x :Int ):List<Answer>
    {
        var list=ArrayList<Answer>();


            for (i in 1..12)
            {
                var answer=Answer()
                answer.first=x
                answer.second=Random.nextInt(1,12)
                answer.correct_ans=answer.first*answer.second
                list.add(answer)
            }






        return list
    }
}