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

    public DcMotorEx lift;
    public DcMotorEx arm;

    public Servo lClaw;
    public Servo rClaw;
    public Servo wrist;

    //TODO: set this to the actual machine limit?????
    public int liftMax = 1000;

    //TODO: fill in these placeholders soon
    //public int ticksPerDegree = gearRatio * TicksPerRev / 360;


    public Robot(HardwareMap hardwareMap){
        //Do hardware mapping here
        //arm
        arm = hardwareMap.get(DcMotorEx.class, "arm");
        arm.setDirection(DcMotorEx.Direction.FORWARD);
        arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        arm.setTargetPosition(0);
        arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        //lift

        lift = hardwareMap.get(DcMotorEx.class, "lift1");
        lift.setDirection(DcMotorEx.Direction.FORWARD);
        lift.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        lift.setTargetPosition(0);
        lift.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);


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
        lClaw = hardwareMap.get(Servo.class, "lClaw");
        rClaw = hardwareMap.get(Servo.class, "rClaw");
    }

    //TODO: move these methods to the Teleop file not here




}