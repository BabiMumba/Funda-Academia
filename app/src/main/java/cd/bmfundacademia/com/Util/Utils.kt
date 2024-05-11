package cd.bmfundacademia.com.Util

import android.content.Context
import android.content.Intent

object Utils {

    fun Intent1(context: Context?, c: Class<*>?) {
        val intent = Intent(context, c)
        context!!.startActivity(intent)
    }
}