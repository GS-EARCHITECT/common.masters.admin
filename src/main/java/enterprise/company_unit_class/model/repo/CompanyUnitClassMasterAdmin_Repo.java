package enterprise.company_unit_class.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import enterprise.company_unit_class.model.master.CompanyUnitClassMaster;

@Repository("compUnitClassAdminRepo")
public interface CompanyUnitClassMasterAdmin_Repo extends JpaRepository<CompanyUnitClassMaster, Long> 
{}
