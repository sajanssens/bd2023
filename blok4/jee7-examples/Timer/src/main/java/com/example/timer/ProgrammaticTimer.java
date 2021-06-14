package com.example.timer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import java.util.Calendar;

@Singleton
@Startup // to eagerly initialize this bean; without it, you would have to inject and call this bean somewhere which doesn't make sense with a timer
public class ProgrammaticTimer {

    @Resource
    private TimerService timerService;
    private int ticks;

    @PostConstruct
    public void initialize() {
        ticks = 0;
        // replacement of @Schedule, now programmatically
        ScheduleExpression expression = new ScheduleExpression();
        expression.second("*/1").minute("*").hour("*");
        timerService.createCalendarTimer(expression);
    }

    @Timeout // gets fired every second now
    public void callMeWhatYouWill() {
        ticks++;
        System.out.println("ProgrammaticTimer current time: " + Calendar.getInstance().getTime());
    }

    public int getTicks() { return ticks; }
}
