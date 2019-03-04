import java.applet.Applet;
import java.awt.*;



public class Digital_clock extends Applet{

    int h,m,s;
    TextField t1,t2,t3;

    public void init() {
        // TODO Auto-generated method stub
        super.init();
        setSize(100,50);
        h=0;
        m=0;
        s=0;
        setLayout(new BorderLayout());
        Panel p2=new Panel();
        t1=new TextField("0");
        t2=new TextField("0");
        t3=new TextField("0");
        p2.add(t1);
        p2.add(t2);
        p2.add(t3);
        add(p2,BorderLayout.CENTER);
    }

    public void start() {
        // TODO Auto-generated method stub
        super.start();
        time();
    }

    public void paint(Graphics arg0) {
        // TODO Auto-generated method stub
        super.paint(arg0);

        arg0.drawString(String.valueOf(s), 200, 100);
        arg0.drawString(String.valueOf(m), 150, 100);
        arg0.drawString(String.valueOf(h), 100, 100);


        time();
    }

    public void time(){

        try {
            if(s!=59){
                Thread.sleep(1000);
                s+=1;
                t3.setText(String.valueOf(s));
                repaint();
            }
            else{
                if(m==59)
                {
                    m=0;
                    h+=1;
                    t1.setText(String.valueOf(h));
                    repaint();
                }
                else if(h==12)
                {
                    h=1;
                }
                s=0;
                m+=1;
                t2.setText(String.valueOf(m));
                repaint();
            }


        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



}
