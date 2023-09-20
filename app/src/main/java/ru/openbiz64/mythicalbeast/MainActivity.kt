package ru.openbiz64.mythicalbeast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.openbiz64.mythicalbeast.adapter.BeastAdapter
import ru.openbiz64.mythicalbeast.databinding.ActivityMainBinding
import ru.openbiz64.mythicalbeast.dataclass.BeastDataClass
import ru.openbiz64.mythicalbeast.model.MainViewModel
import ru.openbiz64.mythicalbeast.model.MainViewModelFactory

class MainActivity : AppCompatActivity(), BeastAdapter.Listener {

    private lateinit var vm: MainViewModel
    private val fileName = "beasts"
    private lateinit var form: ActivityMainBinding
    private lateinit var beastAdapter: BeastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        form = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(form.root)

        beastAdapter = BeastAdapter(this, this)

        vm = ViewModelProvider(this, MainViewModelFactory(this,fileName)).get(MainViewModel::class.java)

        form.rvMain.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        form.rvMain.adapter = beastAdapter//foodAdapter
        //foodAdapter.addAll(foodDummyData)


        vm.data.observe(this) { d ->
            beastAdapter.submitList(d)
        }

    }

    override fun onClick(item: BeastDataClass) {

    }
}