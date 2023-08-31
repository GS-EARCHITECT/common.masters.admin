package enterprise.designations.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import enterprise.designations.model.master.DesignationMaster;

@Repository("designationMasterRepo")
public interface DesignationMaster_Repo extends JpaRepository<DesignationMaster, Long> 
{}
