package com.example.charitable.models

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.charitable.R

class MyAdapter(private val  userList : ArrayList<OrderItems>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item_books, parent, false)

        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

        val currentitem = userList[position]

        holder.name_booksdonate.text = currentitem.userName
        holder.quantity_booksdonate.text = currentitem.quantity
        holder.class_booksdonate.text = currentitem.stdClass
        holder.brief_details_books_name.text = currentitem.userName
        holder.brief_details_books_quantity.text = currentitem.quantity
        holder.brief_details_books_class.text = currentitem.stdClass
        holder.brief_details_books_email.text = currentitem.userEmail
        holder.brief_details_books_number.text = currentitem.userMobile
        holder.brief_details_books_address.text = currentitem.userAddress
        holder.brief_details_books_city.text = currentitem.userCity
        var status = currentitem.BooksOrderProgress
        holder.buttonmarkasdone.setOnClickListener{
            if(status == "Started" ){
                status = "Finished"

            }else{
                status = "was empty"
            }
            Log.d("sign in", "signInWithEmail:success")
        }




        val isVisible : Boolean = currentitem.visibility
        holder.contraintLayout.visibility = if(isVisible) View.VISIBLE else View.GONE

        holder.fullViewToExpand.setOnClickListener{

            currentitem.visibility = !currentitem.visibility
            notifyItemChanged(position)

        }

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val name_booksdonate : TextView = itemView.findViewById(R.id.Username_order_details)
        val quantity_booksdonate : TextView = itemView.findViewById(R.id.quantity_order_details)
        val class_booksdonate : TextView = itemView.findViewById(R.id.standard_order_details)
        val brief_details_books_name : TextView = itemView.findViewById(R.id.briefDetails_books_name)
        val brief_details_books_quantity : TextView = itemView.findViewById(R.id.briefDetails_books_quantity)
        val brief_details_books_class : TextView = itemView.findViewById(R.id.briefDetails_books_class)
        val brief_details_books_email : TextView = itemView.findViewById(R.id.briefDetails_books_email)
        val brief_details_books_number : TextView = itemView.findViewById(R.id.briefDetails_books_number)
        val brief_details_books_address : TextView = itemView.findViewById(R.id.briefDetails_books_address)
        val brief_details_books_city : TextView = itemView.findViewById(R.id.briefDetails_books_city)
        val contraintLayout : ConstraintLayout = itemView.findViewById(R.id.expandedLayout_books)
        val fullViewToExpand : CardView = itemView.findViewById(R.id.click_expand_books)

        val buttonmarkasdone : Button = itemView.findViewById(R.id.btnmarkasdone)

    }


}


