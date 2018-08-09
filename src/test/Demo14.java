package test;

import java.awt.*;
import java.applet.*;

public class Demo14 extends Applet
{
    public void paint(Graphics g)
    {
        int k;
        k=50+(int)(Math.random( )*150);
        if(k%2!=0)
            g.drawString(""+k+" 的平方根约等于 "+(float)Math.sqrt(k),20,20);
        else
            g.drawString(""+k+" 的平方等于 "+k*k,20,20);
    }
}

