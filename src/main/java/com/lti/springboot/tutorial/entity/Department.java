//The entities are the persistence objects stores as a record in the database.

package com.lti.springboot.tutorial.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
/*
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
*/

/*import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
*/

//The @Entity annotation specifies that the class is an entity and is mapped to a database table
@Entity
/*@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder*/
public class Department {

	//The @Id annotation specifies the primary key of an entity
	//The @GeneratedValue provides for the specification of generation strategies for the values of primary keys.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;
	
	//The @NotBlank annotation uses the NotBlankValidator class, which checks that a character sequence's trimmed length is not empty
	@NotBlank(message = "Please Add Department Name")
	/*
	@Length(max = 5, min = 1)
	@Size(max = 10, min = 0)
	@Email
	@Positive
	@Negative
	@PositiveOrZero
	@NegativeOrZero
	@Future
	@FutureOrPresent
	@Past
	@PastOrPresent
	*/
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	

	
	//Constructor for super class-----
	//when an object of a class is created, its default constructor is automatically called. 
	//To explicitly call the superclass constructor from the subclass constructor, we use super()
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	//constructor using fields----
	//A constructor in Java is similar to a method that is invoked when an object of the class is created. 
	//Unlike Java methods, a constructor has the same name as that of the class and does not have any return type.
	public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentAddress = departmentAddress;
		this.departmentCode = departmentCode;
	}

	//generate getter and setter----
	//Getters and setters are used to protect our data, particularly when creating classes.
	//The get method returns the value of the variable.
	public Long getDepartmentId() {
		return departmentId;
	}

	//The set method takes a parameter and assigns it to the name variable. The this keyword is used to refer to the current object.
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getDepartmentAddress() {
		return departmentAddress;
	}


	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}


	public String getDepartmentCode() {
		return departmentCode;
	}


	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	
	//to-string method----
	//If you want to represent any object as a string, toString() method comes into existence. 
	//The toString() method returns the String representation of the object.
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentAddress=" + departmentAddress + ", departmentCode=" + departmentCode + "]";
	}
}

//What is Lombok. Project Lombok (from now on, Lombok) is an annotation-based Java library that allows you to reduce boilerplate code. Lombok offers various annotations aimed at replacing Java code that is well known for being boilerplate, repetitive, or tedious to write
//Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.

