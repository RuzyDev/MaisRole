package br.com.ruzy.maisrole.ui.agenda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.ruzy.maisrole.adapter.CardAgendaAdapter
import br.com.ruzy.maisrole.databinding.AgendaFragmentBinding
import br.com.ruzy.maisrole.databinding.HomeFragmentBinding

class AgendaFragment: Fragment() {

    private lateinit var binding : AgendaFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AgendaFragmentBinding.inflate(inflater,container,false)



        return binding.root
    }

}