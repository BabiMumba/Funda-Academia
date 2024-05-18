package cd.bmfundacademia.com.Auth.StepRegister

//creer par babi mumba le 12/05/2024 a 21h50
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cd.bmfundacademia.com.Auth.RegisterActivity
import cd.bmfundacademia.com.R
import cd.bmfundacademia.com.Util.Utils
import cd.bmfundacademia.com.databinding.FragmentStepeOneBinding

class StepeOneFragment : Fragment() {
    lateinit var binding: FragmentStepeOneBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStepeOneBinding.inflate(layoutInflater)

        binding.btnSave.btnModelSmal.text = "Valider"
        //change text color
        binding.btnSave.btnModelSmal.setTextColor(resources.getColor(R.color.white))
        //change tint color
        binding.btnSave.btnModelSmal.backgroundTintList = resources.getColorStateList(R.color.primary)
        binding.btnSave.btnModelSmal.setOnClickListener {
            // Vérifier si les informations saisies sont valides et retourner true ou false en conséquence
            if (!validateData()) {
                Utils.loading(true, binding.progressBar, binding.btnSave.btnModelSmal)
                Handler().postDelayed({
                    Utils.loading(false, binding.progressBar, binding.btnSave.btnModelSmal)
                    val parentActivity = activity as RegisterActivity
                    // Passer à l'étape suivante
                    parentActivity.viewPager.currentItem += 1

                }, 1000)
            }

        }




        return binding.root
    }

    fun validateData(): Boolean {
        // Vérifier si les informations saisies sont valides et retourner true ou false en conséquence
        val prenom = binding.prenom.text.toString()
        val nom = binding.nom.text.toString()
        val email = binding.email.text.toString()
        val password = binding.password.text.toString()
        val confirmPassword = binding.confirmpassword.text.toString()
        val check_term = binding.termCheck.isChecked
        if (nom.isEmpty()) {
            binding.nom.error = "Nom est obligatoire"
            return false
        }else if (prenom.isEmpty()) {
            binding.prenom.error = "Prenom est obligatoire"
            return false
        }else if (email.isEmpty()) {
            binding.email.error = "Email est obligatoire"
            return false
        }else if (password.isEmpty()) {
            binding.password.error = "Mot de passe est obligatoire"
            return false
        }else if (confirmPassword.isEmpty()) {
            binding.confirmpassword.error = "Confirmer le mot de passe est obligatoire"
            return false
        }else if (password != confirmPassword) {
            binding.confirmpassword.error = "Les mots de passe ne correspondent pas"
            return false
        }else if (!check_term) {
            binding.termCheck.error = "Vous devez accepter les termes et conditions"
            return false
        }


        return true
    }


}