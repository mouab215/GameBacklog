package com.mourad.gamebacklog.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mourad.gamebacklog.R
import com.mourad.gamebacklog.entity.Game
import com.mourad.notepad.ui.AddActivityViewModel

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*
import java.util.*

class AddActivity : AppCompatActivity() {
    private lateinit var addActivityViewModel: AddActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        initViews()
        initViewModel()
    }

    private fun initViews() {
        fab.setOnClickListener {
            var newGame = Game(
                etTitle.text.toString(),
                etPlatform.text.toString(),
                Date((etYear.text.toString().toInt() - 1900),
                    (etMonth.text.toString().toInt() - 1),
                    etDay.text.toString().toInt())
            )
            addActivityViewModel.game.value = newGame
            addActivityViewModel.insertGame()
            finish()
        }
    }

    private fun initViewModel() {
        addActivityViewModel = ViewModelProviders.of(this).get(AddActivityViewModel::class.java)
        addActivityViewModel.game.value = null

        addActivityViewModel.game.observe(this, Observer { note ->
//            if (note != null) {
//                etTitle.setText(note.title)
//                etNote.setText(note.text)
//            }
        })

//        addActivityViewModel.error.observe(this, Observer { message ->
//            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//        })
//
//        addActivityViewModel.success.observe(this, Observer { success ->
//            if (success) finish()
//        })
    }
}
