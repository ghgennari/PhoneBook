package phone.book.phonebook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import phone.book.phonebook.entities.Contact;
import phone.book.phonebook.repositories.ContactsRepository;

@Service
public class ContactsService {
    
    @Autowired
    private ContactsRepository repository;

    public List<Contact> getAll(){
        return repository.findAll();
    }

    public Contact save(Contact contacts){
        return repository.save(contacts);
    }

    public void update(Contact contacts, Long id){
        Contact aux = repository.getReferenceById(id);

        aux.setName(contacts.getName());
        aux.setTelephone(contacts.getTelephone());
        aux.setEmail(contacts.getEmail());
        aux.setAddress(contacts.getAddress());
        aux.setBirthDate(contacts.getBirthDate());
        aux.setCategory(contacts.getCategory());
        aux.setFavorite(contacts.isFavorite());
        aux.setNotes(contacts.getNotes());
        aux.setPhotoUrl(contacts.getPhotoUrl());

        repository.save(aux);
    }

    public void delete(long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Contato não encontrado");
        }
    }

}
