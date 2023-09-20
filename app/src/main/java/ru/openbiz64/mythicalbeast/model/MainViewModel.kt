package ru.openbiz64.mythicalbeast.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.openbiz64.mythicalbeast.dataclass.BeastDataClass

class MainViewModel(private val dataList: ArrayList<BeastDataClass>): ViewModel() {

    var data: MutableLiveData<ArrayList<BeastDataClass>> = MutableLiveData()

    init {
        data.value = dataList
        Log.d("MyLog", "init MainViewModel")
    }
}