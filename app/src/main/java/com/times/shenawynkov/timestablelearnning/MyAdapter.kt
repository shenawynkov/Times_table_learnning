package com.times.shenawynkov.timestablelearnning

import android.content.Context
import android.graphics.Color
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView


class MyAdapter( var context :Context,var list: List<Answer>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    var chVisable=false

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(val con: ConstraintLayout) : RecyclerView.ViewHolder(con)
    {
           var editText: EditText
        var tvExam: TextView
        var checkBox:CheckBox
        init {
            editText=con.findViewById(R.id.editText);
            tvExam=con.findViewById(R.id.tv_exam);
            checkBox=con.findViewById(R.id.checkBox)


        }
    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyAdapter.MyViewHolder {
        // create a new view
        val root = LayoutInflater.from(parent.context)
            .inflate(R.layout.exam_item, parent, false) as ConstraintLayout
        // set the view's size, margins, paddings and layout parameters

        return MyViewHolder(root)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element


        if(chVisable==true)
        {
            holder.editText.setText(list.get(position).answer.toString(),TextView.BufferType.EDITABLE)
            holder.editText.setFocusable(false);
            holder.editText.setEnabled(false);
            holder.editText.setCursorVisible(false);
            holder.editText.setKeyListener(null);
            holder.checkBox.visibility= View.VISIBLE
            if(list.get(position).answer==list.get(position).correct_ans)
            {
                holder.checkBox.isChecked=true
                holder.checkBox.text=context.resources.getText(R.string.correct)

            };
            else
            {
                holder.checkBox.isChecked=false
                holder.checkBox.text=context.resources.getText(R.string.inCorrect)
            }
        }
        else
        {
            holder.editText.text.clear()
            holder.checkBox.visibility=View.INVISIBLE
        }
        holder.tvExam.text = list.get(position).first.toString()+" * "+list.get(position).second.toString()+ " = ";
        holder.editText.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
             //To change body of created functions use File | Settings | File Templates.
            }

            override fun afterTextChanged(s: Editable?) {
                var x=s.toString().toIntOrNull()
                if(x!=null)
                list.get(position).answer=x;
             }

        })

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int): Int {
        return position
    }

}