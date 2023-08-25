package service.service_master.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import service.service_master.model.master.ServiceMaster;

@Repository("serviceMasterRepo")
public interface ServiceMaster_Repo extends JpaRepository<ServiceMaster, Long> 
{}
