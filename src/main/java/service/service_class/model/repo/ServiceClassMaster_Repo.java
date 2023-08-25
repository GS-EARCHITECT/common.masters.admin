package service.service_class.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service.service_class.model.master.ServiceClassMaster;

@Repository("serviceClassMasterRepo")
public interface ServiceClassMaster_Repo extends JpaRepository<ServiceClassMaster, Long> 
{}
