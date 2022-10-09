package com.cgi.cmatch.service;

import com.cgi.cmatch.entity.Register;
import com.cgi.cmatch.exception.MailSendingException;
import com.cgi.cmatch.exception.RegisterException;
import com.cgi.cmatch.vo.UserVo;
//for register service it contains the one method that is register service
public interface RegisterServiceInterface {

	public Register registerService(UserVo userVo) throws RegisterException,MailSendingException;
}
