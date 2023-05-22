package com.example.notekeeper

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.notekeeper.databinding.ActivityNoteListBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoteListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteListBinding
    private lateinit var addNotes : FloatingActionButton
    private lateinit var noteList : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setting binding
        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareInterface()

    }

    private fun prepareInterface(){
        addNotes = binding.addNotes
        noteList = binding.listNotes

        //addNotes floating action button
        addNotes.setOnClickListener{
            val activityIntent = Intent(this,MainActivity::class.java)
            startActivity(activityIntent)
        }

        //populating notelist
        noteList.adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,DataManager.notes )

        //implementing function interface
        noteList.setOnItemClickListener{parent,view,position,id ->
            val activityIntent = Intent(this,MainActivity::class.java)

            //provide note position
            activityIntent.putExtra(EXTRA_NOTE_POSITION,position)

            startActivity(activityIntent)
        }
    }

}
