package com.example.plusminuscount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Declare module-level variable
    private lateinit var countViewModel: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize the ViewModel
        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)

        //Add an observer to the ViewModel
        countViewModel.count.observe(this,
            Observer {
                if(it.equals(4)) goodLuck()
            }
        )

        textViewCount.text = countViewModel.count.value.toString()

        buttonPlus.setOnClickListener {
            countViewModel.increment()
            textViewCount.text = countViewModel.count.value.toString()
        }

        buttonMinus.setOnClickListener {
            countViewModel.decrement()
            textViewCount.text = countViewModel.count.value.toString()
        }
    }

    private fun goodLuck(){
        Toast.makeText(applicationContext,
            "What a lucky day",
            Toast.LENGTH_SHORT).show()
    }


}
