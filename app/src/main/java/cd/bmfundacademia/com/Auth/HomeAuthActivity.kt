package cd.bmfundacademia.com.Auth
//creer par babi mumba le 11/05/2024

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import cd.bmfundacademia.com.R
import cd.bmfundacademia.com.Util.Utils
import cd.bmfundacademia.com.databinding.ActivityHomeAuthBinding

class HomeAuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)


        window?.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        binding.loginBtn.btnModelUi.text = "Se connecter"
        binding.registerBtn.btnModelUi.text = "S'inscrire"
        //change text color
        binding.loginBtn.btnModelUi.setTextColor(resources.getColor(R.color.primary))
        binding.registerBtn.btnModelUi.setTextColor(resources.getColor(R.color.white))
        //change tint color
        binding.registerBtn.btnModelUi.backgroundTintList = resources.getColorStateList(R.color.primary)
        binding.loginBtn.btnModelUi.backgroundTintList = resources.getColorStateList(R.color.white)


        //donner le lien de la vidéo dans le Raw
        binding.videoView.setVideoPath("android.resource://" + packageName + "/" + R.raw.fundv)
        binding.videoView.start()//pour démarrer la vidéo
        binding.videoView.setOnPreparedListener { mp -> mp.isLooping = true }//pour que la vidéo soit en boucle


        binding.loginBtn.btnModelUi.setOnClickListener {
            Utils.Intent1(this,RegisterActivity::class.java)

        }
        binding.registerBtn.btnModelUi.setOnClickListener {
            Utils.Intent1(this,LoginActivity::class.java)
        }


    }

    override fun onResume() {
        binding.videoView.resume()
        super.onResume()
    }
    override fun onPause() {

        binding.videoView.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoView.stopPlayback()
        super.onDestroy()
    }


}