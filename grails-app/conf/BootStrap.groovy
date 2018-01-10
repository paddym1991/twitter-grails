import org.grails.twitter.auth.*

class BootStrap {

    def springSecurityService

    def init = { servletContext ->
        if(!Person.count()) {

            def userRole = new Authority(authority: 'ROLE_USER').save()

            def password = springSecurityService.encodePassword('password')

            [jeff: 'jeff Brown', graeme: 'Graeme Rocher', burt: 'Burt Reynolds']
                def user = new Person(username: userName, realName: realName)
                PersonAuthority.create user, userRole, true
        }
    }
    def destroy = {
    }
}
