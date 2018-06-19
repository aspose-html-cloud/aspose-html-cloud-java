/**
 * --------------------------------------------------------------------------------------------------------------------
 * <copyright company="Aspose" file="DateTime.java">
 *  Copyright (c) 2018 Aspose.HTML for Cloud
 * </copyright>
 * <summary>
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 * </summary>
 * --------------------------------------------------------------------------------------------------------------------
 */


package com.aspose.storage.model;

public class DateTime {
  private Integer Year = null;
  private Integer Month = null;
  private Integer Day = null;
  private Integer Hour = null;
  private Integer Minute = null;
  private Integer Second = null;
  private Integer Millisecond = null;
  private String DayOfWeek = null;
  private Integer DayOfYear = null;
  private String Kind = null;
  private Long Ticks = null;
  private String TimeOfDay = null;
  /**
	 * getYear
	 * Gets Integer
	 * @return Year
	 */
  public Integer getYear() {
    return Year;
  }

	/**
	 * setYear
	 * Sets Integer
	 * @param Year Integer
	 */
  public void setYear(Integer Year) {
    this.Year = Year;
  }

  /**
	 * getMonth
	 * Gets Integer
	 * @return Month
	 */
  public Integer getMonth() {
    return Month;
  }

	/**
	 * setMonth
	 * Sets Integer
	 * @param Month Integer
	 */
  public void setMonth(Integer Month) {
    this.Month = Month;
  }

  /**
	 * getDay
	 * Gets Integer
	 * @return Day
	 */
  public Integer getDay() {
    return Day;
  }

	/**
	 * setDay
	 * Sets Integer
	 * @param Day Integer
	 */
  public void setDay(Integer Day) {
    this.Day = Day;
  }

  /**
	 * getHour
	 * Gets Integer
	 * @return Hour
	 */
  public Integer getHour() {
    return Hour;
  }

	/**
	 * setHour
	 * Sets Integer
	 * @param Hour Integer
	 */
  public void setHour(Integer Hour) {
    this.Hour = Hour;
  }

  /**
	 * getMinute
	 * Gets Integer
	 * @return Minute
	 */
  public Integer getMinute() {
    return Minute;
  }

	/**
	 * setMinute
	 * Sets Integer
	 * @param Minute Integer
	 */
  public void setMinute(Integer Minute) {
    this.Minute = Minute;
  }

  /**
	 * getSecond
	 * Gets Integer
	 * @return Second
	 */
  public Integer getSecond() {
    return Second;
  }

	/**
	 * setSecond
	 * Sets Integer
	 * @param Second Integer
	 */
  public void setSecond(Integer Second) {
    this.Second = Second;
  }

  /**
	 * getMillisecond
	 * Gets Integer
	 * @return Millisecond
	 */
  public Integer getMillisecond() {
    return Millisecond;
  }

	/**
	 * setMillisecond
	 * Sets Integer
	 * @param Millisecond Integer
	 */
  public void setMillisecond(Integer Millisecond) {
    this.Millisecond = Millisecond;
  }

  /**
	 * getDayOfWeek
	 * Gets String
	 * @return DayOfWeek
	 */
  public String getDayOfWeek() {
    return DayOfWeek;
  }

	/**
	 * setDayOfWeek
	 * Sets String
	 * @param DayOfWeek String
	 */
  public void setDayOfWeek(String DayOfWeek) {
    this.DayOfWeek = DayOfWeek;
  }

  /**
	 * getDayOfYear
	 * Gets Integer
	 * @return DayOfYear
	 */
  public Integer getDayOfYear() {
    return DayOfYear;
  }

	/**
	 * setDayOfYear
	 * Sets Integer
	 * @param DayOfYear Integer
	 */
  public void setDayOfYear(Integer DayOfYear) {
    this.DayOfYear = DayOfYear;
  }

  /**
	 * getKind
	 * Gets String
	 * @return Kind
	 */
  public String getKind() {
    return Kind;
  }

	/**
	 * setKind
	 * Sets String
	 * @param Kind String
	 */
  public void setKind(String Kind) {
    this.Kind = Kind;
  }

  /**
	 * getTicks
	 * Gets Long
	 * @return Ticks
	 */
  public Long getTicks() {
    return Ticks;
  }

	/**
	 * setTicks
	 * Sets Long
	 * @param Ticks Long
	 */
  public void setTicks(Long Ticks) {
    this.Ticks = Ticks;
  }

  /**
	 * getTimeOfDay
	 * Gets String
	 * @return TimeOfDay
	 */
  public String getTimeOfDay() {
    return TimeOfDay;
  }

	/**
	 * setTimeOfDay
	 * Sets String
	 * @param TimeOfDay String
	 */
  public void setTimeOfDay(String TimeOfDay) {
    this.TimeOfDay = TimeOfDay;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DateTime {\n");
    sb.append("  Year: ").append(Year).append("\n");
    sb.append("  Month: ").append(Month).append("\n");
    sb.append("  Day: ").append(Day).append("\n");
    sb.append("  Hour: ").append(Hour).append("\n");
    sb.append("  Minute: ").append(Minute).append("\n");
    sb.append("  Second: ").append(Second).append("\n");
    sb.append("  Millisecond: ").append(Millisecond).append("\n");
    sb.append("  DayOfWeek: ").append(DayOfWeek).append("\n");
    sb.append("  DayOfYear: ").append(DayOfYear).append("\n");
    sb.append("  Kind: ").append(Kind).append("\n");
    sb.append("  Ticks: ").append(Ticks).append("\n");
    sb.append("  TimeOfDay: ").append(TimeOfDay).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

