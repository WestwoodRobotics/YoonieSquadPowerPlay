package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Robot;

//TODO: find correct lift positions
//TODO: find cocrrect claw/arm positions

public class JihoonRoboTeleop extends OpMode {
    Robot robot;
    public int liftTarget = 0;
    public int armTarget = 0;

    //status 0 is idle pos
    //status 1 is wrist down, claw open
    //status 2 is scoring
    public int status = 0;


    @Override
    public void init() {
        robot = new Robot(hardwareMap);
    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {
        resetRuntime();
    }

    @Override
    public void loop() {
        double drive = gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_y;

        robot.rightFront.setPower(drive + strafe-turn);
        robot.leftFront.setPower(drive - strafe+turn);
        robot.rightBack.setPower(drive - strafe-turn);
        robot.leftBack.setPower(drive + strafe+turn);

        robot.lift.setPower(1);
        //TODO: switch armtarget from tick value to degreese value by applying the "ticks per degree later"
        robot.arm.setTargetPosition(armTarget);
        robot.lift.setPower(armTarget);


        if(status == 2){
            //TODO: 100 * ticks per degree
            if(robot.arm.getCurrentPosition() > 100){
                robot.lift.setTargetPosition(liftTarget);
            }
        }else if(status == 0){
            robot.lift.setTargetPosition(0);
        }else{
            robot.lift.setTargetPosition(600);
        }
    }

    @Override
    public void stop() {

    }

    public void  idlePos(){
        status = 0;
        //flip arm back forward, flip wrist, reset lift pos
        robot.arm.setTargetPosition(0);
        robot.wrist.setPosition(0.5);
        robot.lClaw.setPosition(1);
        robot.rClaw.setPosition(0);
    }
    public void  scorePos(){
        status = 2;
        //flip arm back forward, flip wrist, reset lift pos
        armTarget = 120;
        robot.wrist.setPosition(1);
    }

    public void  pickPos(){
        idlePos();
        status = 1;
        robot.wrist.setPosition(0);
        robot.lClaw.setPosition(0);
        robot.rClaw.setPosition(1);
    }

}
