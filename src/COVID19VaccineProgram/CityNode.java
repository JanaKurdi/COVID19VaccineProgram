package COVID19VaccineProgram;

public class CityNode {
 /** Define the CityNode class */
private String cityName; 
private int unvaccinatedCases; 
private int vaccinatedCases;
public CityNode next;

public CityNode(String cityName, int unvaccinatedCases, int vaccinatedCases, CityNode next) {
/** Construct CityNode objects */
this.cityName = cityName;
this.unvaccinatedCases = unvaccinatedCases;
this.vaccinatedCases = vaccinatedCases;
this.next = next;
}
public String getCityName() { 
 /** Return the city name */
    return cityName;
}
public void setCityName(String cityName) {
   /** set a new city name */
    this.cityName = cityName;
}
public int getUnvaccinatedCases() {
  /** Return the unvaccinated Cases */
    return unvaccinatedCases;
}
public void setUnvaccinatedCases(int unvaccinatedCases) { 
    /** set a new unvaccinated Cases */
    this.unvaccinatedCases = unvaccinatedCases;
}
public int getVaccinatedCases() {
  /** Return the vaccinated Cases */
    return vaccinatedCases;
}
public void setVaccinatedCases(int vaccinatedCases) { 
   /** set a new vaccinated Cases */
    this.vaccinatedCases = vaccinatedCases;
}
public CityNode getNext() { 
  /** Return the next node */
    return next;
}
public void setNext(CityNode next) {
   /** set a new next node */
    this.next = next;
}
@Override
public String toString() {
  /** Return the information of this city */
return "CityNode{" + "cityName=" + cityName + ", unvaccinatedCases=" + unvaccinatedCases + ", vaccinatedCases=" + vaccinatedCases + '}';
}
}
