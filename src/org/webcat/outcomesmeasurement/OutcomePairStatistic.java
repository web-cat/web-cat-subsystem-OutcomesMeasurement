package org.webcat.outcomesmeasurement;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OutcomePairStatistic {
	private int excellentCount = 0;
	private int moderateCount = 0;
	private int poorCount = 0;
	private int totalNumber = 0;
	private int excellentAsPercent = 0;
	private int moderateAsPercent = 0;
	private int poorAsPercent = 0;
	
	private OutcomePair outcomePair;
	
	public int getExcellentCount() {
		return excellentCount;
	}
	public void setExcellentCount(int excellentCount) {
		this.excellentCount = excellentCount;
	}
	public int getModerateCount() {
		return moderateCount;
	}
	public void setModerateCount(int moderateCount) {
		this.moderateCount = moderateCount;
	}
	public int getPoorCount() {
		return poorCount;
	}
	public void setPoorCount(int poorCount) {
		this.poorCount = poorCount;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public OutcomePair getOutcomePair() {
		return outcomePair;
	}
	public void setOutcomePair(OutcomePair outcomePair) {
		this.outcomePair = outcomePair;
	}
	
	public void incrementExcellent(){
		this.excellentCount++;
		this.totalNumber++;
		setExcellentAsPercent();
	}
	public void incrementModerate(){ 
		this.moderateCount++;
		this.totalNumber++;
		setModerateAsPercent();
	}
	public void incrementPoor(){ 
		this.totalNumber++;
		this.poorCount++;
		setPoorAsPercent();
	}
	
	private void setExcellentAsPercent(){
		this.excellentAsPercent = doDivision(this.excellentCount);
	}
	
	private void setModerateAsPercent(){
		this.moderateAsPercent = doDivision(this.moderateCount);
	}
	
	private void setPoorAsPercent(){
		this.poorAsPercent = doDivision(this.poorCount);
	}
	
	public int getExcellentAsPercent(){ return this.excellentAsPercent; }
	public int getModerateAsPercent(){ return this.moderateAsPercent; }
	public int getPoorAsPercent(){ return this.poorAsPercent; }
	
	private int doDivision(int dividend){
		if (this.totalNumber == 0 ) return 0;
		BigDecimal retVal = new BigDecimal(dividend);
		retVal.setScale(0);
		retVal = retVal.multiply(new BigDecimal(100));
		retVal = retVal.divide(new BigDecimal(this.totalNumber), RoundingMode.DOWN);
		return retVal.intValue();
	}
}
