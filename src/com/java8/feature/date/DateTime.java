package com.java8.feature.date;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

//http://www.mscharhag.com/2014/02/java-8-datetime-api.html
public class DateTime {

	public static void main(String[] args) {
		// the current date
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);

		// 2014-02-10
		LocalDate tenthFeb2014 = LocalDate.of(2014, Month.FEBRUARY, 10);
		System.out.println(tenthFeb2014);

		// months values start at 1 (2014-08-01)
		LocalDate firstAug2014 = LocalDate.of(2014, 8, 1);
		System.out.println(firstAug2014);

		// the 65th day of 2010 (2010-03-06)
		LocalDate sixtyFifthDayOf2010 = LocalDate.ofYearDay(2010, 65);
		System.out.println(sixtyFifthDayOf2010);

		LocalTime currentTime = LocalTime.now(); // current time
		System.out.println(currentTime);
		LocalTime midday = LocalTime.of(12, 0); // 12:00
		System.out.println(midday);
		LocalTime afterMidday = LocalTime.of(13, 30, 15); // 13:30:15
		System.out.println(afterMidday);

		// 12345th second of day (03:25:45)
		LocalTime fromSecondsOfDay = LocalTime.ofSecondOfDay(12345);
		System.out.println(fromSecondsOfDay);

		// dates with times, e.g. 2014-02-18 19:08:37.950
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println(currentDateTime);

		// 2014-10-02 12:30
		LocalDateTime secondAug2014 = LocalDateTime.of(2014, 10, 2, 12, 30);
		System.out.println(secondAug2014);

		// 2014-12-24 12:00
		LocalDateTime christmas2014 = LocalDateTime.of(2014, Month.DECEMBER,
				24, 12, 0);
		System.out.println(christmas2014);

		// current (local) time in Los Angeles
		LocalTime currentTimeInLosAngeles = LocalTime.now(ZoneId
				.of("America/Los_Angeles"));
		System.out.println(currentTimeInLosAngeles);

		// current time in UTC time zone
		LocalTime nowInUtc = LocalTime.now(Clock.systemUTC());
		System.out.println(nowInUtc);

		LocalDate date = LocalDate.of(2014, 2, 15); // 2014-02-15

		LocalDate.now().isBefore(date); // false

		// information about the month
		Month february = date.getMonth(); // FEBRUARY
		february.getValue(); // 2
		february.minLength(); // 28
		february.maxLength(); // 29
		february.firstMonthOfQuarter(); // JANUARY

		// information about the year
		date.getYear(); // 2014
		date.getDayOfYear(); // 46
		date.lengthOfYear(); // 365
		date.isLeapYear(); // false

		DayOfWeek dayOfWeek = date.getDayOfWeek();
		dayOfWeek.getValue(); // 6
		dayOfWeek.name(); // SATURDAY

		date.getDayOfMonth(); // 15
		date.atStartOfDay(); // 2014-02-15 00:00

		// time information
		LocalTime time = LocalTime.of(15, 30); // 15:30:00
		time.getHour(); // 15
		time.getSecond(); // 0
		time.getMinute(); // 30
		time.toSecondOfDay(); // 55800

		Year currentYear = Year.now();
		Year.of(2000);
		currentYear.isLeap(); // false
		currentYear.length(); // 365

		// sixtyFourth day of 2014 (2014-03-05)
		Year.of(2014).atDay(64);

		// Tomorrow
		LocalDate.now().plusDays(1);

		// before 5 houres and 30 minutes
		LocalDateTime.now().minusHours(5).minusMinutes(30);

		date = LocalDate.of(2014, Month.FEBRUARY, 25); // 2014-02-25

		// first day of february 2014 (2014-02-01)
		date.with(TemporalAdjusters.firstDayOfMonth());

		// last day of february 2014 (2014-02-28)
		date.with(TemporalAdjusters.lastDayOfMonth());

		// last day of 2014 (2014-12-31)
		date.with(TemporalAdjusters.lastDayOfYear());

		// first day of next month (2014-03-01)
		date.with(TemporalAdjusters.firstDayOfNextMonth());

		// next sunday (2014-03-02)
		date.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

		ZoneId losAngeles = ZoneId.of("America/Los_Angeles");
		ZoneId berlin = ZoneId.of("Europe/Berlin");

		// 2014-02-20 12:00
		LocalDateTime dateTime = LocalDateTime.of(2014, 02, 20, 12, 0);

		// 2014-02-20 12:00, Europe/Berlin (+01:00)
		ZonedDateTime berlinDateTime = ZonedDateTime.of(dateTime, berlin);

		// 2014-02-20 03:00, America/Los_Angeles (-08:00)
		ZonedDateTime losAngelesDateTime = berlinDateTime
				.withZoneSameInstant(losAngeles);

		int offsetInSeconds = losAngelesDateTime.getOffset().getTotalSeconds(); // -28800
		System.out.println(offsetInSeconds);

		// a collection of all available zones
		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		System.out.println(allZoneIds);

		// using offsets
		LocalDateTime localDateTime = LocalDateTime.of(2013, Month.JULY, 20, 3,
				30);
		ZoneOffset offset = ZoneOffset.of("+05:00");

		// 2013-07-20 03:30 +05:00
		OffsetDateTime plusFive = OffsetDateTime.of(localDateTime, offset);

		// 2013-07-19 20:30 -02:00
		OffsetDateTime minusTwo = plusFive.withOffsetSameInstant(ZoneOffset
				.ofHours(-2));
		System.out.println(minusTwo);

		// current time
		Instant now = Instant.now();

		// from unix timestamp, 2010-01-01 12:00:00
		Instant fromUnixTimestamp = Instant.ofEpochSecond(1262347200);
		System.out.println(fromUnixTimestamp);

		// same time in millis
		Instant fromEpochMilli = Instant.ofEpochMilli(1262347200000l);
		System.out.println(fromEpochMilli);

		// parsing from ISO 8601
		Instant fromIso8601 = Instant.parse("2010-01-01T12:00:00Z");
		System.out.println(fromIso8601);

		// toString() returns ISO 8601 format, e.g. 2014-02-15T01:02:03Z
		String toIso8601 = now.toString();
		System.out.println(toIso8601);

		// as unix timestamp
		long toUnixTimestamp = now.getEpochSecond();
		System.out.println(toUnixTimestamp);

		// in millis
		long toEpochMillis = now.toEpochMilli();
		System.out.println(toEpochMillis);

		// plus/minus methods are available too
		Instant nowPlusTenSeconds = now.plusSeconds(10);
		System.out.println(nowPlusTenSeconds);

		// periods
		LocalDate firstDate = LocalDate.of(2010, 5, 17); // 2010-05-17
		LocalDate secondDate = LocalDate.of(2015, 3, 7); // 2015-03-07
		Period period = Period.between(firstDate, secondDate);

		period.getDays(); // 18
		period.getMonths(); // 9
		period.getYears(); // 4
		period.isNegative(); // false

		Period twoMonthsAndFiveDays = Period.ofMonths(2).plusDays(5);
		LocalDate sixthOfJanuary = LocalDate.of(2014, 1, 6);

		// add two months and five days to 2014-01-06, result is 2014-03-11
		sixthOfJanuary.plus(twoMonthsAndFiveDays);

		// durations
		Instant firstInstant = Instant.ofEpochSecond(1294881180); // 2011-01-13
																	// 01:13
		Instant secondInstant = Instant.ofEpochSecond(1294708260); // 2011-01-11
																	// 01:11

		Duration between = Duration.between(firstInstant, secondInstant);

		// negative because firstInstant is after secondInstant (-172920)
		between.getSeconds();

		// get absolute result in minutes (2882)
		between.abs().toMinutes();

		// two hours in seconds (7200)
		Duration.ofHours(2).getSeconds();

		// 2014-04-01 10:45
		LocalDateTime dateTimeApril = LocalDateTime.of(2014, Month.APRIL, 1,
				10, 45);

		// format as basic ISO date format (20140220)
		dateTimeApril.format(DateTimeFormatter.BASIC_ISO_DATE);

		// format as ISO week date (2014-W08-4)
		dateTimeApril.format(DateTimeFormatter.ISO_WEEK_DATE);

		// format ISO date time (2014-02-20T20:04:05.867)
		dateTimeApril.format(DateTimeFormatter.ISO_DATE_TIME);

		// using a custom pattern (01/04/2014)
		dateTimeApril.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		// french date formatting (1. avril 2014)
		dateTimeApril.format(DateTimeFormatter.ofPattern("d. MMMM yyyy",
				new Locale("fr")));

		// using short german date/time formatting (01.04.14 10:45)
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(
				FormatStyle.SHORT).withLocale(new Locale("de"));
		dateTimeApril.format(formatter);

		// parsing date strings
		LocalDate.parse("2014-01-20");
		LocalDate.parse("2014-W14-2", DateTimeFormatter.ISO_WEEK_DATE);
		LocalDate
				.parse("20.01.2014", DateTimeFormatter.ofPattern("dd.MM.yyyy"));

		// LocalDate/LocalTime <-> LocalDateTime
		LocalDate localDateNow = LocalDate.now();
		LocalTime timeTimeNow = LocalTime.now();
		LocalDateTime.of(localDateNow, timeTimeNow);
		LocalDateTime.now().toLocalTime();

		// Instant <-> LocalDateTime
		Instant instant = Instant.now();
		LocalDateTime.ofInstant(instant, ZoneId.of("America/Los_Angeles"));
		LocalDateTime.now().toInstant(ZoneOffset.ofHours(-2));

		// convert old date/calendar/timezone classes
		Calendar.getInstance().toInstant();
		TimeZone.getDefault().toZoneId();
		new GregorianCalendar().toZonedDateTime();

		// convert to old classes
		Date.from(Instant.now());
		TimeZone.getTimeZone(ZoneId.of("America/Los_Angeles"));
		GregorianCalendar.from(ZonedDateTime.now());
	}
}
