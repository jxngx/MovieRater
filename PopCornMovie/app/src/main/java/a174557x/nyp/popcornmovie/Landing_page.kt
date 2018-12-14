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

class Landing_page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing_page)
        registerForContextMenu(pressMe)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if (v?.id == R.id.pressMe){

            menu?.add(1, 1, 1, "Add")
        }


    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
////        menuInflater.inflate(R.menu.landing_menu, menu)
////        menuInflater.inflate(R.menu.main_movie, menu)
////        var menuadd = menu.findItem(R.id.add)
////        var menuclear = menu.findItem(R.id.reset)
////        menuInflater.inflate(R.menu.main_edit, menu)
//        return super.onCreateOptionsMenu(menu)
//    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == 1){
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }
}