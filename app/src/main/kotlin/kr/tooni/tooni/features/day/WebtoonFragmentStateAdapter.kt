/*
 * Created by Leo on 2021. 05. 22 ..
 */
package kr.tooni.tooni.features.day

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import kr.tooni.tooni.core.model.WeekDay

class WebtoonFragmentStateAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    
    private val fragments by lazy {
        WeekDay.values().map { day -> WebtoonByDayFragment.newInstance(day.value) }
    }
    
    override fun getItemCount(): Int {
        return fragments.size
    }
    
    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}
