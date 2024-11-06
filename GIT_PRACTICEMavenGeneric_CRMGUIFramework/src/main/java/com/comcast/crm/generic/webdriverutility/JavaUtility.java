package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	SimpleDateFormat sim;

	public int getRandomNumber() {
		Random ranDom = new Random();

		int ranDomNumber = ranDom.nextInt(5000);
		return ranDomNumber;
	}

	public String getSystemDateYYYYDDMM() {
		Date dateObj = new Date();
		sim = new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dateObj);

		return date;

	}

	public String getRequiredDateYYYYDDMM(int days) {

		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);

		String endDate = sim.format(cal.getTime());
		return endDate;
	}
}
