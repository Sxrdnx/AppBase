package com.example.mospertestsapprefactor.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

open class BaseFragment<T: ViewBinding>(private val inflateMethod:(LayoutInflater,ViewGroup?,Boolean)-> T): Fragment() {
    private  var _binding : T ? = null
    protected val binding: T
        get() = _binding!!

    open fun T.initialize(){}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
            _binding = inflateMethod.invoke(inflater,container,false)
            binding.initialize()
        return binding.root
    }

    fun showSnackBar(text: String){
        Snackbar.make(
            requireActivity(),
            requireView(),
            text,
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}