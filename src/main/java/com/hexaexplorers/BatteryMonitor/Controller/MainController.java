package com.hexaexplorers.BatteryMonitor.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import oshi.SystemInfo;
import oshi.hardware.PowerSource;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @GetMapping("/")
    public String monitorBatteryStatus() {
        SystemInfo systemInfo = new SystemInfo();
        PowerSource[] powerSources= systemInfo.getHardware().getPowerSources().toArray(new PowerSource[0]);

        for (PowerSource powerSource : powerSources) {
            double batteryLevel = powerSource.getRemainingCapacityPercent() * 100;
            boolean isCharging = powerSource.isCharging();
            System.out.println("BatteryLevel- "+batteryLevel);
            System.out.println("isCharging- "+isCharging);
        }





        return "";
    }


    }



