import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
public class fine extends JFrame implements Runnable,KeyListener {  
public int x, y, flag,c,d,dead = 0;
int score = 0;
public int count = 10;
  public int frameWidth = 300,frameHeight = 600;
Random rand = new Random();
Thread t;
public fine()
        {  
        setBounds(300,700,frameWidth,frameHeight);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    addKeyListener(this);
        d = 10;
        c = 220;
        x=10;        
        y = 10;
        flag = 1;
        t = new Thread(this, "MyThread");  
        t.start();  
    }  
    public void update()
    {
        y = y + 20 * (count/10);
   d= d + 20 *(count/10);
   if(dead!=1)
   score++;
        if(y>=500 && d>=500)
        { if(count/10 <= 3){count++;}
int a=rand.nextInt(2);   // number of cars
int g = rand.nextInt(3);
int h = rand.nextInt(3);
while(g == h){
h = rand.nextInt(3);}
 if(a==0)
 {
if(g == 0)
{
  x=20;
}
else if(g==1)
  {
  x=120;
  }
  else
  {
  x=220;
  }
  y = 10;
 }
else
{
if(g == 0)
{
  x=20;
}
else if(g==1)
  {
  x=120;
  }
  else
  {
  x=220;
  }
if(h == 0)
{
  c=20;
}
else if(h==1)
  {
  c=120;
  }
  else
  {
  c=220;
  }
  y = 10;
  d = 10;
}

          }
          if(((carX+30)>x&&(carX+30)<(x+60)) && ((carY+30)>y)&&((carY+30)<(y+60)))
          {
          dead = 1;
          }
          else if(((carX+30)>c&&(carX+30)<(c+60)) && ((carY+30)>d)&&((carY+30)<(d+60)))
          {
          dead = 1;
          }
    }
    public void run()
    {
while (true)
{
// Repainting the screen
// calls the paint function
repaint();
update();
try {
// creating a pause of 1 second
// so that the movement is recognizable
Thread.sleep(80);
}
catch (InterruptedException ie) {
System.out.println(ie);
}
}
}  
public void paint(Graphics g)
{
if(dead == 0){
super.paint(g);
      g.setColor(Color.RED);
      g.fillRect(carX,carY,60,60);
      g.setColor(Color.GREEN);
      g.fillRect(x,y,60,60);
      g.setColor(Color.BLUE);
      g.fillRect(c,d,60,60);
      g.drawLine(100,0,100,600);
      g.drawLine(200,0,200,600);

}
else
{
g.drawString("DEAD",130,570);
}
g.drawString("score = ",130,550);
g.drawString(String.valueOf(score),180,550);

}
        static int carX = 120,carY = 400;
  public void keyTyped(KeyEvent ke) {}
  public void keyReleased(KeyEvent ke) {}
  public void keyPressed(KeyEvent ke)
  {
int id = ke.getKeyCode();
    if(id==KeyEvent.VK_LEFT)
                 {
      if(carX==120||carX==220)
  {
carX-=100;
}
}
    if(id==KeyEvent.VK_RIGHT)
             {
    if(carX==120||carX==20)
  {
carX+=100;
}
}
if(id==KeyEvent.VK_UP)
         {
      if(carY > 10 && carY <500)
  {
carY-=10;
}
}
if(id==KeyEvent.VK_DOWN)
         {
      if(carY > 0 && carY <490)
  {
carY+=10;
}
}
    repaint();
  }
    public static void main(String args[])
      {
              new fine();
       }
}
