package com.example.charitable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.charitable.R
import com.example.charitable.firebase.FirestoreClass
import kotlinx.android.synthetic.main.activity_donor_two.*

class splash2 : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)
        val time : Long = 2500

        Handler().postDelayed(Runnable {
           val intent = Intent(this@splash2,donor_two::class.java)
            startActivity(intent)
            finish()
        },time)
    }
}
