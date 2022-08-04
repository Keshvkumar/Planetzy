package com.myapp.planetzy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.apply {
            systemUiVisibility =
                 View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        planets_recycler_view.adapter = Adapter(setData.setPlanets())
        planets_recycler_view.layoutManager = LinearLayoutManager(this)
    }
}