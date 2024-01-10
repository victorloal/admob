package com.example.bannereinterstitial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

class InterstitialActivity : AppCompatActivity() {
    // Contador para realizar un seguimiento de los clics en el botón
    private var count = 0

    // Objeto de anuncio intersticial
    private var interstitial: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interstitial)
        // Inicializar el botón
        var btnCount = findViewById<Button>(R.id.btnCount)

        // Inicializar los anuncios intersticiales
        initAds()

        // Configurar el OnClickListener para el botón
        btnCount.setOnClickListener {
            // Incrementar el contador al hacer clic en el botón
            count += 1

            // Verificar el contador y mostrar anuncio intersticial si es necesario
            checkCounter()
        }
    }

    // Verificar el contador y mostrar anuncio intersticial si se alcanza el límite
    private fun checkCounter() {
        if(count == 5){
            // Mostrar el anuncio intersticial cuando el contador alcanza 5
            showAds()

            // Reiniciar el contador y volver a inicializar los anuncios
            count = 0
            initAds()
        }
    }

    // Inicializar los anuncios intersticiales
    private fun initAds() {
        // Crear una solicitud de anuncio
        var adRequest = AdRequest.Builder().build()

        // Cargar el anuncio intersticial
        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback(){
            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                // El anuncio se ha cargado correctamente
                interstitial = interstitialAd
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                // Manejar el error de carga de anuncio (puedes mostrar un mensaje o realizar acciones específicas)
                interstitial = null
            }
        })
    }

    // Mostrar el anuncio intersticial
    private fun showAds(){
        interstitial?.show(this)
    }
}