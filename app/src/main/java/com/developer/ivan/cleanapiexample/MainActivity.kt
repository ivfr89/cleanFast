package com.developer.ivan.cleanapiexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.compat.ScopeCompat.viewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.android.viewmodel.scope.viewModel

class MainActivity : AppCompatActivity() {

    val mViewModel: ViewModelController by currentScope.viewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeChanges()
        mViewModel.initialize()


    }

    private fun observeChanges() {
        mViewModel.state.observe(this, Observer {


            when (it) {
                is ViewModelController.UIState.ShowEmployees -> txtEmployees.text =
                    it.employee.toString()

            }
        })
    }
}
