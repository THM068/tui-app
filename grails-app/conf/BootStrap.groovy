import com.tui.image.search.User
import com.tui.image.search.Role
import com.tui.image.search.UserRole

class BootStrap {

    def init = { servletContext ->
        def user1 = User.findByUsername('kermit') ?: new User(username: 'kermit', password: 'frog', enabled: true).save()
        def user2 = User.findByUsername('gonzo') ?: new User(username: 'gonzo', password: 'bear', enabled: true).save()

        def basicRole = Role.findByAuthority('ROLE_BASIC') ?: new Role(authority: 'ROLE_BASIC').save()

        if (!user1.authorities.contains(basicRole)) {
            UserRole.create(user1, basicRole)
        }

        if (!user2.authorities.contains(basicRole)) {
            UserRole.create(user2, basicRole)
        }

    }
    def destroy = {
    }
}
