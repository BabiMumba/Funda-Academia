package cd.bmfundacademia.com.Auth
//cree par babi mumba le 11/mai/2024

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import cd.bmfundacademia.com.Adapter.RegisterPagerAdapter
import cd.bmfundacademia.com.Auth.StepRegister.StepeOneFragment
import cd.bmfundacademia.com.Auth.StepRegister.StepeTwoFragment
import cd.bmfundacademia.com.R
import cd.bmfundacademia.com.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private var isSwipeEnabled: Boolean = false
    lateinit var viewPager: ViewPager2
    private lateinit var registerPagerAdapter: RegisterPagerAdapter
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ini_toolbar()

        viewPager = binding.viewPager
        registerPagerAdapter = RegisterPagerAdapter(this)
        viewPager.adapter = registerPagerAdapter
        viewPager.isUserInputEnabled = isSwipeEnabled//desactiver le swipe




      /*  binding.btnSave.btnModelUi.text = "Confirmer"
        //change text color
        binding.btnSave.btnModelUi.setTextColor(resources.getColor(R.color.white))
        //change tint color
        binding.btnSave.btnModelUi.backgroundTintList = resources.getColorStateList(R.color.primary)

        binding.btnSave.btnModelUi.setOnClickListener {
            val currentFragment = registerPagerAdapter.getItem(viewPager.currentItem)

            if (currentFragment is StepeOneFragment) {
                if (currentFragment.validateData()) {
                    viewPager.currentItem += 1
                }
            } else if (currentFragment is StepeTwoFragment) {
                if (currentFragment.validateData()) {
                    viewPager.currentItem += 1
                }else{
                    Toast.makeText(this, "desoler", Toast.LENGTH_SHORT).show()
                }
            }
        }*/






    }
    fun ini_toolbar(){
        binding.toolbarTop.titreTl.text = "Creer un compte"
        binding.toolbarTop.ivBack.setOnClickListener {
            //verifier si l'utilisateur a atteint la premiere etape
            if (viewPager.currentItem == 0) {
                finish()
            } else {
                viewPager.currentItem -= 1
            }
        }
    }
}