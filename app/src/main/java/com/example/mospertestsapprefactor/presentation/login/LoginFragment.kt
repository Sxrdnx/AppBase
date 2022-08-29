package com.example.mospertestsapprefactor.presentation.login

import androidx.fragment.app.viewModels
import com.example.mospertestsapprefactor.databinding.FragmentLoginBinding
import com.example.mospertestsapprefactor.presentation.base.BaseFragment
import com.example.mospertestsapprefactor.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment:BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate){
    private val viewModel: LoginViewModel by viewModels()

    override fun FragmentLoginBinding.initialize(){

    }

    fun subscribeToObserver(){
        viewModel.loginState.observe(viewLifecycleOwner){ result ->
            result?.let {
                when(result.status){
                    Status.ERROR->{
                        showSnackBar(result.message ?: "un error ocurrio")
                    }
                    Status.SUCCESS->{
                        showSnackBar(result.message ?: "loggin exitoso!")
                        redirectLogin()
                    }
                }
            }
        }

    }

    private fun redirectLogin() {
        TODO("Not yet implemented")
    }

}