package smartphones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smartphones.Entity.Smartphone;

import java.util.List;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {
    public List<Smartphone>
    findByfabricanteStartingWithIgnoreCase(String fabricante);

    public List<Smartphone>
    findBymodeloStartingWithIgnoreCase(String modelo);



}