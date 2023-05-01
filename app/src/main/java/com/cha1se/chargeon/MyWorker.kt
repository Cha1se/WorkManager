package com.cha1se.chargeon

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    private var mediaPlayer: MediaPlayer? = null

    override fun doWork(): Result {
        try {

            val song = R.raw.song
            playMusic(context = applicationContext, song = song)

        } catch (ex: Exception) {
            return Result.failure(); //или Result.retry()
        }
        return Result.success()
    }

    private fun playMusic(context: Context, song: Int) {

        mediaPlayer = MediaPlayer.create(context, song)
        mediaPlayer?.start()

    }

}