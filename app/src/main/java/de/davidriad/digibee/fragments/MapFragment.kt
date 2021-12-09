package de.davidriad.digibee.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import de.davidriad.digibee.R


class MapFragment : Fragment() {
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_map, container, false)
//        tabLayout = view.findViewById(R.id.tab_layout)
//        viewPager = view.findViewById(R.id.viewPager)


//        val exploreActivitesAdapter =
//            ExploreActivitesAdapter(childFragmentManager)
//        exploreActivitesAdapter.addFragment(UpcomingEventsFragment(),"Upcoming")
//        exploreActivitesAdapter.addFragment(PrivateEventsFragment(),"Private")
//        exploreActivitesAdapter.addFragment(HistoryEventFragment(),"History")
//
//        viewPager.adapter = exploreActivitesAdapter
//        tabLayout.setupWithViewPager(viewPager)
//
//        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
//        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab) {
//                viewPager.currentItem = tab.position
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab) {}
//            override fun onTabReselected(tab: TabLayout.Tab) {}
//        })

        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }


}