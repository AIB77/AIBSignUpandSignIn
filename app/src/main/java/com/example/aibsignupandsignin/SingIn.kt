package com.example.aibsignupandsignin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SingIn : AppCompatActivity() {

    lateinit var EDTmobile1: EditText
    lateinit var EDTpassword1: EditText
    lateinit var dbhr: DBHlper
    lateinit var BTNsignin1: Button
    lateinit var PW: String
    lateinit var spf1: SharedPreferences
    lateinit var editr: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sing_in)
        EDTmobile1 = findViewById(R.id.eddsinginnumber)
        EDTpassword1 = findViewById(R.id.edtsininpass)
        BTNsignin1 = findViewById(R.id.btnsinginpage)
        dbhr = DBHlper(applicationContext)

        spf1 =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        editr = spf1.edit()

        BTNsignin1.setOnClickListener {

            var s1=EDTmobile1.text.toString()
            var s2=EDTpassword1.text.toString()

            PW = dbhr.checkpassword(s1)

            if (PW.equals(s2))
            {
                editr.putString("mob",s1).commit()
                Toast.makeText(applicationContext, "Sign in success!", Toast.LENGTH_SHORT).show();
                Intent(this, TheHome::class.java).apply { startActivity(this) }

            } else
            {
                Toast.makeText(applicationContext, "Invaild details", Toast.LENGTH_SHORT).show();
            }
        }
    }
}