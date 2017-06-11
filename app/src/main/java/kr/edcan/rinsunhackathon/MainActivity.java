package kr.edcan.rinsunhackathon;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by bene on 2016. 7. 22..
 */
public class MainActivity extends FragmentActivity {
    Fragment f = new Fragment();
    SharedPreferences s;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        PagerAdapter mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(mPagerAdapter);


    }

    private class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    f = new MainPager();
                    break;
                case 1:
                    f = new ListPager();
                    break;
            }
            return f;
        }

        @Override
        public int getCount() {
            long lostDate = getDay(timeSet(), getPref("oDate").toString());
            if(lostDate > 240) {
                return 2;
            } else {
                return 1;
            }
        }

        private String timeSet() {
            Calendar cal = new GregorianCalendar(Locale.KOREA);
            cal.setTime(new Date());
            SimpleDateFormat fm = new SimpleDateFormat("yyyyMMdd");
            String strNow = fm.format(cal.getTime());
            return strNow;
        }

        private long getDay(String now, String end) {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            long lost = 0;
            try {
                Date st = format.parse(now);
                Date en = format.parse(end);
                long diff = en.getTime() - st.getTime();
                lost = diff / (24 * 60 * 60 * 1000);
            } catch (Exception e) {
                lost = 0;
                e.printStackTrace();
            }
            return lost;
        }

    }

    protected Uri getPref(String t) {
        s = getSharedPreferences("pref", 0);
        editor = s.edit();
        String v = s.getString(t, "");
        Uri u = Uri.parse(v);
        return u;
    }

}