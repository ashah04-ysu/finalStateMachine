/*
What its doing?

In this project a player has to find cars and drive them to his garage.
While drving he checks if the car has enough fuel, if not it drives to gas station
and fills up gas and does the payment
The player parks the car and have food and feel happy about it
The player also sleeps if he wants to
At last he goes back to find cars.
In between tackles all the things like how to do the payment, what to eat, 
garage dorr is open or not and if he is happy about it or not.
*/
package finalstatemachine;
import java.util.*;
/**
 *
 * @author devil
 */
public class FinalStateMachine {
    /**
     * @param args the command line arguments
     */
      
        public static abstract class State {
        protected Scanner input = new Scanner(System.in);
        protected Random random = new Random();
        public State() {}
        public abstract void enter();
        public abstract void exit();
        public abstract int updateAndCheckTransitions();
    }
        
    public static class Driving extends State {     //looks for a car
        public Driving() {
            super();
        }
        public void enter() {
            System.out.println("The Player is looking for a car! ");
        }
        public void exit() {            
            System.out.println("Player is driving! ");
        }
        public int updateAndCheckTransitions() {        
            int light;
            System.out.print("Did the player find a car? (1 or 0) ");
            light = input.nextInt();
            if (light == 0) {
                System.out.println("The player is still looking for a car");
                return 0;
            }
            else {
                return 1;
            } 
        }
    }
    
    public static class Speeding extends State {        //speeds up the car and 
        public Speeding() {                             //decides if the car need fuel                    
            super();
        }
        public void enter() {
            System.out.println("The player is speeding up the car... ");
        }
        public void exit() {            
            System.out.println("The player is driving to the garage...");
        }
        public int updateAndCheckTransitions() { 
            int percent;
            System.out.println("The player is checking the fuel meter...");
            System.out.print("Enter current percentage of fuel in the car:  ");
            percent = input.nextInt();
          
            if (percent < 10) return 3;
            if (percent > 10) return 2;
            else {
                int as = percent - 90;  
                int randomNumber = random.nextInt(20);
                if (randomNumber < as) {
                    return 2;  
                }
                else {
                    return 1;  
                }
            }
        }
    }
    
   public static class FuelUp extends State {           
	private int count; 
        public FuelUp() {
            super();
        }
        public void enter() {
            System.out.println("The player reached the garage!");
        }
        public void exit() {            
            System.out.println("The car is parked!");
        }
        public int updateAndCheckTransitions() {             
            int light, garage;
            System.out.println("The player is driving in...");
            System.out.print("Is the garage door open? 0 for NO, 1 for YES (1 or 0):  ");
            garage = input.nextInt();
            
            if (garage == 0) {
            System.out.println("Opening the Garage door!");
            }
            System.out.print("Does the player wants to park facing front? (1 or 0): ");
            light = input.nextInt();
            
            if (light == 1) 
                System.out.print("Driving in the garage...");    
            if (light == 0)
                System.out.print("Turning the car backwards... ");
            if (count == 3) return 7;
            else return 7;
        }
    }
   
    public static class GasStation extends State {
        public GasStation() {
            super();
        }
        public void enter() {
            System.out.println("The car is acting weird... ");
        }
        public void exit() {            
            System.out.println("Found! The Player is driving to the gas station...");
        }
        public int updateAndCheckTransitions() {        
            int gas;
            System.out.print("Did the player find a Gas Station? (1 or 0) ");
            gas = input.nextInt();
            if (gas == 0) {
                System.out.println("The player needs to fuel up the car...");
                return 3;
            }
            else {
                return 4;
            } 
        }
    }
      
    public static class FuelingUp extends State {
        public FuelingUp() {
            super();
        }
        public void enter() {
            System.out.println("The Player arrived at the gas station... ");
        }
        public void exit() {            
            System.out.println("Payment successful!");
        }
        public int updateAndCheckTransitions() {        
            int payment;
            System.out.print("Where do you wanna pay for the gas?\nHit 1 for Card! \n Hit 0 for Cash!  (1 or 0) ");
            payment = input.nextInt();
            
            if (payment == 0) {
                System.out.println("Insert the cash...");
                return 5;
            }
            else {
                 System.out.println("Insert the card...");
                return 5;
            } 
        }
    }
      
    public static class Thanks extends State {
        public Thanks() {
            super();
        }
        public void enter() {
            System.out.println("Thanks for the payment");
        }
        public void exit() {            
            System.out.println("The fuel tank is full");
        }
        public int updateAndCheckTransitions() {        
            int payment;
            System.out.print("Hit 1 for Premium\n Hit 0 for Regular  (1 or 0) ");
            payment = input.nextInt();
            
            if (payment == 0) {
                System.out.println("The car is fueling up with regular gas");
                return 6;
            }
            else {
                 System.out.println("The car is fueling up with Premium gas...");
                return 6;
            }  
        }
    }
    
    public static class DriveBack extends State {
        public DriveBack() {
            super();
        }
        public void enter() {
            System.out.println("Driving back to the garage");
        }
        public void exit() {            
            System.out.println("Driving back to garage...");
        }
        public int updateAndCheckTransitions() {        
           int payment;
            System.out.print(" Are you happy? Hit 1 for yes 0 for no!");
            payment = input.nextInt();
            
            if (payment == 0) {
                System.out.println("Sorry About that...");
                return 2;
            }
            else {
                 System.out.println("Stay happy.");
              return 2;
            }   
        }
    }
      
    
    public static class Hungry extends State {
        public Hungry() {
            super();
        }
        public void enter() {
            System.out.println("The player walked in to his home...");
        }
        public void exit() {            
            System.out.println("The player is confused...");
        }
        public int updateAndCheckTransitions() {        
           int payment;
            System.out.print(" Are you hungry? (1 or 0) ");
            payment = input.nextInt();
            
            if (payment == 0) {
                System.out.println("What do you wanna do?");
                return 9;
            }
            else {
                 System.out.println("The player is hungry!!!");
              return 8;
            }  
        }
    }  
    
    public static class Food extends State {
        public Food() {
            super();
        }
        public void enter() {
            System.out.println("The player wants to eat something...");
        }
        public void exit() {            
            System.out.println("The player is Happy");
        }
        public int updateAndCheckTransitions() {        
           int payment;
            System.out.print("Hit 1 for Mac & Cheese\n Hit 0 for Cup Cakes! ");
            payment = input.nextInt();
            
            if (payment == 0) {
                System.out.println("The player is eating Cup Cakes...");
                return 9;
            }
            else {
                 System.out.println("The player is eating Mac & Cheese...");
              return 9;
            }  
        }
    } 
    
    public static class Sleep extends State {
        public Sleep() {
            super();
        }
        public void enter() {
            System.out.println("The player is thinking whether he should sleep or go find more cars...");
        }
        public void exit() {            
            System.out.println("Are you awake? Wanna find more cars?");
        }
        public int updateAndCheckTransitions() {        
           int payment;
            System.out.print("Hit 0 to sleep\n Hit 1 to go find more cars...");
            payment = input.nextInt();
            
            if (payment == 0) {
                System.out.println("The player is sleeping...");
                return 0;
            }
            else {
                 System.out.println("The plpayer wants to find more cars...");
              return 0;
            }   
        }
    }
      
        public static void main(String[] args) {
            
        int numberOfStates = 10;              
        State[] states = new State[numberOfStates];

        states[0] = new Driving();              //finds a car
        states[1] = new Speeding();             //speeds up
        states[2] = new FuelUp();               //checks the fuel
        states[3] = new GasStation();           //decides whether to go to gas station or not
        states[4] = new FuelingUp();            //Fuels up the car  
        states[5] = new Thanks();               //Makes the payment 
        states[6] = new DriveBack();            //drives back to the garage
        states[7] = new Hungry();               //get into home decides if he is hungry
        states[8] = new Food();                 //decides what to eat
        states[9] = new Sleep();                //decides to sleep or go find more cars
        
        int currentState = 0;
        int nextState;  

        states[0].enter();
        while(true) {
            nextState = states[currentState].updateAndCheckTransitions();
            if (nextState != currentState) {
                states[currentState].exit();
                currentState = nextState;
                states[currentState].enter();
            }
        }
    }
}