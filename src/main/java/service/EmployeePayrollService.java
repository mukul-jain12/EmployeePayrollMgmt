package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.EmployeePayrollData;

public class EmployeePayrollService {
	Scanner scanner = new Scanner(System.in);
	public List<EmployeePayrollData> employeePayrollList;
	public enum IOService {CONSOLE_IO, FILE_IO}

	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	public EmployeePayrollService() {
	}

	//main method
	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employePayrollList);
		employeePayrollService.readEmployeePayrollData();
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
	}

	//read employee data from console
	private void readEmployeePayrollData() {
		System.out.println("Enter Employee ID : ");
		int id = scanner.nextInt();
		System.out.println("Enter Employee Name : ");
		String name = scanner.next();
		System.out.println("Enter Employee Salary : ");
		double salary = scanner.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}

	//write employee data in the file
	public void writeEmployeePayrollData(IOService ioService) {
		if (ioService.equals(IOService.CONSOLE_IO))
			System.out.println("\nWriting Employee Payroll Roaster to console\n" + employeePayrollList);
		else if (ioService.equals(IOService.FILE_IO)) {
			new EmployeePayrollFileIOServices().writeData(employeePayrollList);
		}
	}
	
	//count entries in a file
    public long countEntries(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            return new EmployeePayrollFileIOServices().countEntries();
        return 0;
    }
    
    //print the data in the file
    public void printData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOServices().printData();
    }
    
    //reading each line of EmployeePayrollData
    public long readEmployeePayrollData(IOService ioService){
        if (ioService.equals(IOService.FILE_IO))
            this.employeePayrollList = new EmployeePayrollFileIOServices().readData();
        return employeePayrollList.size();
    }
}
