
package acme.features.anonymous.pavonBulletin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.pavonBulletins.PavonBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousPavonBulletinCreateService implements AbstractCreateService<Anonymous, PavonBulletin> {

	// Internal state ----------------------------------------------------------

	@Autowired
	AnonymousPavonBulletinRepository repository;


	@Override
	public boolean authorise(final Request<PavonBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public PavonBulletin instantiate(final Request<PavonBulletin> request) {
		assert request != null;

		PavonBulletin result;

		result = new PavonBulletin();
		result.setAuthor("");
		result.setText("");
		result.setDate(null);

		return result;
	}

	@Override
	public void unbind(final Request<PavonBulletin> request, final PavonBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "text", "date");
	}

	@Override
	public void bind(final Request<PavonBulletin> request, final PavonBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void validate(final Request<PavonBulletin> request, final PavonBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<PavonBulletin> request, final PavonBulletin entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
