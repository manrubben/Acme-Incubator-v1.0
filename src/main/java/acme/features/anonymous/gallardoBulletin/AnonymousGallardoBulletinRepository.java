
package acme.features.anonymous.gallardoBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.gallardoBulletins.GallardoBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousGallardoBulletinRepository extends AbstractRepository {

	@Query("select s from GallardoBulletin s")
	Collection<GallardoBulletin> findMany();

}
