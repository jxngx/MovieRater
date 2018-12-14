package a174557x.nyp.popcornmovie

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import java.io.Serializable
import android.content.Intent
import android.widget.RatingBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.landing_page.*
import kotlinx.android.synthetic.main.rate_movie.*
import kotlinx.android.synthetic.main.movie_details.*

class Rate_movie_kt : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rate_movie)
    }


//    val rateMovie = findViewById<RatingBar>(R.id.ratingMovie)
//    var movieLang :String = ""
//    var suitable :String = ""

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
      menuInflater.inflate(R.menu.main_ratemovie, menu)
      return super.onCreateOptionsMenu(menu)
    }


//    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
//
//        menuInflater.inflate(R.menu.main_ratemovie, menu)
//        return super.onPrepareOptionsMenu(menu)
//    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {


        return super.onContextItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.submit){

            var movie = intent.extras.get("MovieDes") as? Movie
            var reviewsRate = viewShow.text.toString()
            var movieRate = ratingMovie.getRating()

            var movieWithRating = Movie(movie?.title, movie?.description, movie?.lang, movie?.releaseDate, movie?.suitable, reviewsRate, movieRate)
            var intent = Intent(this, Movie_details_kt::class.java)
            intent.putExtra("MovieDes", movieWithRating as Serializable)
//            intent.putExtra("rateMovie",  movieRate as Serializable)
//            intent.putExtra("revMovie", reviewsRate as Serializable)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }


}
