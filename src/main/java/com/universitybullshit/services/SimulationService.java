package com.universitybullshit.services;

import com.universitybullshit.model.Habitat;
import lombok.Getter;
import lombok.Setter;

import java.util.Timer;
import java.util.TimerTask;

public class SimulationService {
    @Getter
    @Setter
    private Habitat context;
    @Getter
    @Setter
    private boolean isSimulationRunning;
    @Getter
    @Setter
    private long time;
    private final Timer timer;

    // Constants
    private final long TIMER_TICK_VALUE = 200;
    private final long TIMER_DELAY_VALUE = 0;
    public SimulationService(Habitat habitat) {
        context = habitat;
        isSimulationRunning = false;
        time = 0;
        timer = new Timer();
    }

    public void simulation() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (isSimulationRunning) {
                    time += TIMER_TICK_VALUE;
                    context.update(time);
                }
            }
        }, TIMER_DELAY_VALUE, TIMER_TICK_VALUE);
    }
}
