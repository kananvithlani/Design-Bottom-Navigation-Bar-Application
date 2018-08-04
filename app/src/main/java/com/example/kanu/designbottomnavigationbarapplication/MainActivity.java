package com.example.kanu.designbottomnavigationbarapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    TextView title;

    TabLayout tabLayout;

    FrameLayout frameLayout;

    Fragment fragment = null;

    FragmentManager fragmentManager;

    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        title = (TextView) toolbar.findViewById(R.id.toolbar_title);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        frameLayout = (FrameLayout) findViewById(R.id.frame);

        fragment = new Orders();
        title.setText(R.string.orders);

        fragmentManager = getSupportFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frame, fragment);

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        fragmentTransaction.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new Orders();
                        title.setText(R.string.orders);
                        toolbar.setElevation(0);
                        break;

                    case 1:
                        fragment = new Deliveries();
                        title.setText(R.string.deliveries);
                        toolbar.setElevation(8);
                        break;

                    case 2:
                        fragment = new Items();
                        title.setText(R.string.items);
                        toolbar.setElevation(8);
                        break;

                    case 3:
                        fragment = new Account();
                        title.setText(R.string.account);
                        toolbar.setElevation(8);
                        break;
                }

                fragmentManager = getSupportFragmentManager();

                fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.frame, fragment);

                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

                fragmentTransaction.commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
