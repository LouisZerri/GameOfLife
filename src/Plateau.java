import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
 
public class Plateau extends JPanel {
	
	boolean plateau[][];
	int ligne;
	int colonne;
	
	public Plateau(int l_, int c_)
	{
		this.ligne = l_;
		this.colonne = c_;
		int value;
		
		plateau = new boolean[this.ligne][this.colonne];
		
		for(int i = 0; i < this.ligne; i++)
		{
			for(int j = 0; j < this.colonne; j++)
			{
				value = (int) (Math.random() * 101);
				if(value % 2 == 0)
				{
					plateau[i][j] = true;
				}
				else
				{
					plateau[i][j] = false;
				}
			}
		}
	}
	
	public int getPosition(boolean[][] plateau, int x, int y)
	{
		plateau = this.plateau;
		
		if(x > 0 && x < this.ligne && y > 0 && y < this.colonne)
		{
			if(plateau[x][y])
			{
				return 1;
			}
		}
		
		return 0;
	}
	
	public boolean[][] nextGeneration()
	{
		boolean[][] buffer = new boolean[this.ligne][this.colonne];
		
		for(int i = 0; i < this.ligne; i++)
		{
			for(int j = 0; j < this.colonne; j++)
			{
				int c = 0;
				c += getPosition(this.plateau, i, j + 1);
	       		c += getPosition(this.plateau, i, j - 1);
	       		c += getPosition(this.plateau, i + 1, j);
	       		c += getPosition(this.plateau, i - 1, j);
	       		c += getPosition(this.plateau, i + 1, j - 1);
	       		c += getPosition(this.plateau, i - 1, j + 1);
	       		c += getPosition(this.plateau, i + 1, j + 1);
	       		c += getPosition(this.plateau, i - 1, j - 1);
	       		
	       		buffer[i][j] = this.plateau[i][j];
	       		
	       		if(!buffer[i][j] && c == 3)
	       		{
	       			buffer[i][j] = true;
	       		}
	       		else if(buffer[i][j] && (c < 2 || c > 3))
	       		{
	       			buffer[i][j] = false;
	       		}
			}		
		}
		
		plateau = buffer;
		
		return plateau;
		
	}
	
	public void show(Graphics g)
	{
		for(int i = 0; i < this.ligne; i++)
		{
			for(int j = 0; j < this.colonne; j++)
			{
				if(plateau[i][j])
				{
					
					g.fillRect(i*10, j*10, 10, 10);
				}
				else
				{
					g.drawRect(i*10, j*10, 10, 10);
				}
			}
		}
	}
	
  public void paintComponent(Graphics g)
  {
	  this.show(g);
  }               
}