package cd.bmfundacademia.com.Util

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ProgressBar

object Utils {

    fun Intent1(context: Context?, c: Class<*>?) {
        val intent = Intent(context, c)
        context!!.startActivity(intent)
    }
    fun loading(isLoading: Boolean, progressBar: ProgressBar, btn: View) {
        if (isLoading) {
            btn.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE

        } else {
            btn.visibility = View.VISIBLE
            progressBar.visibility = View.INVISIBLE
        }
    }
}