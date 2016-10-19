/* 
 *Programmer: Nathan Bougeno
 */
package business;


public class Referal {
    public int phone;
    public int date1;
    public int date2;
    public int date3;
    public String firstname;
    public String lastname;
    public String address;
    public String city;
    public String state;
    public String zip;
    
    //constructor
    public Referal()
    {
        phone = 0;
        date1 = 0;
        date2 = 0;
        date3 = 0;
        String[] fields = {firstname, lastname, address, city, state, zip};
        
        for(String string:fields)
        {
            string = "";
        }
    }

    public int getPhone() 
    {
        return phone;
    }

    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    public int getDate1() 
    {
        return date1;
    }

    public void setDate1(int date1) 
    {
        this.date1 = date1;
    }

    public int getDate2() 
    {
        return date2;
    }

    public void setDate2(int date2) 
    {
        this.date2 = date2;
    }

    public int getDate3() 
    {
        return date3;
    }

    public void setDate3(int date3) 
    {
        this.date3 = date3;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) 
    {
        this.address = address;
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

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip) 
    {
        this.zip = zip;
    }
    
    
    
}
