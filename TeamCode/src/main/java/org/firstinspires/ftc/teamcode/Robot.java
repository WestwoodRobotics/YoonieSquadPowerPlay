package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot{

    public DcMotorEx leftFront;
    public DcMotorEx rightFront;
    public DcMotorEx leftBack;
    public DcMotorEx rightBack;

    public DcMotorEx lift1;
    public DcMotorEx lift2;

    public Servo claw;
    public Servo wrist;
    public Servo armRight;
    public Servo armLeft;
    //TODO: set this to the actual machine limit?????
    public int liftMax = 1000;


    public Robot(HardwareMap hardwareMap){
        //Do hardware mapping here
        //arm

        armRight = hardwareMap.get(Servo.class, "armRight");
        armLeft = hardwareMap.get(Servo.class, "armLeft");

        //lift

        lift1 = hardwareMap.get(DcMotorEx.class, "lift1");
        lift1.setDirection(DcMotorEx.Direction.FORWARD);
        lift1.setTargetPosition(30);
        lift1.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        lift2 = hardwareMap.get(DcMotorEx.class, "lift2");
        lift2.setDirection(DcMotorEx.Direction.REVERSE);
        lift2.setTargetPosition(30);
        lift2.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        //drive

        leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        leftFront.setDirection(DcMotorEx.Direction.REVERSE);
        leftFront.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");
        rightFront.setDirection(DcMotorEx.Direction.FORWARD);
        rightFront.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        leftBack = hardwareMap.get(DcMotorEx.class, "leftBack");
        leftBack.setDirection(DcMotorEx.Direction.REVERSE);
        leftBack.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);


        rightBack = hardwareMap.get(DcMotorEx.class, "rightBack");
        rightBack.setDirection(DcMotorEx.Direction.FORWARD);
        rightBack.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        wrist = hardwareMap.get(Servo.class, "wrist");
        claw = hardwareMap.get(Servo.class, "claw");
    }

    //TODO: move these methods to the Teleop file not here

    public void score(){
        //TODO: probably lower slides, open calw, flip arm and wrist back to normal pos

    }

    public void scoringPos(){
        //TODO: flip arm, flip wrist
    }

}