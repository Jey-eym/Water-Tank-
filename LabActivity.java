package LabAct;

import javax.swing.*;

  abstract class WaterTankProgram{
	  protected int capacity;
	  protected int currentlevel;
	  
	  public WaterTankProgram(int capacity) {
		  this.capacity = capacity;
		  this.currentlevel = 0;		  
	  }
	  public abstract void fillTank(int liters);
	  public abstract void useWater(int liters);
	  public abstract String checkstatus();	  	 
  }
  
  class Home extends WaterTankProgram{
	  public Home() {
		  super(200);
		  
	  }
  @Override
  public void fillTank(int liters) {
	  if(currentlevel + liters >= capacity) {
		  currentlevel = capacity;
		  JOptionPane.showMessageDialog(null,"The Tank is Full" +"\nCurrent Level:" + currentlevel + "/" + capacity);		  
	  }else {
		  currentlevel += liters;
		  JOptionPane.showMessageDialog(null,"Liters Added!!" + "\nCurrent Level:" + currentlevel + "/" + capacity);
		  
	  }
  }
  @Override
  public void useWater(int liters) {
	  if(currentlevel - liters <= 0) {
		  currentlevel = 0;
		  JOptionPane.showMessageDialog(null,"The Tank is now Empty!" + "\nCurrent Level:" + currentlevel + "/" + capacity);		  
	  }else {
		 currentlevel -= liters;
		 JOptionPane.showMessageDialog(null,"Liters Used" + "\nCurrent Level: " + currentlevel + "/" + capacity);
	  }
  }
  @Override
  public String checkstatus() {
  if(currentlevel == 0) return "Empty";
  else if (currentlevel == capacity) return "Full";
  return "The tank is used, it is currently" + currentlevel + "L";
  }
  }
  class Building extends WaterTankProgram {
	  public Building() {
		  super(1000); // capacity 100 liters
	  }
  
  @Override
  public void fillTank(int liters) {
	  if(currentlevel + liters >= capacity) {
		  currentlevel = capacity;
		  JOptionPane.showMessageDialog(null,"The Tank is Full!" + "\nCurrent Level:" + currentlevel + "/" + capacity);
	  }else {
		  currentlevel += liters;
		  JOptionPane.showMessageDialog(null," Liters added!" + "\nCurrent Level: " + currentlevel + "/" + capacity);
		  	  }
  }
  @Override
  public void useWater(int liters) {
	  if (currentlevel - liters <= 0) {
		  currentlevel = 0;
		  JOptionPane.showMessageDialog(null,"The Tank is now Empty!" + "\nCurrent Level: " + currentlevel + "/" + capacity);		 
	  }else {
		  currentlevel -= liters;
		  JOptionPane.showMessageDialog(null,"Liters used!!" + "\nCurrent Level: " + currentlevel + "/" + capacity);		  
	  }
  }
  @Override
  public String checkstatus() {
	  if (currentlevel == 0) return "Water Tank is now Empty!";
	  else if (currentlevel == capacity) return "Water Tank is Full!!";
	  return "The Tank is used, it is currently" + currentlevel + "L";
  }  
  }

public class LabActivity {
	public static void main (String[]args) {
		WaterTankProgram tank = null;
		
		JOptionPane.showMessageDialog(null,"Welcome to the Water Tank Program", "WaterTank Program",JOptionPane.INFORMATION_MESSAGE);
		
		String choose = JOptionPane.showInputDialog("CHOOSE TANK:\n1.) Home Tank (200L)\n2.) Building Tank (1000L)");
		
		if (choose.equals("1")) {
			tank = new Home();
			
		}else if (choose.equals("2")) {
			tank = new Building();		
		}else {
			JOptionPane.showMessageDialog(null,"Invalid Choice! Exiting the program");
			return;
		}
		while(true) {
			String act = JOptionPane.showInputDialog("CHOOSE ACTION:\n1) Fill Tank\n2.) Use Water\n3.) Check Status\n4.) Exit Program");
			if (act.equals("1")) {
				   int lt = Integer.parseInt(JOptionPane.showInputDialog("Enter liters to fill:"));
				   tank.fillTank(lt);				   
			}else if (act.equals("2")) {					
			int lt = Integer.parseInt(JOptionPane.showInputDialog("Enter liters to use:"));
			tank.useWater(lt);
		}else if (act.equals("3")) {
			JOptionPane.showMessageDialog(null,"Tanks Status:" + tank.checkstatus());
		}else if (act.equals("4")){
			JOptionPane.showMessageDialog(null,"Exiting program");
			break;
		}
			if(tank.checkstatus().equals("Full")|| tank.checkstatus().equals("Empty")) {
				JOptionPane.showMessageDialog(null,"Tank is" + tank.checkstatus() + "The program is ended");
				break;
			}
	}
}
}	





