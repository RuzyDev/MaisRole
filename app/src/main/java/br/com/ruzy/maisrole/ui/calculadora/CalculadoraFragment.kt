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
import br.com.ruzy.maisrole.R
import br.com.ruzy.maisrole.adapter.CardAgendaAdapter
import br.com.ruzy.maisrole.adapter.ParticipantesAdapter
import br.com.ruzy.maisrole.databinding.CalculadoraFragmentBinding
import br.com.ruzy.maisrole.databinding.HomeFragmentBinding
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
    private lateinit var customDialog: View
    var text: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CalculadoraFragmentBinding.inflate(inflater, container, false)

        adapter = ParticipantesAdapter()

        val materialAlertDialogBuilder = MaterialAlertDialogBuilder(requireContext())
        val alertDialog = AlertDialog.Builder(requireContext())

        binding.editText.setOnClickListener(View.OnClickListener {

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
                    adapter.addList(text)
                    Log.d("batata", adapter.nomes.toString())
                    dialog.dismiss()
                }else{
                    inputEditText.error = "Digite um nome válido!"
                    Toast.makeText(requireContext(),"deu nao",Toast.LENGTH_SHORT).show()
                }
            }

        })


//        binding.editText.addTextChangedListener {
//            text = it.toString()
//            adapter.nomes.add(text)
//        }

        binding.recycle.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        binding.recycle.adapter = adapter

        return binding.root
    }

}