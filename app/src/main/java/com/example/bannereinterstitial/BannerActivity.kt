package com.example.bannereinterstitial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest

class BannerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner)

        val adRequest = AdRequest.Builder().build()

        var adView1 = findViewById<com.google.android.gms.ads.AdView>(R.id.adView1)
        adView1.loadAd(adRequest)
        var adView2 = findViewById<com.google.android.gms.ads.AdView>(R.id.adView2)
        adView2.loadAd(adRequest)
        var adView3 = findViewById<com.google.android.gms.ads.AdView>(R.id.adView3)
        adView3.loadAd(adRequest)
        var adView4 = findViewById<com.google.android.gms.ads.AdView>(R.id.adView4)
        adView4.loadAd(adRequest)
        var adView5 = findViewById<com.google.android.gms.ads.AdView>(R.id.adView5)
        adView5.loadAd(adRequest)
        var adView6 = findViewById<com.google.android.gms.ads.AdView>(R.id.adView6)
        adView6.loadAd(adRequest)


    }
}