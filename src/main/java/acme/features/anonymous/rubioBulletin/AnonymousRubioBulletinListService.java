
package acme.features.anonymous.rubioBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.rubioBulletins.RubioBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousRubioBulletinListService implements AbstractListService<Anonymous, RubioBulletin> {

	// Internal state ----------------------------------------------------------

	@Autowired
	AnonymousRubioBulletinRepository repository;


	// AbstractListService<Anonymous, Shout> interface --------------------

	@Override
	public boolean authorise(final Request<RubioBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<RubioBulletin> findMany(final Request<RubioBulletin> request) {
		assert request != null;

		Collection<RubioBulletin> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<RubioBulletin> request, final RubioBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "link");
	}

}
