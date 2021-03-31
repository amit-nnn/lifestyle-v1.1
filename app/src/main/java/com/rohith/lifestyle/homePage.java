package com.rohith.lifestyle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import java.util.Objects;

public class homePage extends AppCompatActivity {

    private MeowBottomNavigation gBNV;
    private FrameLayout gFrameLayout;

    private static final int ID_HOME = 1;
    private static final int ID_GOAL = 2;
    private static final int ID_JOURNEL = 3;
    private static final int ID_MONEY = 4;
    private static final int ID_PROFILE = 5;

    private Fragment homeFrag = new homeFragPage();
    private Fragment goalFrag = new goalFragPage();
    private Fragment journelFrag = new journelFragPage();
    private Fragment moneyFrag = new moneyFragPage();
    private Fragment profileFrag = new profileFragPage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        gBNV = (MeowBottomNavigation)findViewById(R.id.home_BNV);
        gFrameLayout = (FrameLayout)findViewById(R.id.home_frameLayout);

        gBNV.add(new MeowBottomNavigation.Model(ID_GOAL,R.drawable.ic_goal));
        gBNV.add(new MeowBottomNavigation.Model(ID_JOURNEL,R.drawable.ic_diary));
        gBNV.add(new MeowBottomNavigation.Model(ID_HOME,R.drawable.ic_home_page));
        gBNV.add(new MeowBottomNavigation.Model(ID_MONEY,R.drawable.ic_save_money));
        gBNV.add(new MeowBottomNavigation.Model(ID_PROFILE,R.drawable.ic_user));

        getSupportFragmentManager().beginTransaction().replace(R.id.home_frameLayout,homeFrag).commit();

        gBNV.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

            }
        });

        gBNV.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment selected_fragment = null;
                switch (item.getId())
                {
                    case ID_HOME:
                        selected_fragment = homeFrag;
                        break;
                    case ID_GOAL:
                        selected_fragment = goalFrag;
                        break;
                    case ID_JOURNEL:
                        selected_fragment = journelFrag;
                        break;
                    case ID_MONEY:
                        selected_fragment = moneyFrag;
                        break;
                    case ID_PROFILE:
                        selected_fragment = profileFrag;
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.home_frameLayout, Objects.requireNonNull(selected_fragment)).commit();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        gBNV.show(ID_HOME,true);
    }
}