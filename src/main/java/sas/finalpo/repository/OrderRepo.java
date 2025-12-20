package sas.finalpo.repository;

import sas.finalpo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface OrderRepo extends JpaRepository<Order,Long> {
}
