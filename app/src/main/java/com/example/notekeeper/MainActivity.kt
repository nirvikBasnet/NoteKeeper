package com.example.notekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import com.example.notekeeper.databinding.ActivityMainBinding
import com.example.notekeeper.databinding.ActivityNoteListBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var notePosition = POSITION_NOT_SET

    private lateinit var spinnerCourses : Spinner
    private lateinit var textNoteTitle : EditText
    private lateinit var textNoteText : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setup view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        spinnerCourses = binding.spinner
        textNoteTitle = binding.editTextNoteTitle
        textNoteText = binding.editTextNoteText

        val adapterCourses = ArrayAdapter<CourseInfo>(this,android.R.layout.simple_spinner_item,
                                DataManager.courses.values.toList())
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerCourses.adapter = adapterCourses

        notePosition = intent.getIntExtra(EXTRA_NOTE_POSITION, POSITION_NOT_SET)

        if(notePosition != POSITION_NOT_SET){
            displayNote()
        }

    }

    private fun displayNote() {
        val note = DataManager.notes[notePosition]

        textNoteTitle.setText(note.title)
        textNoteText.setText(note.text)

        val coursePosition = DataManager.courses.values.indexOf(note.courseInfo)
        spinnerCourses.setSelection(coursePosition)

    }
}