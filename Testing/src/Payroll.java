
public class Payroll {
public static void main(String[] args) {
	
	Employee<Integer> e1 = new Employee<Integer>(1235);
	Employee<String> e2 = new Employee<String>("1234CG");
	System.out.println(e1.empno);
	System.out.println(e2.empno);
	Employee<Boolean> e3 = new Employee<Boolean>(false);
	System.out.println(e3.empno);
}
}
