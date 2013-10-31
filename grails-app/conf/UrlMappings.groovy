class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(controller: 'Evento', action: 'calendario')
		"500"(view:'/error')
	}
}
