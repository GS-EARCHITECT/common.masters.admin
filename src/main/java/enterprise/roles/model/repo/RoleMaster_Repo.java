package enterprise.roles.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import enterprise.roles.model.master.RoleMaster;

@Repository("roleMasterRepo")
public interface RoleMaster_Repo extends JpaRepository<RoleMaster, Long> 
{}
