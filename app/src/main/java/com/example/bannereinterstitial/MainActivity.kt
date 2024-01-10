package com.example.bannereinterstitial

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var ibURL = findViewById<ImageButton>(R.id.ibURL)
        val url = "https://developers.google.com/admob/android/quick-start?hl=es-419"
        ibURL.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        //Banner
        var btnBanner = findViewById<Button>(R.id.btnBanner)
        val bannerIntent = Intent(this, BannerActivity::class.java)
        btnBanner.setOnClickListener { startActivity(bannerIntent) }
        //Interstitial
        var btnInterstitial = findViewById<Button>(R.id.btnInterstitial)
        val interstitialIntent = Intent(this, InterstitialActivity::class.java)
        btnInterstitial.setOnClickListener { startActivity(interstitialIntent) }
        //Recompensa
        var btnRecompensa = findViewById<Button>(R.id.btnRecompensado)
        val recompensaIntent = Intent(this, RecompensadoActivity::class.java)
        btnRecompensa.setOnClickListener { startActivity(recompensaIntent) }

    }




}