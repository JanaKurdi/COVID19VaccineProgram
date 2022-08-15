//18-2-2021
package COVID19VaccineProgram;
import java.io.*; // for files
import java.util.*; // for Scanner
public class COVID19VaccineProgram {
    
public static void main(String[] args) throws Exception {
     /** Main method */
   File inFile = new File("Input.txt");//create file instace
   if(!inFile.exists()){//check if the files are exists or not
  System.out.println("File is Not Found"); 
  System.exit(0);
  }

Scanner input = new Scanner(inFile);//create a Scanner for input file
PrintWriter output = new PrintWriter("Output.txt");//create file output

/** Declare linkedlists */
  COVID19VaccineRecords patienRec=new COVID19VaccineRecords(); 
  CitiesList citiesList=new CitiesList();

 int k = input.nextInt(); //29 in inFile
 String command =null;
for (int i = 0; i < k; i++) { 
    command=input.next();//read from inFile
    
 if(command.matches("ADD_PATIENT")) {
    /**Command #1 */
  output.println("Perform an ADD_PATIENT operation"); 
  String patient[]=input.nextLine().split("\\s");

 if(patient.length<8)//entered data are not completed
  output.println("Instruction (ADD_PATIENT) needs 7 parameters");//patient need 7 parameter

  else if(patienRec.checkPatient(Integer.parseInt(patient[1])))//check that patient is already there or not
    output.println("The patient "+patient[2]+" "+patient[3]+" is already registered!");

 else{
  patienRec.insertPatient(Integer.parseInt(patient[1]), patient[2], patient[3],patient[4].charAt(0),Integer.parseInt(patient[5]), Integer.parseInt(patient[6]),patient[7]);//inser new patient
  if(!citiesList.checkCity(patient[7]))//check if the city already there or not
  citiesList.insertCity(patient[7], 1, 0); //if not insert the new city
 else 
  citiesList.UpdateNode(patient[7]);
 output.println("The patient "+patient[2]+" "+patient[3]+" is registered!");
}
output.println(" --------------------");
}

  if(command.equals("UPDATE_VACCINE")) {
      /**Command #2 */
  int idnum=input.nextInt();//id number
 String vaccDose=input.next();//vaccine dose

 output.println("Perform an UPDATE_VACCINE operation"); 

  if(!patienRec.checkPatient(idnum))//check if the patient regidted or not
  output.println("The patient (ID#"+idnum+") is not registered"); //if not 

 else {
 Patient patient=patienRec.searchPatientById(idnum); //search for the patient using the id
  if(vaccDose.equals("Dose1") && patient.getDose_1()==1)//if she/he took the first dose
  output.println("The patient (ID#"+idnum+") already received Dose1 of the vaccine"); 

  else if(vaccDose.equals("Dose2") && patient.getDose_1()==0)//if she/he did not take the first dose
   output.println("The patient (ID#"+idnum+") must take the Dose 1 first");//she/he must take dose 1 first
  else
  if(vaccDose.equals("Dose1"))
  output.println("The patient (ID#"+idnum+") received Dose1 of the vaccine");
 else
  output.println("The patient (ID#"+idnum+") received Dose2 of the vaccine");

 if(patient.getStatus().equals("unvaccianed"))
 citiesList.UpdateNodeVaccation(patient.getCity());
  patienRec.UpdatePatient(idnum, vaccDose); 
}
output.println(" --------------------");
} 

  if(command.equals("FIND_By_NAME")) {
   /**Command #3 */
  output.println("Perform a FIND_By_NAME operation"); 
  String fName=input.next();//first name
  String lName=input.next();//last name
  Patient patient=patienRec.searchPatientByName(fName,lName);//seach for the patient using her/his name

  if(patient==null)//if not found
  output.println("The patient: "+fName+" "+lName+" is not registered");
  else {//if found print the information
  output.println("The patient: "+fName+" "+lName+" is registered"); 
  output.println("The Patient ID: "+patient.getId());
  output.println("The Patient Name: "+patient.getfName()+" "+patient.getlName()); 
  output.println("The Patient City: "+patient.getCity());
  output.println("The Vaccination Status: "+patient.getStatus());
} 
  output.println(" --------------------");
}

if(command.equals("FIND_By_ID")) {
    /**Command #4 */
  output.println("Perform a FIND_By_ID operation");
  String patient[]=input.nextLine().split("\\s"); 
 if(patient.length<2)
  output.println("Instruction (FIND_By_ID) needs 1 parameter");//to find by id it need the id 
 else {
  int idNum=Integer.parseInt(patient[1]);
  Patient pa=patienRec.searchPatientById(idNum);//search for the patient using id 
  if(pa==null)//not found
  output.println("The patient: ID#"+idNum+" is invalid");
else {//if found print the information
output.println("The patient: (ID#"+idNum+") is registered"); 
output.println("The Patient Name: "+pa.getfName()+" "+pa.getlName()); 
output.println("The Patient City: "+pa.getCity());
output.println("The Vaccination Status: "+pa.getStatus());
}
}
output.println(" --------------------");
}

if(command.equals("DELETE_PATIENT")) {
    /**Command #5 */
output.println("Perform a DELETE_PATIENT operation"); 
String patient[]=input.nextLine().split("\\s");
if(patient.length<3)
output.println("Instruction (DELETE_PATIENT) needs 2 parameters");//to delete patient you need to write first and last name
else {
String fName=patient[1];
String lName=patient[2];
Patient p1=patienRec.searchPatientByName(fName,lName);//seach for the patient using her/his name
if(p1==null)//if not found
output.println("The patient: "+fName+" "+lName+" is not registered!");//she\he did not registed
else if(p1.getStatus().equals("Vaccinated"))
output.println("The patient "+fName+" "+lName+" received the vaccine and he/she can't deleted from the system!");
else {
patienRec.delete(fName,lName);//delete the name from the list
output.println("The patient "+fName+" "+lName+" is deleted!");
}
}
output.println(" --------------------");
} 

if(command.equals("PRINT_RECORD")) {
    /**Command #6 */
output.println("Perform a PRINT_RECORD operation"); 
String fName=input.next();
String lName=input.next();
Patient patient=patienRec.searchPatientByName(fName,lName);

if(patient==null)
output.println("The patient: "+fName+" "+lName+" is not registered!");

 else {
output.println(" --------------------");
output.println("The Patient ID: "+patient.getId());
output.println("The Patient Name: "+patient.getfName()+" "+patient.getlName());
output.println("The Patient Gender: "+patient.getGender());
output.println("The Patient Age: "+patient.getAge());
output.println("The Patient phone: "+patient.getPhone());
output.println("The Patient City: "+patient.getCity());
output.println("The Vaccination Status: "+patient.getStatus()); 
output.println("The Vaccination Dose 1: "+patient.getDose_1()); 
output.println("The Vaccination Dose 2: "+patient.getDose_2());
output.println(" +++++++++++++++\n");
}

 }

if(command.equals("PRINT_CITY")) { 
        /**Command #7 */
    output.println(" --------------------");
    output.println("Perform a PRINT_CITY operation");

String patient[]=input.nextLine().split("\\s");
if(patient.length<3)
output.println("Instruction (PRINT_CITY) needs 2 parameters"); 
else {
String CityName=patient[1]; 
String vaccCiyt=patient[2];

CityNode city=citiesList.findCity(CityName);
output.println("The city: "+CityName); 
if(vaccCiyt.equals("Vaccinated"))
output.println("The Vaccinated cases:"+city.getVaccinatedCases()+" cases");
else
output.println("The Unvaccinated cases:"+city.getUnvaccinatedCases()+" cases");
}
}

if(command.equals("FIND_CITY")) {
    /**Command #8 */
     output.println(" --------------------");
   output.println("FIND_CITY no such operation"); 
   output.println(" --------------------");
}
if(command.equals("PRINT_ALL")) { 
    /**Command #9 */
output.println("Perform a PRINT_ALL operation");
output.print(" ========================="); 
output.println(patienRec.PrintPatient());
} 
}
output.println("End");
output.close();
input.close(); 
}
}
 
        
        
        
        
        
        
        
        
        
        
        
        
 