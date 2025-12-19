package sas.finalpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sas.finalpo.entity.Item;


@Repository
public interface ItemRepo extends JpaRepository<Item,Long> {
}
