
package acme.features.anonymous.rubioBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.rubioBulletins.RubioBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousRubioBulletinRepository extends AbstractRepository {

	@Query("select s from RubioBulletin s")
	Collection<RubioBulletin> findMany();

}
