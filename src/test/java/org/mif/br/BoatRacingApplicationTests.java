package org.mif.br;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mif.br.model.Boat;
import org.mif.br.model.Division;
import org.mif.br.repository.BoatRepository;
import org.mif.br.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoatRacingApplicationTests {

    @Autowired
    public DivisionRepository divisionRepository;
    @Autowired
    public BoatRepository boatRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void test_Division_Repository() {
	Division newDivision = new Division();
	newDivision.name = "Деревянко";
	// System.out.println(newBoat.name);
	assert (newDivision.Id == null) : "Oops! An Id somehow exists already.";

	Division savedDivision = divisionRepository.save(newDivision);
	// System.out.println(savedBoat.name);
	assert (savedDivision.Id > 0) : "Nothing was saved";

	Optional<Division> opt = divisionRepository.findById(savedDivision.Id);
	assert (!opt.isEmpty()) : "Nothing was found.";

	Division loadedBoat = opt.get();
	assert (loadedBoat.Id.equals(savedDivision.Id)
		&& loadedBoat.name.equals(savedDivision.name)) : "Nothing was loaded.";

	divisionRepository.delete(savedDivision);

	opt = divisionRepository.findById(savedDivision.Id);
	assert (opt.isEmpty()) : "Nothing was deleted.";
    }

    @Test
    void test_Boat_Repository() {
	Boat newBoat = new Boat();
	newBoat.name = "..беда";
	// System.out.println(newBoat.name);
	assert (newBoat.Id == null) : "Oops! An Id somehow exists already.";

	Boat savedBoat = boatRepository.save(newBoat);
	// System.out.println(savedBoat.name);
	assert (savedBoat.Id > 0) : "Nothing was saved.";

	Optional<Boat> opt = boatRepository.findById(savedBoat.Id);
	assert (!opt.isEmpty()) : "Nothing was found.";

	Boat loadedBoat = opt.get();
	assert (loadedBoat.Id.equals(savedBoat.Id) && loadedBoat.name.equals(savedBoat.name)) : "Nothing was loaded.";

	boatRepository.delete(savedBoat);

	opt = boatRepository.findById(savedBoat.Id);
	assert (opt.isEmpty()) : "Nothing was deleted.";
    }

    @Test
    void test_Relation_Boat_Division() {
	Division newDivision = new Division();
	newDivision.name = "Slowmore";

	Boat newBoat = new Boat();
	newBoat.name = newDivision.name;
	newBoat.division = newDivision;

	Boat savedBoat = boatRepository.save(newBoat);
	assert (savedBoat.Id > 0) : "Nothing was saved";

	Division savedDivision = savedBoat.division;
	assert (savedDivision.Id > 0) : "Nothing was saved cascaded.";

	Optional<Boat> optBoat = boatRepository.findById(savedBoat.Id);
	assert (!optBoat.isEmpty()) : "Nothing was found.";

	Boat loadedBoat = optBoat.get();
	assert (loadedBoat.Id.equals(savedBoat.Id) && loadedBoat.name.equals(savedBoat.name)) : "Nothing was loaded.";

	Division loadedDivision = loadedBoat.division;
	assert (loadedDivision.Id.equals(savedDivision.Id)
		&& loadedDivision.name.equals(savedDivision.name)) : "Nothing was loaded cascaded.";

	boatRepository.delete(savedBoat);

	Optional<Division> optDivision = divisionRepository.findById(loadedDivision.Id);
	assert (!optDivision.isEmpty()) : "Nothing was found.";
	
	Division notDeletedDivision = optDivision.get();
	assert (notDeletedDivision.Id.equals(loadedDivision.Id)
		&& notDeletedDivision.name.equals(loadedDivision.name)) : "Nothing was loaded after cascaded deletion.";
    }
}
