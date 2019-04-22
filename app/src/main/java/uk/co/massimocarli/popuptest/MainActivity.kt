package uk.co.massimocarli.popuptest

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu

class MainActivity : AppCompatActivity() {

  private val LOG_TAG = "MainActivity"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    supportActionBar?.apply {
      setDisplayHomeAsUpEnabled(true)
      setIcon(R.mipmap.ic_launcher)
    }
  }

  fun showPopup(button: View) {
    // We create the PopupMenu with the reference of the related View
    val popup = PopupMenu(this, button)
    // We register a listener for the selection
    popup.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {

      override fun onMenuItemClick(item: MenuItem): Boolean {
        Log.i(LOG_TAG, "Selected " + item.title)
        Toast.makeText(
          applicationContext, "Selected ${item.title}",
          Toast.LENGTH_SHORT
        ).show()
        return false
      }
    })
    // We register a listener for the dismiss from API level 14
    /*
    popup.setOnDismissListener(new OnDismissListener() {

			@Override
			public void onDismiss(PopupMenu menu) {

			}
		});
		*/
    // We add menu options
    val inflater = popup.getMenuInflater()
    inflater.inflate(R.menu.popup_menu, popup.getMenu())
    // We show the popup
    popup.show()
  }


  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    menuInflater.inflate(R.menu.menu_main, menu)
    return true
  }
}
