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
import kotlinx.android.synthetic.main.movie_details.*
import kotlinx.android.synthetic.main.rate_movie.*
import org.intellij.lang.annotations.JdkConstants
import java.nio.file.Files.size

class movie_details_kt : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details)

        val movie = intent.extras.get("MovieDes") as Movie

        titleMovie.text = movie.title
        overviewMovie.text = movie.description
        languageMovie.text = movie.lang
        dateMovie.text = movie.releaseDate
        suitableMovie.text = movie.suitable

    }

}