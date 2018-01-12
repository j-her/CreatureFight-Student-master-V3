import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Name: Jackson Hercina
 * Course: CS20S
 * Teacher: Mr. Hardman
 * Lab #2, Program #1
 * Date Last Modified: Wednesday, October 25th, 2017 
 * 
 * Lab #2 Mark: 7/10
 * -3 Marks: Indentation issues
 * 
 * 
 * Lab #3 Mark: 1.5/5
 * -1 Marks: Indentation Issues
 * -1 Mark: Excess code that should not be there in the act method of CreatureWorld
 * -0.5 Mark: In Pikachu, super line should have false in it, not true
 * -1 Mark: Comment block was not modified for Lab #3
 *
 */
public class CreatureWorld extends World
{
    private Creature playerOneCreature;
    private Creature playerTwoCreature;
    private boolean playerOneTurn;
    private boolean playerOneMenusAdded;
    private boolean playerTwoMenusAdded;
    private String playerOneName;
    private String playerTwoName;
    private Menu oneFightMenu;
    private Menu oneSwitchMenu;
    private Menu twoFightMenu;
    private Menu twoSwitchMenu;
    private boolean start; 
    /**
     * Default constructor for objects of class MyWorld.
     * 
     * @param There are no parameters
     * @return an object of class MyWorld
     */
    public CreatureWorld()
    {  
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 400, 1); 
        playerOneCreature= new Charmander(this);
        playerTwoCreature= new Pikachu(this);
        prepareCreatures();
        
        start = true;
        Greenfoot.start();
    }
    
    private void prepareCreatures()
    {
        addObject(playerOneCreature, playerOneCreature.getImage().getWidth()/2, getHeight() - playerOneCreature.getImage().getHeight()/2);
        
        addObject(playerTwoCreature, getWidth() - playerTwoCreature.getImage().getWidth()/2, playerTwoCreature.getImage().getHeight()/2);
        
        
    }
    public Creature getPlayerOne()
    {
        return playerOneCreature;
    }
    
    public Creature getPlayerTwo()
    {
        return playerTwoCreature;
    }
    
    public boolean getTurnNumber()
    {
        return playerOneTurn;
    }
    public void setTurnNumber(boolean turn)
    {
        playerOneTurn = turn;
    }
    /**
     * act will complete actions that the CreatureWorld object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        //Improper Indentation
       List allObjects=getObjects(null);
       
       if( start == true)
       {
           //Improper Indentation
          playerOneName = JOptionPane.showInputDialog( "Player One, please enter your name:", null );
          playerTwoName = JOptionPane.showInputDialog( "Player Two, please enter your name:", null );
          
          /**
           * All of this is excess code. That should be deleted.
           * oneFightMenu = new Menu( " Fight ", " Scratch \n Flamethrower ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
           * oneSwitchMenu = new Menu( " Switch ", " Golem \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
           * addObject( oneFightMenu, 173, getHeight() - 100 );
           * addObject( oneSwitchMenu, 241, getHeight() - 100 );
           * twoFightMenu = new Menu( " Fight ", " Tackle \n Thunderbolt ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
           * twoSwitchMenu = new Menu( " Switch ", " Lapras \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
           * addObject( twoFightMenu, 131, 75 );
           * addObject( twoSwitchMenu, 199, 75 );
           */
          playerOneTurn = true;
          
          start = false; 
       }
       else if( playerOneTurn == true)
       {
           showText( playerOneName + " Your turn", getWidth() /2, getHeight() /2);
           showText( "", getWidth() /2, getHeight() /2 + 26 );
       }
       else
       {
           showText( playerTwoName + " Your turn", getWidth() /2, getHeight() /2);
           showText( "", getWidth() /2, getHeight() /2 + 26 );
       }
       
       if( playerOneMenusAdded == false )
       {
           //Improper Indentation
          oneFightMenu = new Menu( " Fight ", " Scratch \n Flamethrower ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
          oneSwitchMenu = new Menu( " Switch ", " Golem \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
          addObject( oneFightMenu, 173, getHeight() - 100 );
          addObject( oneSwitchMenu, 241, getHeight() - 100 );
        
          
        
          playerOneMenusAdded = true;
       }
       
       if( playerTwoMenusAdded == false )
       {
           //Improper Indentation
          twoFightMenu = new Menu( " Fight ", " Tackle \n Thunderbolt ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
          twoSwitchMenu = new Menu( " Switch ", " Lapras \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
          addObject( twoFightMenu, 131, 75 );
          addObject( twoSwitchMenu, 199, 75 );
       
          
             
          playerTwoMenusAdded = true;
       }
      
       //Improper Indentation
        if(playerOneCreature.getHealthBar().getCurrent()<=0)
       {
           //Improper Indentation
            removeObjects(allObjects);
            showText("playerTwo wins...",getWidth()/2,getHeight()/2);
            Greenfoot.stop();
       }
       
       //Improper Indentation
        if(playerTwoCreature.getHealthBar().getCurrent()<=0)
       {
           //Improper Indentation
            removeObjects(allObjects);
            showText("you win!...",getWidth()/2,getHeight()/2);
            Greenfoot.stop();
       }
    }
}
