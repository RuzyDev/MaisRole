package br.com.ruzy.maisrole.ui.calculadora

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.ruzy.maisrole.R
import br.com.ruzy.maisrole.adapter.CardAgendaAdapter
import br.com.ruzy.maisrole.adapter.CardProdutosAdapter
import br.com.ruzy.maisrole.adapter.ParticipantesAdapter
import br.com.ruzy.maisrole.databinding.CalculadoraFragmentBinding
import br.com.ruzy.maisrole.databinding.HomeFragmentBinding
import br.com.ruzy.maisrole.dtos.ParticipantesDto
import br.com.ruzy.maisrole.dtos.ProdutosDto
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.notify
import okhttp3.internal.wait

@AndroidEntryPoint
class CalculadoraFragment : Fragment() {

    private val calculadoraViewModel: CalculadoraViewModel by viewModels()
    private lateinit var binding: CalculadoraFragmentBinding
    private lateinit var adapter: ParticipantesAdapter
    private lateinit var adapterProdutos: CardProdutosAdapter
    private lateinit var customDialog: View
    var text: String = ""
    var listParticipantes = ArrayList<ParticipantesDto>()
    var listProdutos = ArrayList<ProdutosDto>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CalculadoraFragmentBinding.inflate(inflater, container, false)

        adapter = ParticipantesAdapter(listParticipantes)

        adapterProdutos = CardProdutosAdapter(listParticipantes)

        val materialAlertDialogBuilder = MaterialAlertDialogBuilder(requireContext())

        binding.btnAddParticipantes.setOnClickListener(View.OnClickListener {

            val customDialog = LayoutInflater.from(context)
                .inflate(R.layout.dialog_add_participantes, null, false)

            val inputEditText = customDialog.findViewById<TextInputLayout>(R.id.edit_participantes)

            val dialog = materialAlertDialogBuilder.setView(customDialog)
                .setPositiveButton("Adicionar"){ dialog, _ ->
                }
                .setNegativeButton("Cancelar") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
            val positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
            positiveButton.setOnClickListener {
                text = inputEditText.editText?.text.toString()
                if(text.isNotEmpty()){
                    val participante = ParticipantesDto(nomeParticipante = text, valorAPagar = 0.0)
                    listParticipantes.add(participante)
                    dialog.dismiss()
                }else{
                    inputEditText.error = "Digite um nome válido!"
                }
            }

        })

        val customDialog = LayoutInflater.from(context)
            .inflate(R.layout.dialog_add_produtos, null, false)

        val dialogParticipantes = LayoutInflater.from(context)
            .inflate(R.layout.dialog_participantes, null, false)

        binding.btnAddProdutos.setOnClickListener(View.OnClickListener {


            val btnAdd = customDialog.findViewById<MaterialButton>(R.id.btn_quemConsumiu)

            materialAlertDialogBuilder.setView(customDialog)
                .setPositiveButton("Adicionar"){ dialog, _ ->
                }
                .setNegativeButton("Cancelar") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()

            btnAdd.setOnClickListener(View.OnClickListener {

                val recycle_participantesAdd = dialogParticipantes.findViewById<RecyclerView>(R.id.recycle_participantesAdd)

                val recycle_participantesTotais = dialogParticipantes.findViewById<RecyclerView>(R.id.recycle_participantesTotais)

                materialAlertDialogBuilder.setView(dialogParticipantes)
                        .setPositiveButton("Continuar"){ dialog, _ ->
                    }
                    .setNegativeButton("Cancelar") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()

                })

        })




//        binding.editText.addTextChangedListener {
//            text = it.toString()
//            adapter.nomes.add(text)
//        }

        binding.recycle.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        binding.recycle.adapter = adapter

        binding.recycleProdutos.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        binding.recycleProdutos.adapter = adapterProdutos

        return binding.root
    }

}