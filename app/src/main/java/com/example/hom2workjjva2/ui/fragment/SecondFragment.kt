package com.example.hom2workjjva2.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hom2workjjva2.R
import com.example.hom2workjjva2.databinding.FragmentSecondBinding
import com.example.hom2workjjva2.ui.model.viewModel.SecondViewModel
import com.example.hom2workjjva2.ui.model.UserModel
import com.example.hom2workjjva2.ui.model.prefernce.SharedPreference

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val secondViewModel: SecondViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?)
            : View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupDepServis()
    }

    private fun initialize() {
        val preferenceHelper = SharedPreference(requireActivity())
        secondViewModel.updateUserModel(UserModel(preferenceHelper.user_name!!,
            preferenceHelper.age!!,
            preferenceHelper.email!!,
            preferenceHelper.password!!))

    }

    private fun setupDepServis() = with(binding){
        secondViewModel.userData.observe(viewLifecycleOwner){username->
            userData.text = username.userName
            text2.text = username.age
            text3.text = username.email
            text4.text = username.password
        }
        btnSecond.setOnClickListener{
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}