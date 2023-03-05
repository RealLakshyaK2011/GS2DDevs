package methodTest;

import net.chauhanDevs.gsquad.GS2DDevs.math.GSMath;

import java.util.Random;

public class TestConduct2 {
    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt(10000);
        int b = random.nextInt(10000);
        int c = random.nextInt(10000);
        int d = random.nextInt(10000);
        int e = random.nextInt(10000);
        int f = random.nextInt(10000);
        int g = random.nextInt(10000);
        int h = random.nextInt(10000);
        int i = random.nextInt(10000);
        int j = random.nextInt(10000);
        int k = random.nextInt(10000);
        int l = random.nextInt(10000);
        int m = random.nextInt(10000);
        int n = random.nextInt(10000);
        int o = random.nextInt(10000);
        int p = random.nextInt(10000);
        int q = random.nextInt(10000);
        int r = random.nextInt(10000);
        int s = random.nextInt(10000);
        int t = random.nextInt(10000);
        int u = random.nextInt(10000);
        int v = random.nextInt(10000);
        int w = random.nextInt(10000);
        int x = random.nextInt(10000);
        int y = random.nextInt(10000);
        int z = random.nextInt(10000);

        System.out.println("Numbers: " + a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g + "\n"
                + h + " " + i + " " + j + " " + k + " " + l + " " + m + " " + n + " " + o + " " + p + "\n"
                + q + " " + r + " " + s + " " + t + " " + u + " " + v + " " + w + " " + x + " " + y + "\n"
                + z + "\nMinimum: " + GSMath.getMinimumAmongALl(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p
                    ,q,r,s,t,u,v,w,x,y,z));
    }
}
