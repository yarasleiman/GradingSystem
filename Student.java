
public class Student{
   int number;
   String name;
   String year;
   String section;



public Student(int num, String name, String year, String sec){
    this.number = num;
    this.name = name;
    this.year = year;
    this.section = sec;
}
    
public void setName(String name){
    this.name = name;
}
public void setNumber(int num){
    this.number = num;
}
public void setYear(String year){
    this.year = year;
}
public void setSection(String sec){
    this.section = sec;
}
public String getName(){
    return this.name;
}
public int getNumber(){
    return this.number;
}
public String getYear(){
   return this.year;
}
public String getSection(){
    return this.section;
}
}
