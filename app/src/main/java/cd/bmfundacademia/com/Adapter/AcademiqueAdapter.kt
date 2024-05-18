package cd.bmfundacademia.com.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cd.bmfundacademia.com.Model.University
import cd.bmfundacademia.com.R

class AcademiqueAdapter(val liste:ArrayList<University>): RecyclerView.Adapter<AcademiqueAdapter.ViewHolder>() {
    private var onItemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(university: University)
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val nom:TextView = itemView.findViewById(R.id.title_element)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_acca,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nom.text = liste[position].nom
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(liste[position])
        }
    }

    override fun getItemCount(): Int {
        return liste.size
    }
}