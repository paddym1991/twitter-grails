package org.grails.twitter

import org.springframework.security.access.annotation.Secured
import wdtwitter.TestingService

class TestingController {

    TestingService testingService
    @Secured('permitAll')
    def index() {
        render testingService.testDBConnection()
    }

    @Secured('IS_AUTHENTICATED_FULLY')
    def loginTest() {
        render testingService.testLoginConnection()
    }
}