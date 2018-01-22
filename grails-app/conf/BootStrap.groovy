import org.grails.twitter.auth.*

class BootStrap {

    def springSecurityService

    def init = { servletContext ->
        if(!Person.count()) {

            def userRole = new Authority(authority: 'ROLE_USER').save()

           // def password = springSecurityService.encodePassword('password')

            [[realName: 'Jeff Brown', userName: 'jeff', phone: '0877907968'], [realName: 'Graeme Roche', userName: 'graeme', phone: '0877654321'],
             [realName: 'Burt Binglesteen', userName: 'burt', phone: '0876934510'], [realName: 'Peter Ledbrook', userName: 'peter', phone: '0876879876']].each {
                def user = new Person(username: it.userName, realName: it.realName, password: 'password', phone: it.phone, enabled: true).save()
                PersonAuthority.create user, userRole, true
            }

           // println 'THIS IS THE PASSWORD: ' + password
        }
    }
    def destroy = {
    }
}
