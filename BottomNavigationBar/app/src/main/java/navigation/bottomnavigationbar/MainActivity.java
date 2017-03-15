package navigation.bottomnavigationbar;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import navigation.bottomnavigationbar.fragments.FragmentOne;
import navigation.bottomnavigationbar.fragments.FragmentThree;
import navigation.bottomnavigationbar.fragments.FragmentTwo;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        FragmentOne fragmentOne = new FragmentOne();
        replaceFragment(fragmentOne);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_one:

                                FragmentOne fragmentOne = new FragmentOne();
                                replaceFragment(fragmentOne);
                                break;
                            case R.id.action_two:


                                FragmentTwo fragmentTwo = new FragmentTwo();
                                replaceFragment(fragmentTwo);
                                break;

                            case R.id.action_three:


                                FragmentThree fragmentThree = new FragmentThree();
                                replaceFragment(fragmentThree);
                                break;
                        }
                        return true;
                    }
                });
    }

    private void replaceFragment(Fragment fragment){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();
    }
}
