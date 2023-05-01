package com.cha1se.chargeon

import android.content.Context
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onCharge()
    }

    private fun onCharge() {



        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .build()

        val myWorkRequest = OneTimeWorkRequestBuilder<MyWorker>()
            .addTag("tag")
            .setInitialDelay(1, TimeUnit.SECONDS)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(applicationContext).enqueue(myWorkRequest)

    }


}