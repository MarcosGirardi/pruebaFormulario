class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

				//"/$controller/update(.$format)?"(action: "index")
				//"/$controller/save"(action: "index")

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
