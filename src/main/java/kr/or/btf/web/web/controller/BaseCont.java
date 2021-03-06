package kr.or.btf.web.web.controller;

import kr.or.btf.web.common.Base;
import kr.or.btf.web.common.exceptions.AppCheckException;
import kr.or.btf.web.common.service.SystemService;
import kr.or.btf.web.domain.web.Account;
import kr.or.btf.web.domain.web.CourseRequest;
import kr.or.btf.web.domain.web.MemberRoll;
import kr.or.btf.web.domain.web.enums.UserRollType;
import kr.or.btf.web.services.web.CourseRequestCompleteService;
import kr.or.btf.web.services.web.CourseRequestService;
import kr.or.btf.web.utils.RequestUtil;
import kr.or.btf.web.web.AppWebResult;
import kr.or.btf.web.web.form.CourseRequestCompleteForm;
import kr.or.btf.web.web.form.CourseRequestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;


public abstract class BaseCont extends Base {

	@Autowired
	private SystemService systemService;

	@Autowired
	private CourseRequestCompleteService courseRequestCompleteService;
	@Autowired
	private CourseRequestService courseRequestService;

	protected boolean hasAllRoll(Account account, UserRollType...roll) {
		if (roll == null) return false;
		if (account == null || account.getAuthorites() == null || account.getAuthorites().size() == 0) return false;

		boolean rtnBool = true;
		for (UserRollType userRollType : roll) {
			if (!account.getAuthorites().contains(userRollType)) {
				rtnBool = false;
				break;
			}
		}
		return rtnBool;
	}

	protected boolean hasOneRoll(Account account, UserRollType...roll) {
		if (roll == null) return false;
		if (account == null || account.getAuthorites() == null || account.getAuthorites().size() == 0) return false;

		boolean rtnBool = false;
		for (UserRollType userRollType : roll) {
			if (!account.getAuthorites().contains(userRollType)) {
				rtnBool = true;
				break;
			}
		}
		return rtnBool;
	}

	protected boolean checkCourseSn(Long mberPid, Long crsMstPid, Integer sn) {
		if (mberPid == null || crsMstPid == null || sn == null) {
			return false;
		}
		if (sn == 1) {	//???????????? ??????
			return true;
		}
		CourseRequestCompleteForm courseRequestCompleteForm = new CourseRequestCompleteForm();
		courseRequestCompleteForm.setMberPid(mberPid);
		courseRequestCompleteForm.setCrsMstPid(crsMstPid);
		courseRequestCompleteForm.setSn(sn-1);
		Long aLong = courseRequestCompleteService.countComplete(courseRequestCompleteForm);
		if (aLong == 0) {
			return false;
		}
		return (aLong.intValue() == 1);
	}

	protected Long checkCourseRequest(Long mberPid, Long crsMstPid) {
		if (mberPid == null || crsMstPid == null) {
			return null;
		}
		CourseRequestForm courseRequestForm = new CourseRequestForm();
		courseRequestForm.setMberPid(mberPid);
		courseRequestForm.setCrsMstPid(crsMstPid);
		CourseRequest courseRequest = courseRequestService.loadByform(courseRequestForm);
		if (courseRequest.getId() == null) {
			return null;
		} else {
			return courseRequest.getId();
		}

	}

	/**
	 * ?????? ??????????????? ??????(user-agent) ?????????.
	 * @param request
	 * @return
	 */
	protected String gerUserAgent(HttpServletRequest request) {

		return RequestUtil.getUserAgent(request);
	}


	/**
	 * kakao agent ??????????????? ?????????.
	 * @param request
	 * @return
	 */
	protected boolean isKakaoAgent(HttpServletRequest request) {

		return RequestUtil.isKakaoAgent(request);
	}


	// ????????? ????????? ?????????.
	protected boolean isLogined(Account account) {
		if ( account == null )  return false;

		boolean isLogined = account.getId() != null ? true : false;

		return isLogined;
	}
	//???????????????????????? ??????
	protected boolean isNotLogined(Account account) {
		return !isLogined(account);
	}

	/**
	 * client(thymeleaf)?????? ????????? ??? ????????? (??????)???????????? ?????????.
	 * @param model
	 * @param message
	 */
	protected void setAppWebResult(Model model, String message) {
		boolean success = true;
		setAppWebResult(model, message, success);
	}

	protected void setAppWebResult(Model model, AppCheckException e) {
		boolean success = false;
		setAppWebResult(model, e.getMessage(), success);
	}

	/**
	 * client(thymeleaf)?????? ????????? ??? ????????? (??????)???????????? ?????????.
	 * @param model
	 * @param message
	 * @param success
	 */
	private void setAppWebResult(Model model, String message, boolean success) {
		AppWebResult result = new AppWebResult(message);

		model.addAttribute(RequestUtil.getAppWebResultKey(), result);   // key  _app_web_result_
	}

	/**
	 * client(thymleaf) ?????? ???????????? ????????? model ????????? ?????????
	 * @param model
	 * @param request
	 */
	/*protected void setAppWebResult(Model model, HttpServletRequest request) {
		AppWebResult result = RequestUtil.getAppResultMessageAndClear(request);

		model.addAttribute(RequestUtil.getAppWebResultKey(), result);   // key  _app_web_result_
	}*/

	/**
	 * ????????? ??????????????? ????????? ?????????.
	 * @param message
	 */
	public void notifySysAdmin(String message) {

		if ( systemService != null ) systemService.notifySysAdminAsync(message);
	}

	protected ModelAndView newModelAndView() {

		return new ModelAndView();
	}

	protected ModelAndView newRedirectModelAndView(String url) {
		return new ModelAndView(new RedirectView(url));
	}

}
