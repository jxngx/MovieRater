package a174557x.nyp.popcornmovie

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.movie_details.*
import kotlinx.android.synthetic.main.rate_movie.*
import org.intellij.lang.annotations.JdkConstants
import java.io.Serializable
import java.nio.file.Files.size

class Movie_details_kt : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details)
        registerForContextMenu(reviewsMovie)


        var movie = intent.extras.get("MovieDes") as? Movie
        //var ratee = intent.getStringExtra("rateMovie")

        titleMovie.text = movie?.title
        overviewMovie.text = movie?.description
        languageMovie.text = movie?.lang
        dateMovie.text = movie?.releaseDate
        suitableMovie.text = movie?.suitable

//        if ((intent.getStringExtra("revMovie") != null) || (intent.getStringExtra("rateMovie") != null)) {
//
//            var ratee = intent.extras.get("rateMovie")
//            var revieww = intent.extras.get("revMovie")
//            var moreMovie = movie?.rating
//            var moreReview = movie?.reviews

//            if (moreReview != "") {
//                movie?.reviews = revieww.toString()
//                reviewsMovie.text = revieww.toString()
//            }
//
//            if (moreMovie != 0.toFloat()) {
//                movie?.rating = ratee.toString().toFloat()
//                var a = ratee.toString().toFloat()
//                ratingForMovie.rating = a
//            } else {
//                ratingForMovie.setVisibility(View.GONE)
//            }
            //        rateMovie.setRating = movie.reviews

//        if (movie.reviewsBoolean == false){
//            reviewsMovie.text = "No Reviews yet." + "\n" + "Long press here to add your review."
//        }else{
//            reviewsMovie.text = movie.reviews
//            movie.reviewsBoolean = true
//        }
        if (movie?.rating != null || movie?.reviews != null){
            var moreMovRate = movie.rating
            var moreReview = movie.reviews

            if (moreReview != "") {
                reviewsMovie.text = moreReview.toString()
            }

            if (moreMovRate != 0.toFloat() && moreReview == "") {
                var a = moreMovRate.toString().toFloat()
                ratingForMovie.rating = a
                reviewsMovie.setVisibility(View.GONE)
            }

            if (moreMovRate != 0.toFloat()){
                var a = moreMovRate.toString().toFloat()
                ratingForMovie.rating = a
            }
            else {
                ratingForMovie.setVisibility(View.GONE)
            }

//        if (movie.reviewsBoolean == false){
//            reviewsMovie.text = "No Reviews yet." + "\n" + "Long press here to add your review."
//        }else{
//            reviewsMovie.text = movie.reviews
//            movie.reviewsBoolean = true
//        }
        }
        else{
            ratingForMovie.setVisibility(View.GONE)
        }
    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if (v?.id == R.id.reviewsMovie) {

            menu?.add(1, 2, 2, "Add Review")

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

//        menuInflater.inflate(R.menu.main_edit ,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == 2){
     //       setContentView(R.layout.rate_movie)
//            var intent = Intent(this, Movie_details_kt::class.java)
            val intent = Intent(this, Rate_movie_kt::class.java)
//            var movie = intent.extras.get("MovieDes") as? Movie

            var moviee = Movie(titleMovie.text.toString(), overviewMovie.text.toString(), languageMovie.text.toString(),dateMovie.text.toString(),suitableMovie.text.toString(), "",0.toFloat())
            intent.putExtra("MovieDes", moviee as Serializable)
            startActivity(intent)
//            startActivity(intent2)
        }

        return super.onContextItemSelected(item)
    }
}