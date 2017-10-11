package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eCardNo;
import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPoker extends Hand {

	private ArrayList<CardRankCount> CRC = null;

	public HandPoker() {
		this.setHS(new HandScorePoker());
	}

	protected ArrayList<CardRankCount> getCRC() {
		return CRC;
	}

	@Override
	public HandScore ScoreHand() {
		// TODO : Implement this method... call each of the 'is' methods (isRoyalFlush,
		// etc) until
		// one of the hands is true, then score the hand

		Collections.sort(super.getCards());
		Frequency();

		if (isRoyalFlush()) {
			return this.getHS();
		} 
		else if (isStraightFlush()) {
			return this.getHS();
		}
		else if (isFourOfAKind()) {
			return this.getHS();
		}
		else if (isFullHouse()) {
			return this.getHS();
		}
		else if (isFlush()) {
			return this.getHS();
		}
		else if (isStraight()) {
			return this.getHS();
		}
		else if (isThreeOfAKind()) {
			return this.getHS();
		}
		else if (isTwoPair()) {
			return this.getHS();
		}
		else if (isPair()) {
			return this.getHS();
		}
		else if (isHighCard()) {
			return this.getHS();
		}
		return null;
	}

	private void Frequency() {

		CRC = new ArrayList<CardRankCount>();

		int iCnt = 0;
		int iPos = 0;

		for (eRank eRank : eRank.values()) {
			iCnt = (CountRank(eRank));
			if (iCnt > 0) {
				iPos = FindCardRank(eRank);
				CRC.add(new CardRankCount(eRank, iCnt, iPos));
			}
		}

		Collections.sort(CRC);

		for (CardRankCount crcount : CRC) {
			System.out.print(crcount.getiCnt());
			System.out.print(" ");
			System.out.print(crcount.geteRank());
			System.out.print(" ");
			System.out.println(crcount.getiCardPosition());
		}

	}

	private int CountRank(eRank eRank) {
		int iCnt = 0;
		for (Card c : super.getCards()) {
			if (c.geteRank() == eRank) {
				iCnt++;
			}
		}
		return iCnt;
	}

	private int FindCardRank(eRank eRank) {
		int iPos = 0;

		for (iPos = 0; iPos < super.getCards().size(); iPos++) {
			if (super.getCards().get(iPos).geteRank() == eRank) {
				break;
			}
		}
		return iPos;
	}

	public boolean isRoyalFlush() {
		boolean bIsRoyalFlush = false;
		HandScorePoker HSP = (HandScorePoker) super.getHS();
		
		if(this.isStraightFlush() == true) {
			if(super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank().getiRankNbr() == 14) {
				
				bIsRoyalFlush = true;
				HSP.seteHandStrength(eHandStrength.RoyalFlush);
				ArrayList<Card> kickers = new ArrayList<Card>();
				HSP.setKickers(kickers);
				super.setHS(HSP);
			}
		}
		return bIsRoyalFlush;
	}

	public boolean isStraightFlush() {
		boolean bisStraightFlush = false;
		HandScorePoker HSP = (HandScorePoker) super.getHS();
		
		if(this.isFlush() == true && this.isStraight() == true){
			
			bisStraightFlush = true;
			HSP.seteHandStrength(eHandStrength.StraightFlush);
			HSP.setHiCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HSP.setLoCard(super.getCards().get(eCardNo.FIFTH.getiCardNo()));
			ArrayList<Card> kickers = new ArrayList<Card>();
			HSP.setKickers(kickers);
			super.setHS(HSP);
		}
		return bisStraightFlush;
	}

	public boolean isFourOfAKind() {
		boolean bisFourOfAKind = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();

		if (super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.FOURTH.getiCardNo()).geteRank()) {

			HS.seteHandStrength(eHandStrength.FourOfAKind);
			HS.setHiCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setLoCard(null);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIFTH.getiCardNo()));
			HS.setKickers(kickers);
			bisFourOfAKind = true;

		} else if (super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.FIFTH.getiCardNo()).geteRank()) {
			HS.seteHandStrength(eHandStrength.FourOfAKind);
			HS.setHiCard(super.getCards().get(eCardNo.SECOND.getiCardNo()));
			HS.setLoCard(null);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setKickers(kickers);
			bisFourOfAKind = true;
		}

		return bisFourOfAKind;
	}

	public boolean isFullHouse() {
		boolean bisFullHouse = false;

		if (this.CRC.size() == 2) {
			if ((CRC.get(0).getiCnt() == 3) && (CRC.get(1).getiCnt() == 2)) {
				bisFullHouse = true;
				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.FullHouse);
				HSP.setHiCard(this.getCards().get(CRC.get(0).getiCardPosition()));
				HSP.setLoCard(this.getCards().get(CRC.get(1).getiCardPosition()));
				ArrayList<Card> kickers = new ArrayList<Card>();
				HSP.setKickers(kickers);
				this.setHS(HSP);
			}
		}
		return bisFullHouse;

	}

	public boolean isFlush() {
		boolean bisFlush = false;

		int iCardCnt = super.getCards().size();
		int iSuitCnt = 0;

		for (eSuit eSuit : eSuit.values()) {
			for (Card c : super.getCards()) {
				if (eSuit == c.geteSuit()) {
					iSuitCnt++;
				}
			}
			if (iSuitCnt > 0)
				break;
		}

		if (iSuitCnt == iCardCnt) {
			bisFlush = true;
			HandScorePoker HSP = (HandScorePoker) super.getHS();
			HSP.seteHandStrength(eHandStrength.Flush);
			super.setHS(HSP);
		}
		else
			bisFlush = false;

		return bisFlush;
	}

	public boolean isStraight() {
		boolean bisStraight = false;
		HandScorePoker HSP = (HandScorePoker) super.getHS();
		
		for(int C = 0;C < super.getCards().size()-1; C++){
			if(super.getCards().get(C).geteRank().getiRankNbr() != 
			super.getCards().get(C+1).geteRank().getiRankNbr()+1){
				break;
			}
			
			bisStraight = true;
			HSP.seteHandStrength(eHandStrength.Straight);
			HSP.setHiCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HSP.setLoCard(super.getCards().get(eCardNo.FIFTH.getiCardNo()));
			ArrayList<Card> kickers = new ArrayList<Card>();
			HSP.setKickers(kickers);
		}
		return bisStraight;
	}

	public boolean isThreeOfAKind() {
		boolean bisThreeOfAKind = false;

		if (this.CRC.size() == 3) {
			if (CRC.get(0).getiCnt() == 3) {
				
				bisThreeOfAKind = true;
				HandScorePoker HSP = (HandScorePoker)this.getHS();
				HSP.seteHandStrength(eHandStrength.ThreeOfAKind);
				HSP.setHiCard(this.getCards().get(CRC.get(0).getiCardPosition()));
				HSP.setLoCard(null);
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);
			}
		}
		return bisThreeOfAKind;
	}
	
	private ArrayList<Card> FindTheKickers(ArrayList<CardRankCount> CRC)
	{
		ArrayList<Card> kickers = new ArrayList<Card>();
		
		for (CardRankCount crcCheck: CRC)
		{
			if (crcCheck.getiCnt() == 1)
			{
				kickers.add(this.getCards().get(crcCheck.getiCardPosition()));
			}
		}
		
		return kickers;
	}

	public boolean isTwoPair() {
		boolean bisTwoPair = false;
		
		if (this.CRC.size() == 3) {
			if (CRC.get(0).getiCnt() == 2 && CRC.get(1).getiCnt() == 2) {
				 
				bisTwoPair = true;
				HandScorePoker HSP = (HandScorePoker)this.getHS();
				HSP.seteHandStrength(eHandStrength.TwoPair);
				HSP.setHiCard(this.getCards().get(CRC.get(0).getiCardPosition()));
				HSP.setLoCard(this.getCards().get(CRC.get(1).getiCardPosition()));
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);
			}
		}
		return bisTwoPair;
	}

	public boolean isPair() {
		boolean bisPair = false;
		
		if (this.CRC.size() == 4) {
			if (CRC.get(0).getiCnt() == 2) {
				
				bisPair = true;
				HandScorePoker HSP = (HandScorePoker)this.getHS();
				HSP.seteHandStrength(eHandStrength.Pair);
				HSP.setHiCard(this.getCards().get(CRC.get(0).getiCardPosition()));
				HSP.setLoCard(null);
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);
			}
		}
		return bisPair;
	}

	public boolean isHighCard() {
		boolean bisHighCard = false;
		
		if (this.CRC.size() == 5) {
			
			bisHighCard = true;
			HandScorePoker HSP = (HandScorePoker)this.getHS();
			HSP.seteHandStrength(eHandStrength.HighCard);
			HSP.setHiCard(this.getCards().get(CRC.get(0).getiCardPosition()));
			HSP.setLoCard(null);
			HSP.setKickers(FindTheKickers(this.getCRC()));
			this.setHS(HSP);
		}
		return bisHighCard;
	}

}
