
package acme.features.anonymous.pavonBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.pavonBulletins.PavonBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousPavonBulletinListService implements AbstractListService<Anonymous, PavonBulletin> {

	// Internal state ----------------------------------------------------------

	@Autowired
	AnonymousPavonBulletinRepository repository;


	// AbstractListService<Anonymous, Shout> interface --------------------

	@Override
	public boolean authorise(final Request<PavonBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<PavonBulletin> findMany(final Request<PavonBulletin> request) {
		assert request != null;

		Collection<PavonBulletin> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<PavonBulletin> request, final PavonBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "text", "date");
	}

}
