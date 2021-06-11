package com.example.splash.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.splash.Infra.MotivationConstantes
import com.example.splash.Infra.MotivationConstantes.Companion.NAME_SECURITY_PREFERENCES_KEY

import com.example.splash.Infra.SecurityPreferences
import com.example.splash.R
import kotlinx.android.synthetic.main.activity_splash.*

class Splash : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        
        if (supportActionBar != null){
            supportActionBar!!.hide()
        }

        sign.setOnClickListener(this)


        mSecurityPreferences = SecurityPreferences(this)

        verifyName()

    }
    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.sign){
            Saving()
        }
    }

    fun verifyName(){
        val name = mSecurityPreferences.getString(MotivationConstantes.NAME_SECURITY_PREFERENCES_KEY)
        if(name != ""){
            val intent = Intent(this, MainActivity::class.java)
        }
    }

    fun Saving(){
        val name = signName.text.toString()
        if(!name.isEmpty()){
            mSecurityPreferences.storeString(NAME_SECURITY_PREFERENCES_KEY, name)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Enter a name", Toast.LENGTH_SHORT).show()
        }
    }

}