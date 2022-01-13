package br.com.ruzy.maisrole.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.ruzy.maisrole.adapter.CardAgendaAdapter
import br.com.ruzy.maisrole.databinding.HomeFragmentBinding

class HomeFragment: Fragment() {

    private lateinit var binding : HomeFragmentBinding
    private lateinit var adapterAgenda : CardAgendaAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater,container,false)

        adapterAgenda = CardAgendaAdapter()

        binding.adapterAgenda.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        binding.adapterAgenda.adapter = adapterAgenda

        return binding.root
    }

}