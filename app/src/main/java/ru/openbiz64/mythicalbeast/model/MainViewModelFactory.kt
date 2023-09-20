package ru.openbiz64.mythicalbeast.model

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.openbiz64.mythicalbeast.dataclass.BeastDataClass

class MainViewModelFactory(private val context: Context, private val fileName: String): ViewModelProvider.Factory {

    private val beastList: ArrayList<BeastDataClass>  = DataJsonLoader.getData(fileName, context)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(beastList) as T
    }
}