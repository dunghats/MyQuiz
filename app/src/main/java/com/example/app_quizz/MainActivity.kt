package com.example.app_quizz

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.example.app_quizz.QuestionAnswer
import android.os.Bundle
import com.example.app_quizz.R
import android.content.DialogInterface
import android.graphics.Color
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var totalQuestionsTextView: TextView? = null
    var questionTextView: TextView? = null
    var A: Button? = null
    var B: Button? = null
    var C: Button? = null
    var D: Button? = null
    var submitBtn: Button? = null
    var score = 0
    var totalQuestion = QuestionAnswer.question.size
    var currentQuestionIndex = 0
    var selectedAnswer = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        totalQuestionsTextView = findViewById(R.id.total_question)
        questionTextView = findViewById(R.id.question)
        A = findViewById(R.id.A)
        B = findViewById(R.id.B)
        C = findViewById(R.id.C)
        D = findViewById(R.id.D)
        submitBtn = findViewById(R.id.submit_btn)
        A!!.setOnClickListener(this)
        B!!.setOnClickListener(this)
        C!!.setOnClickListener(this)
        D!!.setOnClickListener(this)
        submitBtn!!.setOnClickListener(this)
        with(totalQuestionsTextView) { this!!.setText("Total questions : $totalQuestion") }
        loadNewQuestion()
    }

    override fun onClick(view: View) {
        A!!.setBackgroundColor(Color.WHITE)
        B!!.setBackgroundColor(Color.WHITE)
        C!!.setBackgroundColor(Color.WHITE)
        D!!.setBackgroundColor(Color.WHITE)
        val clickedButton = view as Button
        if (clickedButton.id == R.id.submit_btn) {
            if (selectedAnswer == QuestionAnswer.correctAnswers[currentQuestionIndex]) {
                score++
            }
            currentQuestionIndex++
            loadNewQuestion()
        } else {
            //choices button clicked
            selectedAnswer = clickedButton.text.toString()
            clickedButton.setBackgroundColor(Color.MAGENTA)
        }
    }

    fun loadNewQuestion() {
        if (currentQuestionIndex == totalQuestion) {
            finishQuiz()
            return
        }
        questionTextView!!.text = QuestionAnswer.question[currentQuestionIndex]
        A!!.text = QuestionAnswer.choices[currentQuestionIndex][0]
        B!!.text = QuestionAnswer.choices[currentQuestionIndex][1]
        C!!.text = QuestionAnswer.choices[currentQuestionIndex][2]
        D!!.text = QuestionAnswer.choices[currentQuestionIndex][3]
    }

    fun finishQuiz() {
        var passStatus = ""
        passStatus = if (score > totalQuestion * 0.60) {
            "Passed"
        } else {
            "Failed"
        }
        AlertDialog.Builder(this)
            .setTitle(passStatus)
            .setMessage("Score is $score out of $totalQuestion")
            .setPositiveButton("Restart") { dialogInterface: DialogInterface?, i: Int -> restartQuiz() }
            .setCancelable(false)
            .show()
    }

    fun restartQuiz() {
        score = 0
        currentQuestionIndex = 0
        loadNewQuestion()
    } //    public class QuestionAnswer {
    //        private Random randomquestion;
    //        private ArrayList<ClipData.Item> catalogue;
    //
    //        public QuestionAnswer()
    //        {
    //            catalogue = new ArrayList<ClipData.Item>();
    //            randomquestion = new Random();
    //        }
    //        public ClipData.Item anyItem()
    //        {
    //            int index = randomquestion.nextInt(catalogue.size());
    //            ClipData.Item item = catalogue.get(index);
    //            System.out.println("1" + item + "2");
    //            return item;
    //        }
    //    }
}