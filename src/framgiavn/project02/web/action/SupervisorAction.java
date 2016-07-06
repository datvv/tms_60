/**
 * Jul 06, 2016, AdminAction.java, vuvandat
 */
package framgiavn.project02.web.action;

import java.util.Collection;
import java.util.Iterator;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vuvandat
 *
 */
public class SupervisorAction extends ActionSupport {

	@Override
	public String execute() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) userDetails
				.getAuthorities();
		for (Iterator it = authorities.iterator(); it.hasNext();) {
			SimpleGrantedAuthority authority = (SimpleGrantedAuthority) it.next();
		}
		return SUCCESS;
	}
}