/*
 * AnonymousDiazbulletinCreateService.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.anonymous.diazBulletin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.diazBulletins.DiazBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousDiazBulletinCreateService implements AbstractCreateService<Anonymous, DiazBulletin> {

	// Internal state ----------------------------------------------------------

	@Autowired
	AnonymousDiazBulletinRepository repository;


	@Override
	public boolean authorise(final Request<DiazBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public DiazBulletin instantiate(final Request<DiazBulletin> request) {
		assert request != null;

		DiazBulletin result;

		result = new DiazBulletin();
		result.setSurname("");
		result.setBulletin("");

		return result;
	}

	@Override
	public void unbind(final Request<DiazBulletin> request, final DiazBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "surname", "bulletin");
	}

	@Override
	public void bind(final Request<DiazBulletin> request, final DiazBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void validate(final Request<DiazBulletin> request, final DiazBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<DiazBulletin> request, final DiazBulletin entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
