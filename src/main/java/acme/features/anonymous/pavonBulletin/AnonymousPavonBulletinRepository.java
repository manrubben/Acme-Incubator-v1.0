
package acme.features.anonymous.pavonBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.pavonBulletins.PavonBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousPavonBulletinRepository extends AbstractRepository {

	@Query("select s from PavonBulletin s")
	Collection<PavonBulletin> findMany();

}
