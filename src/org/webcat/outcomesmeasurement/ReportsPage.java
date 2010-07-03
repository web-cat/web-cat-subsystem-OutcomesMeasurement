package org.webcat.outcomesmeasurement;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

@SuppressWarnings("serial")
public class ReportsPage extends BasePage {
	public BigDecimal excellentCutoff;
	public BigDecimal moderateCutoff;
	
	public String newExcellentCutoff = null;
	public String newModerateCutoff = null;
	
	public NSMutableArray<OutcomePairStatistic> outcomePairStats;
	public OutcomePairStatistic anOutcomeStat;
	
	public NSTimestamp endDate;
	public NSTimestamp startDate;
	
	private NSArray<OutcomePair> allOutcomePairs;
	
	public WOComponent updateCutoffs(){
		calculateOutcomes();
		return null;
	}
	
	public void calculateOutcomes() {
		outcomePairStats = new NSMutableArray<OutcomePairStatistic>();
		if (allOutcomePairs == null)
			allOutcomePairs = OutcomePair.allObjects(localContext());
		if (newExcellentCutoff != null){
			try {
				excellentCutoff = new BigDecimal(newExcellentCutoff);
			} catch (Exception e){
				// do error catching here.
			}
		} else {
			newExcellentCutoff = String.valueOf(excellentCutoff);
		}
		
		if (newModerateCutoff != null){
			try {
				moderateCutoff = new BigDecimal(newModerateCutoff);
			} catch (Exception e){
				// do more error checking here.
			}
		} else {
			newModerateCutoff = String.valueOf(moderateCutoff);
		}
		for (OutcomePair pair : allOutcomePairs){
			OutcomePairStatistic opStat = new OutcomePairStatistic();
			opStat.setOutcomePair(pair);
			NSArray<Coursework> courseworks = pair.courseworks();
			for (Coursework cw : courseworks){
				NSArray<StudentAnswer> answers = cw.studentAnswers();
				for (StudentAnswer answer: answers){
					BigDecimal percent = new BigDecimal(answer.percentEarned());
					if (percent != null){
						percent = percent.multiply(new BigDecimal(100));
						if (percent.compareTo(excellentCutoff) >= 0) opStat.incrementExcellent();
						else if (percent.compareTo(moderateCutoff) >= 0) opStat.incrementModerate();
						else opStat.incrementPoor();
					}
				}
			}
			if (opStat.getTotalNumber() > 0) outcomePairStats.add(opStat);
		}
	}
	
	public ReportsPage(WOContext context) {
        super(context);
    }
    
    static Logger log = Logger.getLogger(ReportsPage.class);
}