/*
 * Created by Leo on 2021. 05. 22 ..
 */
package kr.tooni.tooni.features.day

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kr.tooni.tooni.R
import kr.tooni.tooni.core.model.WeekDay

class WebtoonFragmentPagerAdapter(
    fragmentManager: FragmentManager,
    private val context: Context
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    
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
        val array = context.resources.getStringArray(R.array.week_day)
        return array[position]
    }
}
