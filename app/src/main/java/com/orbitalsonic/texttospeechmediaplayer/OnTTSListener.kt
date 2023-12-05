package com.orbitalsonic.texttospeechmediaplayer

interface OnTTSListener {
    fun onReadyForSpeak()
    fun onError(error: String)
}