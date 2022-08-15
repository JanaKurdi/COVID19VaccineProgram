package COVID19VaccineProgram;

public class CitiesList { 
  /** Define the CitiesList class */
  private CityNode head;
/** Construct CitiesList objects */
public CitiesList() {
head = null; 
}
public boolean isEmpty() { 
/** method check if the linkedlist is empty or not */
    return head == null;//if empty return null
}
 public void insertCity(String cityName, int unvaccinatedCases, int vaccinatedCases) {
head = insertCity(head,cityName,unvaccinatedCases,vaccinatedCases);
}
private CityNode insertCity(CityNode head,String cityName, int nvaccinatedCases, int vaccinatedCases) {
/**Method that insert city into linkedlist*/
if (head == null ) {
head = new CityNode(cityName,0,0, head);//insert city with default vales
return head; 
}
else {
CityNode helpPtr = head;
while (helpPtr.getNext() != null) {
helpPtr = helpPtr.getNext();//move the helpPtr
}
CityNode newCity = new CityNode(cityName,0,1,helpPtr.getNext());
helpPtr.setNext(newCity);
}
return head; // return head
}
public boolean checkCity( String city){ 
return checkCity(head, city);
}
private boolean checkCity(CityNode cityHead, String city) { 
    CityNode helpPtr = cityHead;

 while (helpPtr != null) {
if (helpPtr.getCityName().compareTo(city) == 0)
return true;
helpPtr = helpPtr.getNext();
}
return false;
}
public CityNode findCity( String city) { 
return findCity(head, city);
}
private CityNode findCity(CityNode cityHead, String city) { 
    /**Method that return city name if it is found*/
  CityNode helpPtr = cityHead;
while (helpPtr != null) {
if (helpPtr.getCityName().compareTo(city) == 0)
return helpPtr; 
helpPtr = helpPtr.getNext();
}
return null;
}

public void UpdateNode(String city) {
UpdateNode(head, city); 
}
private void UpdateNode(CityNode head, String data) {
  /**Method that update the number unvaccinated Cases in the city */
CityNode helpPtr = head; 
while (helpPtr != null) {
if (helpPtr.getCityName().compareTo(data)==0)
helpPtr.setUnvaccinatedCases(helpPtr.getUnvaccinatedCases()+1); 
helpPtr = helpPtr.getNext();//move helpPtr
}
} 

public void UpdateNodeVaccation(String city){
UpdateNodeVaccation(head, city);
}
private void UpdateNodeVaccation(CityNode head, String city) {
  /**Method that update the number vaccinated Cases in the city */
CityNode helpPtr = head;
while (helpPtr != null) {
if (helpPtr.getCityName().compareTo(city)==0) {//if they are equals
helpPtr.setUnvaccinatedCases(helpPtr.getUnvaccinatedCases()-1);//decrease the number unaccinated Cases
helpPtr.setVaccinatedCases(helpPtr.getVaccinatedCases()+1);//increase the number Vaccinated Cases
}
helpPtr = helpPtr.getNext();//move the helpPtr
}
}
}




