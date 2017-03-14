package tabs.fixedtabsapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import tabs.fixedtabsapplication.fragments.FragmentOne;
import tabs.fixedtabsapplication.fragments.FragmentTwo;
import tabs.fixedtabsapplication.fragments.FrgamentThree;

/**
 * Created by tanmaypandharipande on 14/3/17.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentOne();
            case 1:
                return new FragmentTwo();
            case 2:
                return new FrgamentThree();
        }

        return null;
    }


    @Override
    public int getCount() {
        return 3;
    }
}
