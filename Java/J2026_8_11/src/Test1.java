import java.util.Comparator;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-08-11
 * Time: 16:53
 */
class Card{
    public String suit;//花色
    public int rank;//数值

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", rank=" + rank +
                '}';
    }

    public int CompareTo(Card o) {
        return this.rank-o.rank;
    }
}

class SuitComparator implements Comparator<Card>{

    @Override
    public int compare(Card o1, Card o2) {
        return o1.suit.compareTo(o2.suit);
    }
}

public class Test1 {

    public static void main(String[] args) {
        Card card1=new Card("meihua",15);
        Card card2=new Card("meihua",10);
        if(card1.CompareTo(card2)>0){
            System.out.println("card1>card2");
        }else {
            System.out.println("card1<=card2");
        }

        SuitComparator suitComparator=new SuitComparator();
        if (suitComparator.compare(card1,card2)>0){
            System.out.println("card1>card2");
        }else {
            System.out.println("card1<=card2");
        }
    }

    public static void main1(String[] args) {
        Card card1=new Card("meihua",10);
        Card card2=new Card("meihua",10);
        System.out.println(card1.equals(card2));
    }
}
