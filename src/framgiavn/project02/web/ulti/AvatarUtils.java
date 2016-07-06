package framgiavn.project02.web.ulti;

import com.timgroup.jgravatar.Gravatar;

/**
 * @author nguyenanhvan
 *
 */
public class AvatarUtils {

	public static final String A404 = "404";
	public static final String MM = "mm";
	public static final String IDENTICON = "identicon";
	public static final String MONSTERID = "monsterid";
	public static final String WAVATAR = "wavatar";
	public static final String RETRO = "retro";
	public static final String BLANK = "blank";

	public static String getAvatarURL(String email) {
		Gravatar gravatar = new Gravatar();
		String url = gravatar.getUrl(email);
		int length = url.length();
		StringBuilder sb = new StringBuilder(url);
		if (sb.substring(length - 3, length).equals(A404)) {
			url = sb.replace(length - 3, length, RETRO).toString();
		}
		return url;
	}

	public static String changeDefaultAvatarURL(String avatarURL, String newSuffix) {
		StringBuilder sb = new StringBuilder(avatarURL);
		int length = avatarURL.length();
		int start = length - 1;
		for (int i = length - 1; i >= 0; i--) {
			if (avatarURL.charAt(i) == '=') {
				start = i + 1;
				break;
			}
		}
		String url = sb.replace(start, length, newSuffix).toString();
		return url;
	}

}