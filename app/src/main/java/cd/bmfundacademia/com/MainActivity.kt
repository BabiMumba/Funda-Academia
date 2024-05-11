package cd.bmfundacademia.com

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import cd.bmfundacademia.com.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
      //  enableEdgeToEdge()
        setContentView(binding.root)

        window?.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)




        //donner le lien de la vidéo dans le Raw
        binding.videoView.setVideoPath("android.resource://" + packageName + "/" + R.raw.ff_a)
        binding.videoView.start()//pour démarrer la vidéo
        binding.videoView.setOnPreparedListener { mp -> mp.isLooping = true }//pour que la vidéo soit en boucle








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