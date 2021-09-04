package com.example.controllers

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.controllers.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //View binding
        binding= ActivityMainBinding.inflate(layoutInflater)
        view= binding.root

        //Inflate the activity
        setContentView(view)

        //Method to add all the button listeners
        addListeners()
    }

    private fun addListeners(){
        //Name button

        binding.btnName.setOnClickListener{
            hideKeyboard()
            //Message behaviour
            var message = "${binding.etName.text}, You r using a field"
            if (binding.etName.text.isBlank()) {
                message = "Name field is empty"
            }
            //Show SnackBar
            Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show()
        }

        //Next controller button
        binding.btnNextController.setOnClickListener{
            startActivity(Intent(this, PickerActivity::class.java))
        }
    }


    private fun hideKeyboard(){
        val manager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        manager.hideSoftInputFromWindow(view.windowToken, 0)

    }

}