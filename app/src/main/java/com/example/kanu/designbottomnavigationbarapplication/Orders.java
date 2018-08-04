package com.example.kanu.designbottomnavigationbarapplication;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class Orders extends Fragment {

    public Orders(){

    }

    TabLayout ordersTabLayout;

    FrameLayout frameLayout;

    Fragment fragment = null;

    FragmentManager fragmentManager;

    FragmentTransaction fragmentTransaction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_orders,container,false);

        ordersTabLayout = (TabLayout) view.findViewById(R.id.ordersTabLayout);

        frameLayout = (FrameLayout) view.findViewById(R.id.ordersFrame);

        fragment = new Asps();

        fragmentManager = getChildFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.ordersFrame, fragment);

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        fragmentTransaction.commit();

        ordersTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new Asps();
                        break;

                    case 1:
                        fragment = new Schedule();
                        break;
                }

                fragmentManager = getChildFragmentManager();

                fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.ordersFrame, fragment);

                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

                fragmentTransaction.commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new Asps();
                        break;

                    case 1:
                        fragment = new Schedule();
                        break;
                }

                fragmentManager = getChildFragmentManager();

                fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.ordersFrame, fragment);

                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
