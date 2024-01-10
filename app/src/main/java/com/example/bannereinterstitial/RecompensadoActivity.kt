package com.example.bannereinterstitial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

class RecompensadoActivity : AppCompatActivity() {
    private var rewarded: RewardedAd? = null
    private var tvNPuntos: TextView? = null
    private var puntos = 30  // Inicializar el contador de puntos


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recompensado)

        // Inicializar el TextView para mostrar los puntos
        tvNPuntos = findViewById(R.id.tvNPuntos)
        tvNPuntos?.text = puntos.toString()

        // Cargar el anuncio recompensado al inicio de la actividad
        loadRewardedAd()

        // Configurar el OnClickListener para el botón de ver anuncio
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            // Mostrar el anuncio recompensado al hacer clic en el botón
            showRewardedAd()
        }
    }


    // Método para cargar el anuncio recompensado
    private fun loadRewardedAd() {
        // Crear una solicitud de anuncio
        val adRequest = AdRequest.Builder().build()

        // Cargar el anuncio recompensado
        RewardedAd.load(this,"ca-app-pub-3940256099942544/5224354917", adRequest, object : RewardedAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                // Manejar el error de carga de anuncio (puedes mostrar un mensaje o realizar acciones específicas)
                rewarded = null
            }

            override fun onAdLoaded(ad: RewardedAd) {
                // El anuncio se ha cargado correctamente
                rewarded = ad
            }
        })
    }


    // Método para mostrar el anuncio recompensado
    private fun showRewardedAd() {
        // Verificar si el anuncio recompensado está cargado
        if (rewarded != null) {
            // Mostrar el anuncio recompensado
            rewarded?.show(this) { rewardItem: RewardItem ->
                // Manejar la recompensa obtenida del anuncio
                puntos += rewardItem.amount
                tvNPuntos?.text = puntos.toString()

                // Cargar un nuevo anuncio recompensado para la próxima vez
                loadRewardedAd()
            }
        } else {
            // El anuncio no está cargado, puedes mostrar un mensaje o cargar otro anuncio
            loadRewardedAd()
        }
    }
}