package com.cgi.cmatch.service;

import com.cgi.cmatch.entity.Register;
import com.cgi.cmatch.exception.MailSendingException;
import com.cgi.cmatch.exception.RegisterException;
import com.cgi.cmatch.vo.UserVo;

public interface RegisterServiceInterface {

	public Register registerService(UserVo userVo) throws RegisterException,MailSendingException;
}
