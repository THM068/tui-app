package tui.app

import com.tui.image.search.User

class UserFilters {
    def springSecurityService

    def filters = {
        all(controller:'*', action:'*') {

            after = { Map model ->
                if(model && springSecurityService.isLoggedIn()) {
                    model['user'] = User.get(springSecurityService.getPrincipal().id)
                }

            }

        }
    }
}
