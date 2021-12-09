package de.davidriad.digibee.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import de.davidriad.digibee.R
import de.davidriad.digibee.adapter.BeeHiveAdapter
import de.davidriad.digibee.model.BeeHive
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var beeHiveAdapter: BeeHiveAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View? =
        inflater.inflate(R.layout.fragment_home, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        linearLayoutManager = LinearLayoutManager(
            activity?.applicationContext!!,
            LinearLayoutManager.VERTICAL, false
        )
        recycler.layoutManager = linearLayoutManager
        val beehives = listOf(
            BeeHive("Bee hive 1 ", "1", "Good", 24, 50, "Sunny", "24", "Healthy"),
            BeeHive("Bee hive 2 ", "1", "Good", 22, 81, "Sunny", "24", "Healthy"),
            BeeHive("Bee hive 3 ", "3", "Bad", 18, 32, "Sunny", "24", "Healthy"),
            BeeHive("Bee hive 4 ", "1", "Good", 27, 64, "Sunny", "24", "Healthy"),

            )
        beeHiveAdapter = BeeHiveAdapter(
            beehives, activity?.applicationContext!!
        )
        recycler.adapter = beeHiveAdapter

    }
}