package cd.bmfundacademia.com.Auth
//cree par babi mumba le 11/mai/2024

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import cd.bmfundacademia.com.R
import cd.bmfundacademia.com.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ini_toolbar()



        binding.btnSave.btnModelUi.text = "Valider"
        //change text color
        binding.btnSave.btnModelUi.setTextColor(resources.getColor(R.color.white))
        //change tint color
        binding.btnSave.btnModelUi.backgroundTintList = resources.getColorStateList(R.color.primary)


    }
    fun ini_toolbar(){
        binding.toolbarTop.titreTl.text = "Se connecter"
        binding.toolbarTop.ivBack.setOnClickListener { onBackPressed() }
    }
}