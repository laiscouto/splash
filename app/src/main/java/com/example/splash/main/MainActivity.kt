package com.example.splash.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.splash.Infra.MotivationConstantes
import com.example.splash.Infra.MotivationConstantes.Companion.NAME_SECURITY_PREFERENCES_KEY
import com.example.splash.Infra.SecurityPreferences
import com.example.splash.R
import com.example.splash.Repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mPhrasesFilter : Int = MotivationConstantes.PHRASESFILTER.ALL
    private lateinit var mCoffeStore: CoffeeStoreActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null){
            supportActionBar!!.hide()
        }

        mSecurityPreferences = SecurityPreferences(this)

        notas.setColorFilter(resources.getColor(R.color.black))
        handleNewPhrase()

        setUpView()

        sun.setOnClickListener(this)
        notas.setOnClickListener(this)
        day.setOnClickListener(this)

        Next.setOnClickListener(this)

        Account.setOnClickListener(this)
        Home.setOnClickListener(this)
        Store.setOnClickListener(this)
        StoreCoffe.setOnClickListener(this)
    }

    fun setUpView(){
        val name = mSecurityPreferences.getString(NAME_SECURITY_PREFERENCES_KEY)
        greeTingsUsers.text ="Olá, $name"
    }

    override fun onClick(view: View) {
        val id = view.id
        val listFilter = listOf(R.id.sun, R.id.notas, R.id.day)

        if(id == R.id.Next){
            handleNewPhrase()
        }else if(id in listFilter){
            handlerFilter(id)
        }

        if(id == R.id.StoreCoffe){
            storeCoffe()
        }
    }

    private fun handlerFilter(id: Int){
        sun.setColorFilter(resources.getColor(R.color.marromClaro))
        notas.setColorFilter(resources.getColor(R.color.marromClaro))
        day.setColorFilter(resources.getColor(R.color.marromClaro))

        when (id){
            R.id.sun ->{
                sun.setColorFilter(resources.getColor(R.color.white))
                mPhrasesFilter = MotivationConstantes.PHRASESFILTER.SUN
            }
            R.id.notas ->{
                notas.setColorFilter(resources.getColor(R.color.white))
                mPhrasesFilter = MotivationConstantes.PHRASESFILTER.ALL
            }
            R.id.day ->{
                day.setColorFilter(resources.getColor(R.color.white))
                mPhrasesFilter = MotivationConstantes.PHRASESFILTER.DAY
            }
        }
    }

    private fun handleNewPhrase(){
        textPhrase.text = Mock().getPhrases(mPhrasesFilter)
    }

    private fun storeCoffe(){
        val x = Intent(this, CoffeeStoreActivity::class.java)
        startActivity(x)
    }
}