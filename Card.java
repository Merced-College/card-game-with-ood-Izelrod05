//package cardGame;
/*this is the card class which is in charge of all the getter and setter method 
  as well as the printing method and comparing method
 */

public class Card {
//private varibles 
private String cardSuit;
private String cardName;
private int cardValue;
private String cardPicture;


//Constructor

public Card(String cardSuit,String cardName,int cardValue,String cardPicture){

        this.cardSuit = cardSuit;
        this.cardName = cardName;
        this.cardValue = cardValue;
        this.cardPicture = cardPicture; 

}

//getter methods

public String getCardSuit(){
    return cardSuit;
}

public String getCardName(){
    return cardName;
}

public int getCardValue(){
    return cardValue;
}
public String getCardPicture(){
    return cardPicture;
}

//setter methhods 
public void setCardName(String cardName){
    this.cardName = cardName;
}
public void setCardSuit(String cardSuit){
    this.cardSuit = cardSuit;
}
public void setCardValue(int cardValue){
    this.cardValue = cardValue;
}
public void setCardPicture(String cardPicture){
    this.cardPicture = cardPicture;
}
//printing method
public String toString(){
    return cardName + " of " + cardSuit + " (Value: " + cardValue +")" ;
}
//comparing cards method
public boolean equals(Object obj){
    if (obj == null || !(obj instanceof Card)) return false;
    Card other = (Card) obj;
     return this.cardName.equals(other.cardName) &&
        this.cardSuit.equals(other.cardSuit);

}

}
