package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var submitButton: Button
    lateinit var etMessage: EditText

    private var items = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etMessage = findViewById(R.id.etMessage)

        submitButton = findViewById(R.id.submitButton)

        submitButton.setOnClickListener{ addItems() }
    }

    private fun addItems() {
        if (etMessage.text.isEmpty() || etMessage.text.toString() == " ") {
            Snackbar.make(clMain, "You did not enter anything!", Snackbar.LENGTH_SHORT).show();
            return;
        } else {
            items.add(etMessage.text.toString())

            val myRV = findViewById<RecyclerView>(R.id.rvMain)
            myRV.adapter = RecyclerViewAdapter(items)
            myRV.layoutManager = LinearLayoutManager(this)

            etMessage.text.clear()

            Log.d("MainActivity", items.toString())
        }
    }
}