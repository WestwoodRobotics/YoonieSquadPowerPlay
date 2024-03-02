package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Robot;

public class LiftTicksTester extends OpMode {
    Robot robot;
    @Override
    public void init() {
        robot = new Robot(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("slide pos", robot.lift.getCurrentPosition());
    }
}
