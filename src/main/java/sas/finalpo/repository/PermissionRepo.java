package sas.finalpo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sas.finalpo.entity.Permission;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, Long> {
    Permission findByName(String name);
}
