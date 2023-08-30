package enterprise.company_class.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import enterprise.company_class.model.master.CompanyClassMaster;

@Repository("compClassAdminRepo")
public interface CompanyClassMasterAdmin_Repo extends JpaRepository<CompanyClassMaster, Long> 
{}
