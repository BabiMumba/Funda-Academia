package cd.bmfundacademia.com.Activity

//creer par babi mumba le 11/05/2024 a 13h22

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import cd.bmfundacademia.com.Auth.HomeAuthActivity
import cd.bmfundacademia.com.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        //patienter 3 secondes avant de passer à l'activité suivante en utilisant la fonction postDelayed
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, HomeAuthActivity::class.java))
            finish()
        },3000)



    }
}