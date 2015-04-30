/*
Keith Zuckerman
CS 110 - Java
4/30/15
War Game GUI
*/ 


//import the necessary libraries
import java.util.*;
import java.util.Collections;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//extend the JFrame class
public class WarGame extends JFrame
{
   //initialize some panels
   private JPanel battlePanel = new JPanel();
   private JPanel player1Panel = new JPanel();
   private JPanel player2Panel = new JPanel();
   private JPanel winnerPanel = new JPanel();
   //initialize some ImageIcon 
   private ImageIcon back = new ImageIcon("back.jpg");
   private ImageIcon P1Card = new ImageIcon();
   private ImageIcon P1WarDown = new ImageIcon();
   private ImageIcon P1WarUp = new ImageIcon();
   private ImageIcon P2Card = new ImageIcon();
   private ImageIcon P2WarDown = new ImageIcon();
   private ImageIcon P2WarUp = new ImageIcon(); 
   //initialize some labels
   private JLabel player1Card = new JLabel();
   private JLabel player1WarDown = new JLabel();
   private JLabel player1WarUp = new JLabel();
   private JLabel player2Card = new JLabel();
   private JLabel player2WarDown = new JLabel();
   private JLabel player2WarUp = new JLabel();   
   private JLabel deck1 = new JLabel(back);
   private JLabel deck2 = new JLabel(back);   
   private JLabel deck1size = new JLabel(back);
   private JLabel deck2size = new JLabel(back);   
   private JLabel winner = new JLabel();
   //initialize battle button
   private JButton battleButton = new JButton("Battle!");
   //initialize full deck and player decks
   private ArrayList<Card> deck = new ArrayList<Card>();
   private ArrayList<Card> player1 = new ArrayList<Card>();
   private ArrayList<Card> player2 = new ArrayList<Card>();
   //initialize window dimensions
   private final int WINDOW_WIDTH = 1370;
   private final int WINDOW_HEIGHT = 400;
   //initialize compare variable
   private int compare;
   
   public WarGame()
   {
      //set window dimensions
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      //create the deck
      for (int i = 2; i <= 14; i++)
      {
         Card spades = new Card(i, 's');
         Card clubs = new Card(i, 'c');
         Card hearts = new Card(i, 'h');
         Card diamonds = new Card(i, 'd');
         
         deck.add(spades);
         deck.add(clubs);
         deck.add(hearts);
         deck.add(diamonds);
      }
      //shuffle deck
      Collections.shuffle(deck);  

      for (int i = 0; i < deck.size(); i++)
      {    
         if (i < 26)
         {   
            //give player1 half the cards, 
            player1.add(deck.get(i));
         }   
         else
         {   
            //give player1 half the cards, 
            player2.add(deck.get(i));
         }
      }         
   //set deck size label
   deck1size = new JLabel("Player 1 has " + player1.size() + " cards.");
   deck2size = new JLabel("Player 2 has " + player2.size() + " cards.");
   //create button and action listener
   battleButton = new JButton("Battle!");
   battleButton.addActionListener(new PlayerListener());

   //add to the battle panel
   battlePanel.add(deck1size);
   battlePanel.add(battleButton);
   battlePanel.add(deck2size);
   //add players 1 and 2 cards to panel
   player1Panel.add(deck1);
   player1Panel.add(player1Card);
   player1Panel.add(player1WarDown);
   player1Panel.add(player1WarUp);
   player2Panel.add(player2WarUp);
   player2Panel.add(player2WarDown);
   player2Panel.add(player2Card);
   player2Panel.add(deck2);
   winnerPanel.add(winner);
   //set layout, assign panel positions 
   setLayout(new BorderLayout());
   add(battlePanel,BorderLayout.NORTH);
   add(player1Panel,BorderLayout.WEST);
   add(player2Panel,BorderLayout.EAST);
   add(winnerPanel,BorderLayout.SOUTH);
   //make it viewable
   setVisible(true);
   
   }
   //listen for button click
   private class PlayerListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {         
         String action = e.getActionCommand();
       
         try
         {
            //do if battle button is clicked
            if (action.equals("Battle!"))
            {
               //set everything to null
               winner.setText(null);
               player1WarUp.setIcon(null);
               player1WarDown.setIcon(null);
               player2WarUp.setIcon(null);
               player2WarDown.setIcon(null);
               
               //update size label
               deck1size.setText("Player 1 has " + player1.size() + " cards.");
               deck2size.setText("Player 2 has " + player2.size() + " cards.");
               //display cards
               P1Card = new ImageIcon(player1.get(player1.size()-1) + ".jpg"); 
               P2Card = new ImageIcon(player2.get(player2.size()-1) + ".jpg");                
               player1Card.setIcon(P1Card);
               player2Card.setIcon(P2Card);
               //compare cards
               compare = player1.get(player1.size()-1).compareTo(player2.get(player2.size()-1));
               
               if (compare == 1)
               {
                  //if player 1 wins, remove player 2s card and shuffle deck
                  player1.add((player1.size()-1), player2.remove(player2.size()-1));
                  Collections.shuffle(player1);
                  winner.setText("Player 1 won the battle!");

               }      
               
               else if (compare == -1)
               {
                  //if player 2 wins, remove player 1s card and shuffle deck
                  player2.add((player2.size()-1),player1.remove(player1.size()-1));
                  Collections.shuffle(player2);
                  winner.setText("Player 2 won the battle!");

               }
               
               while (compare == 0)
               {
                  //if draw, have a war
                  Collections.shuffle(player1);
                  Collections.shuffle(player2);
                  
                  player1WarDown.setIcon(back);
                  player2WarDown.setIcon(back);
                  
                  P1WarUp = new ImageIcon(player1.get(player1.size()-3) + ".jpg");
                  P2WarUp = new ImageIcon(player2.get(player2.size()-3) + ".jpg");
                  
                  player1WarUp.setIcon(P1WarUp);
                  player2WarUp.setIcon(P2WarUp);
                  
                  
                  //compare new war cards
                  compare = player1.get(player1.size()-3).compareTo(player2.get(player2.size()-3));

                  if (compare == 1)
                  {
                     //if player 1 wins, remove player 2s cards
                     winner.setText("Player 1 won the war!");                     
                     for (int i = 1; i <= 3; i++)
                     player1.add(player2.remove(player2.size()-i));
                  }      
                  
                  else if (compare == -1)
                  {
                     //if player 2 wins, remove player 1s cards
                     winner.setText("Player 2 won the war!");
                     for (int i = 1; i <= 3; i++)
                     player2.add(player1.remove(player1.size()-i));
                  }
               }
            }  
         }      
         //when the game is over, this exception is thrown
         catch (IndexOutOfBoundsException ex)
         {
            //get rid of the button
            battlePanel.remove(battleButton);

            //set some final labels
            if (player1.size() < player2.size())
            {
               winner.setText("Player 2 wins!");
               deck1size.setText("Player 1 has 0 cards.");
               deck2size.setText("Player 2 has 52 cards.");
            }
            
            else if (player1.size() > player2.size())
            {
               winner.setText("Player 1 wins!");
               deck1size.setText("Player 1 has 52 cards.");
               deck2size.setText("Player 2 has 0 cards.");
            }
         }
      }
   }
   
   public static void main(String[] args)
   {
      //create the game, and play!
      WarGame game = new WarGame();
      game.setTitle("Let's Play War!");
      game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}       
           
                  
                  
                  
                  
                  
                  
                     
   