package com.example.charitable

import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.charitable.models.MyAdapter
import com.example.charitable.models.OrderItems
import com.example.charitable.models.SwipeGesture
import com.google.firebase.database.*
import android.widget.Toast
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import java.util.*
import kotlin.collections.ArrayList

class OrderdetailsNGO_books : BaseActivity() {

    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference
    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<OrderItems>
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orderdetails_ngo)

        userRecyclerView = findViewById(R.id.orderdetails_NGO)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf<OrderItems>()

       swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)

        refreshapp()

        getUserData()

    }
    private fun refreshapp()
    {
        swipeRefreshLayout.setOnRefreshListener {
            Toast.makeText(this,"page refreshed",Toast.LENGTH_SHORT).show()
            swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun getUserData() {

        dbref = FirebaseDatabase.getInstance("https://charitable-48fd7-default-rtdb.asia-southeast1.firebasedatabase.app/")
            .getReference("BooksOrder")

        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

//                if(swipeRefreshLayout.isRefreshing){
//                    swipeRefreshLayout.isRefreshing = false
//                }

                if (snapshot.exists()){
                    for(userSnapshot in snapshot.children) {

                        val user = userSnapshot.getValue(OrderItems::class.java)
                        if (user != null) {
                            userArrayList.add(user)
                        }


                    }
                    val adapter = MyAdapter(userArrayList)

                    val swipegesture = object : SwipeGesture(this@OrderdetailsNGO_books){

                        override fun onMove(
                            recyclerView: RecyclerView,
                            viewHolder: RecyclerView.ViewHolder,
                            target: RecyclerView.ViewHolder
                        ): Boolean {
                            if(viewHolder.itemViewType != target.itemViewType)
                                return false

                            val from_pos = viewHolder.adapterPosition
                            val to_pos =target.adapterPosition

                            val item = userArrayList.removeAt(from_pos)
                            userArrayList.add(to_pos,item)

                            //Collections.swap(userArrayList,from_pos,to_pos)
                           // adapter.notifyItemMoved(from_pos,to_pos)

                            recyclerView.adapter!!.notifyItemMoved(from_pos,to_pos)



                            return true

                        }


                        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                            when(direction){

                                ItemTouchHelper.LEFT ->{
                                    adapter.deleteItem(viewHolder.adapterPosition)
                                }

//                                ItemTouchHelper.RIGHT -> {
//
//                                    //  TODO : mark as done karo
//
////                                    val archiveItem = userArrayList[viewHolder.adapterPosition]
////                                    adapter.deleteItem(viewHolder.adapterPosition)
////                                    adapter.addItem(userArrayList.size,archiveItem)
//
//                                }


                            }


                        }

                    }



                    val touchHelper = ItemTouchHelper(swipegesture)
                    touchHelper.attachToRecyclerView(userRecyclerView)

                    userRecyclerView.adapter = MyAdapter(userArrayList)

                }

            }

            override fun onCancelled(error: DatabaseError) {


            }
            
        })
    }



}


