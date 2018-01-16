package org.grails.twitter

import org.springframework.security.access.annotation.Secured

@Secured('permitAll')
class StatusController {

    def index() {
        //render('status')
        //render (view:'status/index.gsp')
        //render (view:'../views/status/index.gsp')
        render (view:'index.gsp')
    }
}
