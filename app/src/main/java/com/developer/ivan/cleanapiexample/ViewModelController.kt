package com.developer.ivan.cleanapiexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer.ivan.domain.Employee
import com.developer.ivan.usecases.GetEmployees
import com.developer.ivan.usecases.InsertEmployee
import kotlinx.coroutines.launch

class ViewModelController(
    private val getEmployees: GetEmployees,
    val insertEmployee: InsertEmployee): ViewModel()
{
    sealed class UIState{
        class ShowEmployees(val employee: List<Employee>) : UIState()
    }

    private val _state = MutableLiveData<UIState>()
    val state: LiveData<UIState>
        get() = _state

    fun initialize()
    {
        viewModelScope.launch {

            val result = getEmployees.execute(Unit)

            _state.value = UIState.ShowEmployees(result)
        }
    }
}