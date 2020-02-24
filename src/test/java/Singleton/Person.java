package Singleton;

public class Person {
	 String name;
	    int age;
	    private static Person instance;
	    private Person() {
	    }
	    public static Person getInstance() {
	        if (instance == null) {
	            instance = new Person();
	        }
	        return instance;
	    }
	    public void display() {
	        System.out.println("Name: " + name + " age: " + age);
	    }

}


//Singleton pattern applied to AddEmployeePageElements class
//private static AddEmployeePageElements instance;
//
//private AddEmployeePageElements() {
//  PageFactory.initElements(BaseClass.driver, this);
//}
//
//public static AddEmployeePageElements getInstance() {
//  if (instance == null) { //if it has not been create
//      instance = new AddEmployeePageElements();
//  }
//  return instance;
//}
