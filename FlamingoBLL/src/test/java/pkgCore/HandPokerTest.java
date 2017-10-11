package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPokerTest {

	@Test
	public void FourOfAKindTest1() {
		System.out.println("Four of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		
		assertEquals(hp.isFourOfAKind(),true);
		
		System.out.println("");
	}
	
	@Test
	public void FourOfAKindTest2() {
		System.out.println("Four of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.JACK));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.JACK));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.JACK));
		hp.AddCard(new Card(eSuit.SPADES,eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		
		assertEquals(hp.isFourOfAKind(),true);
		
		System.out.println("");
	}
	
	@Test
	public void ThreeOfAKindTest() {
		System.out.println("Three of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		
		assertEquals(hp.isThreeOfAKind(),true);
		
		System.out.println("");
	}
	
	@Test
	public void TwoPairTest() {
		System.out.println("Two Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		
		assertEquals(hp.isTwoPair(),true);
		
		System.out.println("");
	}
	
	@Test
	public void FullHouseTest() {
		System.out.println("Full House");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.ScoreHand();
		
		assertEquals(hp.isFullHouse(),true);
		
		System.out.println("");
	}

	@Test
	public void FlushTest() {
		System.out.println("Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.SEVEN));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.QUEEN));
		hp.ScoreHand();
		
		assertEquals(hp.isFlush(),true);
		
		System.out.println("");
	}
	
	@Test
	public void StraightTest() {
		System.out.println("Straight");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FOUR));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.SIX));
		hp.ScoreHand();
		
		assertEquals(hp.isStraight(),true);
		
		System.out.println("");
	}
	
	@Test
	public void StraightFlushTest() {
		System.out.println("Straight Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.FOUR));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.SIX));
		hp.ScoreHand();
		
		assertEquals(hp.isStraightFlush(),true);
		
		System.out.println("");
	}
	
	@Test
	public void RoyalFlushTest() {
		System.out.println("Straight Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TEN));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.JACK));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.QUEEN));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.KING));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.ACE));
		hp.ScoreHand();
		
		assertEquals(hp.isRoyalFlush(),true);
		
		System.out.println("");
	}
	
	@Test
	public void PairTest() {
		System.out.println("Straight Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TEN));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TEN));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.JACK));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FOUR));
		hp.ScoreHand();
		
		assertEquals(hp.isPair(),true);
		
		System.out.println("");
	}
	
	@Test
	public void HighCardTest() {
		System.out.println("Straight Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TEN));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.JACK));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.EIGHT));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.KING));
		hp.AddCard(new Card(eSuit.SPADES,eRank.TWO));
		hp.ScoreHand();
		
		assertEquals(hp.isHighCard(),true);
		
		System.out.println("");
	}
}
