/*
 * Programmer: Nathan Bougeno  
 * Date: 10/6/2016
 * File: C:\\Desktop\Java_projects\EmployeeApp
 * Desc: Database of employee information
 */
package business;


public class Employee {
    //declare member variables
    private long employeenum;
    private int phone;
    private int paycode;
    private String firstname;
    private String lastname;
    private String middlename;
    private String suffix;
    private String address1;
    private String address2;
    private String email;
    private String city;
    private String state;
    private String zipcode;
    private String gender;
    private String status;
    private String hired;
    private String terminated;
    
    //constructor
    
    public Employee()
    {
        employeenum = 0;
        phone = 0;
        paycode = 0;
        String[] fields = {lastname, firstname, middlename, suffix, address1, address2, city, 
                        state, zipcode, gender, status, hired, terminated};
        
        //initialize
        for (String s:fields)
        {
            s = "";
        }
    }

    public long getEmployeenum() 
    {
        return employeenum;
    }

    public void setEmployeenum(long employeenum) 
    {
        this.employeenum = employeenum;
    }

    public int getPhone() 
    {
        return phone;
    }

    public void setPhone(int phone) 
    {
        this.phone = phone;
    }

    public int getPaycode() 
    {
        return paycode;
    }

    public void setPaycode(int paycode) 
    {
        this.paycode = paycode;
    }

    public String getFirstname() 
    {
        return firstname;
    }

    public void setFirstname(String firstname) 
    {
        this.firstname = firstname;
    }

    public String getLastname() 
    {
        return lastname;
    }

    public void setLastname(String lastname) 
    {
        this.lastname = lastname;
    }

    public String getMiddlename() 
    {
        return middlename;
    }

    public void setMiddlename(String middlename) 
    {
        this.middlename = middlename;
    }

    public String getSuffix() 
    {
        return suffix;
    }

    public void setSuffix(String suffix) 
    {
        this.suffix = suffix;
    }

    public String getAddress1() 
    {
        return address1;
    }

    public void setAddress1(String address1) 
    {
        this.address1 = address1;
    }

    public String getAddress2() 
    {
        return address2;
    }

    public void setAddress2(String address2) 
    {
        this.address2 = address2;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getCity() 
    {
        return city;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getState() 
    {
        return state;
    }

    public void setState(String state) 
    {
        this.state = state;
    }

    public String getZipcode() 
    {
        return zipcode;
    }

    public void setZipcode(String zipcode) 
    {
        this.zipcode = zipcode;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getHired()
    {
        return hired;
    }

    public void setHired(String hired) 
    {
        this.hired = hired;
    }

    public String getTerminated() 
    {
        return terminated;
    }

    public void setTerminated(String terminated) 
    {
        this.terminated = terminated;
    }
           
    
}
