package emppayroll;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import model.EmployeePayrollData;
import service.EmployeePayrollService;

public class EmployeePayrollServiceTest {

	@Test
	public void WriteToFile_MatchEmployeeEntries() {
		EmployeePayrollData[] arrayOfEmployee = {
				new EmployeePayrollData(1, "Bill Gates", 1000000.0),
				new EmployeePayrollData(2, "Jeff Bezos", 2000000.0),
				new EmployeePayrollData(3, "Mark Zuckerberg", 3000000.0)
		};
		
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmployee));
		employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
		employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
		
		long entries = ((EmployeePayrollService) employeePayrollService).countEntries(EmployeePayrollService.IOService.FILE_IO);
		Assert.assertEquals(3, entries);
	}
	
	@Test
	public void ReadingFromFile_MatchEmployeeCount() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
		long entries = ((EmployeePayrollService) employeePayrollService).countEntries(EmployeePayrollService.IOService.FILE_IO);
		Assert.assertEquals(3, entries);
	}
}