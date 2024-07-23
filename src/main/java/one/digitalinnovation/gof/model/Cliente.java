package one.digitalinnovation.gof.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cliente extends Pessoa{


    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}


}
