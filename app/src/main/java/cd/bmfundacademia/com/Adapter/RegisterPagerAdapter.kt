package cd.bmfundacademia.com.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import cd.bmfundacademia.com.Auth.StepRegister.StepeOneFragment
import cd.bmfundacademia.com.Auth.StepRegister.StepeTwoFragment

class RegisterPagerAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity)  {



    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> StepeOneFragment()
            1 -> StepeTwoFragment()
            else -> StepeTwoFragment()
        }
    }

}
