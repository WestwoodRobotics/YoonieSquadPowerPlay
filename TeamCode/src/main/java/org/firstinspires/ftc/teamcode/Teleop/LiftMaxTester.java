package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Robot;

public class LiftMaxTester extends OpMode {
    Robot robot;
    int maxMeasured;
    @Override
    public void init() {
        robot = new Robot(hardwareMap);
        maxMeasured = 0;
    }

    @Override
    public void loop() {
        robot.lift.setTargetPosition(5000);
        robot.lift.setPower(0.3);
        if (maxMeasured < robot.lift.getCurrentPosition()){
            maxMeasured = robot.lift.getCurrentPosition();
        }
        telemetry.addData("max slides", maxMeasured);
    }
}
