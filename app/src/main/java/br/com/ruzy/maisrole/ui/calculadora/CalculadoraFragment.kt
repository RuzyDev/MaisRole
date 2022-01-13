package br.com.ruzy.maisrole.ui.calculadora

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.ruzy.maisrole.R
import br.com.ruzy.maisrole.adapter.CardAgendaAdapter
import br.com.ruzy.maisrole.adapter.ParticipantesAdapter
import br.com.ruzy.maisrole.databinding.CalculadoraFragmentBinding
import br.com.ruzy.maisrole.databinding.HomeFragmentBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CalculadoraFragment: Fragment() {

    private lateinit var binding : CalculadoraFragmentBinding
    private lateinit var adapter: ParticipantesAdapter
    private lateinit var customDialog : View
    var text : String = ""
    private lateinit var materialAlertDialogBuilder: MaterialAlertDialogBuilder


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CalculadoraFragmentBinding.inflate(inflater,container,false)

        adapter = ParticipantesAdapter()

        materialAlertDialogBuilder = MaterialAlertDialogBuilder(requireContext())

        customDialog = LayoutInflater.from(requireContext())
            .inflate(R.layout.dialog_add_participantes, null, false)

        binding.editText.setOnClickListener(
            materialAlertDialogBuilder.setView(customDialog)
                .show()
        )

        binding.editText.addTextChangedListener {
            text = it.toString()
            adapter.nomes.add(text)
        }

        binding.recycle.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)

        binding.recycle.adapter = adapter

        return binding.root
    }

}