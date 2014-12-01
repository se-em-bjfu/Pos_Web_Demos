package bjfu.em.se.posweb.domain.exceptions;

/**
 * 未找到ip地址对应的收银台对象异常
 * @author Roy
 *
 */
public class RegisterNotFoundException extends Exception {

	public RegisterNotFoundException(String msg) {
		super(msg);
	}

}
