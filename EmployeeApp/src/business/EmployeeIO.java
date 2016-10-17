/*
 * Programmer: Nathan Bougeno  
 * Date: 10/6/2016
 * File: C:\\Desktop\Java_projects\EmployeeApp
 * Desc: Database of employee information
 */
package business;

import java.util.Map;
import java.io.*;
import java.util.HashMap;
public class EmployeeIO {
    private static final String [] getMethods = {"getFirstName", "getLastName", "getMiddleName",
           "getSuffix", "getAddress1", "getAddress2", "getCity", "getState", "getZip",
           "getPhone", "getGender", "getStatus", "getHired", "getTerminated"};
    
    public static Map<Long, Employee> getEmployees(String path)
    {
     Map<Long, Employee> emplist = new HashMap<>();   
        
        try
        {
            BufferedReader input = new BufferedReader(new FileReader(path));
            input.readLine();
            String string = input.readLine();
            while(string != null)
            {
                String[] employeedata = string.split(",");
                Employee employee = new Employee();
                long employeeid = Long.parseLong(employeedata[0]);
                employee.setEmployeenum(employeeid);
                
                if(!employeedata[1].isEmpty())
                {
                    employee.setFirstname(employeedata[1]);
                }
                if(!employeedata[2].isEmpty())
                {
                    employee.setLastname(employeedata[2]);
                }
                if(!employeedata[3].isEmpty())
                {
                    employee.setMiddlename(employeedata[3]);
                }
                if(!employeedata[4].isEmpty())
                {
                    employee.setSuffix(employeedata[4]);
                }
                if(!employeedata[5].isEmpty())
                {
                    employee.setAddress1(employeedata[5]);
                }
                if(!employeedata[6].isEmpty())
                {
                    employee.setAddress2(employeedata[6]);
                }
                if(!employeedata[7].isEmpty())
                {
                    employee.setCity(employeedata[7]);
                }
                if(!employeedata[8].isEmpty())
                {
                    employee.setState(employeedata[8]);
                }
                if(!employeedata[9].isEmpty())
                {
                    employee.setZipcode(employeedata[9]);
                }
                if(!employeedata[10].isEmpty())
                {
                    employee.setPhone(Integer.parseInt(employeedata[10]));
                }
                if(!employeedata[11].isEmpty())
                {
                    employee.setGender(employeedata[11]);
                }
                if(!employeedata[12].isEmpty())
                {
                    employee.setStatus(employeedata[12]);
                }
                if(!employeedata[12].isEmpty())
                {
                    employee.setHired(employeedata[12]);
                }
                if(!employeedata[13].isEmpty())
                {
                    employee.setTerminated(employeedata[13]);
                }
                if(!employeedata[14].isEmpty())
                {
                    employee.setPaycode(Integer.parseInt(employeedata[14]));
                }
                if(!employeedata[15].isEmpty())
                {
                    employee.setEmployeenum(Long.parseLong(employeedata[15]));
                }
                emplist.put(employeeid, employee);
                string = input.readLine();
            }
                
        }
        catch(Exception e)
        {
            System.out.println("Error in EmployeeIO class" + e.getMessage());
        }
        return emplist;
    }


}
    
  
