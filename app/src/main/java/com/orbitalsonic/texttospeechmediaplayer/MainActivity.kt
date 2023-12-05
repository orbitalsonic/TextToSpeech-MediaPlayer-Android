package com.orbitalsonic.texttospeechmediaplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var textToSpeechConverter: TextToSpeechConverter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initTTS()

        findViewById<Button>(R.id.btn_speak_english).setOnClickListener {
            requestForTextSpeak("Hello!, How are you?","en")

        }

        findViewById<Button>(R.id.btn_speak_french).setOnClickListener {
            requestForTextSpeak("Bonjour comment allez-vous?","fr")

        }
    }

    private fun initTTS(){
        textToSpeechConverter = TextToSpeechConverter(this,object : OnTTSListener {
            override fun onReadyForSpeak() {}
            override fun onError(error: String) { showToast(error) }
        })
    }

    private fun requestForTextSpeak(text:String,langCode:String){
        textToSpeechConverter?.speakText(text,langCode)
    }

    private fun showToast(message:String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        textToSpeechConverter?.stopTTSMediaPlayer()
        super.onPause()
    }

    override fun onStop() {
        textToSpeechConverter?.stopTTSMediaPlayer()
        super.onStop()
    }

    override fun onDestroy() {
        textToSpeechConverter?.stopTTSMediaPlayer()
        super.onDestroy()
    }
}