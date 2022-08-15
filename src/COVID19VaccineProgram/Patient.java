package COVID19VaccineProgram;

public class Patient { 
/** Define the Patient class */
private int id;
private String fName;
private String lName; 
private char gender;
private int age; 
private int phone;
private String city;
private String status;
private int dose_1;
private int dose_2;
public Patient next;

public Patient(int id, String fName, String lName, char gender, int age, int phone, String city, String status, int dose_1, int dose_2, Patient next) {
/** Construct Patient objects */
this.id = id;
this.fName = fName;
this.lName = lName;
this.gender = gender;
this.age = age;
this.phone = phone;
this.city = city;
this.status = status;
this.dose_1 = dose_1;
this.dose_2 = dose_2; 
this.next = next;
}
public int getId() { 
 /** Return the Patient id */
    return id;
}
public void setId(int id) {
 /** set a new id */
    this.id = id;
}
public String getfName() {
 /** Return the Patient first name */
    return fName;
}
 public void setfName(String fName) { 
  /** set a new first name */
     this.fName = fName;
}
public String getlName() { 
  /** Return the Patient last name */
    return lName;
}
public void setlName(String lName) {
    /** set a new last name */
    this.lName = lName;
}
public char getGender() {
 /** Return the Patient gender*/
    return gender;
}
public void setGender(char gender) {
  /** set a new gender */
    this.gender = gender;
}
public int getAge() {
 /** Return the Patient age */
    return age;
}
public void setAge(int age) { 
 /** set a new age */
    this.age = age;
}
public int getPhone() {
 /** Return the Patient phone number */
    return phone;
}
public void setPhone(int phone) {
  /** set a new phone number */
    this.phone = phone;
}
public String getCity() {
 /** Return the Patient city */
    return city;
}

 public void setCity(String city) {
  /** set a new city*/
     this.city = city;
}
public String getStatus() { 
   /** Return the Patient status */
    return status;
}
public void setStatus(String status) { 
    /** set a new status */
    this.status = status;
}
public int getDose_1() { 
  /** Return the Patient first dose if he/she took it or not */
    return dose_1;
}
public void setDose_1(int dose_1) {
 /** set a new dose 1 if he/she took it or not */
    this.dose_1 = dose_1;
}
public int getDose_2() { 
 /** Return the Patient first dose if he/she took it or not */
    return dose_2;
}
public void setDose_2(int dose_2) { 
 /** set a new dose 2 if he/she took it or not */
    this.dose_2 = dose_2;
}
public Patient getNext() { 
    /** Return the Patient next node */
    return next;
}
public void setNext(Patient next) { 
    /** set a new next node*/
    this.next = next;
}
public void printPatient(){
System.out.println("Patient{" + "id=" + id + ", fName=" + fName + ", lName=" + lName + ", gender=" + gender + ", age=" + age + ", phone=" + phone + ", city=" + city + ", status=" + status + ", dose_1=" + dose_1 + ", dose_2=" + dose_2 + '}');

}
@Override
public String toString() {
 /** Return the information of this patient */
String str="\r\nThe Patient ID: "+id;
str+="\r\nThe Patient Name: "+fName+" "+lName; 
str+="\r\nThe Patient Gender: "+gender;
str+="\r\nThe Patient Age: "+age;
str+="\r\nThe Patient phone: "+phone;
str+="\r\nThe Patient city: "+city;
str+="\r\nThe Vaccination Status: "+status;
str+="\r\nThe Vaccination Dose 1: "+dose_1;
str+="\r\nThe Vaccination Dose 2: "+dose_2;
return str;
} 
}
