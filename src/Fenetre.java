import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.lang.Math;

public class Fenetre extends JFrame{
	
	Plateau plat = new Plateau(127, 72);	
	
	public Fenetre()
	{
		this.setVisible(true);
		
		this.setTitle("Game Of Life");
		
		this.setSize(1280, 720);
		this.setResizable(false);
		
		this.setLocationRelativeTo(null);
		
	    JPanel pan = new JPanel();

	    pan.setBackground(Color.gray);        

	    this.setContentPane(pan);   
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
	}
	
	public void draw(int n)
	{
		long now = System.currentTimeMillis(), delta;
		
		while(true)
		{
			this.setContentPane(plat);
			plat.nextGeneration();
			
			delta = -now + (now = System.currentTimeMillis());
		    if(delta < n)
		    {
		        try 
		        {
		            Thread.sleep(n - delta);
		            now += n - delta;
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    }
		}
	}

}
