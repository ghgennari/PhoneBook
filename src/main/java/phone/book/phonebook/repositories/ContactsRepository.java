package phone.book.phonebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import phone.book.phonebook.entities.Contact;

public interface ContactsRepository extends JpaRepository<Contact, Long> {

    
}  
