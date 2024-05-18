package cd.bmfundacademia.com.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import cd.bmfundacademia.com.Adapter.AcademiqueAdapter
import cd.bmfundacademia.com.R
import cd.bmfundacademia.com.databinding.ActivitySearchAcademiqBinding

class SearchAcademiqActivity : AppCompatActivity() {
    lateinit var binding: ActivitySearchAcademiqBinding
    lateinit var adapter: AcademiqueAdapter
    //liste
    val liste = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchAcademiqBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //enableEdgeToEdge()

        //liste
        liste.add("Universite de lubumbashi")
        liste.add("Universite de kinshasa")
        liste.add("Universite de kisangani")
        liste.add("Universite de bandundu")
        liste.add("Universite de matadi")
        liste.add("Universite de bukavu")
        adapter = AcademiqueAdapter(liste)
        binding.recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter





    }
}