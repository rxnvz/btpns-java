public class MyDate {
 		private int day = 1;
 		private int month = 1;
 		private int year = 2000;
	
 		public MyDate(int day, int month, int year) {
 			this.day = day;
 			this.month = month;
 			this.year = year;
 		}
 		public MyDate(MyDate date) {
 			this.day = date.day;
 			this.month = date.month;
 			this.year = date.year;
        }
         
        public void setDay(int newDay) {
            this.day = newDay;
        }

 		public MyDate addDays(int moreDays) {
 			MyDate newDate = new MyDate(this);
 			newDate.day = newDate.day + moreDays;
 			// Not Yet Implemented: wrap around code...
 			return newDate;
        }
        
        public void addMonth(int moreMonths) {
            this.month = this.month + moreMonths;
        }
        public void addYear(int moreYears) {
            this.year = this.year + moreYears;
        }
        public void minDays(int minDays) {
            this.day = this.day - minDays;
        }
        public void minMonth(int minMonth) {
            this.month = this.month - minMonth;
        }

        // public MyDate addMonth(int moreMonths) {
        //     MyDate newMonth = new MyDate(this);
        //     newMonth.month = newMonth.month + moreMonths;
        //     return newMonth;
        // }
        // public MyDate addYear(int moreYears) {
        //     MyDate newYear = new MyDate(this);
        //     newYear.year = newYear.year + moreYears;
        //     return newYear;
        // }
        // public MyDate minDays(int minDays) {
        //     MyDate newDays = new MyDate(this);
        //     newDays.day = newDays.day - minDays;
        //     return newDays;
        // }
        // public MyDate minMonth(int minMonths) {
        //     MyDate newMonth = new MyDate(this);
        //     newMonth.month = newMonth.month + minMonths;
        //     return newMonth;
        // }


        public String toString() {
            String retString = "" + day + "-" + month + "-" + year;
            return retString;
 		}
 	}
