package a174557x.nyp.popcornmovie

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class Movie (title: String?, description: String?, lang: String?, releaseDate : String?, suitable : String?, reviews: String?, rating: Float?): Serializable{
    var title = title
    var description = description
    var lang = lang
    var releaseDate = releaseDate
    var suitable = suitable
    var reviews = reviews
    var rating = rating
}