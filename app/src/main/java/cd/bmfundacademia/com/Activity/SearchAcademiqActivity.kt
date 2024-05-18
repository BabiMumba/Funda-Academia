package cd.bmfundacademia.com.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import cd.bmfundacademia.com.Adapter.AcademiqueAdapter
import cd.bmfundacademia.com.Model.University
import cd.bmfundacademia.com.R
import cd.bmfundacademia.com.databinding.ActivitySearchAcademiqBinding

class SearchAcademiqActivity : AppCompatActivity() {
    lateinit var binding: ActivitySearchAcademiqBinding
    lateinit var adapter: AcademiqueAdapter
    //liste
    val liste = ArrayList<University>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchAcademiqBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //enableEdgeToEdge()

        //liste
        liste.add(University("Unilu","universite de lubumabshi"))
        liste.add(University("Unh","universite nouveaux horizon"))
        liste.add(University("Unilu","universite de lubumabshi"))

        adapter = AcademiqueAdapter(liste)
        binding.recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : AcademiqueAdapter.OnItemClickListener {
            override fun onItemClick(university: University) {
                //traitement
                val nom = university.nom
                val intent = intent
                intent.putExtra("nom", nom)
                setResult(RESULT_OK, intent)
                finish()
            }
        })





    }
}