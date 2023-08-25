package resource.resource_master.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import resource.resource_master.model.master.ResourceMaster;

@Repository("resourceMaster_Repo")
public interface ResourceMaster_Repo extends JpaRepository<ResourceMaster, Long> 
{}
