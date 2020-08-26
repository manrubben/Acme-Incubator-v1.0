
package acme.features.anonymous.maderoBulletin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.maderoBulletins.MaderoBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousMaderoBulletinCreateService implements AbstractCreateService<Anonymous, MaderoBulletin> {

	// Internal state ----------------------------------------------------------

	@Autowired
	AnonymousMaderoBulletinRepository repository;


	@Override
	public boolean authorise(final Request<MaderoBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public MaderoBulletin instantiate(final Request<MaderoBulletin> request) {
		assert request != null;

		MaderoBulletin result;

		result = new MaderoBulletin();
		result.setAuthor("");
		result.setPhoto("");

		return result;
	}

	@Override
	public void unbind(final Request<MaderoBulletin> request, final MaderoBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "photo");
	}

	@Override
	public void bind(final Request<MaderoBulletin> request, final MaderoBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void validate(final Request<MaderoBulletin> request, final MaderoBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<MaderoBulletin> request, final MaderoBulletin entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
