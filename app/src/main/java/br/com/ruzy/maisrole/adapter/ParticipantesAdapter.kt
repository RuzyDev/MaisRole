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
import br.com.ruzy.maisrole.dtos.ParticipantesDto
import br.com.ruzy.maisrole.ui.home.HomeFragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class ParticipantesAdapter(var Participantes:ArrayList<ParticipantesDto>) : RecyclerView.Adapter<ParticipantesAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val participantes :MaterialButton

        init {
            participantes = view.findViewById(R.id.txt_participantes)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.participantes, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

//        viewHolder.textView.text = dataSet[position]
        viewHolder.participantes.setOnClickListener {
            removeItem(position)
        }

        viewHolder.participantes.text = Participantes[position].nomeParticipante
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = Participantes.size

    fun removeItem(position: Int) {
        Participantes.removeAt(position)
        notifyDataSetChanged()
    }


}