package a174557x.nyp.popcornmovie

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class Movie (title: String, description: String, lang: String, releaseDate : String, suitable : String): Serializable{
    val title = title
    val description = description
    val lang = lang
    val releaseDate = releaseDate
    val suitable = suitable
}