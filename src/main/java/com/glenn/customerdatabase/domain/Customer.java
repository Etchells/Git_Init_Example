package com.glenn.customerdatabase.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	// @Entity annotation defines that a class can be mapped to a table.
@Table // @Table annotation defines the class name as Table name. It can be renamed by adding the following @Table(name="new_name")
public class Customer {

	//--------------------------------------------------------Variable---------------------------------------------------
	//
	//							A Java variable is a piece of memory that can contain a data value. 
	//							A variable thus has a data type. Data types are covered in more detail 
	//							in the text on Java data types. Variables are typically used to store 
	//							information which your Java program needs to do its job.
	//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column // @Column annotation defines the column name in the Table. It can be renamed by adding the following @Column(name="new_name")
	private String firstName;
	@Column
	private String lastName;
	@Column
	private int age;
	@Column
	private LocalDate dob;
	@Column
	private String email;
	//-------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------Constructors-------------------------------------------------
	//
	//							A constructor in Java is a block of code similar to a 
	//							method that's called when an instance of an object is created. 
	//							Unlike methods, constructors are not considered members of a class. 
	//							A constructor is called automatically when a new instance of an object is created.
	//
	// Default Constructor
	public Customer() {
		super();
	}

	// All Arguments Constructor
	public Customer(int id, String firstName, String lastName, int age, LocalDate dob, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dob = dob;
		this.email = email;
	}

	// Overloading Constructor with id removed
	public Customer(String firstName, String lastName, int age, LocalDate dob, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dob = dob;
		this.email = email;
	}	
	//-------------------------------------------------------------------------------------------------------------------
	//---------------------------------------------------Getters and Setters---------------------------------------------
	//
	//							Getters and setters are used to protect your data, particularly 
	//							when creating classes. For each instance variable, 
	//							a getter method returns its value while a setter method sets 
	//							or updates its value. Given this, getters and setters are also 
	//							known as accessors and mutators, respectively

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	//-------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------toString---------------------------------------------------
	//
	//							A toString() is an in-built method in Java that returns the value 
	//							given to it in string format. Hence, any object that this method is 
	//							applied on, will then be returned as a string object.
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", dob="
				+ dob + ", email=" + email + "]";
	}
	//-------------------------------------------------------------------------------------------------------------------
	//---------------------------------------------------hashCode and equals---------------------------------------------
	//
	//							A hashcode is an integer value associated with every 
	//							object in Java, facilitating the hashing in hash tables.
	//							The hashcode() method returns the same hash value when called 
	//							on two objects, which are equal according to the equals() method. 
	//							And if the objects are unequal, it usually returns different hash values.
	@Override
	public int hashCode() {
		return Objects.hash(age, dob, email, firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return age == other.age && Objects.equals(dob, other.dob) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName);
	}
	//-------------------------------------------------------------------------------------------------------------------
}
