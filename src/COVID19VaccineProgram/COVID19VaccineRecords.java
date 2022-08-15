//18-2-2021
package COVID19VaccineProgram;

public class COVID19VaccineRecords {
 /** Define the COVID19VaccineRecords class */
private Patient headPL;

public COVID19VaccineRecords() {
 /** Construct COVID19VaccineRecords objects */
headPL = null; 
}
public boolean isEmpty() {
  /** method that check if the linkedlist is empty or not */
    return headPL == null;
}
public void insertPatient(int id, String fName, String lName, char gender, int age, int phone, String city) {
headPL = insertPatient(headPL, id,fName,lName,gender,age,phone,city);
}
private Patient insertPatient(Patient headPL, int id, String fName, String lName,char gender, int age, int phone, String city) {
/**Method that insert patient into linkedlist*/
 if (headPL == null ) {
    headPL = new Patient(id,fName,lName,gender,age,phone,city,"Unvaccinated",0,0, headPL);//insert city with default vales 
    return headPL;
}else{
Patient helpPtr = headPL;
while (helpPtr.getNext() != null) {
helpPtr = helpPtr.getNext(); 
}

Patient newPa = new Patient(id,fName,lName,gender,age,phone,city,"Unvaccinated",0,0,helpPtr.getNext ());
helpPtr.setNext(newPa);
 }
return headPL;// return head 
}

public boolean checkPatient( int idNum) {
    return checkPatient(headPL, idNum);
}
private boolean checkPatient(Patient pa, int idNum) { 
  /**Method that check if patient id is found on the linkedList */
 Patient helpPtr = pa;
while (helpPtr != null) {
if (helpPtr.getId() == idNum)
return true;
helpPtr = helpPtr.getNext();//move the helpPtr
}
return false;

 }
public Patient searchPatientByName( String fName,String lName) {
    return searchPatientByName(headPL, fName,lName);
}
private Patient searchPatientByName(Patient pa, String fName,String lName) {
 /**Method that search for patient id in the linkedList */
Patient helpPtr = pa; 
while (helpPtr != null) {
if (helpPtr.getfName().equals(fName) && helpPtr.getlName().equals(lName))
return helpPtr; 
helpPtr = helpPtr.getNext();
}
return null; 
}
public Patient searchPatientById( int id) { 
    return searchPatientById(headPL, id);
}
private Patient searchPatientById(Patient pa, int id) { 
    /**Method that search for patient name in the linkedList */   
    Patient helpPtr = pa;
while (helpPtr != null) {
if (helpPtr.getId()==id)
return helpPtr; 
helpPtr = helpPtr.getNext();
}
return null;//not found
}

public String PrintPatient() {
return PrintPatient(headPL);
}
private String PrintPatient(Patient headPL) {
 /**Method that print patient linkedlist */
headPL = this.reverse(headPL);//reverse the linkedlist
Patient helpPtr = headPL;
String str="";

 while (helpPtr != null) {
   str+="\n --------------------";
str+=helpPtr.toString(); 
str+="\r\n +++++++++++++++\n";
helpPtr = helpPtr.getNext(); 
 }
return str;
}
public Patient reverse(Patient paNode) {
 /**Method that reverse likedlist */
Patient prev = null;//previous
Patient current = paNode; 
Patient next = null;
while (current != null) {
next = current.next;
current.next = prev; 
prev = current; 
current = next;
}
paNode = prev; 
return paNode;
}

public void UpdatePatient(int id,String paCase) { 
    UpdatePatient(headPL, id,paCase);
}
private void UpdatePatient(Patient headPL,int id, String paCase) {
 /**Method that update the patient status*/   
Patient helpPtr = headPL;
while (helpPtr != null) {
if (helpPtr.getId()==id ){
helpPtr.setStatus("Vaccinated"); 
if(paCase.equals("Dose1"))
helpPtr.setDose_1(1); 
if(paCase.equals("Dose2")&&helpPtr.getDose_1()==1) 
  helpPtr.setDose_2(1);
}

 helpPtr = helpPtr.getNext(); //move the helpPtr
}
}

public void delete(String fName,String lName) {
 /**method the delete the patient from the list*/
   if(!isEmpty()){
if (headPL.getfName().equals(fName) && headPL.getlName().equals(lName)) 
headPL = headPL.getNext(); 

else {
Patient helpPtr = headPL;
while (helpPtr.getNext() != null) {
if (helpPtr.getNext().getfName().equals(fName) && helpPtr.getNext().getlName().equals(lName)) {
helpPtr.setNext(helpPtr.getNext().getNext());
break;
}
helpPtr = helpPtr.getNext();//move the helpPtr
}

   }
}
}
}


