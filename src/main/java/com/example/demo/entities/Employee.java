package com.example.demo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //bu veri tabanında oluşacak bir varlık.
@Table(name = "employees") //ben veri tabanındaki employees adlı bir tabloyum.
@Data // getter setter demek. otomatik arka planda oluşturuyor.
@AllArgsConstructor //tüm parametrelere sahip constructor
@NoArgsConstructor // boş parametresiz constructor.



public class Employee {
	@Id //Primareykey
	@GeneratedValue(strategy = GenerationType.IDENTITY)//otomatik birer birer arttırıyor.
	@Column(name = "id" )
	private int id;
	
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "salary")
	private double salary;
	
	@OneToMany(mappedBy = "employee")//mapped her bir employee listeye ekliyor.
	List<Order> orders ;
	


}
