package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Robot;

//TODO: find correct lift positions
//TODO: find correct claw/arm positions

public class JihoonRoboTeleop extends OpMode {
    Robot robot;
    public int liftTarget = 0;

    //status 0 is idle pos
    //status 1 is scoring pos claw closed
    //statis 2 is while scoring
    public int status = 0;

    public double liftMoveTime;

    @Override
    public void init() {
        robot = new Robot(hardwareMap);

        robot.claw.setPosition(0);
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


        if (status == 0){
            //claw control
            if(gamepad1.left_bumper||gamepad1.right_bumper){
                robot.claw.setPosition(1);
            }else{
                robot.claw.setPosition(0);
            }
            //lift control for stacks
            liftTarget += gamepad1.right_trigger*10 - gamepad1.left_trigger * 10;
            if (liftTarget > 200){
                liftTarget = 200;
            }else if(liftTarget < 0){
                liftTarget = 0;
            }

        }else if(status == 1){
            //initiate scoring
            if(gamepad1.left_bumper||gamepad1.right_bumper){
                liftTarget = 0;
                liftMoveTime = getRuntime();
                status = 2;
            }

        }else if(status == 2){
            //finish scoring
            if(getRuntime() - liftMoveTime > 1){
                robot.claw.setPosition(1);
            }

            if(getRuntime() - liftMoveTime > 1.25){
                idlePos();
            }

            //or open claw then idlepos immediately, without a delay
        }


        //scoringPos preset buttons
        if(status != 2) {
            if (gamepad1.a) {
                idlePos();
            } else if (gamepad1.b) {
                scoringPos(400);
            } else if (gamepad1.x) {
                scoringPos(600);
            } else if (gamepad1.y) {
                scoringPos(800);
            }
        }


        //set lift powering
        robot.lift.setPower(1);
        robot.lift.setTargetPosition(liftTarget);
    }

    @Override
    public void stop() {

    }

    public void scoringPos(int liftPresetTarget){
        robot.claw.setPosition(0);
        status = 1;
        //flip arm, flip wrist, set lift pos
        liftTarget = liftPresetTarget;
        robot.armLeft.setPosition(0);
        robot.armRight.setPosition(1);
        robot.wrist.setPosition(1);
    }
    public void  idlePos(){
        status = 0;
        //flip arm back forward, flip wrist, reset lift pos
        liftTarget = 0;
        robot.armLeft.setPosition(1);
        robot.armRight.setPosition(0);
        robot.wrist.setPosition(0);
    }

}
