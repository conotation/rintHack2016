package kr.edcan.rinsunhackathon;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by bene on 2016. 7. 22..
 */
public class DateActivity extends Activity implements View.OnClickListener, OnDateSelectedListener {
    TextView mMonth, mDate, mYear;
    ImageView mSubmitButton;
    int month, day, year;
    MaterialCalendarView mCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        mSubmitButton = (ImageView) findViewById(R.id.mSubmitButton);
        String s = timeSet();
        mYear = (TextView) findViewById(R.id.mTextViewYear);
        mYear.setText(s.substring(0,4));
        mMonth = (TextView) findViewById(R.id.mTextViewMonth);
        mMonth.setText(s.substring(4,6));
        mDate = (TextView) findViewById(R.id.mTextViewDay);
        mDate.setText(s.substring(6,8));
        mCalendarView = (MaterialCalendarView) findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangedListener(this);

        mSubmitButton.setOnClickListener(this);
    }
    private String timeSet() {
        Calendar cal = new GregorianCalendar(Locale.KOREA);
        cal.setTime(new Date());
        SimpleDateFormat fm = new SimpleDateFormat("yyyyMMdd");
        String strNow = fm.format(cal.getTime());
        return strNow;
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        switch (view.getId()) {
            case R.id.mSubmitButton:
                String query = String.format("%04d%02d%02d", year, month+1, day);
                savePreferences(query);
                startActivity(i);
                finish();
                break;
            default:
                break;
        }
    }

    private void savePreferences(String s) {
        SharedPreferences pref = getSharedPreferences("pref", 0);
        SharedPreferences.Editor edit = pref.edit();
        edit.putString("oDate", s);
        edit.commit();
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        year = date.getYear();
        month = date.getMonth();
        day = date.getDay();
        mMonth.setText(month+1 + "");
        mYear.setText(year + "");
        mDate.setText(day + "");
    }
}
