package tabs.fixedtabsapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tabs.fixedtabsapplication.R;

/**
 * Created by tanmaypandharipande on 14/3/17.
 */

public class FragmentOne extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_one,container,false);
        return view;
    }
}
