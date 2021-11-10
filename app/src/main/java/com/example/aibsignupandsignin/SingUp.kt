package com.example.aibsignupandsignin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SingUp : AppCompatActivity() {

    lateinit var EDT1name:EditText
    lateinit var EDT1mobile:EditText
    lateinit var EDT1loc:EditText
    lateinit var EDT1pass:EditText
    lateinit var BTNcreate:Button
    lateinit var spf: SharedPreferences
    lateinit var editr: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)

        EDT1name=findViewById(R.id.edt1name)
        EDT1mobile=findViewById(R.id.edt1mobile)
        EDT1loc=findViewById(R.id.edt1loc)
        EDT1pass=findViewById(R.id.edt1pas)
        BTNcreate=findViewById(R.id.btn1create)

        spf =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        editr = spf.edit()


        var dbhr = DBHlper(applicationContext)

        BTNcreate.setOnClickListener {
            var s1 = EDT1name.text.toString()
            var s2 = EDT1loc.text.toString()
            var s3 = EDT1mobile.text.toString()
            var s4 = EDT1pass.text.toString()

            var k = dbhr.savedet(s1, s2, s3, s4)

            Toast.makeText(applicationContext, "data saved successfully! ", Toast.LENGTH_SHORT)
                .show();
            if (k.equals("-1"))
            {
                Toast.makeText(applicationContext, "Error data not saved!", Toast.LENGTH_SHORT)
                    .show();
            } else
            {
                editr.putString("mob",s3).commit()
                Toast.makeText(applicationContext, "save success!", Toast.LENGTH_SHORT).show();
                Intent(this, TheHome::class.java).apply { startActivity(this) }
            }
        }
    }

    }
