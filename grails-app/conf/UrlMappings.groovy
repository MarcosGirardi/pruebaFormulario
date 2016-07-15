class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

				//"/$controller/update(.$format)?"(action: "index")
				//"/$controller/save"(action: "index")

				"/login/$action?"(controller: "login")
				"/logout/$action?"(controller: "logout")

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
