package br.com.ruzy.maisrole.ui.home

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.ruzy.maisrole.MainActivity
import br.com.ruzy.maisrole.adapter.CardAgendaAdapter
import br.com.ruzy.maisrole.databinding.HomeFragmentBinding
import java.lang.Exception

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

//        URls

        binding.appZe.setOnClickListener {
            OpenZe()
        }

        binding.appIfood.setOnClickListener{
            OpenIfood()
        }

        binding.appUberEats.setOnClickListener{
            OpenUberEats()
        }

        binding.btnLocaisPub.setOnClickListener {
            val url = "https://www.google.com.br/maps/search/pubs"
            val intentPubs = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            intentPubs.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
            requireContext().startActivity(intentPubs)
        }

        binding.btnLocaisBares.setOnClickListener {
            val url = "https://www.google.com.br/maps/search/bares"
            val intentBares = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            intentBares.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
            requireContext().startActivity(intentBares)
        }

        binding.btnLocaisDistribuidoras.setOnClickListener {
            val url = "https://www.google.com.br/maps/search/distribuidoras"
            val intentDistribuidoras = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            intentDistribuidoras.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
            requireContext().startActivity(intentDistribuidoras)
        }

        binding.btnLocaisRestaurantes.setOnClickListener {
            val url = "https://www.google.com.br/maps/search/restaurantes"
            val intentRestaurantes = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            intentRestaurantes.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
            requireContext().startActivity(intentRestaurantes)
        }

//        Urls

        return binding.root
    }

    private fun verificarInstalacao(uri: String): Boolean {
        val pm: PackageManager = requireActivity().packageManager
        var app_installed = false
        app_installed = try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
        return app_installed
    }

    private fun OpenZe() {
        var url = ""
        val uri = "com.cerveceriamodelo.modelonow"
        var storeintent: Intent? = null
        val getPackageManager = requireActivity().packageManager
        if(!verificarInstalacao(uri)){
            try {
                url = "market://details?id=$uri"
                storeintent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                storeintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
                requireContext().startActivity(storeintent)
            } catch (e: Exception) {
                url = "https://play.google.com/store/apps/details?id=$uri"
                storeintent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                storeintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
                requireContext().startActivity(storeintent)
            }
        }else{
            val intent = Intent(getPackageManager.getLaunchIntentForPackage(uri))
            startActivity(intent)
       }
    }

    private fun OpenIfood() {
        var url = ""
        val uri = "br.com.brainweb.ifood"
        var storeintent: Intent? = null
        val getPackageManager = requireActivity().packageManager
        if(!verificarInstalacao(uri)){
            try {
                url = "market://details?id=$uri"
                storeintent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                storeintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
                requireContext().startActivity(storeintent)
            } catch (e: Exception) {
                url = "https://play.google.com/store/apps/details?id=$uri"
                storeintent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                storeintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
                requireContext().startActivity(storeintent)
            }
        }else{
            val intent = Intent(getPackageManager.getLaunchIntentForPackage(uri))
            startActivity(intent)
        }
    }
    private fun OpenUberEats() {
        var url = ""
        val uri = "com.ubercab.eats"
        var storeintent: Intent? = null
        val getPackageManager = requireActivity().packageManager
        if(!verificarInstalacao(uri)){
            try {
                url = "market://details?id=$uri"
                storeintent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                storeintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
                requireContext().startActivity(storeintent)
            } catch (e: Exception) {
                url = "https://play.google.com/store/apps/details?id=$uri"
                storeintent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                storeintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
                requireContext().startActivity(storeintent)
            }
        }else{
            val intent = Intent(getPackageManager.getLaunchIntentForPackage(uri))
            startActivity(intent)
        }

    }



}