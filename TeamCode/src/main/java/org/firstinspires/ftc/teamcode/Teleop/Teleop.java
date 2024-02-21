package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Robot;


public class Teleop extends OpMode {
    Robot robot;
    public int liftTarget = 0;

    @Override
    public void init() {
        robot = new Robot(hardwareMap);

        //TODO: see if pos 0 is actually claw closed pos or not
        robot.claw.setPosition(0);
    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {

    }

    @Override
    public void stop() {

    }




    public void score(){
        //TODO: probably lower slides, open calw, flip arm and wrist back to normal pos


    }

    public void scoringPos(int liftPresetTarget){
        //TODO: flip arm, flip wrist, set lift pos
        liftTarget = liftPresetTarget;
    }

}
