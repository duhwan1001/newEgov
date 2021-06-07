package kr.or.ddit.handler.member;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.controller.FileUploadResolver;
import kr.or.ddit.dto.AttachVO;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.utils.GetUploadPath;
import kr.or.ddit.utils.MultipartHttpServletRequestParser;

public class MemberModifyHandler implements Handler {

	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	// 업로드 파일 환경 설정
	private static final int MEMORY_THRESHOLD = 1024 * 500; // 500kb
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 1; // 1mb
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 2; // 2mb
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/modify_success";

		MultipartHttpServletRequestParser multiReq = new MultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
		
		// 회원 정보 영역
		String id = multiReq.getParameter("id");
		String pwd = multiReq.getParameter("pwd");
		String phone = multiReq.getParameter("phone");
		String authority = multiReq.getParameter("authority");
		String name = multiReq.getParameter("name");
		String email = multiReq.getParameter("email");

		System.out.println(id + pwd + email + authority + name + phone);
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setEmail(email);
		member.setAuthority(authority);
		member.setName(name);
		member.setPhone(phone);

		// 파일 관련 코드 start <--
		// 저장경로
		String uploadPath = GetUploadPath.getUploadPath("member.picture.upload");
		File file = new File(uploadPath);
		if(!file.mkdirs()) {
			System.out.println(uploadPath + "가 이미 존재하거나 생성에 실패했습니다.");
		}
		
		// 기존 사진 변경 유무 확인
		String uploadPicture = multiReq.getParameter("uploadPicture");
		if(uploadPicture!=null && !uploadPicture.isEmpty()) { // 사진 변경
			// 기존 이미지 삭제
			File deleteFile = new File(uploadPath, multiReq.getParameter("oldPicture"));
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
			// 최근 이미지 저장
			List<AttachVO> attachList = FileUploadResolver.fileUpload(multiReq.getFileItems("picture"), uploadPath);
			String savedFileName = attachList.get(0).getFileName();
			member.setPicture(savedFileName);
		} else {
			member.setPicture(multiReq.getParameter("oldPicture"));
		}
		// 파일 관련 코드 끝 -->
		
		memberService.modifyMember(member);
		
		request.setAttribute("member", member);

		request.setAttribute("parentReload", false);
		// 로그인 사용자 확인
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		if(member.getId().equals(loginUser.getId())) {
			request.setAttribute("parentReload", false);
			session.setAttribute("loginUser", memberService.getMember(member.getId()));
		};
		
		return url;
	}

}
