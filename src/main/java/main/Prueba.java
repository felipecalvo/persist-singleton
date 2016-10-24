package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pruebas")
public class Prueba {
	
	@Id
	@GeneratedValue
	private Long id;
	
	int hola = 3;
	
	public Long getId(){
		return id;
	}
}
