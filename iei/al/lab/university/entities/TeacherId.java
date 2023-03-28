package iei.al.lab.university.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class TeacherId {
	@OneToOne
	@JoinColumn(name = "id_person", referencedColumnName = "id")
	private Person person;

	public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
	
	
}
