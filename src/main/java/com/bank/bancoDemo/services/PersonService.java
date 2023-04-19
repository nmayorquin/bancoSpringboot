package com.bank.bancoDemo.services;
import com.bank.bancoDemo.dto.DtoPerson;
import com.bank.bancoDemo.dto.DtoPersonAll;
import com.bank.bancoDemo.models.dao.ImplePersonDao;
import com.bank.bancoDemo.models.entity.Person;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private ImplePersonDao implePersonaDao;

    @Autowired
    private ModelMapper modelMapper; //MapStruct

    //VOY A USAR ModelMapper que es un stream de java8. La librería facilita el mapeo entre person y dto
    //y me ahorra código porque no tengo que hacer un array con los atributos que se nombran en la clase dto
    /*Este método se encarga de recuperar una lista de objetos Person y luego mapear cada objeto en un objeto DtoPerson utilizando la librería ModelMapper, para finalmente retornar una lista de objetos DtoPerson.

            Ahora, vamos a examinar línea por línea para entender mejor el proceso:

    public List<DtoPerson> findAll() {: Esta línea indica que el método es público, retorna una lista de objetos DtoPerson y se llama findAll().

            List<Person> person = implePersonaDao.findAll();: Aquí se crea una lista de objetos Person llamada "person" y se asigna el resultado de la llamada al método findAll() del objeto implePersonaDao. Este método devuelve una lista de objetos Person que se asigna a la variable "person".

            List<DtoPerson> dtoPerson = person.stream().map: Aquí se crea una nueva lista de objetos DtoPerson llamada "dtoPerson". La lista "person" se convierte en un Stream y se utiliza el método map() para transformar cada objeto de la lista "person" en un objeto DtoPerson. El resultado de esta transformación se almacena en la lista "dtoPerson".

        (persona -> modelMapper.map(person, DtoPerson.class)): Este es el código que se pasa como argumento al método map(). Es una expresión lambda que toma un objeto Persona (llamado "persona" aquí) y utiliza el objeto ModelMapper para mapearlo a un objeto DtoPerson.

.collect(Collectors.toList());: Una vez que se ha terminado de mapear cada objeto de la lista "person" a un objeto DtoPerson, se utiliza el método collect() para recopilar los objetos DtoPerson mapeados en una lista. El método Collectors.toList() se utiliza para crear una lista de los objetos DtoPerson mapeados.

        return dtoPerson;: Finalmente, la lista "dtoPerson" se devuelve como el resultado del método findAll(). Es decir, el método retorna una lista de objetos DtoPerson que se han mapeado desde una lista de objetos Person.
    */
    public List<DtoPersonAll> findAll() {
        List<Person> person = implePersonaDao.findAll();
        List<DtoPersonAll> dtoPersonAll = person.stream()
                .map(persona -> modelMapper.map(persona, DtoPersonAll.class))
                        .collect(Collectors.toList());
        return dtoPersonAll;
    }

    public DtoPerson findById(Long id) {
        Optional<Person> person = implePersonaDao.findById(id);
        if (person.isEmpty()) {
            throw new RuntimeException();
        }
            DtoPerson dtoPerson = modelMapper.map(person.get(), DtoPerson.class);
            return dtoPerson; //INVERSIÓN DE IF PARA PODER RETORNAR UN DTO
    }
    /* Optional<DtoPerson> dtoPerson = person.stream()
             .map(persona -> modelMapper.map(person, DtoPerson.class))
             .filter( idPerson -> idPerson.getIdPersonaIdentify()== id )
             .findFirst(); //filter trae una lista pero se requiere solo un id y por eso se usa el metodo findFirst
     */
    public void save(DtoPersonAll dtoPersonAll){ //paso como parámetro un dto
        Person person = modelMapper.map(dtoPersonAll, Person.class); //quiero transformar un dto a un objeto de tipo entidad
        Optional<Person> personExist = implePersonaDao.findById(dtoPersonAll.getIdPersonaIdentify()); //verificar si existe
        if(personExist.isPresent()){
            throw new RuntimeException("no se puede guardar, usuario ya existe");
        }
        implePersonaDao.save(person);
    }  //va a ser un metodo void porque no necesito retornar al cliente la información que ya ingresó


    public void update(DtoPersonAll dtoPersonAll){
        Person person = modelMapper.map(dtoPersonAll, Person.class);
        Optional<Person> personUpdate = implePersonaDao.findById(dtoPersonAll.getIdPersonaIdentify());
        if(personUpdate.isEmpty()) {
            throw new RuntimeException();
        }
            implePersonaDao.save(person);
    }

    public void delete(Long id) {
        Optional<Person> personDelete = implePersonaDao.findById(id);
        if(personDelete.isEmpty()) {
            throw new RuntimeException();
        }

        implePersonaDao.delete(personDelete.get()); //para extraer el valor de optional uso GET!!!!
    }

}
