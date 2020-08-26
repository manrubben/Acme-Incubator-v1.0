
package acme.features.anonymous.maderoBulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.maderoBulletins.MaderoBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/madero-bulletin/")
public class AnonymousMaderoBulletinController extends AbstractController<Anonymous, MaderoBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AnonymousMaderoBulletinListService		listService;

	@Autowired
	private AnonymousMaderoBulletinCreateService	createService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
