package a174557x.nyp.popcornmovie

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.rate_movie.*
import java.io.Serializable
import java.nio.file.Files.size



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioEnglish.isChecked == true

        suitableCheck.setOnClickListener {
            if (suitableCheck.isChecked == true) {
                linearSuitable.setVisibility(View.VISIBLE)
            } else {
                linearSuitable.setVisibility(View.INVISIBLE)
            }
        }
    }

    var movieLang :String = ""
    var suitable :String = ""

    fun formMovie(v: View) {
        if (editTitle.text.toString() == "" || editDescription.text.toString() == "" || releaseDate.text.toString() == "") {
            if (editTitle.text.toString() == "") {
                editTitle.setError("Field Empty")
            } else if (editDescription.text.toString() == "") {
                editDescription.setError("Field Empty")
            } else {
                releaseDate.setError("Field Empty")
            }
        } else {
            when {
                radioEnglish.isChecked == true -> movieLang = "English"
                radioChinese.isChecked == true -> movieLang = "Chinese"
                radioMalay.isChecked == true -> movieLang = "Malay"
                else -> movieLang = "Tamil"
            }

            var movieToast =
                "Title = " + editTitle.text.toString() + "\n" +
                        "Overview = " + editDescription.text.toString() + "\n" +
                        "Release Date = " + releaseDate.text.toString() + "\n" +
                        "Language = " + movieLang + "\n" +
                        "Suitable for all ages= " +
                        if (suitableCheck.isChecked == true) {
                            suitable = "No"
                            "false" + "\n" +
                            "Reason: " +
                                    when {
                                        checkLanguage.isChecked == true -> "\n" + "Language" + "\n"
                                        checkViolence.isChecked == true -> "\n" +"Violence" + "\n"
                                        checkLanguage.isChecked == true && checkViolence.isChecked == true -> "\n" + "Language" + "\n" +  "Violence" + "\n"
                                        else -> {
                                            ""
                                        }
                                    }
                        } else {
                            suitable = "Yes"
                            "true"
                        }

            val toast = Toast.makeText(applicationContext, movieToast, Toast.LENGTH_SHORT)
            toast.show()

            val movie = Movie(editTitle.text.toString(), editDescription.text.toString(), movieLang, releaseDate.text.toString(), suitable)

            val intent = Intent(this, movie_details_kt::class.java)
            intent.putExtra("MovieDes", movie as Serializable)
            startActivity(intent)

        }
    }
}

