package com.geopetplusadmin.delegate;

import com.geopetplusadmin.exception.DelegateException;
import com.geopetplusadmin.vo.LoginVO;

public interface LoginDelegate {
	public String verifyLogin(LoginVO loginVO) throws DelegateException;
}
