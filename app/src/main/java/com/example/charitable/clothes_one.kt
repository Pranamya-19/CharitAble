package com.example.charitable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_books_one.*
import kotlinx.android.synthetic.main.activity_clothes_one.*

class clothes_one : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clothes_one)
        proceedclothes.setOnClickListener {
            val intent = Intent(this@clothes_one,clothes_two::class.java)
            startActivity(intent)
            finish()
        }
    }
}

