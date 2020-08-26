
package acme.features.anonymous.gallardoBulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.gallardoBulletins.GallardoBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/gallardo-bulletin/")
public class AnonymousGallardoBulletinController extends AbstractController<Anonymous, GallardoBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AnonymousGallardoBulletinListService	listService;

	@Autowired
	private AnonymousGallardoBulletinCreateService	createService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
