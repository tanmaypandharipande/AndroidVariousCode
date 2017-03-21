package dots.viewpagerwithdots;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    int[] img;
    private static int currentPAge = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img =new int[]{R.drawable.a,R.drawable.b,
                R.drawable.c,R.drawable.a};
        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPagerAdapter = new ViewPagerAdapter(this,img);
        viewPager.setAdapter(viewPagerAdapter);

        CircleIndicator circleIndicator =(CircleIndicator)findViewById(R.id.indicator);
        circleIndicator.setViewPager(viewPager);
        circleIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPAge = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE){
                    int pageCount = img.length;
                    if (currentPAge == 0){
                        viewPager.setCurrentItem(pageCount-1,false);
                    }
                    else if (currentPAge== pageCount){
                        viewPager.setCurrentItem(0,false);
                    }
                }
            }
        });
    }
}
