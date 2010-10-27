package org.webcat.outcomesmeasurement.reports;

import org.webcat.outcomesmeasurement.BasePage;
import org.webcat.outcomesmeasurement.OutcomePairStatistic;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;

@SuppressWarnings("serial")
public class BaseReportsPage extends BasePage {

	public String viewType = "Summary View";
	public boolean summaryView = true;
	public boolean detailView = false;
	public NSMutableArray<OutcomePairStatistic> outcomePairStats;
	public OutcomePairStatistic anOutcomeStat;

	public BaseReportsPage(WOContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public WOComponent setViewToSummary() {
		viewType = "Summary View";
		summaryView = true;
		detailView = false;
		return null;
	}

	public WOComponent setViewToDetail() {
		viewType = "Detailed View";
		summaryView = false;
		detailView = true;
		return null;
	}

	public boolean isSummaryView() { return summaryView; }
	public boolean isDetailView() { return detailView; }
}
