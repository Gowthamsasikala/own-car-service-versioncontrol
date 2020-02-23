package com.ocs.owncarservice.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocs.owncarservice.Entity.Package;

@Repository
public interface PackageRepo extends JpaRepository<Package, String>{

}
