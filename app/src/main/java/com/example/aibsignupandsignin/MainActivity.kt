package com.example.aibsignupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var BTNsingin:Button
    lateinit var BTNsingup:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BTNsingin=findViewById(R.id.btnsingin)
        BTNsingup=findViewById(R.id.btnsingup)

        BTNsingin.setOnClickListener {

            intent = Intent(applicationContext, SingIn::class.java)
            startActivity(intent)

        }

        BTNsingup.setOnClickListener {
            intent = Intent(applicationContext, SingUp::class.java)
            startActivity(intent)
        }




    }
}