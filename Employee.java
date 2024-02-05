class Employee {
    String fullName;
    String jobTitle;
    String ssn;
    String employeeType; // Full Time, Part Time, or Contractor
    double salaryOrHourlyRate; // Annual salary for salaried employees, hourly rate for contractors
    int hoursPerWeek; // Relevant for part-time employees and contractors

    public Employee(String fullName, String jobTitle, String ssn, String employeeType, double salaryOrHourlyRate, int hoursPerWeek) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.ssn = ssn;
        this.employeeType = employeeType;
        this.salaryOrHourlyRate = salaryOrHourlyRate;
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public String toString() {
        return "Name: " + fullName + ", Title: " + jobTitle + ", SSN: " + ssn +
               ", Type: " + employeeType + ", Salary/Rate: " + salaryOrHourlyRate +
               ", Hours/Week: " + hoursPerWeek;
    }
}
