public class HRApplication {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        // Adding employees
        manager.addEmployee("John Doe", "Developer", "123-45-6789", "Full Time", 60000, 40);
        manager.addEmployee("Jane Smith", "Designer", "987-65-4321", "Part Time", 30000, 20);

        // Displaying information of an employee
        String employeeInfo = manager.getEmployeeDetails("123-45-6789");
        System.out.println(employeeInfo);

        // Deleting an employee
        boolean isDeleted = manager.deleteEmployee("987-65-4321");
        if (isDeleted) {
            System.out.println("Employee with SSN 987-65-4321 was deleted.");
        }

        // Attempt to display details of the deleted employee
        System.out.println(manager.getEmployeeDetails("987-65-4321"));
    }
}
