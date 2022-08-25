package com.example.app_quizz

object QuestionAnswer {
    var question = arrayOf(
        "1+1",
        "1+2",
        "1+3",
        "1+4",
        "1+5",
        "1+6",
        "1+7",
        "1+8",
        "1+9",
        "1+10"
    )
    var choices = arrayOf(
        arrayOf("1", "2", "3", "4"),
        arrayOf("2", "3", "4", "6"),
        arrayOf("5", "2", "4", "7"),
        arrayOf("7", "5", "1", "6"),
        arrayOf("1", "8", "6", "4"),
        arrayOf("7", "2", "3", "4"),
        arrayOf("1", "2", "8", "4"),
        arrayOf("1", "2", "9", "4"),
        arrayOf("1", "2", "3", "10"),
        arrayOf("11", "2", "3", "4")
    )
    var correctAnswers = arrayOf(
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11"
    )
}