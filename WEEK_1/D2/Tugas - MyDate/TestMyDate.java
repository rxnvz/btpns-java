public class TestMyDate {
    public static void main(String[] args) {
        MyDate my_birth = new MyDate(22, 7, 1964);

        MyDate the_next_week = my_birth.addDays(7); //bikin objek baru dari my_birth, terus ditambahin 7 dengan method addDays
        System.out.println("Add Day my_birth: " + the_next_week);

        my_birth.addMonth(2);
        System.out.println("Add Month my_birth: " + my_birth);
        
        my_birth.addYear(7);
        System.out.println("Add Years my_birth: " + my_birth);
        
        my_birth.minMonth(3);
        System.out.println("Min Month my_birth: " + my_birth);

        my_birth.minDays(3);
        System.out.println("Min from my_birth: " + my_birth);

        // MyDate nextMonth = my_birth.addMonth(2);
        // System.out.println("Add Month my_birth: " + nextMonth);
        
        // MyDate nextYear = my_birth.addYear(7);
        // System.out.println("Add Years my_birth: " + nextYear);
        
        // MyDate monthBefore = my_birth.minMonth(3);
        // System.out.println("Min Month my_birth: " + monthBefore);

        // MyDate daysBefore = my_birth.minDays(3);
        // System.out.println("Min from my_birth: " + daysBefore);
    }
}