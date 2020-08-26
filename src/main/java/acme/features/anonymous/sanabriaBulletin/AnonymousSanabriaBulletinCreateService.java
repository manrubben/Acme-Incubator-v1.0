
package acme.features.anonymous.sanabriaBulletin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.sanabriaBulletins.SanabriaBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousSanabriaBulletinCreateService implements AbstractCreateService<Anonymous, SanabriaBulletin> {

	// Internal state ----------------------------------------------------------

	@Autowired
	AnonymousSanabriaBulletinRepository repository;


	@Override
	public boolean authorise(final Request<SanabriaBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public SanabriaBulletin instantiate(final Request<SanabriaBulletin> request) {
		assert request != null;

		SanabriaBulletin result;

		result = new SanabriaBulletin();
		result.setAuthor("");
		result.setSong("");

		return result;
	}

	@Override
	public void unbind(final Request<SanabriaBulletin> request, final SanabriaBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "song");
	}

	@Override
	public void bind(final Request<SanabriaBulletin> request, final SanabriaBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void validate(final Request<SanabriaBulletin> request, final SanabriaBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<SanabriaBulletin> request, final SanabriaBulletin entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
