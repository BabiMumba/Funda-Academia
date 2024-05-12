package cd.bmfundacademia.com.Auth.StepRegister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cd.bmfundacademia.com.Auth.RegisterActivity
import cd.bmfundacademia.com.R
import cd.bmfundacademia.com.databinding.FragmentStepeTwoBinding

class StepeTwoFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    lateinit var binding: FragmentStepeTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStepeTwoBinding.inflate(layoutInflater)
        binding.btnSave.btnModelSmal.text = "Terminer"
        //change text color
        binding.btnSave.btnModelSmal.setTextColor(resources.getColor(R.color.white))
        //change tint color
        binding.btnSave.btnModelSmal.backgroundTintList = resources.getColorStateList(R.color.primary)
        binding.btnSave.btnModelSmal.setOnClickListener {
            // Vérifier si les informations saisies sont valides et retourner true ou false en conséquence
            if (validateData()) {
                // Si les informations sont valides, passer à l'étape suivante
                // Récupérer l'instance de l'activité parente
                val parentActivity = activity as RegisterActivity
                // Passer à l'étape suivante
                parentActivity.viewPager.currentItem += 1
            }

        }
        return binding.root
    }

    fun validateData(): Boolean {
        // Vérifier si les informations saisies sont valides et retourner true ou false en conséquence
        return true
    }
}