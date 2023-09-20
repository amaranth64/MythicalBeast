package ru.openbiz64.mythicalbeast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.openbiz64.mythicalbeast.adapter.FoodAdapter
import ru.openbiz64.mythicalbeast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var form: ActivityMainBinding
    private var foodAdapter: FoodAdapter = FoodAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        form = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(form.root)

        form.rvMain.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        form.rvMain.adapter = foodAdapter
        foodAdapter.addAll(foodDummyData)
    }
}