package com.example.aibsignupandsignin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TheHome : AppCompatActivity() {

    lateinit var TV1 : TextView
    lateinit var TV2 : TextView
    lateinit var SharedPreferences: SharedPreferences
    lateinit var d: String
    lateinit var username: String
    lateinit var dbhr: DBHlper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_home)

        dbhr = DBHlper(applicationContext)
        TV1=findViewById(R.id.tv1)
        TV2=findViewById(R.id.tv2)

       SharedPreferences =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        username = SharedPreferences.getString("mob","default value").toString()

        TV1.setText("Welcome "+username+"!"+"\n")
        d = dbhr.getdet(username)
        TV2.setText("Your details are \n"+d+"\n")

        //d = dbhr.getdet(username)





    }
}