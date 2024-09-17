package br.com.codecompany.rysys.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static final Date firstTimeOfDay(Calendar calendar) {
		Calendar start = Calendar.getInstance();
		start.set(Calendar.AM_PM, Calendar.AM);
		start.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
		start.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		start.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.SECOND, 0);
		start.set(Calendar.MILLISECOND, 0);
		
		return start.getTime();
	}
	
	public static final Date lastTimeOfDay(Calendar calendar) {
		Calendar end = Calendar.getInstance();
		end.set(Calendar.AM_PM, Calendar.PM);
		end.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
		end.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		end.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
		end.set(Calendar.HOUR_OF_DAY, 23);
		end.set(Calendar.MINUTE, 59);
		end.set(Calendar.SECOND, 59);
		end.set(Calendar.MILLISECOND, 999);	
		
		return end.getTime();
	}
}
