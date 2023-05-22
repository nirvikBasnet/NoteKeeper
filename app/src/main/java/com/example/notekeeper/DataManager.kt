package com.example.notekeeper

object DataManager {
    val courses = HashMap<String,CourseInfo>()
    val notes = ArrayList<NoteInfo>()


    init {
        initializeCourses()
        initializeNotes()
    }

    private fun initializeCourses(){
        var course = CourseInfo("kotlin_fundamental","Foundation of KOTLIN programming")
        courses.set(course.courseId,course)

         course = CourseInfo("kotlin_core","KOTLIN core")
        courses.set(course.courseId,course)

         course = CourseInfo("kotlin_async","Async Programming with kotlin")
        courses.set(course.courseId,course)

         course = CourseInfo("android_fundamentals","Building Android App with kotlin")
        courses.set(course.courseId,course)
    }

    private fun initializeNotes(){

        var note = NoteInfo(CourseInfo("kotlin_fundamental","Foundation of KOTLIN programming"),"Foundation 1st Lecture",
        "KOTLIN is a modern programming language")

        notes.add(note)

        note = NoteInfo(CourseInfo("kotlin_core","KOTLIN core"),"Kotlin Core 1st Lecture",
            "KOTLIN can be used for mobile, web (frontend & backend)")
        notes.add(note)


    }
}