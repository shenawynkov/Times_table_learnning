package com.times.shenawynkov.timestablelearnning

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

class ChooseAdapter(private val arr: Array<Int>,val context: Context,val type:Boolean ) :
    RecyclerView.Adapter<ChooseAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)



    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ChooseAdapter.MyViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.choose_item, parent, false) as TextView
        // set the view's size, margins, paddings and layout parameters

        return MyViewHolder(textView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.text = arr[position].toString()+"   Times"
        holder.textView.setOnClickListener {
       var intent= Intent(context,TimeAcivity::class.java)
            intent.putExtra("time",arr[position])
            intent.putExtra("type",type)

            context.startActivity(intent);

        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = arr.size
}