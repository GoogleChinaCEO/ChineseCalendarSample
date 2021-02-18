package com.example.chinesecalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity{
    private String week;
    private Calendar c = Calendar.getInstance();
    TextView cale,lunar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cale=findViewById(R.id.cale);
        lunar=findViewById(R.id.lunar);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(System.currentTimeMillis());
        printDayOfWeek();
        cale.setText(simpleDateFormat.format(date) + " " +week);
        lunar.setText(getDayLunar());
    }

    private void printDayOfWeek() {
        switch (c.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:
                week="周日";
                break;
            case Calendar.MONDAY:
                week="周一";
                break;
            case Calendar.TUESDAY:
                week="周二";
                break;
            case Calendar.WEDNESDAY:
                week="周三";
                break;
            case Calendar.THURSDAY:
                week="周四";
                break;
            case Calendar.FRIDAY:
                week="周五";
                break;
            case Calendar.SATURDAY:
                week="周六";
                break;
            default:
                break;
        }
    }
    /**
     * 获取现在农历的日期
     */
    public static String getDayLunar() {
        ChinaCalender lunarCalender = new ChinaCalender();
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DATE);
//        lunarDate = lunarCalender.getLunarDate(year, month, day, true);
//        String lunarMonth = lunarCalender.getLunarMonth();
        String lunarAnimal = lunarCalender.animalsYear(year);
        String lunarGanZhi = lunarCalender.cyclical(year,month,day);
        String lunarString = lunarCalender.getLunarString(year, month, day);
        return "农历"+lunarString+" "+lunarGanZhi+lunarAnimal;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}