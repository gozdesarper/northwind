package com.example.demo.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //bu veri tabanında oluşacak bir varlık.
@Table(name = "orders") //ben veri tabanındaki employees adlı bir tabloyum.
@Data // getter setter demek. otomatik arka planda oluşturuyor.
@AllArgsConstructor //tüm parametrelere sahip constructor
@NoArgsConstructor // boş parametresiz constructor.



public class Order {
	@Id //Primareykey
	@GeneratedValue(strategy = GenerationType.IDENTITY)//otomatik birer birer arttırıyor.
	@Column(name = "id" )
	private int id;
	
	@Column(name = "date")
	private LocalDate date =LocalDate.now();
	
	@ManyToOne()
	@JoinColumn(name = "employeeId")
	private Employee employee;
	
	


}
