package net.chauhanDevs.gsquad.GS2DDevs.math;

public class GSMath {
    public static int getMinimumAmongALl(int... all){
        int temp = 0;
        for (int a : all) {
            System.out.println(a);
            temp += a;
        }
        for (int a : all) {
            temp = Math.min(a, temp);
        }
        return temp;
    }

    public static int toPositive(int num){
        if(num < 0){
            return -num;
        }
        return num;
    }

    public static int toNegative(int num){
        if(num > -1){
            return -num;
        }
        return num;
    }

    public static int negativeAngleToPositiveAngle(int angle){
        return 360 - toPositive(angle);
    }

    public static long percentOf(long percent, long num){
        return num * percent / 100;
    }
}
