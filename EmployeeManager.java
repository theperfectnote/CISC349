import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(String fullName, String jobTitle, String ssn, String employeeType, double salaryOrHourlyRate, int hoursPerWeek) {
        employees.add(new Employee(fullName, jobTitle, ssn, employeeType, salaryOrHourlyRate, hoursPerWeek));
    }

    public String getEmployeeDetails(String ssn) {
        for (Employee emp : employees) {
            if (emp.ssn.equals(ssn)) {
                return emp.toString();
            }
        }
        return "Employee not found.";
    }

    public boolean deleteEmployee(String ssn) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.ssn.equals(ssn)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
