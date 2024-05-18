package cd.bmfundacademia.com.Auth.StepRegister

//creer par babi mumba le 12/05/2024 a 21h52

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import cd.bmfundacademia.com.Activity.SearchAcademiqActivity
import cd.bmfundacademia.com.Auth.RegisterActivity
import cd.bmfundacademia.com.Model.University
import cd.bmfundacademia.com.R
import cd.bmfundacademia.com.Util.Utils
import cd.bmfundacademia.com.databinding.BottomSheetUniversitiesBinding
import cd.bmfundacademia.com.databinding.FragmentStepeTwoBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.firestore.FirebaseFirestore

class StepeTwoFragment : Fragment() {
    private lateinit var firestore: FirebaseFirestore
    private lateinit var bottomSheetDialog: BottomSheetDialog
    lateinit var adapter: ArrayAdapter<String>
    private val selectedUniversities = ArrayList<String>()
    lateinit var binding: FragmentStepeTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        firestore = FirebaseFirestore.getInstance()
        adapter = ArrayAdapter<String>(requireActivity(),android.R.layout.simple_list_item_1)

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
        binding.university.setOnClickListener {
            showUniversityList()
        }
        binding.faculter.setOnClickListener {
            Utils.Intent1(requireActivity(), SearchAcademiqActivity::class.java)
        }
        return binding.root
    }
    private fun showUniversityList() {
        val liste_univer= ArrayList<University>()
        liste_univer.add(University("Unilu","universite de lubumabshi"))
        liste_univer.add(University("Unh","universite nouveaux horizon"))
        liste_univer.add(University("Unh","universite nouveaux horizon"))
        liste_univer.add(University("Unh","universite nouveaux horizon"))
        liste_univer.add(University("Unh","universite nouveaux horizon"))
        liste_univer.add(University("Unh","universite nouveaux horizon"))
        liste_univer.add(University("Unh","universite nouveaux horizon"))
        liste_univer.add(University("Unh","universite nouveaux horizon"))
        val liste_univer_names = ArrayList<String>()
        for (university in liste_univer) {
            liste_univer_names.add(university.nom)
        }


        val binding = BottomSheetUniversitiesBinding.inflate(layoutInflater)
        bottomSheetDialog = BottomSheetDialog(requireActivity())
        bottomSheetDialog.setContentView(binding.root)
        bottomSheetDialog.show()
        adapter.clear()
        binding.universitiesList.adapter = adapter

        adapter.addAll(liste_univer_names)

        binding.universitiesList.setOnItemClickListener { parent, view, position, id ->
            val selectedUniversity = liste_univer_names[position]
            selectedUniversities.add(selectedUniversity)
            Toast.makeText(requireActivity(), selectedUniversity, Toast.LENGTH_SHORT).show()
            bottomSheetDialog.dismiss()

            // Mettre à jour le texte du bouton avec les noms d'universités sélectionnés
            updateButtonLabel()
        }








    }



    fun validateData(): Boolean {
        return true
    }
    private fun updateButtonLabel() {
        val selectedUniversityNames = selectedUniversities.lastOrNull() ?: ""
        binding.university.text = selectedUniversityNames
    }
}