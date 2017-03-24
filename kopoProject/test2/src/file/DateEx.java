package file;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateEx {
	public static void main(String[] args) {
		try {
			String date = "2017-03-15";
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date nDate = dateFormat.parse(date);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(nDate);
			
			int dayNum = cal.get(Calendar.DAY_OF_WEEK);
			System.out.println("요일은 :" + dayNum);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
}
