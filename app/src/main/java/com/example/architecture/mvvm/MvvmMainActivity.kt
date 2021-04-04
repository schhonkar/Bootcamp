package com.example.architecture.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.architecture.R
import com.example.architecture.databinding.ActivityMvvmMainBinding
import com.example.architecture.mvm.model.Player

class MvvmMainActivity : AppCompatActivity() {

    var buttons = arrayOfNulls<Button>(9)
    var activityGameBinding: ActivityMvvmMainBinding? = null
    var row:Int?=0
    var col:Int?=0
    lateinit var gameViewModel: MvvmViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_mvvm_main)

        activityGameBinding= DataBindingUtil.setContentView(this, R.layout.activity_mvvm_main)
        gameViewModel = ViewModelProviders.of(this).get(MvvmViewModel::class.java)
        activityGameBinding?.gameViewModel = gameViewModel



        gameViewModel.getWinner()?.observe(this, Observer {
            winner:Player?->onGameWinnerChanged(winner!!)
//            Log.i("mvvm winner", "winner is : ")
        })

    }

    fun onGameWinnerChanged(winner: Player) {
        if (winner == null)
            activityGameBinding?.winnerPlayerLabelmvvm?.text = "it's a tie"
        else
            activityGameBinding?.winnerPlayerLabelmvvm?.text = winner.toString()

    }
}