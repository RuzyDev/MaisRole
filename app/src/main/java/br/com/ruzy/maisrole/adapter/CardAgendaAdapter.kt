package br.com.ruzy.maisrole.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.ruzy.maisrole.MainActivity
import br.com.ruzy.maisrole.R
import br.com.ruzy.maisrole.ui.home.HomeFragment
import com.google.android.material.textview.MaterialTextView

class CardAgendaAdapter() : RecyclerView.Adapter<CardAgendaAdapter.ViewHolder>() {

    val nomes = arrayListOf("ARCOM", "ARCOM","Batata","besteira")

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val arrow: ImageButton
        val nome:MaterialTextView

        init {
            arrow = view.findViewById(R.id.btn_arrow)
            nome = view.findViewById(R.id.txt_nomeRole)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_agenda_role, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

//        viewHolder.textView.text = dataSet[position]
        viewHolder.arrow.setOnClickListener {

        }

        viewHolder.nome.text = nomes[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = nomes.size

}