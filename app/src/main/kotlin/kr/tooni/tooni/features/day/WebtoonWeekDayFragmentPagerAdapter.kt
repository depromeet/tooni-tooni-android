/*
 * Created by Leo on 2021. 05. 22 ..
 */
package kr.tooni.tooni.features.day

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import kr.tooni.tooni.R
import kr.tooni.tooni.core.model.WeekDay

class WebtoonWeekDayFragmentPagerAdapter(
    private val fragment: Fragment
) : FragmentPagerAdapter(fragment.childFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    
    private val fragments by lazy {
        WeekDay.values().map { day -> WebtoonByDayFragment.newInstance(day.value) }
    }
    
    override fun getCount(): Int {
        return fragments.size
    }
    
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }
    
    override fun getPageTitle(position: Int): CharSequence? {
        val array = fragment.requireContext().resources.getStringArray(R.array.week_day)
        return array[position]
    }
}
