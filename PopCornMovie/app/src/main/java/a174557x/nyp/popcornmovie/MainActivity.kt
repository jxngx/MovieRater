package a174557x.nyp.popcornmovie

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.landing_page.*
import java.io.Serializable


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//                suitableCheck.setOnClickListener {
//            if (suitableCheck.isChecked == true) {
//                linearSuitable.setVisibility(View.VISIBLE)
//            } else {
//                linearSuitable.setVisibility(View.INVISIBLE)
//            }
//        }

        radioEnglish.isChecked == true
        suitableCheck.setOnClickListener {
            if (suitableCheck.isChecked == true) {
                linearSuitable.setVisibility(View.VISIBLE)
            } else {
                linearSuitable.setVisibility(View.INVISIBLE)
            }
        }
    }

//    val rateMovie = findViewById<RatingBar>(R.id.ratingMovie)
    var movieLang :String = ""
    var suitable :String = ""

//    fun formMovie(v: View) {
//        if (editTitle.text.toString() == "" || editDescription.text.toString() == "" || releaseDate.text.toString() == "") {
//            if (editTitle.text.toString() == "") {
//                editTitle.setError("Field Empty")
//            } else if (editDescription.text.toString() == "") {
//                editDescription.setError("Field Empty")
//            } else {
//                releaseDate.setError("Field Empty")
//            }
//        } else {
//            when {
//                radioEnglish.isChecked == true -> movieLang = "English"
//                radioChinese.isChecked == true -> movieLang = "Chinese"
//                radioMalay.isChecked == true -> movieLang = "Malay"
//                else -> movieLang = "Tamil"
//            }
//
//            var movieToast =
//                "Title = " + editTitle.text.toString() + "\n" +
//                        "Overview = " + editDescription.text.toString() + "\n" +
//                        "Release Date = " + releaseDate.text.toString() + "\n" +
//                        "Language = " + movieLang + "\n" +
//                        "Suitable for all ages= " +
//                        if (suitableCheck.isChecked == true) {
//                            suitable = "No"
//                            "false" + "\n" +
//                            "Reason: " +
//                                    when {
//                                        checkLanguage.isChecked == true -> "\n" + "Language" + "\n"
//                                        checkViolence.isChecked == true -> "\n" +"Violence" + "\n"
//                                        checkLanguage.isChecked == true && checkViolence.isChecked == true -> "\n" + "Language" + "\n" +  "Violence" + "\n"
//                                        else -> {
//                                            ""
//                                        }
//                                    }
//                        } else {
//                            suitable = "Yes"
//                            "true"
//                        }
//
//            val toast = Toast.makeText(applicationContext, movieToast, Toast.LENGTH_SHORT)
//            toast.show()
//
//            val movie = Movie(editTitle.text.toString(), editDescription.text.toString(), movieLang, releaseDate.text.toString(), suitable, "", "")
//
//            val intent = Intent(this, Movie_details_kt::class.java)
//            intent.putExtra("MovieDes", movie as Serializable)
//            startActivity(intent)
//        }
//    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_movie, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item?.itemId == R.id.addedMovie) {
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
                                            checkViolence.isChecked == true -> "\n" + "Violence" + "\n"
                                            checkLanguage.isChecked == true && checkViolence.isChecked == true -> "\n" + "Language" + "\n" + "Violence" + "\n"
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

                if (suitableCheck.isChecked == true) {
                    if (checkLanguage.isChecked == true){
                        suitable = "No (Language)"}
                    else if (checkViolence.isChecked == true){
                        suitable = "No (Violence)"
                    } else{
                        suitable = "No (Language and Violence)"
                    }
                } else {
                    suitable = "Yes"
                }

                var x = 0
                var movie = Movie(
                    editTitle.text.toString(),
                    editDescription.text.toString(),
                    movieLang,
                    releaseDate.text.toString(),
                    suitable,
                    "",
                    x.toFloat()
                )

                var intent = Intent(this, Movie_details_kt::class.java)
//                var intent2 = Intent (this, Rate_movie_kt::class.java)
                intent.putExtra("MovieDes", movie as Serializable)
//                intent2.putExtra("MovieDes", movie as Serializable)
                startActivity(intent)
            }
        }

        if (item?.itemId == R.id.reset){
            editTitle.text.clear()
            editDescription.text.clear()
            radioEnglish.isChecked = true
            releaseDate.text.clear()
            suitableCheck.isChecked = false
            linearSuitable.setVisibility(View.INVISIBLE)
            checkViolence.isChecked = false
            checkLanguage.isChecked = false

        }

        return super.onOptionsItemSelected(item)
    }

}


