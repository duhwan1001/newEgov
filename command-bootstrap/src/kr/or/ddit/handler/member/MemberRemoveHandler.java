package kr.or.ddit.handler.member;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.utils.GetUploadPath;

public class MemberRemoveHandler implements Handler {

	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/delete_success";

		String id = request.getParameter("id");
		
		MemberVO member = memberService.getMember(id);
		
		String path = GetUploadPath.getUploadPath("member.picture.upload");
		String file = member.getPicture();
		File deleteFile = new File(path, file);
		if(deleteFile.exists()) {
			deleteFile.delete();
		}
		
		memberService.remove(id);
		
		request.setAttribute("member", id);
		
		MemberVO loginUser = (MemberVO)request.getSession().getAttribute("loginUser");
		if(loginUser.getId().equals(member.getId())) {
			request.getSession().invalidate(); // 세션 갱신
		}
		
		return url;
	}

}
