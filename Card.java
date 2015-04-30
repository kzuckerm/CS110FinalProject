 /* Keith Zuckerman
 CS 110
 Homework Assignment 5
 Card class
 */
 
public class Card 
{ 
   //Declares public constants whose values cannot be modified
   public static final char SPADES = 's';         
   public static final char CLUBS = 'c';         
   public static final char HEARTS = 'h';         
   public static final char DIAMONDS = 'd';
   
   public static final int ACE = 14;
   public static final int KING = 13;
   public static final int QUEEN = 12;
   public static final int JACK = 11;
   //Declares private variables
   private final int suit;
   private final int rank;
   
   
   //Constructor method 
   //@param s The suit 
   //@param r The rank          
   public Card(int r, char s)
   {
      suit = s;
      rank = r;      
   }  
   
   //Converts integer rank to a usable String type, and returns value  
   //@return RankStr Rank of the playing card in a usable String type
   public String getRank()
   {  //initializes string
      String RankStr = "0";
     //tests rank and assigns appropriate characters to String RankStr   
     if (rank == 14)
         RankStr = "Ace";
      else if (rank == 2)  
         RankStr = "2";
      else if (rank == 3)
         RankStr = "3";
      else  if (rank == 4)
         RankStr = "4";
      else if (rank == 5)
         RankStr = "5";
      else if (rank == 6)
         RankStr = "6";
      else if (rank == 7)
         RankStr = "7";
      else if (rank == 8)
         RankStr = "8";
      else if (rank == 9)
         RankStr = "9";
      else if (rank == 10)
         RankStr = "10";
      else if (rank == 11)
         RankStr = "Jack";
      else if (rank == 12)
         RankStr = "Queen";
      else 
         RankStr = "King";
      //returns rank stored in string RankStr 
      return RankStr;
   }
   //Creates string for the suit of the card and returns the value 
   public String getSuit()
   {
      String SuitStr = " ";
      if (suit == 's')
         SuitStr = "Spades"; 
      else if (suit == 'c')
         SuitStr = "Clubs";
      else if (suit == 'h')
         SuitStr = "Hearts";
      else 
         SuitStr = "Diamonds";
         
      return SuitStr;
   }   
   
   
      
   //Creates a string to including rank and suit
   //@return The string for the card 
   public String toString()
   {
      //initialize SuitStr and RankStr
      String SuitStr = "0";
      String RankStr = "0";
      //set suit string
      if (suit == 's')
         SuitStr = "s"; 
      else if (suit == 'c')
         SuitStr = "c";
      else if (suit == 'h')
         SuitStr = "h";
      else 
         SuitStr = "d";
      //set rank string
      if (rank == 14)
         RankStr = "ace";
      else if (rank == 2)  
         RankStr = "2";
      else if (rank == 3)
         RankStr = "3";
      else  if (rank == 4)
         RankStr = "4";
      else if (rank == 5)
         RankStr = "5";
      else if (rank == 6)
         RankStr = "6";
      else if (rank == 7)
         RankStr = "7";
      else if (rank == 8)
         RankStr = "8";
      else if (rank == 9)
         RankStr = "9";
      else if (rank == 10)
         RankStr = "10";
      else if (rank == 11)
         RankStr = "jack";
      else if (rank == 12)
         RankStr = "queen";
      else 
         RankStr = "king";
      //return string including rank and suit
      return (RankStr + SuitStr);
      
      }
   //method to test if two cards are the same
    public int compareTo(Card c)
   {
      int check = 2; 
      //tests rank against another cards rank
      if (this.rank == c.rank)
          check = 0; //returns 0 if equal
      else if (this.rank > c.rank)
         check = 1;//returns 1 if greater
      else if (this.rank < c.rank)
         check = -1;//returns -1 if less
      //returns test variable
      return check;
   } 
          
}
