package com.example.bannereinterstitial

import android.app.Application
import com.google.android.gms.ads.MobileAds

class BannerInterstitial:Application() {
    override fun onCreate() {
        super.onCreate()
            // inicializa los anuncios
            MobileAds.initialize(this)
    }
}