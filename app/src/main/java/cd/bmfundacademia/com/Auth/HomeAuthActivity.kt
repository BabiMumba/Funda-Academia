package cd.bmfundacademia.com.Auth

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import cd.bmfundacademia.com.R
import cd.bmfundacademia.com.databinding.ActivityHomeAuthBinding

class HomeAuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}